package easy;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class _83_deleteDuplicates {

    private static ListNode process(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode index = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (index.val != cur.val) {
                index.next = cur;
                index = cur;
                cur = cur.next;
            } else {
                cur = cur.next;
            }
        }
        index.next = null;
        return head;
    }

    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
