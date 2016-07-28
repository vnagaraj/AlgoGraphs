package week5;

import java.util.Scanner;

/**
 * ClusteringTest class - client class to test the clustering algorithm
 *
 * @author Vivekanand Ganapathy Nagarajan
 * @version 1.0 July 28th, 2016
 */
public class ClusteringTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);;
        Point[] points = getPoints(s);
        int k = s.nextInt();
        Clustering clustering = new Clustering(points, k);
        double dist = clustering.minDist();
        System.out.println(String.format( "%.12f", dist));
    }

    /**
     * Create Points from user input
     * @param s user input
     * @return list of points
     */
    private static Point[] getPoints(Scanner s){
        int n = s.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = s.nextInt();
            int y = s.nextInt();
            Point p = new Point(x, y);
            points[i] = p;
        }
        return points;
    }
}










