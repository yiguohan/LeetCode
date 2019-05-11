package easy;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class _28_strStr {


    private static int process(String haystack, String needle) {

        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack.equals(needle)) {
            return 0;
        }

        int hIndex = 0;
        int nIndex = 0;
        int index = 0;

        while (hIndex < haystack.length()) {
            if (nIndex < needle.length()) {
                if (haystack.charAt(hIndex) == needle.charAt(nIndex)) {
                    nIndex++;
                    hIndex++;
                } else {
                    nIndex = 0;
                    index++;
                    hIndex = index;
                }
            } else {
                return hIndex - nIndex;
            }

        }

        if (nIndex == needle.length()) {
            return hIndex - nIndex;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(process("hello", "llo"));
    }

}
