package algorithm;

public class PalindromeNumber {

    /**
     * 由于做过了转换整数，回文数可以先将整数转换为字符串，对字符串进行操作比对。
     * 运行时间
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


    public boolean isPalindrome2(int x) {

        if(x < 0) return false;
        if(x < 10) return true;

        int exten = 1;
        int temp = x;
        //求出最高位是什么位
        while(temp/10 > 0) {
            exten *= 10;
            temp /= 10;
        }

        while(exten >= 10) {
            if(x/exten != x%10) return false;
            x = x % exten / 10; //每次
            exten /= 100;
        }
        return true;
    }


    public static void main(String[] args) {
        PalindromeNumber pn = new PalindromeNumber();
        boolean res = pn.isPalindrome2(-12321);
        System.out.println(res);
    }
}
