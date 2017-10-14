/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * 
 * 分為走一步跟走兩步來遍尋List
 * 若裡面有Cycle，則必會發生兩種遍尋方式走到同點的情形。
 */
class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode oneStep = head;
        ListNode twoStep = head;
        while (null != twoStep.next && null != twoStep.next.next) {
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
            if (oneStep == twoStep)
                return true;
        }
        return false;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}