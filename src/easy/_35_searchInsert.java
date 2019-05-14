package easy;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class _35_searchInsert {

    private static int process(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        int index = (left + right) / 2;

        while (left < right) {
            if (nums[index] > target) {
                right = index - 1 < 0 ? 0 : index - 1;
                index = (left + right) / 2;
            } else if (nums[index] < target) {
                left = index + 1;
                index = (left + right) / 2;
            } else {
                return index;
            }
        }

        if (nums[index] >= target) {
            return index;
        } else {
            return index + 1;
        }

    }

    public static void main(String[] args) {
        int[] test = new int[]{3, 5, 7, 9, 10};
        System.out.println(process(test, 8));
    }
}
