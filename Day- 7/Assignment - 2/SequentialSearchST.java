public class SequentialSearchST<Key extends Comparable<Key>, Value> {
    /**
     * the field to store the given key and value.
     */
    private MyLinkedList list = new MyLinkedList();

    /**
     * function to add the key and value to the list.
     * @param key the key of the pair.
     * @param value the value corresponding to the value.
     */
    public void put(final Key key, final Value value) {
        list.add(key, value);
    }

    /**
     * function to get the value of the given key.
     * @param key the key to be searched for.
     * @return the value of the sent key.
     */
    public Object get(final Key key) {
        Node temp = list.contains(key);
        if (temp != null) {
            return temp.value;
        }
        return null;
    }

    /**
     * method to return the iterable of the keys.
     * @return the iterable of the keys.
     */
    public Iterable<Key> keys() {
        Queue<Key> que = new Queue<Key>();
        Node current = list.head;
        while (current != null) {
            que.enqueue((Key) current.key);
            current = current.next;
        }

        return que;
    }
}
