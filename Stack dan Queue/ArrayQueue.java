public class ArrayQueue {
    int currSize;
    int[] elements;

    public ArrayQueue(int max) {
        this.currSize = 0;
        this.elements = new int[max];
    }
    
    /**
     * Adds an element to the queue
     */
    public void enqueue(int value) {
        if (currSize == elements.length) {
            // The queue is full
            throw new IllegalStateException("Queue full");
        } else {
            // The queue is not full, so add the element to the queue
            elements[currSize] = value;
            currSize++;
        }    
    }

    /**
     * Removes an element from the queue
     * @return value of the element that is popped
     */
    public int dequeue() {
        // The Array that will replace the current array
        int[] newElements = new int[elements.length];

        // Value to be returned
        int value = elements[0];

        // Shift elements to the left by one
        for (int i = 1; i < currSize; i++) {
            newElements[i - 1] = elements[i];
        }
        elements = newElements;
        currSize--;
        return value;
    }

    /**
     * Finds a specific element in the queue
     * @param value the value of the element to be found
     * @return index of the element
     */
    public int find(int value) {
        for (int i = 0; i < currSize; i++) {
            if (elements[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Finds the maximum value in the queue
     * @return maximum value in the queue
     */
    public int max() {
        int max = elements[0];
        for (int i = 1; i < currSize; i++) {
            if (elements[i] > max) {
                max = elements[i];
            }
        }
        return max;
    }

    /**
     * Prints out the values of all elements in the queue
     */
    public void printElements() {
        for (int i = 0; i < currSize - 1; i++) {
            System.out.print(elements[i]);
            System.out.print(" <-- ");
        }
        System.out.println(elements[currSize-1]);
        System.out.println();
    }

    /**
     * Prints out the value of the frontmost element
     */
    public void peek() {
        System.out.println(elements[0]);
    }
    

    public static void main(String[] args) {
        ArrayQueue arrQueue = new ArrayQueue(10);
        arrQueue.enqueue(10);
        arrQueue.enqueue(2);
        arrQueue.enqueue(3);
        arrQueue.enqueue(4);
        arrQueue.enqueue(100);
        arrQueue.enqueue(4);

        System.out.println("Initial values:");
        arrQueue.printElements();

        System.out.print("Dequeued element's value: ");
        System.out.println(arrQueue.dequeue());
        System.out.println();

        System.out.println("After dequeue:");
        arrQueue.printElements();

        System.out.print("Max value: ");
        System.out.println(arrQueue.max());
        System.out.println();

        System.out.print("Index of element with value 3: ");
        System.out.println(arrQueue.find(3));
        System.out.println();

        System.out.print("Frontmost element's value: ");
        arrQueue.peek();
    }
}
