package cn.byteboy.difficulty.medium;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nature
 * @version 1.0
 * @email xhhsc@outlook.com
 * @date 2020/2/10 5:12 AM
 *
 * @name
 * 字符串转换整数 (atoi)
 *
 * @description
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @example
 * 输入: "42"
 * 输出: 42
 */
public class StringToIntegerAtoi {

    public static void main(String[] args) {
        System.out.println(new StringToIntegerAtoi().myAtoi("-1"));
    }

    public int myAtoi(String str) {
        str = str.trim();
        int value = 0;
        Pattern pattern = Pattern.compile("^[\\+\\-]?\\d+");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            try {
                value = Integer.valueOf(str.substring(matcher.start(), matcher.end()));
            } catch (Exception e) {
                e.printStackTrace();
                value = str.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }

        return value;
    }


}
