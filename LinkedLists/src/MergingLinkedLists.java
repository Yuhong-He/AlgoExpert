import java.util.HashSet;
import java.util.Set;

public class MergingLinkedLists {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList a_linkedList = new LinkedList(1);
        LinkedList a_linkedList1 = new LinkedList(2);
        LinkedList a_linkedList2 = new LinkedList(3);
        LinkedList a_linkedList3 = new LinkedList(4);
        LinkedList a_linkedList4 = new LinkedList(5);
        LinkedList a_linkedList5 = new LinkedList(6);
        a_linkedList.next = a_linkedList1;
        a_linkedList1.next = a_linkedList2;
        a_linkedList2.next = a_linkedList3;
        a_linkedList3.next = a_linkedList4;
        a_linkedList4.next = a_linkedList5;

        LinkedList b_linkedList = new LinkedList(7);
        LinkedList b_linkedList1 = new LinkedList(4);
        LinkedList b_linkedList2 = new LinkedList(5);
        LinkedList b_linkedList3 = new LinkedList(6);
        b_linkedList.next = b_linkedList1;
        b_linkedList1.next = b_linkedList2;
        b_linkedList2.next = b_linkedList3;

        LinkedList result = mergingLinkedLists(a_linkedList, b_linkedList);
        while(result != null) {
            System.out.println(result.value);
            result = result.next;
        }
    }

    public static LinkedList mergingLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        Set<LinkedList> set = new HashSet<>();
        while(linkedListOne != null) {
            set.add(linkedListOne);
            linkedListOne = linkedListOne.next;
        }

        while(linkedListTwo != null) {
            if(set.contains(linkedListTwo)) {
                return linkedListTwo;
            }
            linkedListTwo = linkedListTwo.next;
        }

        return null;
    }
}
