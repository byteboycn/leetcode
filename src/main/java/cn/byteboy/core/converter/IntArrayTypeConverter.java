package cn.byteboy.core.converter;

import cn.byteboy.core.test.TestUtils;

/**
 * @author Hong Shaochuan
 * @email xhhsc@outlook.com
 * @date 2020/8/16 21:43
 */
public class IntArrayTypeConverter implements TypeConverter<int[]> {

    public static final IntArrayTypeConverter INSTANCE = new IntArrayTypeConverter();

    private IntArrayTypeConverter() {}

    @Override
    public int[] convert(String input) {
        return TestUtils.parse2IntArray(input);
    }

    @Override
    public String reverse(int[] input) {
        if (input == null)
            return "";
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i : input) {
            sb.append(i).append(",");
        }
        int i = sb.lastIndexOf(",");
        if (i != -1) {
            sb.replace(i, i + 1, "]");
        } else {
            sb.append("]");
        }
        return sb.toString();
    }

    @Override
    public Class<int[]> getType() {
        return int[].class;
    }

    @Override
    public void register() {
        TypeConverterFactory.register(getType(), this);
    }
}
