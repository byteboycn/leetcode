package cn.byteboy.difficulty.medium._22;

import cn.byteboy.core.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author hongshaochuan
 * @date 2021/8/11
 *
 * Given n pairs of parentheses, write a function to generate all combinations of
 *  well-formed parentheses.
 *
 *
 *  Example 1:
 *  Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *  Example 2:
 *  Input: n = 1
 * Output: ["()"]
 *
 *
 *  Constraints:
 *
 *
 *  1 <= n <= 8
 *
 *  Related Topics String Dynamic Programming Backtracking
 *  👍 9238 👎 363
 */
public class GenerateParentheses {

    @Solution
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, n, new Stack<>(), res);
        return res;
    }

    private void backtrack(int left, int right, Stack<Character> track, List<String> res) {
        if (right < left || left < 0)
            return;
        if (left == 0 && right == 0) {
            StringBuilder s = new StringBuilder();
            track.forEach(s::append);
            res.add(s.toString());
            return;
        }

        track.push('(');
        backtrack(left - 1, right, track, res);
        track.pop();

        track.push(')');
        backtrack(left, right - 1, track, res);
        track.pop();
    }
}
