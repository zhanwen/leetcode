package algorithm;

public class LengthofLastWord {

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

    public int lengthOfLastWord2(String s) {

        if(" ".equals(s) || "".equals(s) || s == null) return 0;
        String[] str = s.split(" ");
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
