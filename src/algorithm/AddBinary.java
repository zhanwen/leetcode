package algorithm;

public class AddBinary {

    public String addBinary(String a, String b) {

        int len1 = a.length();
        int len2 = b.length();

        int carry = 0; // 进位
        String res = "";

        int len = Math.max(len1, len2);
        for(int i = 0; i < len; i++) {
            int p = 0, q = 0;
            if(i < len1) {
                p = a.charAt(len1-1-i) - '0';
            }else {
                p = 0;
            }

            if(i < len2) {
                q = b.charAt(len2-1-i) - '0';
            }else {
                q = 0;
            }

            int tmp = p + q + carry;
            carry = tmp/2;
            res += tmp%2;
        }
        return (carry == 0) ? res : "1" + res;
    }

    public static void main(String[] args) {
        AddBinary ab = new AddBinary();
        String res = ab.addBinary("1010", "1011");
        System.out.println(res);
    }
}
