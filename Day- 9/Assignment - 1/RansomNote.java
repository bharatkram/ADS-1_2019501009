public class RansomNote {

    /**
     * field to store the key-value pairs in an array.
     */
    private Pair[] pair;

    /**
     * field to store the number of elements present in the array.
     */
    private int numOfElements;

    RansomNote() {
        final int size = 20;
        pair = new Pair[size];
    }

    RansomNote(final int size) {
        pair = new Pair[size];
    }

    /**
     * function to add the given key-value pair to array.
     *
     * @param key the key that is to be added to the array.
     */
    public void put(final String key) {
        int pos = Math.abs(key.hashCode()) % pair.length;

        while (pair[pos] != null) {
            if (pair[pos].key().compareTo(key) == 0) {
                pair[pos].incValue();
                return;
            } else {
                if (pos == pair.length - 1) {
                    pos = 0;
                } else {
                    pos += 1;
                }
            }
        }
        pair[pos] = new Pair(key, 1);
    }

    /**
     * function to get the value corresponding to the key specified.
     *
     * @param key the key that is to be searched for.
     * @return the value corresponding to the key specified.
     */
    public Integer get(final String key) {
        int pos = Math.abs(key.hashCode()) % pair.length;

        while (pair[pos] != null) {
            if (pair[pos].key().compareTo(key) == 0) {
                return pair[pos].value();
            } else {
                if (pos == pair.length - 1) {
                    pos = 0;
                } else {
                    pos += 1;
                }
            }
        }
        return 0;
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
     * function to return the field pair.
     *
     * @return the field containin the words.
     */
    public Pair[] pair() {
        return pair;
    }

    /**
     * function to check the words in the letter and that in the magazine.
     *
     * @param that the note of the letter.
     * @return 'Yes' if the letter can be written, else 'No'.
     */
    public String check(final RansomNote that) {
        int pos = 0;
        while (pos < that.pair().length) {
            if (that.pair()[pos] != null) {
                if (that.get(that.pair()[pos].key())
                            > this.get(that.pair()[pos].key())) {
                    return "No";
                }
            }
            pos += 1;
        }
        return "Yes";
    }

    /**
     * the main method to initialize the letters in magazine and the letters
     * in the letter and then check if the letter is possible to be written.
     *
     * @param args parameter of the main method.
     */
    public static void main(final String[] args) {
        String mag = "This is a test to check if the program "
                    + "is working properly";
        String letter1 = "This is a test";
        String letter2 = "This may be wrong";

        String[] magArray = mag.split(" ");
        String[] letter1Array = letter1.split(" ");
        String[] letter2Array = letter2.split(" ");

        RansomNote lettersInMag = new RansomNote();
        RansomNote lettersInLetter1 = new RansomNote();
        RansomNote lettersInLetter2 = new RansomNote();

        for (int i = 0; i < magArray.length; i++) {
            lettersInMag.put(magArray[i]);
        }

        for (int i = 0; i < letter1Array.length; i++) {
            lettersInLetter1.put(letter1Array[i]);
        }

        for (int i = 0; i < letter2Array.length; i++) {
            lettersInLetter2.put(letter2Array[i]);
        }

        System.out.println(lettersInMag.check(lettersInLetter1));
        System.out.println(lettersInMag.check(lettersInLetter2));
    }
}
