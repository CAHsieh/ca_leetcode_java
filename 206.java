/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        reverse(head, head.next);
        head.next = null;
        return last;
    }

    private void reverse(ListNode head, ListNode next) {
        if (next == null)
            return;
        if (next.next != null)
            reverse(next, next.next);
        next.next = head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}