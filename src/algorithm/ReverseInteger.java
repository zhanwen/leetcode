package algorithm;


public class ReverseInteger {

    /**
     * 看到本题首先想到的是用数组来处理，然后将数组倒序拼接在输出
     * 但是看到第二个测试样例的时候，发现这样不能很好的处理末尾为
     * 0的情况，首先是末尾0的个数是不确定的，所以就想到了用科学计
     * 数法来处理，将数逆序输出也就是从末尾以此乘以10的几次方。
     * 运行时间47ms
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

    /**
     * 利用StringBuffer对字符串的逆序直接转
     * 运行时间52ms
     * @param x
     * @return
     */
    public int reverse2(int x) {
       if(x <= Integer.MIN_VALUE) {
           return 0;
       }
       int temp = Math.abs(x);
       String str = Long.toString(temp);
       StringBuffer sb = new StringBuffer(str);
       String result = sb.reverse().toString();
       if(Long.parseLong(result) > Integer.MAX_VALUE) {
           return 0;
       }
       return x > 0 ? Integer.parseInt(result) : -Integer.parseInt(result);
    }

    /**
     * 同第一种方法一样利用科学计数法来进行计算
     * 运行时间52ms
     * @param x
     * @return
     */
    public int reverse3(int x) {
        long result = 0;
        int tmp = Math.abs(x);
        while(tmp>0){
            result *= 10;
            result += tmp % 10;
            if(result > Integer.MAX_VALUE){
                return 0;
            }
            tmp /= 10;
        }
        return (int)(x>=0?result:-result);
    }

    public int reverse4(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = -x;
        }
        int r =0;
        int q = 1;
        int result = 0;
        while (true) {
            q = (x * 52429) >>> 19;//去尾1位，2<<(16+3)＝524288 52429/524288约为0.1
            r = x - ((q << 3) + (q << 1));//r=i-q*10,截出最后一位
            result = (result<<3)+(result<<1)+r;
            x=q;
            if(q==0)break;
        }
        if(isNegative) result = -result;
        return result;
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        int result = ri.reverse4(1147483648);
        System.out.println(result);
    }


}
