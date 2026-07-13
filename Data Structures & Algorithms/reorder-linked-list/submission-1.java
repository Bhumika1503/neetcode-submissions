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
    public void reorderList(ListNode head) {
        ListNode s=head;
        ListNode f=head;
        while(f.next!=null&& f.next.next!=null)
        {
            s=s.next;
            f=f.next.next;
        }
        ListNode sf=s.next;
        s.next=null;
        ListNode prev =null;
        while(sf!=null)
        {
            ListNode next=sf.next;
            sf.next=prev;
            prev=sf;
            sf=next;
        }
        ListNode first=head;
        sf=prev;
        while(sf!=null)
        {
            ListNode temp1=first.next;
            ListNode temp2=sf.next;
            first.next=sf;
            sf.next=temp1;

            first=temp1;
            sf =temp2;
        }
    }
}
