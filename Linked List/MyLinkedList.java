/**
 * List of my linkedlists.
 */
public class MyLinkedList {
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
    public void add(String data){
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param data  The data
     */
    public void addFirst(String data){
        Node temp = new Node(data);

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
     * @param      data  The data
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(String data) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            } else {
                current = current.next;
            }
        }
        return false;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param      index  The index
     *
     * @return     { description_of_the_return_value }
     */
    public String get(int index){
        if (index >= 0) {
            Node current = head;
            int i = 0;
            while (current != null) {
                if (index == i) {
                    return current.data;
                }
                i += 1;
            }
        }
        return null;
    }

    /**
     * Returns the first element in this list.
     *
     * @return     The first.
     */
    public String getFirst() {
        if (head != null) {
            return head.data;
        }
        return null;
    }

    /**
     * Returns the last element in this list.
     *
     * @return     The last.
     */
    public String getLast() {
        if (head == null) {
            return null;
        }

        Node current = head;
        while (true) {
            if(current.next == null) {
                break;
            } else {
                current = current.next;
            }
        }
        return current.data;
    }

    /**
     * Retrieves and removes the head (first element) of this list.
     *
     * @return     { description_of_the_return_value }
     */
    public String remove() {
        if (head == null) {
            return null;
        }
        Node temp = head;
        head = head.next;
        return temp.data;
    }
    /**
     * Removes and returns the last element from this list.
     *
     * @return     { description_of_the_return_value }
     */
    public String removeLast() {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            head = null;
            return null;
        }

        Node current = head;
        Node temp;
        while (current.next.next != null) {
            current = current.next;
        }
        temp = current.next;
        current.next = null;
        return temp.data;
    }
    /**
     * Returns the number of elements in this list.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        if (head == null) {
            return 0;
        }
        int count = 0;
        Node current = head;
        while (current != null) {
            current = current.next;
            count += 1;
        }
        return count;
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
            String temp = "[" + current.data + "]";
            output += temp;
            current = current.next;
        }
        return output;
    }
}
