package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static SLList creatslist(int N) {
        SLList<Integer> a=new SLList();
        for (int i=0; i<N; i++) {
            a.addLast(0);
        }
        return a;
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        int[] x= new int[] {1000,2000,4000,8000,16000,32000,64000,128000};
        AList<Integer> N=new AList();
        for (int i=0; i< x.length; i++) {
            N.addLast(x[i]);
        }

        AList<Double> time =new AList();
        for (int i=0; i<x.length;i++) {
            SLList b= creatslist(x[i]);
            Stopwatch sw = new Stopwatch();
            for (int c=0; c<10000; c++) {
                b.getLast();
            }
            double timeInseconds= sw.elapsedTime();
            time.addLast(timeInseconds);

        }

        AList<Integer> opCounts=new AList();
        for (int i=0; i<x.length; i++) {
            opCounts.addLast(10000);
        }

        printTimingTable(N,time,opCounts);
    }

}

