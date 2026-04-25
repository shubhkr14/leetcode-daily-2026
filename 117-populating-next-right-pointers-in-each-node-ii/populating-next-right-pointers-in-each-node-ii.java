class Solution {
    public Node connect(Node root) {
        Node curr = root;

        while (curr != null) {
            Node dummy = new Node(0); // start of next level
            Node tail = dummy;

            while (curr != null) {
                if (curr.left != null) {
                    tail.next = curr.left;
                    tail = tail.next;
                }

                if (curr.right != null) {
                    tail.next = curr.right;
                    tail = tail.next;
                }

                curr = curr.next; // move within same level
            }

            curr = dummy.next; // go to next level
        }

        return root;
    }
}