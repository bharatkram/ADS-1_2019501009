public class Pair<Key extends Comparable<Key>, Value> {
    /**
     * field to store the key.
     */
    private Key key;

    /**
     * field to store the value corresponding to the key.
     */
    private Value val;

    public Pair(final Key key, final Value val) {
        this.key = key;
        this.val = val;
    }

    /**
     * function to return the key in the given pair.
     */
    public Key key() {
        return this.key;
    }

    /**
     * function to change the value in the pair.
     */
    public void chgValue(final Value val) {
        this.val = val;
    }

    /**
     * function to return the value in the pair.
     */
    public Value value() {
        return this.val;
    }
}
