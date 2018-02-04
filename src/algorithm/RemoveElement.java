package algorithm;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        if(nums == null || nums.length == 0) {
            return 0;
        }
        int len = 0;
        for(int i = 0; i < nums.length; i++) {
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
