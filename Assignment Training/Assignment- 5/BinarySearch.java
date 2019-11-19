public class BinarySearch {
    int[] arrKeys;
    int[] arrVals;
    int size;
    
    public BinarySearch() {
        arrKeys = new int[10];
        arrVals = new int[10];
        size = 0;        
    }

    public BinarySearch(int size) {
        arrKeys = new int[size];
        arrVals = new int[size];
        this.size = size;
    }

    public void add(int key, int val) {
        arrKeys[size] = key;
        arrVals[size] = val;

        for (int j = size; j > 0; j++) {
            if (arrKeys[j] < arrKeys[j - 1]) {
                int temp = arrKeys[j];
                arrKeys[j] = arrKeys[j - 1];
                arrKeys[j - 1] = temp;

                temp = arrVals[j];
                arrVals[j] = arrVals[j - 1];
                arrVals[j - 1] = temp;
            } else {
                break;
            }
        }
        size += 1;
    }

    public int get(int key) {
        int hi = size - 1;
        int lo = 0;
        int mid;

        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (arrKeys[mid] == key) {
                return arrVals[mid];
            } else if (arrKeys[mid] > key) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();

        for (int i = 0; i < 10; i++) {
            bs.add(i, i*10);
        }

        System.out.println(bs.get(5));
        System.out.println(bs.get(10));
        System.out.println(bs.get(2));
    }
}
