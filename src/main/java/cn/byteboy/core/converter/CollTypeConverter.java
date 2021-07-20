package cn.byteboy.core.converter;

import cn.byteboy.core.test.TestUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author hongshaochuan
 * @Date 2021/7/20
 */
public class CollTypeConverter<T> implements TypeConverter<Collection<T>> {

    private final Class<T> clazz;

    public CollTypeConverter(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Collection<T> convert(String input) {
        TypeConverter<T> converter = TypeConverterFactory.getStrategy(clazz);
        String[] arr = TestUtils.parse2StringArray(input);
        List<T> coll = new ArrayList<>(arr.length);
        for (String s : arr) {
            T obj = converter.convert(s);
            coll.add(obj);
        }
        return coll;
    }

    @Override
    public String reverse(Collection<T> input) {
        TypeConverter<T> converter = TypeConverterFactory.getStrategy(clazz);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (T obj : input) {
            sb.append(converter.reverse(obj));
        }
        sb.append("[");
        return sb.toString();
    }

    @Override
    public Class<Collection<T>> getType() {
        return (Class<Collection<T>>) (Class<?>) Collection.class;
    }

    @Override
    public void register() {

    }
}
