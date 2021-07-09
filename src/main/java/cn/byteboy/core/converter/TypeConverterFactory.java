package cn.byteboy.core.converter;


import java.util.HashMap;
import java.util.Map;

/**
 * @author Hong Shaochuan
 * @email xhhsc@outlook.com
 * @date 2020/8/16 20:38
 */
public class TypeConverterFactory {

    private static final Map<Class<?>, TypeConverter<?>> strategyMap = new HashMap<>();

    @SuppressWarnings("rawtypes")
    public static TypeConverter getStrategy(Class<?> type) {
        return strategyMap.get(type);
    }

    public static void register(Class<?> type, TypeConverter<?> converter) {
        if (type == null || converter == null) {
            return;
        }
        strategyMap.put(type, converter);
    }
}
