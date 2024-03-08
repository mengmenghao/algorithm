/**
 * @author lmh
 * @description:
 * 给你两个正整数：n 和 target 。
 *
 * 如果数组 nums 满足下述条件，则称其为 美丽数组 。
 *
 * nums.length == n.
 * nums 由两两互不相同的正整数组成。
 * 在范围 [0, n-1] 内，不存在 两个 不同 下标 i 和 j ，使得 nums[i] + nums[j] == target 。
 * 返回符合条件的美丽数组所可能具备的 最小 和，并对结果进行取模 109 + 7。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2, target = 3
 * 输出：4
 * 解释：nums = [1,3] 是美丽数组。
 * - nums 的长度为 n = 2 。
 * - nums 由两两互不相同的正整数组成。
 * - 不存在两个不同下标 i 和 j ，使得 nums[i] + nums[j] == 3 。
 * 可以证明 4 是符合条件的美丽数组所可能具备的最小和。
 * 示例 2：
 *
 * 输入：n = 3, target = 3
 * 输出：8
 * 解释：
 * nums = [1,3,4] 是美丽数组。
 * - nums 的长度为 n = 3 。
 * - nums 由两两互不相同的正整数组成。
 * - 不存在两个不同下标 i 和 j ，使得 nums[i] + nums[j] == 3 。
 * 可以证明 8 是符合条件的美丽数组所可能具备的最小和。
 * 示例 3：
 *
 * 输入：n = 1, target = 1
 * 输出：1
 * 解释：nums = [1] 是美丽数组。
 * @projectName: algorithm
 * @className: 找出美丽数组的最小和2834
 * @createDate: 2024/3/8 23:20
 */
public class 找出美丽数组的最小和2834 {
    public static void main(String[] args) {
        System.out.println(minimumPossibleSum(2, 3));
    }

    // 方法一：贪心
    // 首先考虑特殊情况。当k <= 2时，由于选择的数字互不相同，那么必然不会出现两个数字之和等于k，因此在这种情况下就应该选择最小的n个自然数，这些数的和就是(1 + n) * n / 2。
    //
    //接下来对于k > 2的情况，此时就存在若干组和等于k的数对。等k为奇数时，有(1, k - 1)、(2, k - 2)、...、(k / 2, k / 2 + 1)这些数对，而当k等于偶数时，则有(1, k - 1)、(2, k - 2)、(k / 2 - 1, k / 2 + 1)这些数对。
    //
    //为了使得答案最小，无论是奇数还是偶数的情况，在小于k的数中都只能选择1到k / 2这些数，而k / 2 + 1到k - 1这些则必然会被丢弃。
    //
    //记m = k / 2，那么当n <= m时，依然是直接选择1到n这些数，于是此时的答案同样是(1 + n) * n / 2。
    //
    //当n > m时，就只能先选择1到m，然后对于剩下的n - m个数，则需要从k开始向上选择，也就是最终将选择1到m，以及k到k + n - m + 1这两段，此时的答案就是(1 + m) * m / 2 + (k + k + n - m + 1) * (n - m) / 2。
    public static int minimumPossibleSum(int n, int target) {
        final int MOD = (int) 1e9 + 7;
        int m = target / 2;
        if (n <= m) {
            return (int) ((long) (1 + n) * n / 2 % MOD);
        }
        return (int) (((long) (1 + m) * m / 2 +
                ((long) target + target + (n - m) - 1) * (n - m) / 2) % MOD);
    }
}
