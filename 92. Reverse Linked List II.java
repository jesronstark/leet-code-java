











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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Edge case: if the list is empty or has only one node, or no need to reverse
        if (head == null || head.next == null || left == right) {
            return head;
        }

        // Create a dummy node to simplify edge cases where reversing includes the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preLeft = dummy;

        // Step 1: Traverse to the node just before the 'left' position
        for (int i = 1; i < left; i++) {
            preLeft = preLeft.next;
        }

        // 'start' will eventually be the last node in the reversed sublist
        ListNode start = preLeft.next;
        // 'then' is the node that will be moved to the front of the reversed sublist
        ListNode then = start.next;

        // Step 2: Reverse the sublist from 'left' to 'right'
        for (int i = 0; i < right - left; i++) {
            start.next = then.next; // Connect start to the node after 'then'
            then.next = preLeft.next; // Move 'then' node to the front of the sublist
            preLeft.next = then; // Connect preLeft to the new front
            then = start.next; // Move 'then' to the next node to be processed
        }

        // Step 3: Return the modified list
        return dummy.next;
    }
}
