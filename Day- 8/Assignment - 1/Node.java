public class Node<Key extends Comparable<Key>, Value> {
    Key key;
    Value value;
    Node right;
    Node left;
    int size;

    public Node(Key key, Value value, int size) {
        this.key = key;
        this.value = value;
        this.size = size;
        right = null;
        left = null;
    }
}
