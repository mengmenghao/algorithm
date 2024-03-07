package 数组遍历;

/**
 * @author lmh
 * @description: 一句话描述该类的功能
 * @projectName: algorithm
 * @className: 最大连续1的个数485
 * @createDate: 2024/3/7 20:56
 */
public class 最大连续1的个数485 {
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));

    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        // maxCount最大连续1的个数,count当前连续1的个数
        int maxCount = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                maxCount = Math.max(count, maxCount);
                count = 0;
            }
        }

        maxCount = Math.max(count, maxCount);
        return maxCount;
    }
}
