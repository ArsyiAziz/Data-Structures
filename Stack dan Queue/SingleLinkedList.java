// Written by Arsyi Syarief Aziz 
// H071191003

public class SingleLinkedList implements LinkedList{
    Node head;

    /**
     * Inserts a node into the head of the linked list
     */
    @Override
    public void insertHead(int value) {
  
        if (head != null) {
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
        } else {
            head = new Node(value);
        }
    }

    /**
     * Inserts a node into the tail of the linked list
     */
    @Override
    public void insertTail(int value) {

        if (head != null) {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            Node newNode = new Node(value);
            current.next = newNode;
        } else {
            insertHead(value);
        }
    }

    /**
     * Inserts a node into a specified index in the linked list
     */
    public void insert(int index, int value) {

        Node current = head;

        if ((head == null && index != 0) || index < 0) {
            // Trying to instert into non zero index of an empty linked list 
            // or index is negative (invalid)

            throw new ArrayIndexOutOfBoundsException();
        }

        if (index == 0) {
            insertHead(value);
            return;
        }

        // Count until the node right before the node at the specified index
        int counter = index - 1;
        
        while (counter > 0 && current.next != null) {
            // Iterate till the node right before the the specified index

            current = current.next;
            counter--;
        }

        if (counter > 0) {
            // Invalid index
            throw new ArrayIndexOutOfBoundsException();
        } else {
            
            Node newNode = new Node(value);
            if (current.next != null) {
                // Insert into middle

                newNode.next = current.next;
                current.next = newNode;
            } else {
                // Insert into tail

                current.next = newNode;
            }
        }
    }

    /**
     * Deletes the node at the head of the linked list
     */
    @Override
    public void deleteHead() {

        if (head == null) {
            // Linked list is empty

            throw new ArrayIndexOutOfBoundsException();
        }
        head = head.next;
    }

    /**
     * Deletes the node at the tail of the linked list
     */
    @Override
    public void deleteTail() {

        if (head == null) {
            // Linked list is empty

            throw new ArrayIndexOutOfBoundsException();
        }

        if (head.next == null) {
            // There is only one node in the linked list

            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            // Iterate till the second last node
            current = current.next;
        }
        current.next = null;
    }

    /**
     * Deletes the node at a specified index in the linked list
     */
    public void delete(int index) {

        if (head == null || index < 0) {
            // Trying to delele from a non zero index of an empty linked list
            // or index is negative (invalid)

            throw new ArrayIndexOutOfBoundsException();
        }
        
        if (index == 0) {
            deleteHead();
            return;
        }

        // Count until the node before the node at the specified index
        int counter = index - 1;
        Node current = head;
    

        while (counter > 0 && current.next != null) {
            // Iterate till the node right before the the specified index

            current = current.next;
            counter--;
        }

        if (counter > 0 || current.next == null) {
            // Invalid index

            throw new ArrayIndexOutOfBoundsException();
        } else {
            if (current.next != null) {
                // delete at middle
                current.next = current.next.next;
            } else {
                // delete at tail
                current.next = null;
            }
        }

    }

    /**
     * Finds the maximum value of the linked list
     */
    @Override
    public int max() {

        Node current = head;
        int max_v = head.value;
        while (current.next != null) {
            if (max_v < current.next.value) {
                max_v = current.next.value;
            }
            current = current.next;
        }
        return max_v;
    }

    /**
     * Finds and returns the index of a specified value in the linked list
     */
    @Override
    public int find(int v) {

        Node current = head;
        int i = 0;
        while (current != null) {
            if (current.value == v)
                return i;
            i++;
            current = current.next;
        }
        return -1;
    }
    
    @Override
    public Node getHead() {
        return this.head;
    }

    /**
     * Prints out all the values in the linked list
     */
    @Override
    public void printNodes() {


        Node current = head;
        while (current != null) {
            System.out.print(current.value + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void printNodesStack() {
        Node current = head;
        System.out.println("--Top--");
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
        System.out.println("--Bottom--");
    }

    public static void main(String[] args) {
        SingleLinkedList sLinkedList = new SingleLinkedList();
        sLinkedList.insertHead(5);
        sLinkedList.insertHead(4);
        sLinkedList.insertHead(1);

        System.out.println("Initial values:");
        sLinkedList.printNodes();
        System.out.println();

        System.out.println("Insert into tail:");
        sLinkedList.insertTail(50);
        sLinkedList.printNodes();
        System.out.println();

        System.out.println("Insert into head:");
        sLinkedList.insertHead(12);
        sLinkedList.printNodes();
        System.out.println();

        System.out.println("Delete node at index 3:");
        sLinkedList.delete(3);
        sLinkedList.printNodes();
        System.out.println();


        System.out.println("Insert (100) into index 2:");
        sLinkedList.insert(2, 100);
        sLinkedList.printNodes();
        System.out.println();

        System.out.println("Index of node with value 4:");
        System.out.println(sLinkedList.find(4));
        System.out.println();

        System.out.println("Max value:");
        System.out.println(sLinkedList.max());
        System.out.println();

        System.out.println("Delete node at head:");
        sLinkedList.deleteHead();
        sLinkedList.printNodes();
        System.out.println();

        System.out.println("Delete node at tail:");
        sLinkedList.deleteTail();
        sLinkedList.printNodes();
        System.out.println();
    }

}
