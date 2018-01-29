package algorithm;


public class ReverseInteger {

    /**
     * 看到本题首先想到的是用数组来处理，然后将数组倒序拼接在输出
     * 但是看到第二个测试样例的时候，发现这样不能很好的处理末尾为
     * 0的情况，首先是末尾0的个数是不确定的，所以就想到了用科学计
     * 数法来处理，将数逆序输出也就是从末尾以此乘以10的几次方。
     * @param x 输入的整形值
     * @return 反转的值
     */
    public int reverse(int x) {
        //首先处理符号的问题，不管符号正负，一律为转换为正数处理
        //因为符号只影响到最后的输出，并不参与运算
        int temp = x;
        if(x < 0) {
            x = -x;
        }
        //将数转换为字符串，这样可以得到数组，便于输出
        String str = x + "";
        byte[] num = str.getBytes();
        int sum = 0;
        for(int i = num.length-1; i >= 0; i--) {
            sum += (num[i] - '0')*Math.pow(10, i);
            //逆序之后的数，如果溢出（超出32位的数值所能表示的范围），则返回0
            if(sum <= Integer.MIN_VALUE || sum >= Integer.MAX_VALUE) {
                return 0;
            }
        }
        //判断是否加上符号
        return temp < 0 ? -sum : sum;
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        int result = ri.reverse(1534236469);
        System.out.println(result);
    }


}
