package SingleLinkedList.java;


/**
 * A single linked list.
 */
class SingleLinkedList {
    

    /**
     * A node of a single linked list.
     */
    private class Node {
        Object obj;
        Node next;
        
        public Node(Object obj) {
            this.obj=obj;
            this.next=null;
        }
    }

    private Node head = null;
    private Node tail = null;

    /**
     * Adds an object to the start of the linked list.
     */
    public void push(Object obj) {
        
        // create a new instance of a node
        Node newNode = new Node(obj);

        if (head == null) {
            // the linked list is empty, so fill it in
            head = newNode;
            tail = newNode;
        } else {
            // add the node to the start of the linked list
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * Adds an object to the end of the linked list.
     */
    public void append(Object obj) {

        // create a new instance of a node
        Node newNode = new Node(obj);

        if (head == null) {
            // the linked list is empty, so fill it in
            head = newNode;
            tail = newNode;
        } else {
            // add the node to the end of the linked list
            tail.next = newNode;
            tail = newNode;
        }
    }

    /**
     * Adds an object to the end of the linked list.
     */
    public Object pop() {

        // set current node to be the frontmost node
        Node current = head;
        
        // loop until the current node is the second last node in the linked list
        while (current.next.next != null) {
            current = current.next;
        }

        // grab tail object for output
        Object output = tail.obj;
        
        // remove pointer to the current tail and set tail to second last node
        current.next = null;
        tail = current;

        return output;
    }

    /**
     * Prints out all the objects in the linked list.
     */    
    public void traverse() {

        // set the current node to be the frontmost node
        Node current = head;

        // loop and output the objects until the very last node
        while (current.next != null) {
            System.out.printf("%s, ", current.obj);
            current = current.next;
        }
        System.out.print(current.obj);
    } 

}

