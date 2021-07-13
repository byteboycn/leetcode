package cn.byteboy.core.model;

/**
 * @author hongshaochuan
 * @date 2021/7/9
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {}

    public ListNode(int val) { this.val = val; }

    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
