public class BinaryTree {
    /**
     * class to create the object node that stores the key,
     * val, and the right and the left nodes.
     */
    private class Node {
        int key;
        int val;
        Node right;
        Node left;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            right = null;
            left = null;
        }

    }
    
    /**
     * field that stores the root node of the tree.
     */
    Node root;;
    
    public BinaryTree() {
        root = null;
    }

    /**
     * function to add the key and val to the tree.
     *
     * @param key the key to be added.
     * @param val the value of the corresponding key.
     */
    public void add(int key, int val) {
        if (root == null) {
            root = new Node(key, val);
        } else {
            Node current = root;
            while (true) {
                if (key < current.key) {
                    if (current.left == null) {
                        current.left = new Node(key, val);
                        break;
                    } else {
                        current = current.left;
                    }
                } else if (key > current.key) {
                    if (current.right == null) {
                        current.right = new Node(key, val);
                        break;
                    } else {
                        current = current.right;
                    }
                } else {
                    current.val = val;
                    break;
                }
            }
        }
    }

    /**
     * recursive function to check if the tree is right or wrong.
     *
     * @param root the node to be checked from.
     * @param min the min value that is allowed in the tree.
     * @param max the max value that is allowed in the tree.
     *
     * @return true if the rules are followed, else false.
     */
    public boolean isOrdered(Node root, int min, int max) {
        if (root == null) {
            return true;
        } else if (root.key < min || root.key > max) {
            return false;
        }
        // System.out.println(root.key + " " + min + " " + max);

        boolean flag = true;

        flag = isOrdered(root.left, min, root.key);
        if (!flag) {
            return false;
        }
        flag = isOrdered(root.right, root.key, max);
        return flag;
    }

    /**
     * main function to build the tree.
     *
     * @param args main function arguments.
     */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        int rootKey = 10;
        int rootVal = 100;

        tree.add(rootKey, rootVal);
        int i = 1;
        while (i < 20) {
            int key = (int) (Math.random() * 20);
            int val = key * 10;
            // System.out.println(key + " " + val);
            tree.add(key, val);
            i += 1;
        }

        if (tree.isOrdered(tree.root, 0, 20)) {
            System.out.println("Correct.");
        } else {
            System.out.println("InCorrect.");
        }
    }
}