public class CircularLinkedList implements LinkedList {
    Node head;

    /**
     * Inserts a node into the head of the linked list
     */
    @Override
    public void insertHead(int value) {
        Node newNode = new Node(value);

        if (head != null) {
            // Linked list is not empty
            Node currentNode = head;
            
            // Iterate until the tail node
            while (currentNode.next != head) {
                currentNode = currentNode.next;
            }

            // Set tail node's pointer 
            currentNode.next = newNode;
            newNode.next = head;
            head = newNode;
        } else {
            // Linked list is empty
            head = newNode;
            newNode.next = newNode;
        }
    }
    /**
     * Inserts a node into the tail of the linked list
     */
    @Override
    public void insertTail(int value) {
        Node newNode = new Node(value);
        if (head != null) {
            // Linked list is not empty
            
            Node currentNode = head;

            // Iterate until the tail node
            while (currentNode.next != head) {
                currentNode = currentNode.next;
            }
            
            // Set current tail's pointer to newNode
            currentNode.next = newNode;
            // Set newNodes pointer back to head
            newNode.next = head;
        } else {
            // Linked list is empty
            head = newNode;
            newNode.next = newNode;
        }
    }

    // Insert @ any index is not added because of the ambiguity between adding a
    // node at the tail and adding a node at the head for n > 1 cycles
    
    /**
     * Deletes the head of the linked list
     */
    @Override
    public void deleteHead() {
        if (head != null) {
            Node currentNode = head;

            // Iterate until the tail node
            while (currentNode.next != head) {
                currentNode = currentNode.next;
            }
            // Grab the node after head
            Node headNext = head.next;

            // Set the tail's pointer to the node after head
            currentNode.next = headNext;
            // Set head as the node after the head
            head = head.next;
        }
    }

    /**
     * Deletes the tail of the linked list
     */
    @Override
    public void deleteTail() {
        if (head != null) {
            Node currentNode = head;
            
            // Iterate until the node before the tail
            while (currentNode.next.next != head) {
                currentNode = currentNode.next;
            }
            // Set the node before the tail's pointer as the head
            currentNode.next = head;
        }
    }


    public void delete(int index) {
        if (head != null) {
            Node currentNode = head;

            if (index == 0) {
                deleteHead();
                return;
            }

            index--;
            // Iterate until the node before the tail
            while (index > 0) {
                currentNode = currentNode.next;
                index--;
            }

            if (currentNode.next == head) {
                deleteHead();
            } else if (currentNode.next.next == head) {
                deleteTail();
            } else {
                Node currentNodePlusTwo = currentNode.next.next;
                currentNode.next = currentNodePlusTwo;
            }

        }
    }
    
    /**
     * Prints out all the values in the linked list
     */
    @Override
    public void printNodes() {
        Node currentNode = head;
    
        while (currentNode.next != head) {
            System.out.print(currentNode.value);
            currentNode = currentNode.next;
            System.out.print(" -> ");
        }
        System.out.println(currentNode.value);
    }

    /**
     * Finds and returns the index of a specified value in the linked list
     */
    @Override
    public int find(int v) {

        Node currentNode = head;
        
        int i = 0;
    
        while (currentNode.next != head) {
            if (currentNode.value == v) {
                return i;
            }
            i++;
            currentNode = currentNode.next;
        }
    
        if (currentNode.value == v) {
            return i;
        }
        return -1;
    }

    /**
     * Finds the maximum value of the linked list
     */
    @Override
    public int max() {

        int max_v = head.value;

        Node currentNode = head.next;

        while (currentNode != head) {
            if (currentNode.value > max_v) {
                max_v = currentNode.value;
            }
            currentNode = currentNode.next;
        }
        return max_v;
    }

    @Override
    public Node getHead() {
        return this.head;
    }
    
    public static void main(String[] args) {
        CircularLinkedList cLinkedList = new CircularLinkedList();
        cLinkedList.insertHead(10);
        cLinkedList.insertHead(20);
        cLinkedList.insertHead(30);
        cLinkedList.insertHead(40);
        cLinkedList.insertHead(1000);
        cLinkedList.insertHead(60);
        cLinkedList.insertTail(69);
        cLinkedList.insertHead(40);
        cLinkedList.insertTail(100);
        System.out.println("Initial values:");
        cLinkedList.printNodes();
        System.out.println();

        System.out.println("After deleting head:");
        cLinkedList.deleteHead();
        cLinkedList.printNodes();
        System.out.println();

        System.out.println("After deleting tail:");
        cLinkedList.deleteTail();
        cLinkedList.printNodes();
        System.out.println();

        System.out.println("Delete node at index 10:");
        cLinkedList.delete(10);
        cLinkedList.printNodes();
        System.out.println();

        System.out.println("Insert (40) into head");
        cLinkedList.insertHead(40);
        cLinkedList.printNodes();
        System.out.println();
        
        System.out.println("Index of node with value (1000):");
        System.out.println(cLinkedList.find(1000));
        System.out.println();

        System.out.println("Maximum value of the linked list:");
        System.out.println(cLinkedList.max());
        System.out.println();

    }
     
    
    
}