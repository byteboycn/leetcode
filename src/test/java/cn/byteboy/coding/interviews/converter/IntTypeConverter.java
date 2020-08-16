package cn.byteboy.coding.interviews.converter;

import cn.hutool.core.util.StrUtil;

/**
 * @author Hong Shaochuan
 * @email xhhsc@outlook.com
 * @date 2020/8/16 21:44
 */
public class IntTypeConverter implements TypeConverter<Integer> {

    @Override
    public Integer convert(String input) {
        if (StrUtil.isBlank(input)) {
            throw new IllegalArgumentException(input + " can not be blank");
        }
        return Integer.parseInt(input);
    }

    @Override
    public Class<Integer> getType() {
        return int.class;
    }

    @Override
    public void register() {
        TypeConverterFactory.register(int.class, this);
    }
}
