public class MiddleNode {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(0);
        linkedList.next = new LinkedList(1);
        LinkedList expected = new LinkedList(2);
        linkedList.next.next = expected;
        expected.next = new LinkedList(3);
        var actual = middleNode(linkedList);
        System.out.println("expected: " + expected.value);
        System.out.println("actual: " + actual.value);
    }

    public static LinkedList middleNode(LinkedList linkedList) {
        LinkedList fastNode = linkedList;
        LinkedList slowNode = linkedList;
        while(fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }
}
