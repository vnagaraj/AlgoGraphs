package week5;

import week4.MinPQ;
import java.util.HashMap;
/**
 * Prims class - implement the Prim's  algorithm(using heaps) to compute mim length of segment between points (Minimum Spanning Tree)
 *
 * @author Vivekanand Ganapathy Nagarajan
 * @version 2.0 July 28th, 2016
 */

class Prims {
    private PointDistanceGraph graph;
    private HashMap<Point, Boolean> visited;
    private MinPQ<Point> minPQ;
    private double minDist; //min spanning tree distance

    /**
     * Prims constructor
     * @param graph PointDistanceGraph
     */
    Prims(PointDistanceGraph graph) {
        this.graph = graph;
        visited = new HashMap<Point, Boolean>();
        minPQ = new MinPQ<Point>(graph.getPoints());
        run();

    }

    /**
     * Get the min spanning distance
     * @return min distance
     */
    double dist(){
        return minDist;
    }

    /**
     * Run Prim's algorithm picking first Point as the source
     */
    private void run() {
        //initialize steps
        if (graph.getPoints() == 1){
            return;
        }
        Point sourcePoint = graph.points[0];
        sourcePoint.key = 0;
        for (int i = 0; i < graph.getPoints(); i++) {
            Point point = graph.points[i];
            minPQ.insert(point);
            visited.put(point, false);
        }
        while (!minPQ.isEmpty()) {
            Point point = minPQ.deleteMin();
            visited.put(point, true); //belongs to set X
            if (point.key == Integer.MAX_VALUE) {
                //graph not connected
                return;
            }
            minDist += point.key;
            for (Distance edge : graph.adj.get(point)) {
                Point otherPoint = edge.endPoint;
                if (point == otherPoint){
                    otherPoint = edge.startPoint;
                }
                if (!visited.get(otherPoint)) {
                    //delete from heap
                    minPQ.deleteKey(otherPoint);
                    //recompute key
                    if (otherPoint.key > edge.distance){
                        otherPoint.key = edge.distance;
                    }
                    //re-insert into heap
                    minPQ.insert(otherPoint);
                }
            }
        }


    }
}