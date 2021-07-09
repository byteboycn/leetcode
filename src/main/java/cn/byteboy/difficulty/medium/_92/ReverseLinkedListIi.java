package cn.byteboy.difficulty.medium._92;

import cn.byteboy.core.Solution;
import cn.byteboy.core.model.ListNode;

import java.util.List;

/**
 * @author hongshaochuan
 * @date 2021/7/9
 *
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
 * 表节点，返回 反转后的链表 。
 *
 *
 *  示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 *
 *
 *  示例 2：
 *
 *
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *
 *
 *
 *
 *  提示：
 *
 *
 *  链表中节点数目为 n
 *  1 <= n <= 500
 *  -500 <= Node.val <= 500
 *  1 <= left <= right <= n
 *
 *
 *
 *
 *  进阶： 你可以使用一趟扫描完成反转吗？
 *  Related Topics 链表
 *  👍 943 👎 0
 */
public class ReverseLinkedListIi {

    @Solution
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1)
            return reverseN(head, right);
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    // 返回翻转后的链表头
    private ListNode reverse(ListNode head) {
        if (head.next == null)
            return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    // 翻转前n个节点
    ListNode marker;
    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            marker = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = marker;
        return last;
    }


}
