public class LinearProbingHashST<Key extends Comparable<Key>, Value> {

    /**
     * field to store the key-value pairs in an array.
     */
    private Pair[] pair;

    /**
     * field to store the number of elements present in the array.
     */
    private int numOfElements;

    LinearProbingHashST() {
        final int size = 20;
        pair = new Pair[size];
    }

    LinearProbingHashST(final int size) {
        pair = (Pair[]) new Comparable[size];
    }

    /**
     * function to add the given key-value pair to array.
     *
     * @param key the key that is to be added to the array.
     * @param val the corresponding value of the key.
     */
    public void put(final Key key, final Value val) {
        int pos = key.hashCode() % pair.length;

        while (pair[pos] != null) {
            if (pair[pos].key().compareTo(key) == 0) {
                pair[pos].chgValue(val);
                return;
            } else {
                if (pos == pair.length - 1) {
                    pos = 0;
                } else {
                    pos += 1;
                }
            }
        }
        pair[pos] = new Pair(key, val);
    }

    /**
     * function to get the value corresponding to the key specified.
     *
     * @param key the key that is to be searched for.
     * @return the value corresponding to the key specified.
     */
    public Value get(final Key key) {
        int pos = key.hashCode() % pair.length;

        while (pair[pos] != null) {
            if (pair[pos].key().compareTo(key) == 0) {
                return (Value) pair[pos].value();
            } else {
                pos += 1;
            }
        }
        return null;
    }

    /**
     * function to delete the key-value pair from the array.
     *
     * @param key the key to be deleted from the array.
     */
    public void delete(final Key key) {
        int pos = key.hashCode() % pair.length;

        while (pair[pos] != null) {
            if (pair[pos].key().compareTo(key) == 0) {
                pair[pos] = null;
                reHash(pos + 1);
            } else {
                pos += 1;
            }
        }
    }

    /**
     * function to rearrange the key-value pairs after the deletion of a key.
     *
     * @param startingPos the position from which the rehashing should be done.
     */
    private void reHash(final int startingPos) {
        int pos = startingPos;

        while (pair[pos] != null) {
            System.out.println("here");
            this.put((Key) pair[pos].key(), (Value) pair[pos].value());
            pos += 1;
        }
        pair[pos - 1] = null;
    }

    /**
     * function to display all the key value pairs in the array.
     */
    public void display() {
        int pos = 0;

        while (pos < pair.length) {
            if (pair[pos] != null) {
                System.out.println(pair[pos].key() + " " + pair[pos].value());
            }
            pos += 1;
        }
    }

    /**
     * the main function.
     *
     * @param args the parameters of the main function.
     */
    public static void main(final String[] args) {
        LinearProbingHashST<String, Integer> dict = new
                    LinearProbingHashST<String, Integer>();

        dict.put("B", 1);
        dict.put("H", 2);
        dict.put("A", 3);
        dict.put("R", 4);
        dict.put("A", 5);
        dict.put("T", 6);

        dict.display();

        System.out.println("After deletion:");
        dict.delete("R");
        dict.display();
    }
}
