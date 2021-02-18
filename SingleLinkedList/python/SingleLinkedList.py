class SingleLinkedList:
    """A single linked list."""

    def __init__(self):
        self.head = None
        self.tail = None

    class Node:
        """A node of a single linked list."""

        def __init__(self, obj):
            self.obj = obj
            self.next = None
   
    def push(self, obj):
        """Adds an object to the start of the linked list.
        
        Args:
            The object that is going to be added.
        """

        # create a new instance of a node
        new_node = SingleLinkedList.Node(obj)

        if self.head is None:
            # the linked list is empty, so fill it in
            self.head = new_node
            self.tail = new_node
        else:
            # add the node to the start of the linked list
            new_node.next = self.head
            self.head = new_node
            
    def append(self, obj):
        """Adds an object to the end of the linked list.
        
        Args:
            The object that is going to be added.
        """

        # create a new instance of a node
        new_node = SingleLinkedList.Node(obj)

        if self.head is None:
            # the linked list is empty, so fill it in
            self.head = new_node
            self.tail = new_node
        else:
            # add the node to the end of the linked list
            self.tail.next = new_node;
            self.tail = new_node;
    
    def pop(self):
        """Removes and retrieves the last object in the linked list.
        
        Returns:
            Last object in the linked list.
        """

        # set current node to be the frontmost node
        current = self.head
        
        # loop until the current node is the second last node in the linked list
        while current.next.next is not None:
            current = current.next

        # grab tail object for output
        output = self.tail.obj
        
        # remove pointer to the current tail and set tail to second last node
        current.next = None
        self.tail = current

        return output


    def traverse(self):
        """Prints out all the objects in the linked list."""

        # set the current node to be the frontmost node
        current = self.head

        # loop and output the objects until the very last node
        while current.next is not None:
            print(f'{current.obj}, ', end='')
            current = current.next
        print(current.data)

