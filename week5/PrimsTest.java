package week5;


import java.util.Scanner;

/**
 * PrimsTest class - client class to test the Prim's algorithm to compute to mim length of segment between points (Minimum Spanning Tree)
 *
 * @author Vivekanand Ganapathy Nagarajan
 * @version 2.0 July 28th, 2016
 */
public class PrimsTest {
    public static void main(String[] args) {
        PointDistanceGraph graph = buildPointDistanceGraph();
        System.out.println(new Prims(graph).dist());
    }

    /**
     * Build the PointDistanceGraph based on user input
     * @return pointDistanceGraph
     */
    private static PointDistanceGraph buildPointDistanceGraph(){
        Scanner scanner = new Scanner(System.in);
        int points = scanner.nextInt();
        PointDistanceGraph graph = new PointDistanceGraph(points);
        for (int i = 0; i < points; i++) {
            int x = scanner.nextInt();
            int y  = scanner.nextInt();
            Point p = new Point(x, y);
            graph.addPoint(p);
        }
        for (int p = 0; p < graph.getPoints(); p++){
            for (int p2 = p+1; p2 < graph.getPoints(); p2++){
                Point firstPoint = graph.points[p];
                Point secondPoint = graph.points[p2];
                graph.addDistance(firstPoint, secondPoint);
            }
        }
        return graph;
    }
}







