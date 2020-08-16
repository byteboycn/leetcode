package cn.byteboy.coding.interviews;

import cn.hutool.core.util.StrUtil;

/**
 * @author Hong Shaochuan
 * @email xhhsc@outlook.com
 * @date 2020/8/16 18:35
 */
public class TestUtils {

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
}
