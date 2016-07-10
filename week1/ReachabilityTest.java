package week1;
import java.util.Scanner;

public class ReachabilityTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        UndirectedGraph g = new UndirectedGraph(n, m);
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





