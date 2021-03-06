package week2;


import java.util.Scanner;
/**
 * StronglyConnectedTest class - test the StronglyConnectedComponents class
 *
 * @author Vivekanand Ganapathy Nagarajan
 * @version 2.0 July 28th, 2016
 */
class StronglyConnectedTest {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        DirectedGraph g = new DirectedGraph(n);
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            g.addEdge(x, y);
        }
        System.out.println(new StronglyConnectedComponents(g).run());
    }


}







