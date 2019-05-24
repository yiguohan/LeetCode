package easy;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class _67_addBinary {

    private static String process(String a, String b) {
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
        int[] result = new int[Math.max(a.length(), b.length())];

        int indexA = arrA.length - 1;
        int indexB = arrB.length - 1;

        int carry = 0;
        int intA = 0;
        int intB = 0;
        int curValue = 0;

        while (indexA >= 0 && indexB >= 0) {
            intA = arrA[indexA] - '0';
            intB = arrB[indexB] - '0';
            curValue = (intA + intB + carry) % 2;
            carry = (intA + intB + carry) / 2;
            result[Math.max(indexA, indexB)] = curValue;
            indexA--;
            indexB--;
        }

        while (indexA >= 0) {
            intA = arrA[indexA] - '0';
            curValue = (intA + carry) % 2;
            carry = (intA + carry) / 2;
            result[indexA] = curValue;
            indexA--;
        }

        while (indexB >= 0) {
            intB = arrB[indexB] - '0';
            curValue = (intB + carry) % 2;
            carry = (intB + carry) / 2;
            result[indexB] = curValue;
            indexB--;
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
        }

        if (carry > 0) {
            sb.insert(0, '1');
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(process("100", "110010"));
    }
}
