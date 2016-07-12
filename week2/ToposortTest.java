package week2;

import java.util.Scanner;

public class ToposortTest {


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
        int[] time = new ToplogicalSort(g).run();
        for (int i= time.length-1; i >=1; i--){
            System.out.print(time[i]);
            System.out.print(" ");
        }
    }
}




