public class LinkedListChecker {
    public static boolean isCircular(LinkedList linkedList) {
        Node head = linkedList.getHead();
        Node currentNode = head;
        while (currentNode.next != head && currentNode.next != null) {
            currentNode = currentNode.next;
        }

        if (currentNode.next == head) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        LinkedList cLinkedList = new CircularLinkedList();
        cLinkedList.insertHead(10);
        cLinkedList.insertHead(20);
        cLinkedList.insertHead(30);
        cLinkedList.insertHead(40);
        cLinkedList.insertHead(50);
        cLinkedList.insertHead(60);
        System.out.printf("cLinkedList is circular: %s\n", isCircular(cLinkedList));

        LinkedList sLinkedList = new SingleLinkedList();
        sLinkedList.insertHead(10);
        sLinkedList.insertHead(20);
        sLinkedList.insertHead(30);
        sLinkedList.insertHead(40);
        sLinkedList.insertHead(50);
        sLinkedList.insertHead(60);
        System.out.printf("sLinkedList is circular: %s\n", isCircular(sLinkedList));

        LinkedList dLinkedList = new DoubleLinkedList();
        dLinkedList.insertHead(10);
        dLinkedList.insertHead(20);
        dLinkedList.insertHead(30);
        dLinkedList.insertHead(40);
        dLinkedList.insertHead(50);
        dLinkedList.insertHead(60);
        System.out.printf("dLinkedList is circular: %s\n", isCircular(dLinkedList));

    }
}