public class Node<Key extends Comparable<Key>, Value> {
    Key key;
    Value value;
    Node right;
    Node left;

    public Node(Key key, Value value) {
        this.key = key;
        this.value = value;
    }
}
