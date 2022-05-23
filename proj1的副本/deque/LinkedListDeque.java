package deque;

public class LinkedListDeque<T> {
    public class Node<T> {
        public Node prev;
        public T item;
        public Node next;

        public Node(Node p, T x, Node n) {
            prev=p;
            item=x;
            next=n;
        }

        public T getRecursive(int i) {
            if (i==0) {
                return item;
            }
            return (T)next.getRecursive(i-1);
        }
    }
    public Node sentFront;
    public int size;
    public Node sentBack;

    public LinkedListDeque () {
        sentFront= new Node(null, 63, sentBack);
        sentBack= new Node(sentFront, 63, null);
        sentFront.next=sentBack;
        size=0;
    }

    public void addFirst(T x) {
        sentFront.next=new Node(sentFront, x, sentFront.next);
        sentFront.next.next.prev=sentFront.next;
        size+=1;
    }

    public void addLast(T x) {
        sentBack.prev=new Node(sentBack.prev,x,sentBack);
        sentBack.prev.prev.next=sentBack.prev;
        size+=1;
    }

    public Boolean isEmpty() {
        return sentFront.next==sentBack && sentBack.prev==sentFront;

    }

    public int size() {
        return size;
    }

    /** get the ith items of the DLList using Iteration */
    public T get(int i) {
        Node P=sentFront.next;
        while (i>0) {
            P=P.next;
            i-=1;
        }
        return (T) P.item;
    }

    /** remove the first item in the DLList (must take constant time) */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T t=(T) sentFront.next.item;
        sentFront.next=sentFront.next.next;
        sentFront.next.prev=sentFront;
        size-=1;
        return t;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T t=(T) sentBack.prev.item;
        sentBack.prev=sentBack.prev.prev;
        sentBack.prev.next=sentBack;
        size-=1;
        return t;
    }

    public void printDeque() {
        for (int i=0; i<size;i++) {
            T t=getRecursive(i);
            System.out.println(t);
        }
        System.out.println();
    }

    public T getRecursive(int i) {
        LinkedListDeque P=this;
        if (i==0) {
            return (T) sentFront.next.item;
        }

        return (T) sentFront.next.next.getRecursive(i-1);
    }


}
