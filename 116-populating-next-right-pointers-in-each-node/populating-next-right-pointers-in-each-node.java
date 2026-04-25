class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Node leftmost = root;
        while (leftmost.left != null) {
            Node head = leftmost;
            while (head != null) {
                // connect left -> right
                head.left.next = head.right;
                // connect right -> next subtree's left
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }
}