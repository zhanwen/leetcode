package algorithm;

public class Sqrt_x {

    /**
     * 使用Java自带的API计算机一个数的根，并将其强制转换为整数
     * @param x 输入的数
     * @return  返回这个数的根
     */
    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }

    /**
     * 采用暴力破解的方法
     * 从1开始到x结束。不断的进行计算比较
     * @param x 输入的数
     * @return  返回这个数的根
     */
    public int mySqrt2(int x) {
        if(x == 0) return 0;
        int left = 1;
        int right = Integer.MAX_VALUE;
        int ans = 0;
        while(left <= right) {
            int mid = left + (right - left)/2;

            if(mid > x/mid) {
                right = mid - 1;
            }else {
                ans = mid;
                left = mid + 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Sqrt_x s = new Sqrt_x();
        int result = s.mySqrt2(9);
        System.out.println(result);
    }

}
