package cn.byteboy.core.test;

import cn.hutool.core.util.StrUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Hong Shaochuan
 * @email xhhsc@outlook.com
 * @date 2020/8/16 18:35
 */
public class TestUtils {

    // convert String to int[]
    public static int[] parse2IntArray(String str) {
        if (StrUtil.isNotBlank(str)) {
            if (str.startsWith("[") && str.endsWith("]")) {

                String[] strArr = str.substring(1, str.length() - 1).split(",");
                int[] nums = new int[strArr.length];
                for (int i = 0; i < nums.length; i++) {
                    try {
                        nums[i] = Integer.parseInt(strArr[i].trim());
                    } catch (Exception e) {
                        throw new IllegalArgumentException(strArr[i] + " can not be translate to int type");
                    }

                }
                return nums;
            } else {
                throw new IllegalArgumentException("str must be start with [ and end with ]");
            }
        } else {
            throw new IllegalArgumentException("str not be blank");
        }
    }

    // convert String to int[][]
    public static int[][] parse2Int2Array(String str) {
        if (StrUtil.isNotBlank(str)) {
            if (str.startsWith("[") && str.endsWith("]")) {

                str = str.substring(1, str.length() - 1);
                Pattern pattern = Pattern.compile("(\\[[(\\+|\\-)?\\d,]+\\])");
                Matcher matcher = pattern.matcher(str);
                int count = 0;
                while (matcher.find()) {
                    count++;
                }
                if (count > 0) {
                    matcher = pattern.matcher(str);
                    int[][] nums = new int[count][];
                    count = 0;
                    while (matcher.find()) {
                        nums[count] = parse2IntArray(matcher.group());
                        count++;
                    }
                    return nums;
                } else {
                    throw new IllegalArgumentException(str + " can not be translate to int[][] type");
                }

            } else {
                throw new IllegalArgumentException("str must be start with [ and end with ]");
            }
        } else {
            throw new IllegalArgumentException("str not be blank");
        }
    }

}
