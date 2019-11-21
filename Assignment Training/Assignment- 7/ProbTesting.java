public class ProbTesting {
    Integer[] arr;

    public ProbTesting() {
        arr = new Integer[1000000];
    }

    public void add(int val) {
        int pos = (int) (Math.random() * 1000000);
        // System.out.println(pos);
        while (true) {
            if (arr[pos] == null) {
                arr[pos] = val;
                break;
            } else {
                if (pos == arr.length - 1) {
                    pos = 0;
                } else {
                    pos += 1;
                }
            }
        }
    }

    public int check() {
        int pos = 0;
        int count = 0;
        while (pos < 1000000) {
            // System.out.println(pos);
            if (arr[pos] == null) {
                count += 1;
            }
            pos += 100;
        }
        return count;
    }

    public static void main(String[] args) {
        ProbTesting pt = new ProbTesting();
        for (int i = 0; i < 500000; i++) {
            pt.add(i);
        }
        int count = pt.check();
        System.out.println(count / 500000.0);
    }
}
