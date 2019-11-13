import java.util.NoSuchElementException;
import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    
    /**
     * class to create an object that contains the item,
     * and the connection.
     *
     * @param <Item> the item to be stored.
     */
    private static class Node<Item> {

        /**
         * field to store the item.
         */
        private Item item;

        /**
         * field to store the next item.
         */
        private Node<Item> next;

        /**
         * field to store the previous item.
         */
        private Node<Item> prev;

        public Node() {
        }

        public Node(Item item) {
            this.item = item;
            this.next = null;
            this.prev = null;
        }

        /**
         * function to return the item in the node.
         *
         * @return the item stored in the node.
         */
        public Item get() {
            return this.item;
        }
        
        /**
         * function to set the next node to the specified.
         *
         * @param next the next node to be connected.
         */
        public void setNext(Node<Item> next) {
            this.next = next;
        }

        /**
         * function to return the next node.
         *
         * @return the next node.
         */
        public Node getNext() {
            return this.next;
        }

        /**
         * function to set the prev node to the specified.
         *
         * @param prev the previous node to be connected.
         */
        public void setPrev(Node<Item> prev) {
            this.prev = prev;
        }
        
        /**
         * function to return the previous node.
         *
         * @return the prev node.
         */
        public Node<Item> getPrev() {
            return this.prev;
        }
    }
    
    /**
     * field to store the first element in the deque.
     */
    private Node<Item> first;

    /**
     * field to store the last element in the deque.
     */
    private Node<Item> last;

    /**
     * field to store the number of elements in the deque.
     */
    private int size;

    /**
     * default constructor.
     */
    public Deque() {
        first = last = null;
        size = 0;
    }

    /**
     * function to check if the deque is empty.
     *
     * @return true if the deque is empty, else false.
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * function to return the size of the deque.
     *
     * @return the size of the deque.
     */
    public int size() {
        return size;
    }

    /**
     * function to add an item at the start.
     *
     * @param item the item to be added to the start.
     */
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (first == null) {
            first = last = new Deque.Node<Item>(item);
            size += 1;
            return;
        }

        Deque.Node<Item> f = new Deque.Node<Item>(item);
        first.setPrev(f);
        f.setNext(first);

        first = f;
        size += 1;
    }

    /**
     * function to add an item at the last.
     *
     * @param item the item to be added to the last.
     */
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (last == null) {
            first = last = new Deque.Node<Item>(item);
            size += 1;
            return;
        }
        
        Deque.Node<Item> l = new Deque.Node<Item>(item);
        last.setNext(l);
        l.setPrev(last);

        last = l;
        size += 1;
    }

    /**
     * function to remove the item from the front of the deque.
     *
     * @return the item stored at the front.
     */
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Deque.Node<Item> temp = first;
        first = first.getNext();
        if (size == 1) {
            first = last = null;
        }

        size -= 1;
        return (Item) temp.get();
    }

    /**
     * function to remove the item from the end of the deque.
     *
     * @return the item stored at the last.
     */
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Deque.Node<Item> temp = last;
        last = last.getPrev();
        if (size == 1) {
            first = last = null;
        }

        size -= 1;
        return (Item) temp.get();
    }

    /**
     * iterates over the items in the deque in FIFO order.
     *
     * @return an iterator that iterates over the items in this deque in FIFO order.
     */
    public Iterator<Item> iterator()  {
        return new DequeIterator<Item>(first);  
    }

    /**
     * class iterator.
     *
     * @param <Item> the type of the element.
     */
    private class DequeIterator<Item> implements Iterator<Item> {
        private Deque.Node<Item> current;

        public DequeIterator(Deque.Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }

    /**
     * main function to test the methods written.
     *
     * @param args the parameter of the main function.
     */
    public static void main(String[] args) {
        Deque deque = new Deque();

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            deque.addFirst(i);
        }
        
        for (int i = 0; i < 10; i++) {
            System.out.println(deque.removeLast());
        }
    }
}
