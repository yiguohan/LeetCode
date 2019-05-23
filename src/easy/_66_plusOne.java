package easy;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class _66_plusOne {

    private static int[] process(int[] digits) {

        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int current = digits[i];
            int result = (current + carry + (i == digits.length - 1 ? 1 : 0)) % 10;
            carry = (current + carry + (i == digits.length - 1 ? 1 : 0)) / 10;
            digits[i] = result;
        }
        if (carry == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }

    public static void main(String[] args) {

    }
}
