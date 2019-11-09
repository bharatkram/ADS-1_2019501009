class ArrayImplementation<Key extends Comparable<Key>> {
    /**
     * the array to store the keys.
     */
    private Key[] keys;

    /**.
     * the array to store the keys to the left of the root.
     */
    private int[] left;

    /**.
     * the array to store the keys to the right of the root.
     */
    private int[] right;

    /**.
     * the field to store the position of the root of the array.
     */
    private int pos = 0;

    /**.
     * the field to store the position of the element in the left array.
     */
    private int p = 0;

    /**.
     * the field to store the position of the element in the right array.
     */
    private int j = 0;

    /**.
     * constructor to initialise the array elements to default values.
     */
    ArrayImplementation() {
        final int size = 50;
        keys = (Key[]) new Comparable[size];
        left = new int[size];
        right = new int[size];
        for (int i = 0; i < size; i++) {
            // keys[i] = -1;
            left[i] = -1;
            right[i] = -1;
        }
    }

    /**
     * parameterised constructor to create the arrays of specified size.
     *
     * @param capacity the capacity of the array.
     */
    ArrayImplementation(final int capacity) {
        keys = (Key[]) new Comparable[capacity];
        left = new int[capacity];
        right = new int[capacity];
    }

    /**.
     * function to store the elements in the array.
     *
     * @param k the key to be added to the array.
     */
    void put(final Key k) {
        if (keys.length == 0) {
            keys[pos] = k;
            return;
        }
        int i = 0;
        while (i < keys.length) {
            if (keys[i] == null) {
                break;
            } else if (k.compareTo(keys[i]) < 0) {
                i = 2 * i + 1;
                if (keys[i] == null) {
                    break;
                }
            } else if (k.compareTo(keys[i]) > 0) {
                i = 2 * i + 2;
                if (keys[i] == null) {
                break;
            }
            } else {
                break;
            }
        }
        keys[i] = k;
        if (k.compareTo(keys[0]) < 0) {
            left[j++] = i;
            // System.out.println(left[j-1]);
        } else {
            right[p++] = i;
            // System.out.println(right[p-1]);
        }
    }

    /**.
     * function to get the corresponding value of the key.
     *
     * @param k the key whose value is to be returned.
     *
     * @return the value corresponding to the key.
     */
    int get(final Key k) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null && k.compareTo(keys[i]) == 0) {
                return i;
            }
        }
        return -1;
    }

    /**.
     * the main function to run the program.
     *
     * @param args argument of the main function.
     */
    public static void main(final String[] args) {
        ArrayImplementation obj = new ArrayImplementation();
        final int[] arr = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            obj.put(arr[i]);
            // System.out.println(1);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(obj.get(arr[i]));
        }
    }
}
