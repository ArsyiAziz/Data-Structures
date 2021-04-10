public class ArrayStack {
    int[] elements;
    int currSize;

    public ArrayStack(int max) {
        this.elements = new int[max];
        this.currSize = 0;
    }

    /**
     * Adds element to the top of the stack
     * @param value
     */
    public void push(int value) {
        // The Array that will replace the current array
        int[] newElements = new int[elements.length];
        
        newElements[0] = value;

        if (currSize == elements.length) {
            // Stack is full
            throw new StackOverflowError();
        }

        // Shift elements right by one
        for (int i=1; i < currSize+1; i++) {
            newElements[i] = elements[i-1]; 
        }
        elements = newElements;
        currSize++;
    }

    /**
     * Pop the topmost element
     * @return the value of the popped element
     */
    public int pop() {
        // The array that will replace the current array
        int[] newElements = new int[elements.length];

        int value = elements[0];

        // Shift elements left by one
        for (int i = 1; i < currSize; i++) {
            newElements[i-1] = elements[i];
        }

        elements = newElements;
        currSize--;
        return value;
    }

    /**
     * Find the index of an element with a specific value
     * @param value
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
     * Finds the maximum value of the stack
     * @return maximum value in the stack
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
     * Prints the values of all elements in the stack
     */
    public void printElements() {
        System.out.println("--Top--");
        for (int i = 0;i < currSize; i++) {
            System.out.println(elements[i]);
        }
        System.out.println("--Bottom--");
        System.out.println();
    }

    /**
     * Prints out the value of the topmost element
     */
    public void peek() {
        System.out.println(elements[0]);
    }

    public static void main(String[] args) {
        ArrayStack arrStack = new ArrayStack(10);
        arrStack.push(10);
        arrStack.push(2);
        arrStack.push(3);
        arrStack.push(4);
        arrStack.push(100);
        arrStack.push(4);

        System.out.println("Initial values:");
        arrStack.printElements();

        System.out.print("Popped element's value: ");
        System.out.println(arrStack.pop());
        System.out.println();

        System.out.println("After pop:");
        arrStack.printElements();

        System.out.print("Max value: ");
        System.out.println(arrStack.max());
        System.out.println();

        System.out.print("Index of element with value 3: ");
        System.out.println(arrStack.find(3));
        System.out.println();

        System.out.print("Topmost element's value: ");
        arrStack.peek();
    }
}
