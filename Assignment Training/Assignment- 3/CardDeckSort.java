public class CardDeckSort {
    Card[] cards;

    public CardDeckSort() {
        cards = new Card[52];
        int num = 0;
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j < 4; j++) {
                cards[num++] = new Card(i, j);
            }
        }

        // for (int i = 0; i < 52; i++) {
        //     System.out.println(cards[i].display());
        // }
    }

    public Card[] sorted() {
        for (int i = 0; i < cards.length; i++) {
            for (int j = i; j > 0; j--) {
                if (cards[j].compareTo(cards[j - 1]) < 0) {
                    Card temp = cards[j];
                    cards[j] = cards[j - 1];
                    cards[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        return cards;
    }

    public static void main(String[] args) {
        CardDeckSort cds = new CardDeckSort();
        Card[] cards = cds.sorted();
        for (int i = 0; i < cards.length; i++) {
            System.out.print(cards[i].display() + " ");
            if ((i + 1) % 13 == 0) {
                System.out.println("\n");
            }
        }
    }
}
