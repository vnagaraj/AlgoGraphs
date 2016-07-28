package week4;

import java.util.Scanner;

/**
 * ShortestDistanceTest class - client class to test the BellmanFord algorithm
 *
 * @author Vivekanand Ganapathy Nagarajan
 * @version 2.0 July 28th, 2016
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


