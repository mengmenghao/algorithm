import java.util.Arrays;

/**
 * @author lmh
 * @description: 给你一个下标从 0 开始的字符串 word ，长度为 n ，由从 0 到 9 的数字组成。另给你一个正整数 m 。
 * <p>
 * word 的 可整除数组 div  是一个长度为 n 的整数数组，并满足：
 * <p>
 * 如果 word[0,...,i] 所表示的 数值 能被 m 整除，div[i] = 1
 * 否则，div[i] = 0
 * 返回 word 的可整除数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "998244353", m = 3
 * 输出：[1,1,0,0,0,1,1,0,0]
 * 解释：仅有 4 个前缀可以被 3 整除："9"、"99"、"998244" 和 "9982443" 。
 * 示例 2：
 * <p>
 * 输入：word = "1010", m = 10
 * 输出：[0,1,0,1]
 * 解释：仅有 2 个前缀可以被 10 整除："10" 和 "1010" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * word.length == n
 * word 由数字 0 到 9 组成
 * 1 <= m <= 109
 * @projectName: algorithm
 * @className: 找出字符串的可整除数组2575
 * @createDate: 2024/3/7 20:01
 */
public class 找出字符串的可整除数组2575 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(divisibilityArray("998244353", 3)));
    }

    public static int[] divisibilityArray(String word, int m) {
        int[] res = new int[word.length()];
        //int cur = 0; 注意这里要用long，用int可能会越界
        // Java中int类型的取值范围是：
        //最小值：-2^31
        //最大值：2^31 - 1
        //具体数值为：
        //最小值：-2,147,483,648
        //最大值：2,147,483,647
        long cur = 0;
        for (int i = 0; i < word.length(); i++) {
            // word.charAt(i)返回指定索引处的 char 值
            char c = word.charAt(i);
            // charAt - '0'代表获取数值，(mod * 10 + (charAt - '0'))将个位数与前面的数相加
            // % m 获取余数，如果余数为0，说明当前数字可以被m整除，否则不能，将余数当做剩余数值，用于后面继续除
            cur = (cur * 10 + (c - '0')) % m;
            res[i] = (cur == 0) ? 1 : 0;

        }
        return res;


    }
}
