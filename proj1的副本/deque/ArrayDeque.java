package deque;

public class ArrayDeque<Type> {
    public  Type[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    public ArrayDeque() {
        items= (Type[]) new Object[8];
        size=0;
        nextFirst=1;
        nextLast=2;
    }

    private void resize(int capacity) {
        Type[] a=(Type[]) new Object[capacity];
        int t=nextFirst;
        nextFirst=nextFirst+a.length- size-1;
        System.arraycopy(items,0,a,0,nextLast);
        System.arraycopy(items,t+1,a,nextFirst+1,capacity-nextFirst-1);
        items=a;
    }

    public void resize1(int capacity) {
        Type[] a=(Type[]) new Object[capacity];
        if (nextLast>nextFirst) {
            int c=nextFirst;
            System.arraycopy(items,c+1,a, 0, nextLast-nextFirst-1);
            int t=nextLast-nextFirst;
            nextFirst=t-1;
            nextLast=t-1;
            items=a;
        }
        else {
            int t=nextFirst;
            nextFirst=nextLast;
            System.arraycopy(items,0,a,0,nextLast);
            System.arraycopy(items,t+1,a,nextFirst+1,capacity-nextFirst-1);
            items=a;
        }

    }

    public void addLast(Type x) {
        if (nextFirst==nextLast) {
            resize(size*2);
        }
        items[nextLast] = x;
        if (nextLast == (items.length - 1)) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }
        size += 1;
    }

    public void addFirst(Type x) {
        if (nextFirst==nextLast) {
            resize(size*2);
        }
        items[nextFirst]=x;
        if (nextFirst==0) {
            nextFirst=items.length-1;
        } else {
            nextFirst-=1;
        }
        size+=1;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int size() {
        return size;
    }

    public Type get(int i) {
        int c=nextFirst+i+1;
        if (c<items.length) {
            return items[c];
        }
        else {
            return items[c-items.length];
        }
    }

    public void printDeque() {
        for (int i=0; i<size; i++) {
            System.out.println(get(i));
        }
        System.out.println();
    }

    public Type removeFirst() {
        if (size< items.length/4 && (size>4)) {
            resize1(items.length/4);
        }
        if (isEmpty()) {
            return null;
        }
        int c;
        if (nextFirst==items.length-1) {
            c=0;
        }
        else {
            c=nextFirst+1;
        }
        Type t=items[c];
        items[c]=null;
        size-=1;
        nextFirst=c;
        return t;
    }

    public Type removeLast() {
        if (size< items.length/4 && (size>4)) {
            resize1(items.length/4);
        }
        if (isEmpty()) {
            return null;
        } else {
            int c;
            if (nextLast == 0) {
                c = items.length - 1;
            } else {
                c = nextLast - 1;
            }
            Type t = items[c];
            items[c] = null;
            size -= 1;
            nextLast=c;
            return t;
        }
    }

}
