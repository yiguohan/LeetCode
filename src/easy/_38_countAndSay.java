package easy;

import java.util.HashMap;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 */
public class _38_countAndSay {

    private static String process(int n) {
        String result = "1";
        while (n > 1) {
            n--;
            result = getNextNum(result);
        }
        return new StringBuilder(result).reverse().toString();
    }

    private static String getNextNum(String current) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < current.length(); i++) {
            if (map.isEmpty()) {
                map.put(current.charAt(i), 1);
            } else {
                if (map.containsKey(current.charAt(i))) {
                    map.put(current.charAt(i), map.get(current.charAt(i)) + 1);
                } else {
                    char lastChar = map.keySet().iterator().next();
                    sb.append(lastChar)
                            .append(map.get(lastChar));
                    map.clear();
                    map.put(current.charAt(i), 1);
                }
            }
        }
        char lastChar = map.keySet().iterator().next();
        sb.append(lastChar)
                .append(map.get(lastChar));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(process(3));
    }
}
