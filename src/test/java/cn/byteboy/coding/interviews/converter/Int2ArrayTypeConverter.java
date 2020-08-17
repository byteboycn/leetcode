package cn.byteboy.coding.interviews.converter;

import cn.byteboy.coding.interviews.TestUtils;

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
    public Class<int[][]> getType() {
        return int[][].class;
    }

    @Override
    public void register() {
        TypeConverterFactory.register(getType(), this);
    }
}
