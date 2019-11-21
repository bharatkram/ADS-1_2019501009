import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import java.lang.IllegalArgumentException;

public class Percolation {

    private boolean[][] grid;
    private int n;
    private int numberOfOpenSites;
    private WeightedQuickUnionUF quf;
    private int top;
    private int bottom;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        numberOfOpenSites = 0;
        this.n = n;
        grid = new boolean[n][n];
        quf = new WeightedQuickUnionUF(n * n + 2);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = false;
            }
        }
        top = n * n;
        bottom = n * n + 1;

        // for (int i = 0; i < n - 1; i++) {
        // quf.union(0, i);
        // quf.union(i * n, n * n + 1);
        // }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        // if (!isOpen(row - 1, col - 1)) {
        //     numberOfOpenSites += 1;
        //     grid[row - 1][col - 1] = true;
        //     if (row == 1) {
        //         quf.union(top,(row-1) * n + col - 1);
        //     }
        //     if (row == n){
        //         quf.union(bottom,(row-1) * n + col - 1));
        //     }
        //     if (isOpen(row - 2, col - 1)) {
        //         quf.union((row - 1) * n + col - 1, (row - 2) * n + col - 1);
        //     }
        //     if (isOpen(row, col - 1)) {
        //         quf.union((row - 1) * n + col - 1, (row) * n + col - 1);
        //     }
        //     if (isOpen(row - 1, col - 2)) {
        //         quf.union((row - 1) * n + col - 1, (row - 1) * n + col - 2);
        //     }
        //     if (isOpen(row - 1, col)) {
        //         quf.union((row - 1) * n + col - 1, (row - 1) * n + col);
        //     }
        // }
        // if (!isOpen(row, col)) {
        //     numberOfOpenSites += 1;
        //     grid[row][col] = true;
        // }
        // if (row == 0) {
        //     quf.union(top, row * n + col);
        //     quf.union((row + 1) * n + col, row * n + col);
        //     quf.union((row) * n + col + 1, row * n + col);
        // } else if (row == n) {
        //     quf.union(row * n + col, bottom);
        //     quf.union((row - 1) * n + col , row * n + col);
        //     quf.union(row * n + col, row * n + col);
        // } else {
        // }
        if (row <= 0 || col <= 0 || row > n || col > n) {
            throw new IllegalArgumentException();
        }
        if (!isOpen(row, col)){
            grid[row - 1][col - 1] = true;
            numberOfOpenSites += 1;
        }

        if (col - 1 > 0) {
            if (isOpen(row , col - 1)) {
                quf.union((row - 1) * n + col - 1, (row - 1) * n + col - 2);
            }
        }

        if (col < n) {
            if (isOpen(row, col+1)) {
                quf.union((row - 1) * n + col - 1, (row - 1) * n + col);
            }
        }

        if (row - 1 > 0) {
            if (isOpen(row - 1, col)) {
                quf.union((row - 1) * n + col - 1, (row - 2) * n + col - 1);
            }
        } 
        if(row == 1) {
            quf.union((row - 1) * n + col - 1, top);
        }

        if (row < n) {
            if (isOpen(row+1, col)) {
                quf.union((row - 1) * n + col - 1, (row) * n + col - 1);
            }
        } 
        if(row == n) {
            quf.union((row - 1) * n + col - 1, bottom);
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if ((row <= 0 || row > n) || (col <= 0 || col > n)) {
            throw new IllegalArgumentException();
        }
        return grid[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int ro, int co) {
        if ((ro <= 0 || ro > n) || (co <= 0 || co > n)) {
            throw new IllegalArgumentException();
        } else {
            int row = ro - 1;
            int col = co - 1;
            return quf.connected((row) * n + col, top);
        }
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return quf.connected(top, bottom);
    }

    // test client (optional)
    public static void main(String[] args) {
    }
}
