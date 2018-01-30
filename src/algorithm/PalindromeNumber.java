package algorithm;

public class PalindromeNumber {

    /**
     * 由于做过了转换整数，回文数可以先将整数转换为字符串，对字符串进行操作比对。
     * @param x 输入数字
     * @return  若是回文返回true，否则返回false
     */
    public boolean isPalindrome(int x) {
//        错误想法，负数不存在回文
//        if(x < 0) {
//            x = -x;
//        }
        String str = x + "";
        byte[] num = str.getBytes();
        int len = num.length;
        for(int i = 0; i < len/2; i++) {
            if(num[i] != num[len-i-1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 每次比较首尾两位，若首尾两位不同直接返回，否则继续判断
     * @param x 输入数字
     * @return  若是回文返回true，否则返回false
     */
    public boolean isPalindrome2(int x) {

        if(x < 0) return false;   //负数没有回文
        if(x < 10) return true;   //0-9一个数字就是回文

        int exten = 1;
        int temp = x;
        //求出最高位是什么位
        while(temp/10 > 0) {
            exten *= 10;
            temp /= 10;
        }

        while(exten >= 10) {
            if(x/exten != x%10) return false;   //判断首尾数字是否相同，若相同继续往下判断，否则直接返回false。
            x = x % exten / 10; //去除首尾的数字，取中间的数字
            exten /= 100;   //每次去除首尾数字两位，位数减少两位，要除以100
        }
        return true;
    }

    /**
     * 直接求出数字的回文数，然后比较两个数字是否相同即可
     * @param x 输入的数字
     * @return  若是回文返回true，否则返回false
     */
    public boolean isPalindrome3(int x) {
        if(x < 0) return false;
        int reverse = 0;
        int y = x;
        int remainder;
        boolean isPalindrome = false;

        while(y > 0){
            remainder = y % 10;
            reverse = reverse * 10 + remainder;
            y /= 10;

        }

        if(reverse == x){
            isPalindrome = true;
        }

        return isPalindrome;

    }


    public static void main(String[] args) {
        PalindromeNumber pn = new PalindromeNumber();
        boolean res = pn.isPalindrome2(-12321);
        System.out.println(res);
    }
}
