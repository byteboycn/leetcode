package cn.byteboy.difficulty.hard._76;

import cn.byteboy.core.Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

/**
 * @author hongshaochuan
 * @date 2021/7/27
 *
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 *
 *
 *  注意：
 *
 *
 *  对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 *  如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *
 *
 *
 *  示例 1：
 *
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 *
 *
 *  示例 2：
 *
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 *
 *
 *  示例 3:
 *
 *
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *
 *
 *
 *  提示：
 *
 *
 *  1 <= s.length, t.length <= 105
 *  s 和 t 由英文字母组成
 *
 *
 *
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口
 *  👍 1260 👎 0
 */
public class MinimumWindowSubstring {

    @Solution
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        Map<Character, AtomicInteger> needs = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            needs.computeIfAbsent(t.charAt(i), k -> new AtomicInteger()).incrementAndGet();
        }
        while (right < s.length()) {

            char c = s.charAt(right);
            right++;
            AtomicInteger counter = needs.get(c);
            if (counter != null && counter.get() > 0) {
                valid++;
                counter.decrementAndGet();
            }
            System.out.println(s.substring(left, right));
            if (s.substring(left, right).equals("DOBECODEBA")) {
                System.out.println("fuck");
            }
            while (valid == t.length()) {
//                System.out.printf("%d, %d, %d\n", left, right, minLen);
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char d = s.charAt(left);
                left++;
                AtomicInteger counter2 = needs.get(d);
                if (counter2 != null && counter2.get() == 0) {
                    valid--;
                    counter2.incrementAndGet();
//                    if (valid < 0) {
//                        System.out.println("fuck");
//                    }
                }

            }

        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }


    public static void main(String[] args) {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));
    }


}
