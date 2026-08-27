class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {

            // Find the kth node
            ListNode kth = getKthNode(groupPrev, k);

            // Less than k nodes remain
            if (kth == null) {
                break;
            }

            // Node after the group
            ListNode groupNext = kth.next;

            // Reverse the group
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Connect previous part to reversed group
            ListNode oldGroupStart = groupPrev.next;
            groupPrev.next = kth;

            // Move groupPrev to the end of reversed group
            groupPrev = oldGroupStart;
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode curr, int k) {

        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }

        return curr;
    }
}