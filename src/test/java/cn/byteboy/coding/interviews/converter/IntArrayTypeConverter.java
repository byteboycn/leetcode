package cn.byteboy.coding.interviews.converter;

import cn.byteboy.coding.interviews.TestUtils;

/**
 * @author Hong Shaochuan
 * @email xhhsc@outlook.com
 * @date 2020/8/16 21:43
 */
public class IntArrayTypeConverter implements TypeConverter<int[]> {

    @Override
    public int[] convert(String input) {
        return TestUtils.parse2IntArray(input);
    }

    @Override
    public Class<int[]> getType() {
        return int[].class;
    }

    @Override
    public void register() {
        TypeConverterFactory.register(int[].class, this);
    }
}
