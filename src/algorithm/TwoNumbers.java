package algorithm;

public class TwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int [] la = new int[100];
        int [] lb = new int[100];
        int i = 0;
        int j = 0;
        while(l1 != null) {
            la[i] = l1.val;
            l1 = l1.next;
            i++;
        }

        while(l2 != null) {
            lb[j] = l2.val;
            l2 = l2.next;
            j++;
        }

        int l1lenth = i;
        int l2lenth = j;
        int sum1 = 0;
        int sum2 = 0;
        for(i = l1lenth-1; i >= 0; i--) {
            sum1 += la[i] * Math.pow(10, i);
        }
        for(j = l2lenth-1; j >= 0; j--) {
            sum2 += lb[j] * Math.pow(10, j);
        }

        int sum = sum1 + sum2;
        int[] l3 = new int[100];
        int k = 0;
        while(sum !=0 ) {
            l3[k] = sum%10;
            sum /= 10;
            k++;
        }
        ListNode result = new ListNode(l3[k-1]);
        for(int len = k-2; len >=0; len--) {
            result.next = new ListNode(l3[len]);
           

        }
        return result;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        TwoNumbers tn = new TwoNumbers();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

//        System.out.println(l1.val + "===" + l1.next.val + "====" + l1.next.next.val);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode res = tn.addTwoNumbers(l1, l2);
        System.out.println(res.val + "===" + res.next.val + "====" + res.next.next.val);
    }


}
