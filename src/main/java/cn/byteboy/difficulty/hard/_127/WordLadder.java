package cn.byteboy.difficulty.hard._127;

import cn.byteboy.core.Solution;

import java.util.*;

/**
 * @author hongshaochuan
 * @Date 2021/8/11
 *
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
 *
 *
 *  序列中第一个单词是 beginWord 。
 *  序列中最后一个单词是 endWord 。
 *  每次转换只能改变一个字母。
 *  转换过程中的中间单词必须是字典 wordList 中的单词。
 *
 *
 *  给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中
 * 的 单词数目 。如果不存在这样的转换序列，返回 0。
 *
 *
 *  示例 1：
 *
 *
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
 * g","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 *
 *
 *  示例 2：
 *
 *
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
 * g"]
 * 输出：0
 * 解释：endWord "cog" 不在字典中，所以无法进行转换。
 *
 *
 *
 *  提示：
 *
 *
 *  1 <= beginWord.length <= 10
 *  endWord.length == beginWord.length
 *  1 <= wordList.length <= 5000
 *  wordList[i].length == beginWord.length
 *  beginWord、endWord 和 wordList[i] 由小写英文字母组成
 *  beginWord != endWord
 *  wordList 中的所有字符串 互不相同
 *
 *  Related Topics 广度优先搜索 哈希表 字符串
 *  👍 825 👎 0
 */
public class WordLadder {

    @Solution
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int step = 1;   // begin 算一步
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (endWord.equals(cur)) {
                    return step;
                }
                for (String s : findTheNext(cur, wordList)) {
                    if (!visited.contains(s)) {
                        q.offer(s);
                        visited.add(s);
                    }

                }
            }
            step++;

        }

        return 0;
    }

    private List<String> findTheNext(String word, List<String> wordList) {
        List<String> res = new LinkedList<>();
        int mark = 0;
        for (String w : wordList) {
            for (int i = 0; i < word.length(); i++) {
                if (w.charAt(i) != word.charAt(i)) {
                    mark++;
                    if (mark > 1) {
                        break;
                    }
                }
            }
            if (mark == 1)
                res.add(w);
            mark = 0;
        }
        return res;
    }

    @Solution("双向BFS")
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        q1.add(beginWord);
        q2.add(endWord);
        int step = 1;
        Set<String> visited = new HashSet<>();

        while (!q1.isEmpty() && !q2.isEmpty()) {
            Set<String> temp = new HashSet<>();
            for (String cur : q1) {
                if (q2.contains(cur))
                    return step;
                visited.add(cur);
                for (String s : findTheNext(cur, wordList)) {
                    if (!visited.contains(s)) {
                        temp.add(s);
                    }
                }
            }
            step++;
            q1 = q2;
            q2 = temp;
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> arr = Arrays.asList("hot","dot","dog","lot","log","cog");
        String beginWord = "hit";
        String endWord = "cog";

        WordLadder w = new WordLadder();
        System.out.println(w.ladderLength2(beginWord, endWord, arr));
    }
}
