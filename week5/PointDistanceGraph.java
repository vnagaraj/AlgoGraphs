package week5;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * PointDistanceGraph class - complete graph with vertices as points and  edges as distances between points
 * Adj representation of the graph
 * Used in Prim's algorithm
 *
 * @author Vivekanand Ganapathy Nagarajan
 * @version 2.0 July 28th, 2016
 */
class PointDistanceGraph{
    HashMap<Point, ArrayList<Distance>> adj = null; //keeping track of the list of out going distances  for each point
    Point[] points;
    private int pointCounter = 0;

    PointDistanceGraph(int vertices){
        this.points = new Point[vertices];
        adj = new HashMap<Point, ArrayList<Distance>>();
    }

    /**
     * Add point to graph
     * @param p Point
     */
    void addPoint(Point p){
        points[pointCounter++] = p;
    }

    /**
     * Get no of points in graph
     * @return no of points
     */
    int getPoints(){
        return pointCounter;
    }

    /**
     * Adding distance edge in both directions since graph is undirected
     * @param p Point
     * @param q Point
     */
    void addDistance(Point p, Point q){
        Distance edge = new Distance(p, q);
        addDist(p, q, edge);
        addDist(q, p , edge);
    }

    /**
     * Add distance edge between pair of points
     * @param p point
     * @param q point
     * @param distance eucledian distance between pair of points
     */
    private void addDist(Point p, Point q, Distance distance){
        ArrayList<Distance> dist = null;
        if (adj.get(p) == null){
            dist = new ArrayList<>();
        }else{
            dist = adj.get(p);
        }
        dist.add(distance);
        adj.put(p, dist);
    }
}