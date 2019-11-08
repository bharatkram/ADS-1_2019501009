public class BST<Key extends Comparable<Key>, Value> {
    /**
     * the starting node of the tree.
     */
    private Node root;

    /**
     * the default constructor.
     */
    public BST() {
    }

    /**
     * function to add the given key-value pair to the tree.
     * @param key the key of the pair.
     * @param value the value of the pair.
     */
    public void put(final Key key, final Value value) {
        root = put(root, key, value);
    }

    /**
     * recursive function to add the key value pair to the tree.
     *
     * @param current the node which is to be checked for.
     * @param key the key of the given node.
     * @param value the value of the given node.
     * @return the current node which has been added.
     */
    private Node put(final Node current, final Key key, final Value value) {
        if (current == null) {
            return new Node(key, value, 1);
        }
        int comp = key.compareTo((Key) current.key);
        if (comp < 0) {
            current.left = put(current.left, key, value);
        } else if (comp > 0) {
            current.right = put(current.right, key, value);
        } else {
            current.value = value;
        }
        current.size = 1 + size(current.left) + size(current.right);
        return current;
    }

    /**
     * function to return the size of the selected node.
     *
     * @param current the node whose size is to be found.
     * @return the size of the given node.
     */
    private int size(final Node current) {
        if (current == null) {
            return 0;
        }
        return current.size;
    }

    /**
     * function to get the value of the given key if available, else
     * null.
     *
     * @param key the key whose value is to be found.
     * @return the value of the specified key.
     */
    public Value get(final Key key) {
        Node current = root;
        while (current != null) {
            if (current.key.compareTo(key) == 0) {
                return (Value) current.value;
            } else if (current.key.compareTo(key) > 0) {
                current = current.left;
            } else if (current.key.compareTo(key) < 0) {
                current = current.right;
            }
        }
        return null;
    }

    /**
     * function to check if the tree is empty.
     *
     * @return true if the tree is empty, else false.
     */
    public boolean isEmpty() {
        return root.size == 0;
    }

    /**
     * function to find the smallest key in the tree.
     *
     * @return the smallest key.
     */
    public Key min() {
        return (Key) min(root).key;
    }

    /**
     * the function to return the smallest key from the given position.
     *
     * @param given the node below which the smallest is to be found.
     * @return the node with the smallest key below the given node.
     */
    private Node min(final Node given) {
        Node current = given;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    /**
     * function to find the largest key in the tree.
     *
     * @return the largest key present in the tree.
     */
    public Key max() {
        return (Key) max(root).key;
    }

    /**
     * the function to return the node with the largest key below
     * the given node.
     *
     * @param given the node below which the largest is to be found.
     * @return the node with the largest key below the given node.
     */
    private Node max(final Node given) {
        Node current = given;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    /**
     * the function to return the key equal to or just below the given key.
     *
     * @param key the key whose floor key is to be found.
     * @return the floor of the given key.
     */
    public Key floor(final Key key) {
        Node current = root;
        Key floor = (Key) current.key;
        while (current != null) {
            if (current.key.compareTo(key) == 0) {
                return (Key) current.key;
            } else if (floor.compareTo((Key) current.key) < 0
                        && current.key.compareTo((Key) key) < 0) {
                floor = (Key) current.key;
            }
            if (current.key.compareTo(key) < 0) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return floor;
    }

    /**
     * the functio to return the key equal to or just above the given key.
     *
     * @param key the key whose ceiling is to be found.
     * @return the ceiling of the given key.
     */
    public Key ceiling(final Key key) {
        Node current = root;
        Key ceiling = max();
        while (current != null) {
            if (current.key.compareTo(key) == 0) {
                return (Key) current.key;
            } else if (ceiling.compareTo((Key) current.key) > 0
                    && current.key.compareTo((Key) key) > 0) {
                ceiling = (Key) current.key;
            }
            if (current.key.compareTo(key) < 0) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return ceiling;
    }

    /**
     * the function to return the key according to the level specified.
     *
     * @param k the level of the key to be found.
     * @return the key in the specified level in the tree.
     */
    public Key select(final int k) {
        if (!(k < 0 || k >= root.size)) {
            Node x = select(root, k);
            return (Key) x.key;
        }
        return null;
    }

    /**
     * the function to return the key according to the level specified.
     *
     * @param x the node below which the key is to be selected.
     * @param k the level of the key to be found.
     * @return the key in the specified level in the tree.
     */
    private Node select(final Node x, final int k) {
        if (!(x == null)) {
            int t = size(x.left);
            if (t > k) {
                return select(x.left, k);
            } else if (t < k) {
                return select(x.right, k - t - 1);
            } else {
                return x;
            }
        }
        return null;
    }

    /**
     * the number of keys in the tree less than the given key.
     *
     * @param key the key whose rank is to be found.
     * @return the rank of the given key.
     */
    public int rank(final Key key) {
        Node current = root;
        int rank = 1;
        while (current != null) {
            if (current.key.compareTo(key) >= 0) {
                break;
            } else if (current.key.compareTo(key) < 0) {
                rank += current.left.size;
                current = current.right;
            }
        }
        return rank;
    }

    /**
     * the function to return the iterable of the tree.
     *
     * @return the iterable of the tree.
     */
    public Iterable<Key> keys() {
        if (isEmpty()) {
            return new Queue<Key>();
        }
        return keys(min(), max());
    }

    /**
     * the function to return the iterable between the given keys.
     *
     * @param lo the starting of the iterable.
     * @param hi the ending of the iterable.
     * @return the iterable of the keys in between the given.
     */
    public Iterable<Key> keys(final Key lo, final Key hi) {
        if (lo == null) {
            return null;
        }
        if (hi == null) {
            return null;
        }
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    /**
     * the function to return the iterable of the given tree.
     *
     * @param x the node at the starting of the iterable.
     * @param queue the que to which the latest elements are to be added.
     * @param lo the starting key of the iterable.
     * @param hi the ending key of the iterable.
     */
    private void keys(final Node x, final Queue<Key> queue,
                    final Key lo, final Key hi) {
        if (x == null) {
            return;
        }
        int cmplo = lo.compareTo((Key) x.key);
        int cmphi = hi.compareTo((Key) x.key);
        if (cmplo < 0) {
            keys(x.left, queue, lo, hi);
        }
        if (cmplo <= 0 && cmphi >= 0) {
            queue.enqueue((Key) x.key);
        }
        if (cmphi > 0) {
            keys(x.right, queue, lo, hi);
        }
    }

    /**
     * function to delete the key given.
     *
     * @param key the key which is to be deleted.
     */
    public void delete(final Key key) {
        if (!(key == null)) {
            root = delete(root, key);
        }
    }

    /**
     * function to delete the key given.
     *
     * @param given the node below which the key is to be checked for.
     * @param key the key to be deleted.
     * @return the node after the deletion of the key.
     */
    private Node delete(final Node given, final Key key) {
        Node x = given;
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo((Key) x.key);
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * function to delete the largest key present in the tree.
     */
    public void deleteMax() {
        delete(max());
    }

    /**
     * function to delete the largest key present in the tree.
     *
     * @param x the node below which the largest key is to be deleted.
     * @return the node after the deletion of the given key.
     */
    private Node deleteMax(final Node x) {
        if (x.right == null) {
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * function to delete the smallest key in the tree.
     */
    public void deleteMin() {
        delete(min());
    }

    /**
     * the function to delete the smallest key present below the given node.
     *
     * @param x the node below which the smallest key is to be found.
     * @return the node after the deletion of the key.
     */
    private Node deleteMin(final Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
}
