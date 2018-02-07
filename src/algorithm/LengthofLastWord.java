package algorithm;

public class LengthofLastWord {

    /**
     * 一个字符串以" "分隔，求出最后一个单词的长度，若最后一个单词不存在，则返回0
     * 第一次读完这题的时候，以为是求出所有的字符串，然后返回最长的那个字符串的长度，所以这个方法是理解错了。
     * @param s 字符串
     * @return  最后一个字符串的长度
     */
    public int lengthOfLastWord(String s) {
        int len = 0;
        String[] str = s.split(" ");
        for(int i = 0; i < str.length; i++) {
            if(str[i].length() > len) {
                len = str[i].length();
            }
        }
        return len;
    }

    /**
     * 一个字符串以" "分隔，求出最后一个单词的长度，若最后一个单词不存在，则返回0
     * 正确解法：先将不符合的情况排除，不符合的情况全部返回0
     * 对于符合的情况，先将字符串划分为字符串数组，然后直接返回最后一个字符串的长度。
     * @param s 字符串
     * @return  最后一个字符串的长度
     */
    public int lengthOfLastWord2(String s) {

        if(" ".equals(s) || "".equals(s) || s == null) return 0;
        String[] str = s.split(" ");
        // 排除"   "多个空格的情况
        if(str.length == 0) return 0;
        int len = str[str.length-1].length();
//        int index = s.lastIndexOf(" ");
//        if(index == -1) return 0;
//        int result = s.substring(index, s.length()-1).length();
//        return result == 0 ? 0 : result;
        return len;
    }

    public static void main(String[] args) {
        LengthofLastWord llw = new LengthofLastWord();
//        int result = llw.lengthOfLastWord2("hello world i love you because you beautiful and");
        int result2 = llw.lengthOfLastWord2("a");
        System.out.println(result2);
    }
}
