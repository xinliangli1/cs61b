package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.lang.reflect.Array;

import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void addIsEmptySizeTest() {
        ArrayDeque<Integer> ad=new ArrayDeque<>();
        assertTrue("A newly initialized LLDeque should be empty", ad.isEmpty());
        ad.addFirst(3);
        assertEquals(1, ad.size());
        assertFalse("lld1 should now contain 1 item", ad.isEmpty());

        ad.addLast(11);
        assertEquals(2, ad.size());
        ad.addLast(9);
        assertEquals(3, ad.size());
        ad.addFirst(1);
        ad.addFirst(5);
        ad.addFirst(7);
        ad.addLast(13);
        ad.addLast(15);

        System.out.println("Printing out deque: ");
        ad.printDeque();

    }

    @Test
    public void removeEmptyTest() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.addFirst(3);
        ad.removeLast();
        ad.removeFirst();
        ad.removeLast();
        ad.removeFirst();

        int size = ad.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
    }
    
    @Test
    public void multipleParamTest() {


        ArrayDeque<String>  ad1 = new ArrayDeque<>();
        ArrayDeque<Double>  ad2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> ad3 = new ArrayDeque<Boolean>();

        ad1.addFirst("string");
        ad2.addFirst(3.14159);
        ad3.addFirst(true);

        String s = ad1.removeFirst();
        double d = ad2.removeFirst();
        boolean b = ad3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        //System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, ad1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, ad1.removeLast());


    }

    @Test
    public void resizeTest() {
        ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
        ad.addFirst(9);
        ad.addFirst(7);
        ad.addFirst(5);
        ad.addFirst(3);
        ad.addLast(11);
        ad.addLast(13);
        ad.addFirst(1);
        //ad.printDeque();
        ad.addLast(15);
        ad.addLast(17);
        System.out.println(ad.size());
        ad.removeFirst();
        ad.removeFirst();
        ad.removeLast();
        ad.removeLast();
        System.out.println(ad.size());
        ad.printDeque();
    }

    @Test
    public void resize1Test() {
        ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
        for (int k=0;k<30;k++) {
            ad.addLast(k);
        }
        //ad.printDeque();
        ad.addLast(30);
        ad.addLast(31);
        //ad.addLast(33);
        //ad.addLast(34);
        ad.printDeque();
        ad.removeLast();
        ad.removeLast();
        ad.removeLast();
        ad.removeLast();
        ad.removeLast();
        ad.removeLast();
        ad.removeLast();
        ad.removeLast();
        ad.removeLast();
        ad.removeLast();
        ad.removeLast();
        ad.removeLast();
        ad.removeLast();
        ad.removeLast();
        ad.removeLast();
        ad.removeLast();
        ad.removeLast();
        ad.removeLast();
        ad.removeLast();
        ad.removeLast();
        ad.removeLast();
        ad.removeLast();

    }


    @Test
    public void RandomizedTest() {
        ArrayDeque<Integer> a=new ArrayDeque<>();
        AListNoResizing<Integer> b=new AListNoResizing<>();
        int N=1000000;
        for (int i=0; i<N; i++) {
            int operationNumber = StdRandom.uniform(0,4);
            if (operationNumber==0) {
                //addLast
                int Val=StdRandom.uniform(0,100);
                a.addLast(Val);
                b.addLast(Val);
                //System.out.println("addLast(" + Val + ")");
            } else if (operationNumber==1) {
                if (a.size()==0 || b.size()==0) {
                    continue;
                }
                assertEquals(a.size(), b.size());
                //assertEquals(a.getLast(), b.getLast());
            } else {
                if (a.size()==0 || b.size()==0){
                    continue;
                }
                assertEquals(a.size(),b.size());
                assertEquals(a.removeLast(), b.removeLast());
            }

        }
    }
    
}
