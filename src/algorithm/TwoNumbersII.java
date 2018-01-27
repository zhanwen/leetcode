package algorithm;

import java.util.Stack;

public class TwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        l1 = reverseList(l1);
        l2 = reverseList(l2);

        ListNode cur = l1;
        int len1 = 0;
        while(cur != null) {
            len1++;
            cur = cur.next;
        }

        cur = l2;
        int len2 = 0;
        while(cur != null) {
            len2++;
            cur = cur.next;
        }

        ListNode dummy = new ListNode(0);
        if(len1 > len2) {
            dummy.next = l1;
        }else {
            dummy.next = l2;
        }

        cur = dummy;
        int carry = 0;

        while(l1 != null || l2 != null) {
            if(l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            cur.next.val = carry%10;
            cur = cur.next;
            carry /= 10;
        }

        if(carry != 0) {
            cur.next = new ListNode(1);
        }

        ListNode nxt = dummy.next;
        ListNode newHead = reverseList(nxt);
        nxt.next = null;
        return newHead;

    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    // 2--4--3
    // 3--4--2
    private ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode tail = head;
        ListNode cur = head;
        ListNode pre;
        ListNode temp;

        while(tail.next != null) {
            pre = cur;
            cur = tail.next;
            temp = cur.next;
            cur.next = pre;
            tail.next = temp;

        }
        return cur;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        Stack<Integer> stk1 = new Stack<Integer>();
        Stack<Integer> stk2 = new Stack<Integer>();
        while(l1 != null){
            stk1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            stk2.push(l2.val);
            l2 = l2.next;
        }

        ListNode dummy = new ListNode(0);
        int carry = 0;
        while(!stk1.isEmpty() || !stk2.isEmpty()){
            if(!stk1.isEmpty()){
                carry += stk1.pop();
            }
            if(!stk2.isEmpty()){
                carry += stk2.pop();
            }
            ListNode cur = new ListNode(carry%10);
            cur.next = dummy.next;
            dummy.next = cur;
            carry /= 10;
        }
        if(carry != 0){
            ListNode cur = new ListNode(1);
            cur.next = dummy.next;
            dummy.next = cur;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        TwoNumbersII tn = new TwoNumbersII();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode res = tn.addTwoNumbers2(l1, l2);

        System.out.println(res.val + "===" + res.next.val + "====" + res.next.next.val);
    }


}
