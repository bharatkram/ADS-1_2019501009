public class Pair {
    /**
     * field to store the key.
     */
    private String key;

    /**
     * field to store the value corresponding to the key.
     */
    private Integer val;

    public Pair(final String key, final Integer val) {
        this.key = key;
        this.val = val;
    }

    /**
     * function to return the key in the given pair.
     */
    public String key() {
        return this.key;
    }

    /**
     * function to change the value in the pair.
     */
    public void incValue() {
        this.val += 1;
    }

    /**
     * function to return the value in the pair.
     */
    public Integer value() {
        return this.val;
    }
}
