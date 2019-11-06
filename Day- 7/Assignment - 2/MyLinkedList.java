/**
 * List of my linkedlists.
 */
public class MyLinkedList<Key extends Comparable<Key>, Value> {
    Node head;
    /**
     * Constructs an empty list with size initialized to zero.
     */
    public MyLinkedList() {
        head = null;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param data  The data
     */
    public void add(Key key, Value value){
        if (head == null) {
            head = new Node(key, value);
            return;
        }

        Node current = head;
        while (current.next != null) {
            if ((current.key.equals(key))) {
                current.value = value;
                return;
            }
            current = current.next;
        }
        Node temp = new Node(key, value);
        temp.next = head;
        head = temp;
    }

    /**
     * Removes all of the elements from this list.
     */
    public void clear() {
        head = null;
    }

    /**
     * Returns true if this list contains the specified element.
     *
     * @param data  The data
     *
     * @return { description_of_the_return_value }
     */
    public Node contains(Key key) {
        Node current = head;
        Node temp = null;
        while (current.next != null) {
            // System.out.println(current.key + " " + current.value);
            if (current.next.key.compareTo(key) == 0) {
                temp = current.next;
                // addLast(temp);
                current.next = temp.next;
                temp.next = null;
            }
            current = current.next;
        }
        current.next = temp;
        return temp;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (head == null) {
            return "LinkedList is empty";
        }

        String output = "";
        Node current = head;
        while (current != null) {
            String temp = "[" + current.key + "]";
            output += temp;
            current = current.next;
        }
        return output;
    }
}
