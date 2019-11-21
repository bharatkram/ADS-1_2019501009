public class Board {

    private int[][] tiles;
    private int n;
    
    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        this.tiles = tiles;
        this.n = tiles.length;
    }
                                           
    // string representation of this board
    public String toString() {
        String output = new String();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                output += Integer.toString(tiles[i][j]) + " ";
            }
            output += tiles[i][n - 1];
            if (i != n - 1){
                output +=  "\n";
            }
        }
        return output;
    }

    // board dimension n
    public int dimension() {
        return this.n;
    }

    // number of tiles out of place
    public int hamming() {
        int wrongPos = 0;
        // int[][] str = new int[n][n];

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (i == n - 1 && j == n - 1) {
        //             str[i][j] = 0;
        //         } else {
        //             str[i][j] = (i * n) + j + 1;
        //         }
        //     }
        // }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // if (str[i][j] != tiles[i][j]) {
                //     wrongPos += 1;
                // }
                if (tiles[i][j] != (i * n) + j + 1) {
                    wrongPos += 1;
                }
            }
        }
        return wrongPos;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int dist = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tiles[i][j] != 0) {
                    int num = tiles[i][j];
                    int iIndex = num / n;
                    int jIndex = num % n;
                    dist += Math.abs(i - iIndex) + Math.abs(j - jIndex);
                }
            }
        }
        return dist;
    }

    // is this board the goal board?
    public boolean isGoal() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tiles[i][j] != (i * n) + j + 1) {
                    return false;
                }
            }
        }
        return true;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (this.dimension() != (Board)  y).dimension()) {
            return false;
        }
        if (!this.toString().equals(y.toString())) {
            return false;
        }
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {

    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
            }
        }
    }

    // unit testing (not graded)
    public static void main(String[] args);

}