package cn.byteboy.difficulty.medium._870;

import cn.byteboy.core.Solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hongshaochuan
 * @Date 2021/7/26
 *
 * 给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
 *
 *  返回 A 的任意排列，使其相对于 B 的优势最大化。
 *
 *
 *
 *  示例 1：
 *
 *  输入：A = [2,7,11,15], B = [1,10,4,11]
 * 输出：[2,11,7,15]
 *
 *
 *  示例 2：
 *
 *  输入：A = [12,24,8,32], B = [13,25,32,11]
 * 输出：[24,32,8,12]
 *
 *
 *
 *
 *  提示：
 *
 *
 *  1 <= A.length = B.length <= 10000
 *  0 <= A[i] <= 10^9
 *  0 <= B[i] <= 10^9
 *
 *  Related Topics 贪心 数组 排序
 *  👍 137 👎 0
 */
public class AdvantageShuffle {

    @Solution
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[] res = new int[len];

        // 升序
        Arrays.sort(nums1);

        // 降序
        PriorityQueue<int[]> maxQ = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < len; i++) {
            maxQ.offer(new int[]{i, nums2[i]});
        }
        int left = 0;
        int right = len - 1;
        // 每次都拿nums1的最大的和nums2最大的打，打的过就上，打不过就那nums1最小的打
        while (!maxQ.isEmpty()) {
            int[] q = maxQ.poll();
            if (nums1[right] > q[1]) {
                res[q[0]] = nums1[right];
                right--;
            } else {
                res[q[0]] = nums1[left];
                left++;
            }
        }
        return res;
    }
}
