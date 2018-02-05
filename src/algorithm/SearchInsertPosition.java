package algorithm;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

        int low = 0;
        int high = nums.length-1;
        int mid = -1;
        while(low <= high) {
            mid = (low + high)/2;
            if(nums[mid] == target) {
                return mid;
            }else if(nums[mid] < target) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        SearchInsertPosition sip = new SearchInsertPosition();
        int[] nums = {1, 3, 5, 6};
        int result = sip.searchInsert(nums, 0);
        System.out.println(result);
    }

}
