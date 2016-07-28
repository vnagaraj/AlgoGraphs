package week1;
import java.util.Scanner;

/**
 * DFSTest class - test DFS
 *
 * @author Vivekanand Ganapathy Nagarajan
 * @version 2.0 July 28th, 2016
 */
public class DFSTest {

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
        System.out.println(new DFS(x, y, g).run());
    }
}





