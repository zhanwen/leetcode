package algorithm;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesfromSortedList {

    /**
     * 从有序的列表中移除重复的数字
     * @param head  原始链表
     * @return  去重之后的链表
     */
    public ListNode deleteDuplicates(ListNode head) {

       if(head == null) {
           return head;
       }
       //前指针
       ListNode pre = head;
       //当前指针
       ListNode current = head.next;
       while(current != null){
           //如果前面指针的数值和当前指针的数值相同则将当前指针下一个元素前移，否则两个指针同时后移一步
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
