package leetcode.array;

import java.util.TreeSet;

/**
 * ${DESCRIPTION}
 *
 * @author zhangzhengye
 * @create 2017-10-01 下午8:36
 * <p>
 * There is a garden with N slots. In each slot, there is a flower. The N flowers will bloom one by one in N days. In each day,
 * <p>
 * there will be exactly one flower blooming and it will be in the status of blooming since then.
 * <p>
 * Given an array flowers consists of number from 1 to N. Each number in the array represents the place where the flower
 * <p>
 * will open in that day.
 * <p>
 * 每天只会有一个花开(数组不重复)
 * <p>
 * For example, flowers[i] = x means that the unique flower that blooms at day i will be at position x, where i and x will be
 * <p>
 * in the range from 1 to N.
 * <p>
 * 第i天第x个花会开
 * <p>
 * Also given an integer k, you need to output in which day there exists two flowers in the status of blooming, and also the
 * <p>
 * number of flowers between them is k and these flowers are not blooming.
 * <p>
 * 求第几天两个开着的花之间有k个花没开
 * <p>
 * If there isn't such day, output -1.
 * <p>
 * Example 1:
 * Input:
 * flowers: [1,3,2]
 * k: 1
 * Output: 2
 * Explanation: In the second day, the first and the third flower have become blooming.
 * <p>
 * Example 2:
 * Input:
 * flowers: [1,2,3]
 * k: 1
 * Output: -1
 */

public class KEmptySlots {

    public static int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> tree = new TreeSet<>();
        for (int i = 0; i < flowers.length; i++) {
            int cur = flowers[i];
            tree.add(cur);

            Integer higher = tree.higher(cur);
            if (higher != null && higher - cur == k + 1) {
                return i + 1;
            }
            Integer lower = tree.lower(cur);
            if (lower != null && cur - lower == k + 1) {
                return i + 1;
            }
        }
        return -1;
    }

}
