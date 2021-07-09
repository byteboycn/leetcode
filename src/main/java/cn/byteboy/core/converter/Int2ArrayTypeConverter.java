package cn.byteboy.core.converter;

import cn.byteboy.core.test.TestUtils;

/**
 * @author Hong Shaochuan
 * @email xhhsc@outlook.com
 * @date 2020/8/17 22:48
 *
 * 二维Int数组转换器
 */
public class Int2ArrayTypeConverter implements TypeConverter<int[][]> {

    @Override
    public int[][] convert(String input) {
        return TestUtils.parse2Int2Array(input);
    }

    @Override
    public String reverse(int[][] input) {
        if (input == null)
            return "";

        StringBuffer sb = new StringBuffer("[");
        for (int[] ints : input) {
            sb.append(IntArrayTypeConverter.INSTANCE.reverse(ints)).append(",");
        }
        if (input.length > 0) {
            int i = sb.lastIndexOf(",");
            if (i != -1) {
                sb.replace(i, i + 1, "]");
            }
        } else {
            sb.append("]");
        }
        return sb.toString();
    }

    @Override
    public Class<int[][]> getType() {
        return int[][].class;
    }

    @Override
    public void register() {
        TypeConverterFactory.register(getType(), this);
    }
}
