public class Stack {

    /**
     * field to store the string items in stack.
     */
    private String[] s;

    /**
     * field to store the size of the stack.
     */
    private int size;

    Stack(final int capacity) {
        s = new String[capacity];
        size = 0;
    }

    /**
     * function to check if the stack is empty.
     * @return true if empty, else false.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * function to return the size of the stack.
     * @return the size.
     */
    public int size() {
        return size;
    }

    /**
     * function to add the item to the stack.
     * @param item the item that is to be added.
     */
    public void push(final String item) {
        // System.out.println(item);
        s[size++] = item;
    }

    /**
     * function to pop out the item.
     * @return the item that is at the end.
     */
    public String pop() {
        String output = s[--size];
        s[size] = null;
        return output;
    }

    /**
     * function to print the elements in the stack.
     */
    public void pr() {
        for (int i = 0; i < size; i++) {
            System.out.print(s[i]);
        }
    }
}
