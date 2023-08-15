package MostAskedQue;

public class DoubleANumberRepresentedInLinkedList {
    public static ListNode head=null;
    public static class ListNode{
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
    //Doubling the value represnted in linkedList

    public static ListNode doubleIt(ListNode head) {
        head = reverseList(head);
        int carry = 0;
        for(ListNode ptr = head; ptr != null; ptr = ptr.next){
            int t = ptr.val*2;
            ptr.val = (t + carry)%10;
            carry = (t + carry)/10;
            if( ptr.next == null && carry != 0) {
                ptr.next = new ListNode(carry); ptr = ptr.next; }
        }
        return reverseList(head);
    }
    public static void addAtStart(int data) {
        //Create a new node
        ListNode newNode = new ListNode(data);

        //Checks if the list is empty
        if(head == null) {
            //If list is empty, both head and tail will point to new node
            head = newNode;
        }
        else {
            //Node temp will point to head
            ListNode temp = head;
            //newNode will become new head of the list
            head = newNode;
            //Node temp(previous head) will be added after new head
            head.next = temp;
        }
    }
    public static void main(String[] args) {
        //Leetcode: 2816. Double a Number Represented as a Linked List
        //Input: head = [9,9,9]
        //Output: [1,9,9,8]
        //eg 1 -> 8 -> 9 then output: 3 -> 7 -> 8
        addAtStart(9);
        addAtStart(8);
        addAtStart(1);
        doubleIt(head);
        while(head !=null){
            System.out.print(head.val+" -> ");
            head=head.next;
        }
        System.out.print("null");

    }
}
