package week4;

import java.util.*;

public class DijkstraTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        WeightedDirectedGraph g = new WeightedDirectedGraph(n);
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            g.addEdge(x, y, w);
        }
        int x = scanner.nextInt();
        Djikstra djikstra = new Djikstra(g, x);
        int y = scanner.nextInt();
        System.out.println(djikstra.dist(y));
    }
}




