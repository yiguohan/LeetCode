package middle;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class _06_zigzagConversion {

    private static String process(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows == 1) {
            return s;
        }

        char[][] matrix = new char[numRows][getColumnNum(s, numRows)];
        setMatrix(matrix, s);
        return printMatrix(matrix);

    }

    private static int getColumnNum(String s, int numRows) {
        int num1 = (s.length() / (2 * numRows - 2)) * (numRows - 1);
        int num2 = 0;

        if (s.length() % (2 * numRows - 2) == 0) {
            num2 = 0;
        } else {
            num2 = s.length() % (2 * numRows - 2) <= numRows ? 1 : (s.length() % (2 * numRows - 2) - numRows + 1);
        }

        return num1 + num2;
    }

    private static void setMatrix(char[][] matrix, String s) {

        int rowIndex = 0;
        int columnIndex = 0;
        boolean isFromTop = true;
        for (int i = 0; i < s.length(); i++) {
            matrix[rowIndex][columnIndex] = s.charAt(i);
            if (isFromTop) {
                if (rowIndex == matrix.length - 1) {
                    isFromTop = !isFromTop;
                    rowIndex--;
                    columnIndex++;
                } else {
                    rowIndex++;
                }
            } else {
                if (rowIndex == 0) {
                    isFromTop = !isFromTop;
                    rowIndex++;
                } else {
                    rowIndex--;
                    columnIndex++;
                }
            }
        }
    }

    private static String printMatrix(char[][] matrix) {
        char n = '\0';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != n) {
                    sb.append(matrix[i][j]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(process("PAYPALISHIRING", 5));
    }
}
