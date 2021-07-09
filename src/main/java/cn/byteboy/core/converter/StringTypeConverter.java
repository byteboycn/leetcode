package cn.byteboy.core.converter;

/**
 * @author hongshaochuan
 * @Date 2021/6/29
 *
 * "" -> 空字符串
 * ” “ -> 空格
 * \"\" -> ""
 * "abc" -> abc
 * abc -> abc
 * \"abc\" -> "abc"
 * \\ -> \
 * a" -> a
 *
 */
public class StringTypeConverter implements TypeConverter<String> {

    @Override
    public String convert(String input) {
        if (input == null)
            return null;

        boolean mark = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != '"' && c != '\\') {
                sb.append(c);
                mark = false;
            } else {
                if (c == '"') {
                    if (mark) {
                        sb.append('"');
                        mark = false;
                    }
                }
                if (c == '\\') {
                    if (mark) {
                        sb.append('\\');
                        mark = false;
                    } else {
                        mark = true;
                    }

                }
            }
        }
        return sb.toString();
    }

    @Override
    public String reverse(String input) {
        return input == null ? "" : input;
    }

    @Override
    public Class<String> getType() {
        return String.class;
    }

    @Override
    public void register() {
        TypeConverterFactory.register(getType(), this);
    }
}
