import java.util.NoSuchElementException;
import java.util.Iterator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class Permutation {

    public static void main(String[] args) {
        RandomizedQueue que = new RandomizedQueue();

        // String input = null;

        while (!StdIn.isEmpty()) {
            // input = StdIn.readString();
            que.enqueue(StdIn.readString());
        }

        int req = Integer.parseInt(args[0]);

        // String[] inputArray = input.split(" ");

        // for (int i = 0; i < inputArray.length; i++) {
        //     que.enqueue(inputArray[i]);
        // }

        for (int i = 0; i < req; i++) {
            System.out.println(que.dequeue());
        }
    }
}
