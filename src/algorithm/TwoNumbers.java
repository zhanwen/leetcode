package algorithm;

public class TwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry =0;

        ListNode newHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p3=newHead;

        while(p1 != null || p2 != null){
            if(p1 != null){
                carry += p1.val;
                p1 = p1.next;
            }

            if(p2 != null){
                carry += p2.val;
                p2 = p2.next;
            }

            p3.next = new ListNode(carry%10);
            p3 = p3.next;
            carry /= 10;
        }

        if(carry==1)
            p3.next=new ListNode(1);

        return newHead.next;
    }

    
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ListNode cur = ret;

        int sum = 0;
        while (true) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            cur.val = sum % 10;
            sum /= 10;
            if (l1 != null || l2 != null || sum != 0) {
                cur = (cur.next = new ListNode(0));
            } else {
                break;
            }
        }
        return ret;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

}

