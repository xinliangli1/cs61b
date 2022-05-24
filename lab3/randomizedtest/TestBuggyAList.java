package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove () {
      AListNoResizing<Integer> a=new AListNoResizing();
      BuggyAList<Integer> b=new BuggyAList();
      a.addLast(4);
      b.addLast(4);
      a.addLast(5);
      b.addLast(5);
      a.addLast(6);
      b.addLast(6);

      assertEquals(a.size(), b.size());
      assertEquals(a.removeLast(), b.removeLast());
      assertEquals(a.removeLast(), b.removeLast());
      assertEquals(a.removeLast(), b.removeLast());

    }

    @Test
  public void RandomizedTest() {
      AListNoResizing<Integer> a=new AListNoResizing<>();
      BuggyAList<Integer> b=new BuggyAList<>();
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
          assertEquals(a.getLast(), b.getLast());
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
