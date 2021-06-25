package cn.byteboy.difficulty.easy;


import java.util.HashMap;
import java.util.Map;

/**
 * @author Nature
 * @version 1.0
 * @email xhhsc@outlook.com
 * @date 2020/2/10 2:02 AM
 *
 * @name
 * 两数之和
 *
 * @description
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * @example
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4,-5};
        int target = -8;
        int[] res = new TwoSum().twoSum(nums, target);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{};

        // 假如两个相同值
        if (target % 2 == 0) {
            int z = target / 2;
            int x = -1;
            int y = -1;
            for (int i = 0; i < nums.length; i++) {
                if (z == nums[i]) {
                    if (x == -1)
                        x = i;
                    else
                        y = i;
                }
            }
            if (x != y && y != -1)
                return new int[]{x, y};
        }

        Map<Integer, Integer> source = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            source.put(nums[i], i);
        }

        int num1Index = 0;
        int num2Index = 0;

        for (Map.Entry<Integer, Integer> entry: source.entrySet()) {
            int num1 = target - entry.getKey();
            try {
                num1Index = source.get(num1);
            } catch (NullPointerException e) {
                continue;
            }

            num2Index = entry.getValue();
            break;
        }
        return new int[]{num1Index, num2Index};


    }
}
