import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.io.File;
import java.util.Collections;
import java.util.Set;

public class ThreadsOfSuduko{
    public static void main(String[] args) {
        
        try {
            if(args.length < 2) {
                System.err.println("usage: java ThreadsOfSuduko threads puzzleFilename [puzzleName]");
                System.exit(-1);
            }
            
            Scanner in = new Scanner(new File(args[1]));
            String name = (args.length > 1) ? args[2] : null;
            Suduko sud = new Suduko(in, name);
            System.out.println(sud + "\n\n");
            
            int numThreads = Integer.parseInt(args[0]);
            
            // Split the search field into 81 different sub-puzzles
            int index = 0;
            for(int y=1; y<=9; ++y) {
                for(int x=1; x<=9; ++x) {
                    suds[index++] = new Suduko(sud, new int[]{x, y});
                }
            }
            
            // WORK HERE
            // solveSuds accepts a range of the 81 Suduko candidate solutions
            //   (in this case from 0 to suds.length-1 - that is, ALL of them!)
            //   with a "thread ID" hard-coded as 1.
            // Your job is to rewrite this to create numThreads threads, with
            //   the set of Suduko candidate solutions split between them
            //   (for example, 0 to 40 for the first thread and 41-81 for the second).   

            /*solveSuds(0, suds.length-1, 1);
            Thread t1 = new Thread(solveSuds(0, suds.length-1, 1));
            t1.start();*/

            if(numThreads == 1){
                solveSuds(0, suds.length-1, 1);
            }
            else{
                try{
                    int work = (suds.length-1) / numThreads;
                    int start = 0;
                    int end = work;
                    Thread[] ts = new Thread[numThreads];


                    for(int i=0; i<numThreads; ++i){
                        final int threadID = i;
                        final int fstart = start;
                        final int fend = end;
                        ts[i] = new Thread(()-> solveSuds(fstart, fend, threadID));
                        ts[i].start();
                        start = end;
                        end += work;
                    }
                    for(int i=0; i<numThreads; ++i){
                        ts[i].join();
                    }
                }catch(InterruptedException e){
                    System.err.println("Error: " + e);
                }
            }

            // END WORK HERE
                        
            // Show the solution(s), if any
            System.out.println("Found " + solutions.size() + " solutions");
            for(var s : solutions) System.out.println(s);
        } catch(Exception e) {
            //System.err.println("ABORT: " + e);
            e.printStackTrace(System.err);
            System.exit(-1);
        }
    }
    
    // WORK HERE
    // Be sure to protect the solutions ArrayList from Thread Interference!
    private static synchronized void solveSuds(int first, int last, int id) {
        System.out.println("Thread " + id + " will solve " + first + " to " + last);
        for(int i=first; i<=last; ++i) {
            System.out.println("Thread " + id + " solving " + i);// + "\n\n" + suds[i]);
            if(suds[i].solve()) syncSolutions.add(suds[i]);
        }
    }
    // END WORK HERE
    
    private static Suduko[] suds = new Suduko[81];
    private static HashSet<Suduko> solutions = new HashSet<>();
    private static Set<Suduko> syncSolutions = Collections.synchronizedSet(solutions);
}
