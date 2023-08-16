import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n 个朋友在玩游戏。这些朋友坐成一个圈，按 顺时针方向 从 1 到 n 编号。从第 i 个朋友的位置开始顺时针移动 1 步会到达第 (i + 1) 个朋友的位置（1 <= i < n），而从第 n 个朋友的位置开始顺时针移动 1 步会回到第 1 个朋友的位置。
 *
 * 游戏规则如下：
 *
 * 第 1 个朋友接球。
 *
 * 接着，第 1 个朋友将球传给距离他顺时针方向 k 步的朋友。
 * 然后，接球的朋友应该把球传给距离他顺时针方向 2 * k 步的朋友。
 * 接着，接球的朋友应该把球传给距离他顺时针方向 3 * k 步的朋友，以此类推。
 * 换句话说，在第 i 轮中持有球的那位朋友需要将球传递给距离他顺时针方向 i * k 步的朋友。
 *
 * 当某个朋友第 2 次接到球时，游戏结束。
 *
 * 在整场游戏中没有接到过球的朋友是 输家 。
 *
 * 给你参与游戏的朋友数量 n 和一个整数 k ，请按升序排列返回包含所有输家编号的数组 answer 作为答案。
 * @Author LMH
 * @Date 2023/8/16 9:59:39
 **/
public class 找出转圈游戏输家2682 {
    public static void main(String[] args) {
        int[] ints = circularGameLosers(5, 2);
        System.out.println(Arrays.toString(ints));
    }

    /**
     *
     * @param n 代表朋友数量
     * @param k 代表起始是多少步
     * @return
     */
    public static int[] circularGameLosers(int n, int k) {
        // 定义一个数组做为存放参与游戏人员，以及标记此人是否接到球的作用
        boolean[] visit = new boolean[n];

        // 用于记录有多少人接到了球
        int count = 0;
        // 进行遍历，i代表起始步数，j代表从第一个朋友开始，也就数组的起始位0，!visit[j]表示，如果当前这个朋友已经得到过球了，i+=k是因为每一轮的步长都会在初始步长上加一倍
        for (int i = k, j = 0; !visit[j]; i += k) {
            // 循环到的这个朋友，将其设置为true，表示他接到过球
            visit[j] = true;
            // 数组下标加上步长，然后去对本身的长度取模，就可以得到下一个的位置下标，因为下标是从0开始的所以这里的逻辑不需要加一
            j = (j + i) % n;
            count++;
        }
        // 获取没有接到球的人
        int[] ans = new int[n-count];
        for (int i = 0,j=0; i < n; i++) {
            if (!visit[i]) {
                ans[j++] = i + 1;
            }
        }
        return ans;
    }
}
