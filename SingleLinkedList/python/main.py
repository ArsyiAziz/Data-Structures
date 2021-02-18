from SingleLinkedList import SingleLinkedList

if __name__ == '__main__':
    sll = SingleLinkedList()
    sll.append(1)
    sll.append("abc")
    sll.append(3)
    sll.append(123)
    sll.traverse()
    sll.pop()
    sll.pop()
    sll.traverse()
