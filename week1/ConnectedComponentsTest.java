package week1;
import java.util.Scanner;

/**
 * ConnectedComponentsTest class - test the ConnectedComponents
 *
 * @author Vivekanand Ganapathy Nagarajan
 * @version 2.0 July 28th, 2016
 */
public class ConnectedComponentsTest {

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
        System.out.println(new ConnectedComponents(g).run());
    }
}





