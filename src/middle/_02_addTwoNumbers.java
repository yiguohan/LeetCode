package middle;

/**
 * 题目描述：
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class _02_addTwoNumbers {

    public static void main(String[] args) {

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode currentNode = head;
        ListNode p = l1;
        ListNode q = l2;
        int carry = 0;

        while (p != null || q != null) {

            int x = p == null ? 0 : p.val;
            int y = q == null ? 0 : q.val;

            int sum = x + y + carry;
            carry = sum / 10;
            currentNode.next = new ListNode(sum % 10);
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
            currentNode = currentNode.next;

        }
        if (carry > 0) {
            currentNode.next = new ListNode(carry);
        }
        return head.next;

    }

    private static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode result  = new ListNode(0);
        ListNode head = result;
        int set = 0;
        while(l1!=null||l2!=null){
            if(result.next==null){
                result.next = new ListNode(0);
            }
            if(l1!=null&&l2!=null){
                result.next.val = (l1.val+l2.val+set)%10;
                set = (l1.val+l2.val+set)/10;
            }else if(l1!=null){
                result.next.val = (l1.val+set)%10;
                set = (l1.val+set)/10;
            }else {
                result.next.val = (l2.val+set)%10;
                set = (l2.val+set)/10;
            }
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
            result = result.next;
        }
        if(set>0){
            result.next = new ListNode(1);
        }
        return head.next;
    }
}
