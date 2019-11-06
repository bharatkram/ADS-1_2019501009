public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    public BST() {
    }

    public void put(Key key, Value value) {
        // Node current = root;
        // if (current == null) {
        //     current = new Node(key, value, 1);
        //     return;
        // }
        // while (current != null) {
        //     if (current.key().compareTo(key) == 0) {
        //         current.cngValue(value);
        //     } else if (current.key().compareTo(key) < 0) {
        //         current = current.left;
        //     } else {
        //         current = current.right;
        //     }
        // }
        // current = new Node(key, value, 1);
    }
}
