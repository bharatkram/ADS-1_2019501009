public class Node<Key extends comparable<Key>, Value> {
    private Key key;
    private Value value;
    private Node left;
    private Node right;
    private int size;

    Node(Key key, Value value, int size) {
        this.key = key;
        this.value = value;
        this.size = size;
    }

    public Key key() {
        return this.key;
    }

    public Value value() {
        return this.value;
    }

    public void cngValue(Value value) {
        this.value = value;
    }

    public void updtSize(int size) {
        this.size = size;
    }

    public Node left() {
        return this.left;
    }

    public Node right() {
        return this.right;
    }
}