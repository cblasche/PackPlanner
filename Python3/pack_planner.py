"""
Pack Planner

The pack planner is a program that takes a list of items and sorts them into
several packs (groups). Find the full description of the problem in 
SoftwareProgram.pdf.
"""


class Item:
    def __init__(self, id, length, quantity, weight):
        self.id = id
        self.length = length
        self.quantity = quantity
        self.weight = weight


class Pack:
    def __init__(self, number):
        self.number = number
        self.items = []
        self.length = 0  # longest length of contained items determines pack length
        self.weight = 0  # sum over weight of all items in pack
        self.quantity = 0  # total number of items in pack

    def add_item(self, new_item):
        self.items.append(new_item)
        # updating length, weight, and quantity
        self.length = max(new_item.length, self.length)
        self.weight += new_item.weight * new_item.quantity
        self.quantity += new_item.quantity

    def print(self):
        print('Pack number:', self.number)
        for item in self.items:
            print(item.id, item.length, item.quantity, item.weight)
        print('Pack Length:', self.length,
              'Pack Weight:', round(self.weight, 2), end='\n \n')


def read_input():
    print('Please insert input here and finish with an empty line:')

    lines = []
    line = input()
    while line != "":
        lines.append(line)
        line = input()

    return lines


def main():
    # Reading input
    lines = read_input()

    # set packing parameters
    sort_order, max_p, max_w = lines[0].split(",")
    max_pieces_per_pack = int(max_p)
    max_weight_per_pack = float(max_w)

    # initialising the list of items to be packed
    items = []
    for line in lines[1:]:
        id, length, quantity, weight = line.split(",")
        items.append(Item(int(id), int(length), int(quantity), float(weight)))

    # sort items according to sort order
    if sort_order == 'NATURAL':
        pass
    elif sort_order == 'SHORT_TO_LONG':
        items.sort(key=lambda item: item.length, reverse=True)
    elif sort_order == 'LONG_TO_SHORT':
        items.sort(key=lambda item: item.length, reverse=False)

    # begin list of packs
    packs = []
    pack_number = 1
    packs.append(Pack(pack_number))

    for item in items:
        while item.quantity > 0:
            # identify quantity of respective item to be packed in current pack
            space_limit = (max_pieces_per_pack - packs[pack_number - 1].quantity)
            weight_left_in_pack = (max_weight_per_pack - packs[pack_number - 1].weight)
            weight_limit = int(weight_left_in_pack / item.weight)
            quantity = min(space_limit, weight_limit, item.quantity)

            if quantity > 0:  # take respective quantity of item and put into pack
                item.quantity -= quantity
                item_added_to_pack = Item(item.id, item.length, quantity, item.weight)
                packs[pack_number - 1].add_item(item_added_to_pack)
            elif quantity == 0:  # start new pack
                pack_number += 1
                packs.append(Pack(pack_number))

    # print packing details
    for pack in packs:
        pack.print()


if __name__ == "__main__":
    main()
