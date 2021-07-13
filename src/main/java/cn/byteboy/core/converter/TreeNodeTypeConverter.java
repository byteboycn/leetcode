package cn.byteboy.core.converter;

import cn.byteboy.core.model.TreeNode;
import cn.byteboy.core.test.TestUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hongshaochuan
 * @Date 2021/7/13
 */
public class TreeNodeTypeConverter implements TypeConverter<TreeNode> {

    public static final TreeNodeTypeConverter INSTANCE = new TreeNodeTypeConverter();


    private TreeNodeTypeConverter() {}

    @Override
    public TreeNode convert(String input) {
        String[] arr = TestUtils.parse2StringArray(input);
        if (arr.length == 0)
            return null;

        List<TreeNode> nodeList = new LinkedList<>();

        for (String s : arr) {
            if (s.equalsIgnoreCase("null")) {
                nodeList.add(null);
            } else {
                nodeList.add(new TreeNode(Integer.parseInt(s)));
            }
        }

        int curLevelCount = 0;
        int curLevel = 0;
        for (int i = 0; i < arr.length; i++) {
            curLevelCount++;

            int offset = (int) Math.pow(2, curLevel) + (curLevelCount - 1) * 2;
            TreeNode cur = nodeList.get(i);
            if (cur != null) {
                cur.left = i + offset > arr.length - 1 ? null : nodeList.get(i + offset);
                cur.right = i + offset + 1 > arr.length - 1 ? null : nodeList.get(i + offset + 1);
            }
            if (Math.pow(2, curLevel) == curLevelCount) {
                curLevel++;
                curLevelCount = 0;
            }
        }
        return nodeList.get(0);
    }

    @Override
    public String reverse(TreeNode input) {

        List<String> nodes = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(input);
        // 若下一层级全部为null,则截止到该层级
        long curLevelCount = 0; // 当前层的数量
        int curLevel = 0;   // 当前层级
        int nullCount = 0;  // 当前层连续的null数量
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            curLevelCount++;

            if (node != null) {
                nullCount = 0;
                nodes.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                nullCount++;
                nodes.add("null");
                queue.offer(null);
                queue.offer(null);
            }

            if (Math.pow(2, curLevel) == nullCount) {
                break;
            }

            if (Math.pow(2, curLevel) == curLevelCount) {
                curLevel++;
                curLevelCount = 0;
                nullCount = 0;
            }
        }
        return "[" + String.join(",", nodes.subList(0, nodes.size() - nullCount)) + "]";
    }



    @Override
    public Class<TreeNode> getType() {
        return TreeNode.class;
    }

    @Override
    public void register() {
        TypeConverterFactory.register(getType(), this);
    }

}
