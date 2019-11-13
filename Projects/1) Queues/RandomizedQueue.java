import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.Random;
import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    /**
     * field to store the elements.
     */
    private Item[] items;

    /**
     * field to store the number of elements in the array.
     */
    private int size = 0;

    public RandomizedQueue() {
        items = (Item[]) new Comparable[10];
    }

    /**
     * function to check if the array is empty.
     *
     * @return true if the array is empty, else false.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * function to return the size of the array.
     */
    public int size() {
        return size;
    }

    /**
     * function to add the element to the array.
     *
     * @param item the item to be added to the array.
     */
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        if (size == items.length - 1) {
            resize();
        }

        items[size++] = item;
    }

    /**
     * function to resize the array when full.
     */
    private void resize() {
        items = Arrays.copyOf(items, items.length * 2);
    }
    
    /**
     * function to remove the element from the array and return it.
     *
     * @return item randomly from the array.
     */
    public Item dequeue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        
        int n = StdRandom.uniform(size);

        Item temp = items[n];
        items[n] = items[--size];
        items[size + 1] = null;

        return temp;
    }

    /**
     * function to return an element at random.
     *
     * @return item randomly from the array.
     */
    public Item sample() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        
        int n = StdRandom.uniform(size);
        return items[n];
    }

    public Iterator<Item> iterator() {
        return new RandomisedQueIterator<Item>(items);
    }

    /**
     * class to get the iterator of the randomized que.
     *
     * @param <Item> the generic type used.
     */
    private class RandomisedQueIterator<Item> implements Iterator<Item> {
        Item[] temp;
        int count;

        public RandomisedQueIterator(Item[] items) {
            temp = items;
            StdRandom.shuffle(temp);
            count = 0;
        }

        public boolean hasNext() {
            return count < size;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = temp[count++];
            return item;
        }
    }

    // /**
    //  * class to use the required random operations.
    //  *
    //  * @author Robert Sedgewick
    //  * @author Kewin Wayne
    //  */
    // private static class StdRandom {
    //     private static Random random;
    //     private static long seed;

    //     public StdRandom() {
    //         seed = System.currentTimeMillis();
    //         random = new Random(seed);
    //     }

    //     /**
    //      * Returns a random integer uniformly in [0, n).
    //      * 
    //      * @param n number of possible integers
    //      * @return a random integer uniformly between 0 (inclusive) and {@code n} (exclusive)
    //      * @throws IllegalArgumentException if {@code n <= 0}
    //      */
    //     public static int uniform(int n) {
    //         if (n <= 0) throw new IllegalArgumentException("argument must be positive: " + n);
    //         return random.nextInt(n);
    //     }

    //     /**
    //      * Rearranges the elements of the specified array in uniformly random order.
    //      *
    //      * @param  a the array to shuffle
    //      * @throws IllegalArgumentException if {@code a} is {@code null}
    //      */
    //     public static void shuffle(Object[] a) {
    //         validateNotNull(a);
    //         int n = a.length;
    //         for (int i = 0; i < n; i++) {
    //             int r = i + uniform(n-i);     // between i and n-1
    //             Object temp = a[i];
    //             a[i] = a[r];
    //             a[r] = temp;
    //         }
    //     }

    //     /**
    //      * throw an IllegalArgumentException if x is null.
    //      * // (x can be of type Object[], double[], int[], ...)
    //      *
    //      * @param x the object to be checked for.
    //      * @throws IllegalArgumentException if the argument is null.
    //      */
    //     private static void validateNotNull(Object x) {
    //         if (x == null) {
    //             throw new IllegalArgumentException("argument is null");
    //         }
    //     }
    // }
    
    /**
     * the main function.
     *
     * @param args the main function parameter.
     */
    public static void main(String[] args) {
        RandomizedQueue randque = new RandomizedQueue();

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            randque.enqueue(i);
        }

        System.out.println("\nAfter addition:\n");

        System.out.println(randque.dequeue());
        System.out.println(randque.sample());
        System.out.println(randque.dequeue());
        System.out.println(randque.sample());
        System.out.println(randque.dequeue());
        System.out.println(randque.sample());
        System.out.println(randque.dequeue());
        System.out.println(randque.sample());
    }
}
