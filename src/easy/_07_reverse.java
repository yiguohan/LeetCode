package easy;

/**
 * 题目描述：
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 */
public class _07_reverse {

    private static int reverse(int x) {
        int i = Integer.MAX_VALUE % 10;
        int j = Integer.MIN_VALUE % 10;
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > i)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < j)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }


    public static void main(String[] args) {

    }

}
