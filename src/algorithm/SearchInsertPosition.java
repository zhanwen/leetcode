package algorithm;

public class SearchInsertPosition {

    /**
     * 确定插入数字的索引，将给定的数字插入在原有序数组哪个位置，若该数字存在数组中，则返回该数字下标，若不存在则返回正确插入的位置
     * 使用二分查找的思想来确定要插入的位置，若找到该数字则直接返回该索引下标，否则返回 low 即可。
     * @param nums  输入的数组
     * @param target    要插入的数字
     * @return  数组中的下标（从 0 开始）
     */
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
