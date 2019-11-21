import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats {

    private int n;
    private int trials;
    private double[] fractions;
    
    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n<= 0 || trials <= 0){
            throw new IllegalArgumentException();
        }
        this.n = n;
        this.trials = trials;

        fractions = new double[trials];

        for (int i = 0; i < trials; i++) {
            Percolation perc = new Percolation(n);

            while (!perc.percolates()) {
                int row = StdRandom.uniform(1,n+1);
                int col = StdRandom.uniform(1,n+1);

                perc.open(row, col);

            }
            fractions[i] = (double) (perc.numberOfOpenSites() / (n * n));
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(fractions);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(fractions);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return this.mean() - (1.96 * this.stddev()) / Math.sqrt(trials);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return this.mean() + (1.96 * this.stddev()) / Math.sqrt(trials);
    }

   // test client (see below)
   public static void main(String[] args){
   }

}