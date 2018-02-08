package algorithm;

public class PlusOne {
    public int[] plusOne(int[] digits) {

        for(int i = digits.length-1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }


    public static void main(String[] args) {
        PlusOne po = new PlusOne();
        int[] a = new int[]{1, 2, 3};
        int[] b = {1,9};
        int[] result = po.plusOne(b);
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
