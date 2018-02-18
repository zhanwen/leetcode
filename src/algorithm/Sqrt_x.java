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

    public static void main(String[] args) {
        Sqrt_x s = new Sqrt_x();
        int result = s.mySqrt(4);
        System.out.println(result);
    }

}
