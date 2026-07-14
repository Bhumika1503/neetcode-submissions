/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode a = new ListNode(0);
        a.next = head;
        ListNode s = a;
        ListNode t = a;
        for (int i = 0; i <= n; i++)
        {
            t = t.next;
        }
        
        while (t != null) 
        {
            t = t.next;
            s = s.next;
        }
        s.next = s.next.next;
        return a.next;
    }
}