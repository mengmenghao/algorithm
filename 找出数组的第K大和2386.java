import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author lmh
 * @description:
 * 给你一个整数数组 nums 和一个 正 整数 k 。你可以选择数组的任一 子序列 并且对其全部元素求和。
 *
 * 数组的 第 k 大和 定义为：可以获得的第 k 个 最大 子序列和（子序列和允许出现重复）
 *
 * 返回数组的 第 k 大和 。
 *
 * 子序列是一个可以由其他数组删除某些或不删除元素排生而来的数组，且派生过程不改变剩余元素的顺序。
 *
 * 注意：空子序列的和视作 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,4,-2], k = 5
 * 输出：2
 * 解释：所有可能获得的子序列和列出如下，按递减顺序排列：
 * - 6、4、4、2、2、0、0、-2
 * 数组的第 5 大和是 2 。
 * 示例 2：
 *
 * 输入：nums = [1,-2,3,4,-10,12], k = 16
 * 输出：10
 * 解释：数组的第 16 大和是 10 。
 * @projectName: algorithm
 * @className: 找出数组的第K大和2386
 * @createDate: 2024/3/9 21:14
 */
public class 找出数组的第K大和2386 {
    public static void main(String[] args) {
        System.out.println(kSumTwo(new int[]{2, 4, -2}, 5));
    }

    public static long kSumOne(int[] nums, int k) {
        // 获取数组长度
        int n = nums.length;
        // 记录正数的和
        long total = 0;
        // 循环数组
        for (int i = 0; i < n; i++) {
            // 如果当前元素大于0，直接加到total中
            if (nums[i] >= 0) {
                total += nums[i];
            } else {
                // 否则将当前元素变为正数，因为后续是找第k小的序列和，用于减去，
                // 那么如果此和是负数那么，就应该是加上这个负数，如果是正数，那么就应该是最大的和减去这个正数，
                // 所以为了统一操作就将负数转换成正数，后面直接用减法就成，因为都是要减去其绝对值，所以后面的排序操作是合理的
                nums[i] = -nums[i];
            }
        }
        // 排序数组
        Arrays.sort(nums);
        // 一个非负数数组的第k小的子序列之和（不选任何元素也是一个子序列）
        long ret = 0;

        // PriorityQueue 是 Java 集合框架中的一个类，位于 java.util.PriorityQueue 包下，它实现了 Queue 接口。这是一个无界优先级队列，基于堆（默认是小顶堆）实现，能够保证具有最高优先级的元素总是在队列头部。
        //使用 PriorityQueue 时，队列元素需要实现 Comparable 接口，或者在创建队列时提供自定义的 Comparator 实例，以便根据优先级对元素进行排序。
        PriorityQueue<long[]> pq = new PriorityQueue<long[]>((a, b) -> Long.compare(a[0], b[0]));
        // 将指定的元素插入到此优先级队列中。第一个元素与0,第一个元素：子序列之和；第二个元素：对应的下标
        pq.offer(new long[]{nums[0], 0});

        // k代表第k大的和
        for (int j = 2; j <= k; j++) {
            // 删除并返回队列中具有最小优先级（即最小值）的元素
            long[] arr = pq.poll();
            long t = arr[0];
            int i = (int) arr[1];
            ret = t;
            // n个数都加完了
            if (i == n - 1) {
                continue;
            }
            // i + 1 表示当前下标，当前下标必选
            // 上一个下标的数要选
            pq.offer(new long[]{t + nums[i + 1], i + 1});
            // 上一个下标的数不选
            pq.offer(new long[]{t - nums[i] + nums[i + 1], i + 1});
        }
        return total - ret;
    }
    static int cnt;

    public static long kSumTwo(int[] nums, int k) {
        int n = nums.length;
        long total = 0, total2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                total += nums[i];
            } else {
                nums[i] = -nums[i];
            }
            total2 += Math.abs(nums[i]);
        }
        Arrays.sort(nums);

        long left = 0, right = total2;
        while (left <= right) {
            long mid = (left + right) / 2;
            cnt = 0;
            dfs(nums, k, n, 0, 0, mid);
            if (cnt >= k - 1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return total - left;
    }

    public static void dfs(int[] nums, int k, int n, int i, long t, long limit) {
        if (i == n || cnt >= k - 1 || t + nums[i] > limit) {
            return;
        }
        cnt++;
        dfs(nums, k, n, i + 1, t + nums[i], limit);
        dfs(nums, k, n, i + 1, t, limit);
    }
}
