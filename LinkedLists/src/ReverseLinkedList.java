public class ReverseLinkedList {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1);
        LinkedList linkedList1 = new LinkedList(2);
        LinkedList linkedList2 = new LinkedList(3);
        LinkedList linkedList3 = new LinkedList(4);
        LinkedList linkedList4 = new LinkedList(5);
        LinkedList linkedList5 = new LinkedList(6);
        linkedList.next = linkedList1;
        linkedList1.next = linkedList2;
        linkedList2.next = linkedList3;
        linkedList3.next = linkedList4;
        linkedList4.next = linkedList5;
        LinkedList result = reverseLinkedList(linkedList);
        while(result != null) {
            System.out.println(result.value);
            result = result.next;
        }
    }

    public static LinkedList reverseLinkedList(LinkedList head) {
        LinkedList previous = null;
        LinkedList current = head;
        while(current != null) {
            LinkedList next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
