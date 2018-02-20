package algorithm;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesfromSortedList {

    public ListNode deleteDuplicates(ListNode head) {

       if(head == null) {
           return head;
       }
       ListNode pre = head;
       ListNode current = head.next;
       while(current != null){
           if(pre.val == current.val) {
               pre.next = current.next;
           }else {
               pre = current;
           }
           current = current.next;
       }
       return head;
    }

    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
        ln.next = new ListNode(1);
        ln.next.next = new ListNode(2);
        RemoveDuplicatesfromSortedList t = new RemoveDuplicatesfromSortedList();
        t.deleteDuplicates(ln);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
