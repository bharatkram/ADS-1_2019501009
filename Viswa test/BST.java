import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class BST<Key extends Comparable<Key>, Value> {

    public BST() {

    }

    private Node root; // root of BST

    private class Node {
        Key key;
        Value val;
        Node left, right;
        int size;

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }
        
        public boolean isEmpty() {
            return size() == 0;
        }

        public int size() {
            return size(root);
        }
        private int size(Node x) {
            if (x == null) {
                return 0;
            } else {
                return x.size;
            }
        }

        public void put(Key key, Value val) {
            if (val == null) {
                delete(key);
                return;
            }
            root = put(root, key, val);
        }

        private Node put(Node x, Key key, Value val) {
            if (x == null) {
                return new Node(key, val, 1);
            }
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x.left = put(x.left, key, val);
            } else if (cmp > 0) {
                x.right = put(x.right, key, val);
            } else {
                x.val = val;
                x.size = 1 + size(x.left) + size(x.right);
            }
            return x;
        }

        public Value get(Key key) {
            return get(root, key);
        }

        private Value get(Node x, Key key) {
            if (x == null) {
                return null;
            }
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                return get(x.left, key);
            } else if (cmp > 0) {
                return get(x.right, key);
            } else {
                return x.val;
            }
        }

        public Key max() {
            return max(root).key;
        }

        private Node max(Node x) {
            if (x.right == null) {
                return x;
            } else {
                return max(x.right);
            }
        }

        public Key min() {
            return min(root).key;
        }

        private Node min(Node x) {
            if (x.left == null) {
                return x;
            } else {
                return min(x.left);
            }
        }

        public void deleteMax() {
            root = deleteMax(root);
        }

        private Node deleteMax(Node x) {
            if (x.right == null)
                return x.left;
            x.right = deleteMax(x.right);
            x.size = size(x.left) + size(x.right) + 1;
            return x;
        }

        public void deleteMin() {
            root = deleteMin(root);
        }

        private Node deleteMin(Node x) {
            if (x.left == null)
                return x.right;
            x.left = deleteMin(x.left);
            x.size = size(x.left) + size(x.right) + 1;
            return x;
        }

        public void delete(Key key) {
            root = delete(root, key);
        }

        private Node delete(Node x, Key key) {
            if (x == null)
                return null;

            int cmp = key.compareTo(x.key);
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
            x.size = size(x.left) + size(x.right) + 1;
            return x;
        }

        public boolean isOrdered() {
            return isOrdered(root, null, null);
        }

        private boolean isOrdered(Node x, Key min, Key max) {
            if (x == null) {
                return true;
            }
            if ((x.key.compareTo(min) < 0) || (x.key.compareTo(max) > 0)) {
                return false;
            }
            return isOrdered(x.left, min, max) && isOrdered(x.right, max, max);

        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size n:");
        int n = sc.nextInt();
        BST<String, Integer> bst = new BST<String, Integer>();

        System.out.println("enter pairs(k,v) :");
        for (int i = 0; i < n; i++) {
            // Integer k = new Integer(Integer.parseInt(sc.nextLine()));
            Integer v = new Integer(Integer.parseInt(sc.nextLine()));
            String k = sc.nextLine();
            // String v = sc.nextLine();
            bst.put(k, v);
        }
        System.out.println(" max" + bst.max());
        System.out.println(" max" + bst.min());
        System.out.println(" statement " + bst.isOrdered());

    }
}