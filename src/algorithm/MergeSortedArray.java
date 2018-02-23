package algorithm;

public class MergeSortedArray {

    /**
     * 合并两个有序数组
     * 因为被合并的那个数组足够大，所以不用担心溢出的问题。从后面往前遍历并合并。
     * @param nums1 数组1
     * @param m 指定数组1什么位置开始合并
     * @param nums2 数组2
     * @param n 合并数组2的几个元素
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 要合并的元素个数为0个，直接返回
        if(n == 0) {
            return;
        }
        // 被合并的数组为空，直接将要合并的数组元素进行复制过去
        if(m == 0 && n != 0) {
            for(int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }

        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        // 从后往前比较，将大的数字放到后面的位置
        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            }else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // 被合并的数组还有剩余，继续合并
        while(i >= 0) {
            nums1[k] = nums1[i];
            i--;
            k--;
        }

        // 合并的数组还有剩余，继续合并
        while(j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }


    public static void main(String[] args) {

    }



}
