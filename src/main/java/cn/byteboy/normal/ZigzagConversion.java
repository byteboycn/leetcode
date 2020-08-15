package cn.byteboy.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nature
 * @version 1.0
 * @email xhhsc@outlook.com
 * @date 2020/2/10 4:31 AM
 *
 * @name
 * Z 字形变换
 *
 * @description
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * @example
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 *
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 */
public class ZigzagConversion {

    public static void main(String[] args) {
        System.out.println(new ZigzagConversion().convert("LEETCODEISHIRING", 3));
    }


    public String convert(String s, int numRows) {
        List<List<Character>> res = new ArrayList<>();
        int rowNum = Math.max(s.length(), numRows);
        for (int i = 0; i < rowNum; i++) {
            res.add(new ArrayList<>());
        }

        int row = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            List<Character> rowList = res.get(row);
            rowList.add(s.charAt(i));
            if (flag) {
                row++;
            } else {
                row--;
            }
            if (row == numRows - 1 || row == 0) flag = !flag;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rowNum; i++) {
            res.get(i).forEach(sb::append);
        }
        return sb.toString();

    }


}
