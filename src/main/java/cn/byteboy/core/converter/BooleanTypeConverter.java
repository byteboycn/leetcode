package cn.byteboy.core.converter;

import cn.hutool.core.util.StrUtil;

/**
 * @author Hong Shaochuan
 * @email xhhsc@outlook.com
 * @date 2020/8/17 22:46
 */
public class BooleanTypeConverter implements TypeConverter<Boolean> {

    @Override
    public Boolean convert(String input) {
        if (StrUtil.isBlank(input)) {
            throw new IllegalArgumentException(input + " can not be blank");
        }
        return Boolean.parseBoolean(input);
    }

    @Override
    public Class<Boolean> getType() {
        return Boolean.TYPE;
    }

    @Override
    public void register() {
        TypeConverterFactory.register(getType(), this);
    }
}
