package algorithm;

public class ImplementstrStr {

    /**
     * 子串在原字符串中首次出现的下标
     * @param haystack  原字符串
     * @param needle    子字符串
     * @return  下标，从0开始
     */
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        ImplementstrStr is = new ImplementstrStr();
        int index = is.strStr("hello", "ll");
        System.out.println(index);
    }
}
