package algorithm;

import java.util.List;

public class MergeTwoSortedLists {

//    Input: 1->2->4, 1->3->4
//    Output: 1->1->2->3->4->4

    /**
     * 合并成有序列表
     *
     * @param l1    链表1
     * @param l2    链表2
     * @return  合并后的列表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = new ListNode(-1);
        ListNode l3 = head;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                l3.next = l1;
                l3 = l3.next;
                l1 = l1.next;
            }else {
                l3.next = l2;
                l3 = l3.next;
                l2 = l2.next;
            }
        }
        if(l1 != null) {
            l3.next = l1;
        }
        if(l2 != null) {
            l3.next = l2;
        }
        return head.next;
    }

    private static class ListNode {
            int val;
            ListNode next;
            ListNode(int x) {
                val = x;
            }
    }


    public static void main(String[] args) {
        MergeTwoSortedLists test = new MergeTwoSortedLists();
        MergeTwoSortedLists.ListNode l1 = new MergeTwoSortedLists.ListNode(1);
        l1.next = new MergeTwoSortedLists.ListNode(2);
        l1.next.next = new MergeTwoSortedLists.ListNode(3);

        MergeTwoSortedLists.ListNode l2 = new MergeTwoSortedLists.ListNode(1);
        l2.next = new MergeTwoSortedLists.ListNode(3);
        l2.next.next = new MergeTwoSortedLists.ListNode(4);
        test.mergeTwoLists(l1, l2);
    }

}


