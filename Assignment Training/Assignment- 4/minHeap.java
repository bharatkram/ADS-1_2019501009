public class minHeap {
    private int[] heapArray;
    private int numOfEle;
    private int size;

    public minHeap(int size) {
        this.size = size;
        numOfEle = 0;
        heapArray = new int[size + 1];
        // System.out.println(size + 1);
    }

    /**
     * function to add the element in the heap.
     * Worst Time Complexity: O(log(k)).
     *
     * @param element the element to be added.
     */
    public void add(int element) {
        if (numOfEle < size) {
            heapArray[++numOfEle] = element;
            swim(numOfEle - 1);
            // System.out.println(numOfEle);
        } else {
            // System.out.println(numOfEle);
            if (element > heapArray[1]) {
                // exch(1, size);
                heapArray[1] = element;
                // swim(size);
                sink();
            }
        }
    }

    private void exch(int pos1, int pos2) {
        int temp = heapArray[pos1];
        heapArray[pos1] = heapArray[pos2];
        heapArray[pos2] = temp;
    }

    private void swim(int pos) {
        while (pos != 1) {
            if (heapArray[pos] < heapArray[pos / 2]) {
                exch(pos, pos / 2);
                pos /= 2;
            } else {
                break;
            }
        }
    }

    private void sink() {
        int pos = 1;
        while ((pos * 2) <= size) {
            if (pos * 2 + 1 > size) {
                if (heapArray[pos] > heapArray[pos * 2]) {
                    exch(pos, pos * 2);
                }
                break;
            } else if (heapArray[pos] > heapArray[pos * 2] || heapArray[pos] > heapArray[(pos * 2) + 1]) {
                if (heapArray[pos * 2] <= heapArray[(pos * 2) + 1]){
                    exch(pos, pos * 2);
                    pos *= 2;
                } else {
                    exch(pos, (pos * 2) + 1);
                    pos = (pos * 2) + 1;
                }
            } else {
                break;
            }
        }
        // if (heapArray[pos] > heapArray[pos * 2]) {
        //     exch(pos, pos * 2);
        // }
    }

    public void display() {
        for (int i = 1; i <= size; i++) {
            System.out.println(heapArray[i]);
        }
        // System.out.println("\n");
    }

    /**
     * main function - sends all the elements to the heap.
     * Worst Time Complexity: O(N log(k))
     *
     * @param args parameters of the main function.
     */
    public static void main(String[] args) {
        int[] arr = {1,8,3,4,7,3,6,9,4,7,0,56,4,7,91,5,57,7};
        int size = 4;
        minHeap mH = new minHeap(size);

        for (int i = 0; i < arr.length; i++) {
            // System.out.println(arr[i]);
            mH.add(arr[i]);
            // mH.display();
        }
        mH.display();
    }
}
