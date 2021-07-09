package cn.byteboy.core.converter;

/**
 * @author Hong Shaochuan
 * @email xhhsc@outlook.com
 * @date 2020/8/16 21:41
 *
 * type converter
 * make input convert to type R
 *
 */
public interface TypeConverter<R> {
    R convert(String input);

    String reverse(R input);

    Class<R> getType();

    void register();
}
