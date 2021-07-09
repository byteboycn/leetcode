package cn.byteboy.core.converter;

import cn.byteboy.core.model.ListNode;

/**
 * @author hongshaochuan
 * @date 2021/7/9
 *
 * String to ListNode
 */
public class ListNodeTypeConverter implements TypeConverter<ListNode> {

    public static final ListNodeTypeConverter INSTANCE = new ListNodeTypeConverter();

    private ListNodeTypeConverter() {}

    @Override
    public ListNode convert(String input) {
        int[] arr = IntArrayTypeConverter.INSTANCE.convert(input);
        ListNode list = new ListNode();
        ListNode current = list;
        for (int i : arr) {
            current.next = new ListNode(i);
            current = current.next;
        }
        return list.next;
    }

    @Override
    public String reverse(ListNode input) {
        if (input == null)
            return "";
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        while (input != null) {
            sb.append(input.val).append(",");
            input = input.next;
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
    public Class<ListNode> getType() {
        return ListNode.class;
    }

    @Override
    public void register() {
        TypeConverterFactory.register(getType(), this);
    }
}
