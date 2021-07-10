package cn.byteboy.difficulty.easy._234;

import cn.byteboy.core.Solution;
import cn.byteboy.core.model.ListNode;

/**
 * @author hongshaochuan
 * @date 2021/7/11
 *
 * 请判断一个链表是否为回文链表。
 *
 *  示例 1:
 *
 *  输入: 1->2
 * 输出: false
 *
 *  示例 2:
 *
 *  输入: 1->2->2->1
 * 输出: true
 *
 *
 *  进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *  Related Topics 栈 递归 链表 双指针
 *  👍 1042 👎 0
 */
public class PalindromeLinkedList {

    ListNode left;

    @Solution
    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    private boolean traverse(ListNode right) {
        if (right == null) return true;
        boolean res = traverse(right.next);
        res = res && (left.val == right.val);
        left = left.next;
        return res;
    }

    @Solution
    public boolean isPalindrome2(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null)
            slow = slow.next;

        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre, cur, next;
        pre = null;
        cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
