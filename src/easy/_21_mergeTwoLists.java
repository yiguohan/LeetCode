package easy;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class _21_mergeTwoLists {

    public static void main(String[] args) {

    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode list = new ListNode(0);
        ListNode head = list;
        while (l1 != null && l2 != null) {
            int val1 = l1.val;
            int val2 = l2.val;
            if (val1 >= val2) {
                list.next = new ListNode(val2);
                l2 = l2.next;
            } else {
                list.next = new ListNode(val1);
                l1 = l1.next;
            }
            list = list.next;
        }

        if (l1 != null) {
            list.next = l1;
        }

        if (l2 != null) {
            list.next = l2;
        }

        return head.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
