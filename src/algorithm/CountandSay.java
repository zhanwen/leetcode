package algorithm;

public class CountandSay {
    /**
     * 统计前面出现的数字并将其打印出来
     * 这题有点绕，但是细读还是可以理解的。就是将前面出现的数字做统计并进行下一轮的输出。
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        //递归调用，然后对字符串处理
        String str = countAndSay(n-1) + "*";
        char[] c = str.toCharArray();
        int count = 1;
        String s = "";
        for(int i = 0; i < c.length - 1;i++){
            if(c[i] == c[i+1]){
                count++;//计数增加
            }else{
                s = s + count + c[i];//上面的*标记这里方便统一处理
                count = 1;//初始化
            }
        }
        return s;
    }

    public static void main(String[] args) {
        CountandSay cs = new CountandSay();
        String result = cs.countAndSay(5);
        System.out.println(result);
    }

}
