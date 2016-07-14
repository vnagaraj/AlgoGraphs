package week3;

import week1.UndirectedGraph;
import java.util.Scanner;

public class BFSTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        UndirectedGraph g = new UndirectedGraph(n);
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            g.addEdge(x, y);
        }
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        BFS bfs = new BFS(x, g);
        System.out.println(bfs.distTo(y));
    }
}




