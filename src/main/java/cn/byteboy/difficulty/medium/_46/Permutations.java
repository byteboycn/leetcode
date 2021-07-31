package cn.byteboy.difficulty.medium._46;

import cn.byteboy.core.Solution;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hongshaochuan
 * @Date 2021/7/31
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *
 *
 *  示例 1：
 *
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 *  示例 2：
 *
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 *
 *
 *  示例 3：
 *
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 *
 *
 *
 *  提示：
 *
 *
 *  1 <= nums.length <= 6
 *  -10 <= nums[i] <= 10
 *  nums 中的所有整数 互不相同
 *
 *  Related Topics 数组 回溯
 *  👍 1468 👎 0
 */
public class Permutations {

    private List<List<Integer>> res = new LinkedList<>();

    @Solution
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new LinkedList<>());
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track) {

        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int num : nums) {
            if (track.contains(num))
                continue;
            track.add(num);
            backtrack(nums, track);
            track.removeLast();
        }
    }
}
