// Written by Arsyi Syarief Aziz 
// H071191003

public class DoubleLinkedList implements LinkedList{
    Node head;
    Node tail;


    /**
     * Inserts a node into the head of the linked list
     */
    @Override
    public void insertHead(int value) {
      
        Node newNode = new Node(value);

        if (head != null) {
            // Linked list has other nodes

            // Point the new node to the current head and point
            // the current head to this new node
            newNode.next = head;
            head.prev = newNode;

            head = newNode;
        } else {
            // Linked list is empty

            head = newNode;
            tail = newNode;
        }
    }

    /**
     * Inserts a node into the head of the linked list
     */
    @Override
    public void insertTail(int value) {

        Node newNode = new Node(value);

        if (head != null) {
            // Linked list has other nodes

            // Point the new node to the current tail and point
            // the current tail to this new node
            newNode.prev = tail;
            tail.next = newNode;

            tail = newNode;
        } else {
            insertHead(value);
        }
    }

    /**
     * Inserts a node into a specified index in the linked list 
     * (works forwards and backwards)
     */
    public void insert(int index, int value) {

        if ((head == null && index != 0)) {
            // Linked list is empty and specified index is not 0
            throw new ArrayIndexOutOfBoundsException();
        }

        if (index == 0) {
            // Insert into head

            insertHead(value);
            return;
        }

        if (index == -1) {
            // Insert into tail

            insertTail(value);
            return;
        }

        // Sets counter to (index - 1) to grab the element 
        // before the specified index.
        int counter = Math.abs(index) - 1;
        
        if (index > 0) {
            // Iterate forwards

            Node current = head;

            while (counter > 0 && current.next != null) {
                // Iterate utill the node before the specified index

                current = current.next;
                counter--;
            }

            if (counter > 0) {
                // Index is invalid

                throw new ArrayIndexOutOfBoundsException();
            } else {
                Node newNode = new Node(value);
                if (current.next != null) {
                    // Insert into middle

                    newNode.next = current.next;
                    newNode.prev = current;

                    Node currentPlusOne = current.next;
                    currentPlusOne.prev = newNode;

                    current.next = newNode;
                    

                } else {
                    // Insert into tail

                    insertTail(value);
                }
            }
        } else {
            // Iterate backwards

            Node current = tail;
            counter--;

            while (counter > 0 && current.prev != null) {
                // Iterate utill the node before the specified index

                current = current.prev;
                counter--;
            }

            if (counter > 0) {
                // Index is invalid
                throw new ArrayIndexOutOfBoundsException();
            } else {
                Node newNode = new Node(value);

                if (current.prev != null) {
                    // Insert into middle

                    newNode.prev = current.prev;
                    newNode.next = current;
                    
                    Node currentPlusOne = current.prev;
                    currentPlusOne.next = newNode;

                    current.prev = newNode;                    
                } else {
                    // Insert into head

                    insertHead(value);
                }
            }
        }
        
    }


    /**
     * Deletes the node at the head of the linked list
     */
    @Override
    public void deleteHead() {
        
        if (head == null) {
            return;
        }
        Node headNext = head.next;
        headNext.prev = null;
        head = headNext;
    }

    /**
     * Deletes the node at the tail of the linked list
     */
    @Override
    public void deleteTail() {

        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        
        Node tailPrev = tail.prev;
        tailPrev.next = null;
        tail = tailPrev;
    }

    /**
     * Inserts the node at a specified index in the linked list 
     * (works forwards and backwards)
     */
    public void delete(int index) {

        if ((head == null && index != 0)) {
            // Linked list is empty and specified index is not 0
            throw new ArrayIndexOutOfBoundsException();
        }

        if (index == 0) {
            // Delete node at head

            deleteHead();
            return;
        }

        if (index == -1) {
            // Delete node at tail
            deleteTail();
            return;
        }

        // Sets counter to (index - 1) to grab the element
        // before the specified index.
        int counter = Math.abs(index) - 1;

        if (index > 0) {
            // Iterate forwards 

            Node current = head;

            while (counter > 0 && current.next != null) {
                // Iterate utill the node before the specified index

                current = current.next;
                counter--;
            }

            if (counter > 0) {
                // Invalid index
                
                throw new ArrayIndexOutOfBoundsException();
            } else {
                Node currentNext = current.next;
                try{
                    if (currentNext.next == null) {
                        // Delete at tail

                        deleteTail();
                    } else {
                        // Delete at middle

                        Node currentTwoNext = current.next.next;
                        current.next = currentTwoNext;
                        currentTwoNext.prev = current;
                    }
                } catch (NullPointerException e) {
                    // Invalid index
                    throw new ArrayIndexOutOfBoundsException();
                }
      
            }
        } else {
            Node current = tail;
            counter--;

            while (counter > 0 && current.prev != null) {
                current = current.prev;
                counter--;
            }

            if (counter > 0) {
                throw new ArrayIndexOutOfBoundsException();
            } else {
                Node currentPrev = current.prev;
                try {
                    if (currentPrev.prev == null) {
                        deleteHead();
                    } else {
                        Node currentTwoPrev = current.prev.prev;
                        current.prev = currentTwoPrev;
                        currentTwoPrev.next = current;
                    } 
                } catch (NullPointerException e) {
                    throw new ArrayIndexOutOfBoundsException();
                }
            }
        }

    }

    /**
     * Prints out all the values in the linked list
     */
    @Override
    public void printNodes() {

        Node current = head;
        if (current != null) {
            System.out.print("null <-- ");
        }
        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) {
                System.out.print(" <--> ");
            } else {
                System.out.print(" --> ");
            }
            current = current.next;
        }
        System.out.println("null");
    }

    public void printNodesQueue() {

        Node current = head;

        while (current.next != null) {
            System.out.print(current.value + " <-- ");
            current = current.next;
        }
        System.out.println(current.value);
    }

    /**
     * Prints out the values of all the nodes from front to back
     */
    public void printNodesForward() {

        Node current = head;

        while (current != null) {
            System.out.print(current.value + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }


    /**
     * Prints out the values of all the nodes from back to front
     */
    public void printNodesBackwards() {

        Node current = tail;

        while (current != null) {
            System.out.print(current.value + " --> ");
            current = current.prev;
        }
        System.out.println("null");
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

    public static void main(String[] args) {

        DoubleLinkedList dLinkedList = new DoubleLinkedList();
        dLinkedList.insertTail(69);
        dLinkedList.insertTail(70);
        dLinkedList.insertTail(123);
        dLinkedList.insertTail(24);  

        System.out.println("Initial Values:");
        dLinkedList.printNodes();
        System.out.println();

        System.out.println("Insert (1) into head:");
        dLinkedList.insertHead(1);
        dLinkedList.printNodes();
        System.out.println();

        System.out.println("Insert (2) into tail:");
        dLinkedList.insertTail(2);
        dLinkedList.printNodes();
        System.out.println();

        System.out.println("Insert (1234) into index 2 (from the front):");
        dLinkedList.insert(2, 1234);
        dLinkedList.printNodes();
        System.out.println();

        System.out.println("Insert (12345) into index -2 (from the back):");
        dLinkedList.insert(-2, 12345);
        dLinkedList.printNodes();
        System.out.println();

        System.out.println("Delete node at head:");
        dLinkedList.deleteHead();
        dLinkedList.printNodes();
        System.out.println();

        System.out.println("Delete node at tail:");
        dLinkedList.deleteTail();
        dLinkedList.printNodes();
        System.out.println();

        System.out.println("Delete node at index 3:");
        dLinkedList.delete(3);
        dLinkedList.printNodes();
        System.out.println();

        System.out.println("Delete node at index -3:");
        dLinkedList.delete(-3);
        dLinkedList.printNodes();
        System.out.println();


        System.out.println("Index of node with value 24:");
        System.out.println(dLinkedList.find(24));
        System.out.println();

        System.out.println("Max value:");
        System.out.println(dLinkedList.max());
        System.out.println();

        System.out.println("Printing from front to back:");
        dLinkedList.printNodesForward();
        System.out.println();

        System.out.println("Printing from back to front:");
        dLinkedList.printNodesBackwards();
        System.out.println();
    }

}
