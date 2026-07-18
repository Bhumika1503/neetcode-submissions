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

    public ListNode merge(ListNode a, ListNode b){

        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while(a!=null && b!=null){

            if(a.val<=b.val){
                curr.next=a;
                a=a.next;
            }else{
                curr.next=b;
                b=b.next;
            }

            curr=curr.next;
        }

        curr.next=(a!=null)?a:b;

        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length==0)
            return null;

        while(lists.length>1){

            ArrayList<ListNode> merged = new ArrayList<>();

            for(int i=0;i<lists.length;i+=2){

                ListNode l1 = lists[i];

                ListNode l2 =
                    (i+1<lists.length)
                    ? lists[i+1]
                    : null;

                merged.add(merge(l1,l2));
            }

            lists = merged.toArray(new ListNode[0]);
        }

        return lists[0];
    }
}