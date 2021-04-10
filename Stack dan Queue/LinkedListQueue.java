public class LinkedListQueue {
    int max;
    int currSize;
    DoubleLinkedList elements;

    public LinkedListQueue(int max) {
        this.max = max;
        this.currSize = 0;
        this.elements = new DoubleLinkedList();
    }

    /**
     * Adds an element to the queue
     */
    public void enqueue(int value) {
        if (currSize <= max) {
            elements.insertTail(value);
            currSize++;
        } else {
            throw new IllegalStateException("Queue full");
        }
    }

    /**
     * Removes an element from the queue
     */
    public int dequeue() {
        int value = elements.head.value;
        elements.deleteHead();
        currSize--;
        return value;
    }

    /**
     * Finds the index of an element with a specific index
     * @return index of the element
     */
    public int find(int value) {
        return elements.find(value);
    }

    /**
     * Finds the maximum value of the queue
     * @return maximum value
     */
    public int max() {
        return elements.max();
    }

    /**
     * Prints all the values in the queue
     */
    public void printNodes() {
        elements.printNodesQueue();
        System.out.println();
    }

    /**
     * Prints the value of the frontmost element
     */
    public void peek() {
        System.out.println(elements.head.value);
    }

    public static void main(String[] args) {
        LinkedListQueue llQueue = new LinkedListQueue(10);
        llQueue.enqueue(10);
        llQueue.enqueue(2);
        llQueue.enqueue(3);
        llQueue.enqueue(4);
        llQueue.enqueue(100);
        llQueue.enqueue(4);

        System.out.println("Initial values:");
        llQueue.printNodes();

        System.out.print("Dequeued element's value: ");
        System.out.println(llQueue.dequeue());
        System.out.println();

        System.out.println("After dequeue:");
        llQueue.printNodes();

        System.out.print("Max value: ");
        System.out.println(llQueue.max());
        System.out.println();

        System.out.print("Index of element with value 3: ");
        System.out.println(llQueue.find(3));
        System.out.println();

        System.out.print("Frontmost node's value: ");
        llQueue.peek();
    }
}
