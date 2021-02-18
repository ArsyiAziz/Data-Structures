package SingleLinkedList.java;

class Main {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        sll.append(1);
        sll.append("abc");
        sll.append(3);
        sll.append(3);
        sll.pop();

        sll.traverse();
    }
}
