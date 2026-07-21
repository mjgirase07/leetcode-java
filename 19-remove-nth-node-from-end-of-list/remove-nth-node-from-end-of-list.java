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
        ListNode temp = head;
        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        temp = head;
        len -= n;
        int cnt = 0;

        if(len == 0){
            return temp.next;
        }

        while(temp != null){
            cnt++;
            if(cnt == len){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }

        
        return head;
    }
}