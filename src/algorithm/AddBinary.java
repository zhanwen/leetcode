package algorithm;

import javax.print.DocFlavor;

public class AddBinary {

    /**
     * 验证不通过，主要是对字符串进行拼接的时候造成先计算的放在了前面，也就是不能在字符串前面插入，而在后面插入了。
     * 所以想到使用StringBuffer来解决
     * @param a 字符串
     * @param b 字符串
     * @return  二进制相加的结果
     */
    public String addBinary(String a, String b) {

        int len1 = a.length();
        int len2 = b.length();

        int carry = 0; // 进位
//        String res = "";
        StringBuffer sb = new StringBuffer();
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
//            res += tmp%2;
            sb.insert(0, tmp%2);
        }

        return (carry == 0) ? sb.toString() : sb.insert(0, 1).toString();
    }

    /**
     * 二进制相加
     * 将长度短的那个字符串进行补0操作，然后进行相加，借助StringBuffer来存储每次计算的结果。
     * @param a 字符串
     * @param b 字符串
     * @return  二进制相加的结果
     */
    public String addBinary2(String a, String b) {
        int maxLen = Math.max(a.length(), b.length());
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        for(int i = 0; i < maxLen; i++) {
            int tempA = a.length() > i ? a.charAt(a.length() - i - 1) - '0' : 0;
            int tempB = b.length() > i ? b.charAt(b.length() - i - 1) - '0' : 0;
            sb.insert(0, (tempA+tempB+carry) % 2);
            carry = (tempA+tempB+carry) > 1 ? 1 : 0;
        }

        if(carry == 1) {
            sb.insert(0, 1);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        AddBinary ab = new AddBinary();
        String res = ab.addBinary("1010", "1011");
        System.out.println(res);
    }
}
