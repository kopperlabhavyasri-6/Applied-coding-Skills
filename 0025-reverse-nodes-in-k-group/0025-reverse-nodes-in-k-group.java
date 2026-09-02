class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode current = head;
        ListNode temp = head;
        for (int i = 0; i < k; i++) {
            if (temp == null) {
                return head;
            }
            temp = temp.next;
        }
        ListNode prev = null;
        current = head;
        for (int i = 0; i < k; i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head.next = reverseKGroup(current, k);
        return prev;
    }
}