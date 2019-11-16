public class Card implements Comparable<Card> {
    int rank;
    int deck;

    public Card(int rank, int deck) {
        this.rank = rank;
        this.deck = deck;
    }

    public String display() {
        String strDeck = (deck == 0) ? "S" : (deck == 1) ? "H" : (deck == 2) ? "C" : "D";
        String strRank = (rank == 1) ? "A" : (rank == 11) ? "J" : (rank == 12) ? "Q" : (rank == 13) ? "K" : Integer.toString(rank);

        return strRank + strDeck;
    }

    public int compareTo(Card that) {

        if (this.deck == that.deck) {
            return this.rank - that.rank;
        }
        return this.deck - that.deck;
    }
}
