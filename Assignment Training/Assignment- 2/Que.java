public class Que {
    private class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    Node last;

    public Que() {
        last = null;
    }

    public void enque(int val) {
        if (last == null) {
            last = new Node(val);
            last.next = last;
        } else {
            Node temp = new Node(val);
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
    }

    public int deque() {
        if (last == null) {
            return -1;
        }
        Node temp = last.next;
        if (last.next == last) {
            temp = last;
            last = null;
        } else {
            last.next = temp.next;
        }
        return temp.val;
    }

    public static void main(String[] args) {
        Que que = new Que();

        for (int i = 0; i < 10; i++) {
            que.enque(i);
        }

        System.out.print(que.deque() + " ");
        System.out.print(que.deque() + " ");
        System.out.print(que.deque() + " ");
        System.out.print(que.deque() + " ");
        System.out.print(que.deque() + " ");
        System.out.print(que.deque() + " ");

        que.enque(100);
        que.enque(200);
        
        System.out.print(que.deque() + " ");
        System.out.print(que.deque() + " ");
        System.out.print(que.deque() + " ");
        System.out.print(que.deque() + " ");
        System.out.print(que.deque() + " ");
        System.out.print(que.deque() + " ");
    }
}
