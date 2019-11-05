class BinarySearchST<Key extends Comparable<Key>, Value> {

    /**
     * field to store the keys in an array.
     */
    private Key[] keys = (Key[]) new Comparable[20];

    /**
     * field to store the values in an array.
     */
    private Value[] values = (Value[]) new Comparable[20];

    /**
     * field to store the size of the array.
     */
    private int size = 0;

    /**
     * method to add the elements to the array.
     * @param key the key to be added.
     * @param value the value corresponding to the key.
     */
    public void put(final Key key, final Value value) {

        boolean added = false;
        // System.out.println(key);
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                values[i] = value;
                // System.out.println(keys[size] + " " + values[size]);
                added = true;
                break;
            }
        }
        if (!added) {
            keys[size] = key;
            values[size] = value;
            // System.out.println(keys[size] + " " + values[size]);
            size++;
        }
        if (size > 1) {
            insSort();
        }
    }

    /**
     * method to sort the arrays in order.
     */
    private void insSort() {
        for (int i = size - 1; i > 0; i--) {
            if (keys[i].compareTo(keys[i - 1]) < 0) {
                Key tempKey = keys[i];
                keys[i] = keys[i - 1];
                keys[i - 1] = tempKey;

                Value tempValue = values[i];
                values[i] = values[i - 1];
                values[i - 1] = tempValue;
            } else {
                break;
            }
        }
    }

    /**
     * the method to know if the key is present in the array.
     * @param key the key to be found.
     * @return true if key is present, else false.
     */
    public boolean contains(final Key key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    /**
     * method to get the value corresponding to the key.
     * @param key the key whose value is to be returned.
     * @return the value corresponding to the key.
     */
    public Value get(final Key key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    /**
     * the method to return the max key.
     * @return the max key.
     */
    public Key max() {
        Key max = keys[0];
        for (int i = 1; i < size; i++) {
            if (max.compareTo(keys[i]) < 0) {
                max = keys[i];
            }
        }
        return max;
    }

    /**
     * method to return a key equal to or less than the key.
     * @param key the key whose floor is to be found.
     * @return the floor of the key.
     */
    public Key floor(final Key key) {
        for (int i = size - 1; i >= 0; i--) {
            if (key.compareTo(keys[i]) >= 0) {
                return keys[i];
            }
        }
        return null;
    }

    /**
     * the number of keys less than the given key.
     * @param key the rank of the key to be found.
     * @return the rank of the key.
     */
    public int rank(final Key key) {
        int hi = size - 1;
        int lo = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (keys[mid].compareTo(key) == 0) {
                return mid;
            } else if (keys[mid].compareTo(key) < 1) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    /**
     * method to delete the min key in the array.
     */
    public void deleteMin() {
        for (int i = 0; i < size; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
        keys[size] = null;
        values[size] = null;
        size--;
    }

    /**
     * method to return the iterable of the keys.
     * @return the iterable of the keys.
     */
    public Iterable<Key> keys() {
        Queue<Key> que = new Queue<Key>();

        for (int i = 0; i < size; i++) {
            que.enqueue(keys[i]);
        }

        return que;
    }
}
