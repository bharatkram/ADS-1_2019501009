class BST1<Key extends Comparable<Key>, Value> {

    Node root;

    public BST1() {
        root = null;
    }

    public void put(Key key, Value val) {
        if (key != null && val != null) {
            root = put(root, key, val);
        }
    }

    public int size(Node j) {
        if (j != null) {
            return j.n;
        }
        return 0;
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null || x.key == null)
            return new Node(key, val);
        int cmp = key.compareTo((Key) x.key);
        if (cmp < 0)
            x.left = put(x.left, key, val);
        else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else if (cmp == 0)
            x.val = val;
        x.n = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void deleteMin() {
        if (!isEmpty()) {
            root = deleteMin(root);
        }
    }

    private Node deleteMin(Node x) {
        if (x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax() {
        if (!isEmpty()) {
            root = deleteMax(root);
        }
    }

    private Node deleteMax(Node x) {
        if (x.right == null)
            return x.left;
        x.right = deleteMax(x.right);
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        if (!(key == null)) {
            root = delete(root, key);
        }
    }

    private Node delete(Node x, Key key) {
        if (x == null)
            return null;

        int cmp = key.compareTo((Key) x.key);
        if (cmp < 0)
            x.left = delete(x.left, key);
        else if (cmp > 0)
            x.right = delete(x.right, key);
        else {
            if (x.right == null)
                return x.left;
            if (x.left == null)
                return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min() {
        if (!isEmpty()) {
            return (Key) min(root).key;
        }
        return null;
    }

    private Node min(Node x) {
        if (x.left == null)
            return x;
        else
            return min(x.left);
    }

    public Key max() {
        if (!isEmpty()) {
            return (Key) max(root).key;
        }
        return null;
    }

    private Node max(Node x) {
        if (x.right == null)
            return x;
        else
            return max(x.right);
    }

    public Key floor(Key key) {
        if ((!(key == null)) && (!isEmpty())) {
            Node x = floor(root, key);
            if (x == null)
                return null;
            else
                return (Key) x.key;
        }
        return null;
    }

    private Node floor(Node x, Key key) {
        if (!(x == null)) {
            int cmp = key.compareTo((Key) x.key);
            if (cmp == 0)
                return x;
            if (cmp < 0)
                return floor(x.left, key);
            Node t = floor(x.right, key);
            if (t != null)
                return t;
            else
                return x;
        }
        return null;
    }

    public Key ceiling(Key key) {
        if ((!(key == null)) && (!(isEmpty()))) {
            Node x = ceiling(root, key);
            if (x == null)
                return null;
            else
                return (Key) x.key;
        }
        return null;
    }

    private Node ceiling(Node x, Key key) {
        if (!(x == null)) {
            int cmp = key.compareTo((Key) x.key);
            if (cmp == 0)
                return x;
            if (cmp < 0) {
                Node t = ceiling(x.left, key);
                if (t != null)
                    return t;
                else
                    return x;
            }
            return ceiling(x.right, key);
        }
        return null;
    }

    public Key select(int k) {
        if (!(k < 0 || k >= root.size())) {
            Node x = select(root, k);
            return (Key) x.key;
        }
        return null;
    }

    private Node select(Node x, int k) {
        if (!(x == null)) {
            int t = size(x.left);
            if (t > k)
                return select(x.left, k);
            else if (t < k)
                return select(x.right, k - t - 1);
            else
                return x;
        }
        return null;
    }

    public int rank(Key key) {
        if (key != null)
            return rank(key, root);
        return -1;
    }

    private int rank(Key key, Node x) {
        if (x != null) {
            int cmp = key.compareTo((Key) x.key);
            if (cmp < 0)
                return rank(key, x.left);
            else if (cmp > 0)
                return 1 + size(x.left) + rank(key, x.right);
            else
                return size(x.left);
        }
        return 0;
    }

    public Iterable<Key> keys() {
        if (isEmpty())
            return new Queue<Key>();
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null)
            return null;
        if (hi == null)
            return null;
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null)
            return;
        int cmplo = lo.compareTo((Key) x.key);
        int cmphi = hi.compareTo((Key) x.key);
        if (cmplo < 0)
            keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0)
            queue.enqueue((Key) x.key);
        if (cmphi > 0)
            keys(x.right, queue, lo, hi);
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (key == null)
            return null;
        if (x == null)
            return null;
        int cmp = key.compareTo((Key) x.key);
        if (cmp < 0)
            return get(x.left, key);
        else if (cmp > 0)
            return get(x.right, key);
        else
            return (Value) x.val;
    }

    public boolean isEmpty() {
        return root.size() == 0;
    }

}