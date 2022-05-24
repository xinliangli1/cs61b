package timingtest;
import edu.princeton.cs.algs4.Stopwatch;
import org.checkerframework.checker.units.qual.A;

/**
 * Created by hug.
 */
public class TimeAList {
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

    public static double Times(int N) {
        AList<Integer> a=new AList();
        Stopwatch sw=new Stopwatch();
        for (int i=0; i<N ; i++) {
            a.addLast(0);
        }
        double timeInseconds=sw.elapsedTime();
        return timeInseconds;
    }


    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns= new AList();
        Ns.addLast(1000);
        Ns.addLast(2000);
        Ns.addLast(4000);
        Ns.addLast(8000);
        Ns.addLast(16000);
        Ns.addLast(32000);
        Ns.addLast(64000);
        Ns.addLast(128000);
        Ns.addLast(128000000);

        AList<Double> times= new AList();
        times.addLast(Times(1000));
        times.addLast(Times(2000));
        times.addLast(Times(4000));
        times.addLast(Times(8000));
        times.addLast(Times(16000));
        times.addLast(Times(32000));
        times.addLast(Times(64000));
        times.addLast(Times(128000));
        times.addLast(Times(128000000));

        AList<Integer> opCounts= new AList();
        opCounts.addLast(1000);
        opCounts.addLast(2000);
        opCounts.addLast(4000);
        opCounts.addLast(8000);
        opCounts.addLast(16000);
        opCounts.addLast(32000);
        opCounts.addLast(64000);
        opCounts.addLast(128000);
        opCounts.addLast(128000000);

        printTimingTable(Ns,times,opCounts);


    }
}
