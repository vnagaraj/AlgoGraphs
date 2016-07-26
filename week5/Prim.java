package week5;

import week4.MinPQ;
import java.util.HashMap;


class Prim {
    private PointDistanceGraph graph;
    private HashMap<Point, Boolean> visited;
    private MinPQ<Point> minPQ;
    private double dist;

    Prim(PointDistanceGraph graph) {
        this.graph = graph;
        visited = new HashMap<Point, Boolean>();
        minPQ = new MinPQ<Point>(graph.getPoints());
        run();

    }

    public double dist(){
        return dist;
    }


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
            dist  += point.key;
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