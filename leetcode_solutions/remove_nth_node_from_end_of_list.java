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
        Deque<ListNode> nodeDq = new ArrayDeque<>();
        // add nodes at the input list to the deque
        ListNode currentNode = head;
        while (currentNode!=null) {
            nodeDq.add(currentNode);
            currentNode = currentNode.next;
        } 
        // if the input list has only one node, return to null
        if (nodeDq.size()==1) return null;
        // simply delete the rightmost node in case n==1 and the input list has more than one node
        if (n==1) {
            nodeDq.removeLast();
            nodeDq.getLast().next = null;
            return nodeDq.getFirst();
        }
        // simply delete the leftmost node in case n==nodeDq.size() and the input list has more than one node
        if (n==nodeDq.size()) {
            nodeDq.removeFirst();
            return nodeDq.getFirst();
        }
        // if 1 < n < nodeDq.size(), it's not the rightmost node that would need to be removed
        int count_from_end = 1;
        ListNode rightNode;
        ListNode focusedNode = nodeDq.pollLast();
        while (!nodeDq.isEmpty()) {
            count_from_end++; // a node has been removed at the last iteration, therefore add this count
            if (count_from_end==n) nodeDq.removeLast();
            rightNode = focusedNode;
            focusedNode = nodeDq.pollLast();
            focusedNode.next = rightNode;
        }
        return focusedNode;
    }
}
