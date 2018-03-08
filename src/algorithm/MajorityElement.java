package algorithm;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        if(nums == null) return 0;

        int count = 1, majority = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(count == 0) {
                count = 1;
                majority = nums[i];
            }else if(majority == nums[i]) {
                count++;
            }else {
                count--;
            }
        }
        return majority;
    }


    public static void main(String[] args) {
        MajorityElement major = new MajorityElement();
        int[] nums = new int[]{3,2,1};
        int result = major.majorityElement(nums);
        System.out.println(result);
    }


}
