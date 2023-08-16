package MostAskedQue;

public class DetectALoopInLinkedList {
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
    //I'm using Slow pointer, Fast Pointer Approach to detect a cycle in Linked list
    //In another words: if 2 men are running on a track and if one is slow and one is fast then they will meet at some point
    public static boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        if(head==null){
            return false;
        }
        while(fast.next !=null && fast.next.next !=null){
            fast=fast.next.next;
            slow=slow.next;
            //if fast and slow pointer meet at any point it means we have detected a cycle
            if(fast==slow){
                return true;
            }
        }
        return false;
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
        addAtStart(9);
        addAtStart(8);
        addAtStart(1);
        //I'm using Slow pointer, Fast Pointer Approach to detect a cycle in Linked list
        System.out.println(hasCycle(head));

    }
}
