package algorithm;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix {

    /**
     * 求最长公共子串
     * 将数组中的第一个看作是公共子串，以此与后面的字符串比较，若比较的过程中出现了空字符串，则直接返回空字符串
     * 传入的字符串数组若为空或者长度为零则直接返回空字符串
     * 例如：字符串数组为 {"abcd", "abc", "ab"}
     * 则返回结果为 "ab"
     * @param strs  字符串数组
     * @return  最长公共子串
     */
    public String longestCommonPrefix(String[] strs) {
        String result = strs.length == 0 ? "" : strs[0];
        for(int i = 1; i < strs.length; i++) {
            result = commonPrefix(result, strs[i]);
            if(result == "") {
                return result;
            }
        }
        return result;
    }

    private String commonPrefix(String start, String next) {
        StringBuffer sb = new StringBuffer();
        int len = start.length() >= next.length() ? next.length() : start.length();
        for(int i = 0; i < len; i++) {
            if(start.charAt(i) == next.charAt(i)) {
                sb.append(start.charAt(i));
            }else{
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"1234", "1234", "4", "123"};
        String res = lcp.longestCommonPrefix(strs);
        System.out.println(res);

    }

}
