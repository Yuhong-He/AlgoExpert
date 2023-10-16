public class RemoveKthNodeFromEnd {
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
        removeKthNodeFromEnd(linkedList, 2);
        while(linkedList != null) {
            System.out.println(linkedList.value);
            linkedList = linkedList.next;
        }
    }

    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        int index = 1;
        LinkedList first = head;
        LinkedList second = head;
        while(index <= k) {
            second = second.next;
            index++;
        }
        if(second == null) {
            assert head != null;
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }
        while(second.next != null) {
            second = second.next;
            first = first.next;
        }
        first.next = first.next.next;
    }
}
