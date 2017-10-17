
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB)
            return null;

        ListNode a = headA;
        int lenA = 0;
        while (a.next != null) {
            a = a.next;
            lenA++;
        }
        a = headA;

        ListNode b = headB;
        int lenB = 0;
        while (b.next != null) {
            b = b.next;
            lenB++;
        }
        b = headB;

        while (lenA > lenB) {
            a = a.next;
            lenA--;
        }

        while (lenB > lenA) {
            b = b.next;
            lenB--;
        }

        do{
            if(a == b){
                return a;
            }
            a = a.next;
            b = b.next;
        }while(a!=null && b!=null);


        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}