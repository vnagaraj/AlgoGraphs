package week5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PointsTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int points = scanner.nextInt();
        PointDistanceGraph graph = buildPointDistanceGraph(points, scanner);
        System.out.println(new Prim(graph).dist());
    }

    private static PointDistanceGraph buildPointDistanceGraph(int points, Scanner scanner){
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

class Distance {
    Point startPoint;
    Point endPoint;
    double distance;

    Distance(Point startPoint, Point endPoint){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.distance = distTo(startPoint, endPoint);
    }

    double distTo(Point first, Point second){
        double x_diff = first.x - second.x;
        double y_diff = first.y - second.y;
        double pow = Math.pow(x_diff, 2) + Math.pow(y_diff, 2);
        return Math.sqrt(pow);
    }
}

class PointDistanceGraph{
    HashMap<Point, ArrayList<Distance>> adj = null;
    Point[] points;
    private int pointCounter = 0;

    PointDistanceGraph(int vertices){
        this.points = new Point[vertices];
        adj = new HashMap<Point, ArrayList<Distance>>();
    }

    public void addPoint(Point p){
        points[pointCounter++] = p;
    }

    public int getPoints(){
        return pointCounter;
    }

    public void addDistance(Point u, Point v){
        Distance edge = new Distance(u, v);
        addDist(u, v, edge);
        addDist(v, u , edge);
    }

    private void addDist(Point u, Point v, Distance edge){
        ArrayList<Distance> dist = null;
        if (adj.get(u) == null){
            dist = new ArrayList<>();
        }else{
            dist = adj.get(u);
        }
        dist.add(edge);
        adj.put(u, dist);
    }
}

class Point implements Comparable<Point>{
    int x;
    int y;
    double key;

    Point(int x, int y){
        this.x = x;
        this.y = y;
        this.key = Double.MAX_VALUE;
    }

    public String toString(){
        return "X = " + this.x + " Y = " + this.y;

    }



    @Override
    public int compareTo(Point o) {
        if (this.key <  o.key){
            return -1;
        }
        if (this.key > o.key){
            return 1;
        }
        return 0;
    }

}

