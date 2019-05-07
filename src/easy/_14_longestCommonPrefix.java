package easy;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class _14_longestCommonPrefix {

    private static String process(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int columns = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            columns = strs[i].length() < columns ? strs[i].length() : columns;
        }
        if (columns == 0) {
            return "";
        }
        int index = 0;
        while (index < columns) {
            char target = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(index) != target) {
                    return strs[i].substring(0, index);
                }
            }
            index++;
        }
        return strs[0].substring(0, columns);
    }

    public static void main(String[] args) {
        String[] text = new String[]{"cctv", "cctva", "ccc"};
        System.out.println(process(text));
    }
}
