package week4;

import java.util.Scanner;

/**
 * Created by vnagarajan on 7/21/16.
 */
public class ShortestDistanceTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        BellmanWeightedDirectedGraph g = new BellmanWeightedDirectedGraph(n);
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            g.addEdge(x-1, y-1, w);
        }
        int src = scanner.nextInt();
        BellmanFord b = new BellmanFord(g, src-1);
        for (int i=0; i < n; i++){
            System.out.println(b.dist(i));
        }
    }
}


