package algorithm;

public class MaximumSubarray {
    /**
     * 子数组和最大值
     * 对于一个子数组求子数组的和最大，并不需要将所有的情况一一列举并计算，只需要将其依次相加并比较即可。
     * 对于和小于0的，将其重新赋值为0，若大于0的，则取和和最大值的最大值
     * 时间复杂度为O(n)
     * @param nums  输入的数组
     * @return  最大子数组和
     */
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            max = Math.max(sum, max);
        }
        return max;
    }

    /**
     * 采用分而治之来计算
     * 该时间复杂度为O(nlogn)
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        return divide(nums, 0, nums.length-1);
    }

    private int divide(int[] nums, int low, int high) {
        //只有一个元素的时候
        if(low == high) {
            return nums[low];
        }
        //两个元素的时候
        if(low == high-1) {
            return Math.max(nums[low]+nums[high], Math.max(nums[low], nums[high]));
        }
        //其余情况递归调用
        int mid = (low+high)/2;
        int lmax = divide(nums, low, mid-1);
        int rmax = divide(nums, mid+1, high);
        int mmax = nums[mid];
        int tmp = mmax;

        for(int i = mid-1; i >= 0; i--) {
            tmp += nums[i];
            if(tmp > mmax) {
                mmax = tmp;
            }
        }
        tmp = mmax;
        for(int i = mid+1; i <= high; i++) {
            tmp += nums[i];
            if(tmp > mmax) {
                mmax = tmp;
            }
        }
        return Math.max(mmax, Math.max(lmax, rmax));
    }

    public static void main(String[] args) {
        MaximumSubarray ms = new MaximumSubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums2 = {-2, -1};
        int result = ms.maxSubArray2(nums);
        System.out.println(result);
    }

}
