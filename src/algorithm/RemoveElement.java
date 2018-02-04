package algorithm;

public class RemoveElement {

    /**
     * 本题跟 RemoveDuplicatesfromSortedArray 题很相似，只是换了一种方法，将数组中的重复数字去重，跟给定的数字相同的数字从数组中移除
     * 是相同的道理。数组去重是使用双指针移动法，本题也可以根据这种方法来处理。
     * @param nums  数组
     * @param val   要去除的数字
     * @return  去重之后的数组长度
     */
    public int removeElement(int[] nums, int val) {

        if(nums == null || nums.length == 0) {
            return 0;
        }
        int len = 0;
        for(int i = 0; i < nums.length; i++) {
            // 数组中的数字跟给定的数字不同就往前移动
            if(nums[i] != val) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }


    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        int[] test = {3, 2, 2, 3};
        int val = 3;
        int result = re.removeElement(test, val);
        System.out.println(result);
    }
}
