/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * 本題必為ASC
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }else if(l1 != null && l2 == null){
            return l1;
        }else if(l1 == null && l2 != null){
            return l2;
        }else{
            l1 = mergeAsc(l1,l2);
            // if(l1.next == null && l2.next == null){
            //     l1.next = l2;
            // }else{
            //     if(l1.next != null){
            //         if(l1.val > l1.next.val)
            //             l1 = mergeDesc(l1,l2);
            //         else
            //             l1 = mergeAsc(l1,l2);
            //     }else{
            //         if(l2.val > l2.next.val)
            //             l1 = mergeDesc(l1,l2);
            //         else
            //             l1 = mergeAsc(l1,l2);
            //     }
            // }
            return l1;
        }
    }

    private ListNode mergeAsc(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode tmp=null;

        while(l1!=null && l2!=null){
            if(l1.val <= l2.val){
                if(head.next == null){
                    head.next = l1;
                }else{
                    tmp.next = l1;
                }
                tmp = l1;
                l1 = l1.next;
            }else{
                if(head.next == null){
                    head.next = l2;
                }else{
                    tmp.next = l2;
                }
                tmp = l2;
                l2 = l2.next;
            }
        }

        while(l1!=null){
            tmp.next = l1;
            tmp = l1;
            l1 = l1.next;
        }

        while(l2!=null){
            tmp.next = l2;
            tmp = l2;
            l2 = l2.next;
        }
        return head.next;
    }

    // private ListNode mergeDesc(ListNode l1, ListNode l2){
    //     ListNode head = new ListNode(0);
    //     ListNode tmp=null;

    //     while(l1!=null && l2!=null){
    //         if(l1.val >= l2.val){
    //             if(head.next == null){
    //                 head.next = l1;
    //             }else{
    //                 tmp.next = l1;
    //             }
    //             tmp = l1;
    //             l1 = l1.next;
    //         }else{
    //             if(head.next == null){
    //                 head.next = l2;
    //             }else{
    //                 tmp.next = l2;
    //             }
    //             tmp = l2;
    //             l2 = l2.next;
    //         }
    //     }

    //     while(l1!=null){
    //         tmp.next = l1;
    //         tmp = l1;
    //         l1 = l1.next;
    //     }

    //     while(l2!=null){
    //         tmp.next = l2;
    //         tmp = l2;
    //         l2 = l2.next;
    //     }
    //     return head.next;
    // }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}