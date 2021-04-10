public class LinkedListStack {
    int max;
    int currSize;
    SingleLinkedList elements;

    public LinkedListStack(int max) {
        this.max = max;
        this.currSize = 0;
        this.elements = new SingleLinkedList();
    }

    /**
     * Adds an element to the top of the stack
     */
    public void push(int value) {
        if (currSize <= max) {
            elements.insertHead(value);
            currSize++;
        } else {
            throw new StackOverflowError();
        }
    }

    /**
     * Removes an element from the top of the stack
     * @return value of the topmost element
     */
    public int pop() {
        int value = elements.getHead().value;
        elements.deleteHead();
        currSize--;
        return value;
    }

    /**
     * Finds the index of an element with a specific value
     * @param value of the element to be searched
     * @return index of the element
     */
    public int find(int value) {
        return elements.find(value);
    }

    /**
     * Finds the maximum value of the stack
     * @return maximum value
     */
    public int max() {
        return elements.max();
    }

    /**
     * Print all the values in the stack
     */
    public void printNodes() {
        elements.printNodesStack();
        System.out.println();
    }

    /**
     * Prints the value of the frontmost element
     */
    public void peek() {
        System.out.println(elements.head.value);
    }

    public static void main(String[] args) {
        LinkedListStack llStack = new LinkedListStack(10);
        llStack.push(10);
        llStack.push(2);
        llStack.push(3);
        llStack.push(4);
        llStack.push(100);
        llStack.push(4);
        
        System.out.println("Initial values:");
        llStack.printNodes();

        System.out.print("Popped element's value: ");
        System.out.println(llStack.pop());
        System.out.println();

        System.out.println("After pop:");
        llStack.printNodes();
        
        System.out.print("Max value: ");
        System.out.println(llStack.max());
        System.out.println();

        System.out.print("Index of element with value 3: ");
        System.out.println(llStack.find(3));
        System.out.println();

        System.out.print("Top node's value: ");
        llStack.peek();
    }
}
