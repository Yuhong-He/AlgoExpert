public class RemoveDuplicatesFromLinkedList {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList1 = new LinkedList(1);
        LinkedList linkedList2 = new LinkedList(1);
        LinkedList linkedList3 = new LinkedList(2);
        LinkedList linkedList4 = new LinkedList(2);
        LinkedList linkedList5 = new LinkedList(3);
        LinkedList linkedList6 = new LinkedList(3);
        linkedList1.next = linkedList2;
        linkedList2.next = linkedList3;
        linkedList3.next = linkedList4;
        linkedList4.next = linkedList5;
        linkedList5.next = linkedList6;
        LinkedList result = removeDuplicatesFromLinkedList(linkedList1);
        while(result != null) {
            System.out.println(result.value);
            result = result.next;
        }
    }

    public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList currentNode = linkedList;
        while(currentNode != null) {
            LinkedList nextNode = currentNode.next;
            while(nextNode != null && nextNode.value == currentNode.value) {
                nextNode = nextNode.next;
            }
            currentNode.next = nextNode;
            currentNode = nextNode;
        }
        return linkedList;
    }
}