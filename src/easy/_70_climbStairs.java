package easy;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class _70_climbStairs {

    /**
     * 暴力递归版
     *
     * @param n
     * @return
     */
    private static int getWayWithRecursive(int n) {
        if (n <= 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        return getWayWithRecursive(n - 1) + getWayWithRecursive(n - 2);
    }

    /**
     * 动态规划版
     *
     * @param n
     * @return
     */
    private static int getWayWithDP(int n) {
        if (n < 2) {
            return 1;
        }
        int[] table = new int[n];
        table[0] = 1;
        table[1] = 1;
        for (int i = 2; i < n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }

        return table[n - 2] + table[n - 1];
    }

    public static void main(String[] args) {
    }
}
