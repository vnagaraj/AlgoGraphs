package week3;

import week1.UndirectedGraph;
import java.util.Scanner;
/**
 * BipartiteTest class - client class to test if graph is bipartite
 *
 * @author Vivekanand Ganapathy Nagarajan
 * @version 2.0 July 28th, 2016
 */
public class BipartiteTest {

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
        BFS bfs = new BFS(1, g);
        bfs.run();
        if (bfs.isBipartite){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}






