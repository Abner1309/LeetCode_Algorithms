/*
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
*/

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); 
        
        ListNode current1 = l1;
        ListNode current2 = l2;
        ListNode current3 = dummyHead;
        
        int carry = 0;
        
        while (current1 != null || current2 != null || carry != 0) {  
            int val1 = (current1 != null) ? current1.val : 0;
            int val2 = (current2 != null) ? current2.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;
            int digit = sum % 10;
            
            current3.next = new ListNode(digit); 
            current3 = current3.next;
            
            if (current1 != null) {
                current1 = current1.next;
            }
            
            if (current2 != null) {
                current2 = current2.next;
            }
        }

        return dummyHead.next;
    }
}
