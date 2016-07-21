package week4;

import java.util.Scanner;

public class NegativeCycleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        //taking into account virtual node ended at last
        BellmanWeightedDirectedGraph g = new BellmanWeightedDirectedGraph(n+1);
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            g.addEdge(x-1, y-1, w);
        }
        System.out.println(new BellmanFord(g).checkCycle());
    }
}



