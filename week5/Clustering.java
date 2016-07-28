package week5;
import java.util.Arrays;

/**
 * Clustering class - implement the clustering algorithm based on Kruskal's MST using UnionFind DS
 *
 * @author Vivekanand Ganapathy Nagarajan
 * @version 1.0 July 28th, 2016
 */

class Clustering{
    private Distance[] distances; //distanced between points
    private UnionFind uf; //union find ds for fusing components and checking connections between components
    private double d = 0; // final output d, minDist spacing among different components

    /**
     * Clustering constructor
     * @param points Points in space
     * @param components no of distinct components
     */
    Clustering(Point[] points, int components){
        buildStruct(points);
        run(components);
    }

    /**
     * Get min distance spacing among different components
     * @return
     */
    public double minDist(){
        return d;
    }

    /**
     * Update UF and Distances
     * @param points
     */
    private void buildStruct(Point[] points){
        createUnionFind(points);
        createDistances(points);
    }

    /**
     * Create UnionFind from a list of Points
     * @param points
     */
    private void createUnionFind(Point[] points){
        uf = new UnionFind(points.length);
        for (Point point: points) {
            uf.addPoint(point);
        }
    }

    /**
     * Create Distances from a list of Points
     * @param points
     */
    private void createDistances(Point[] points){
        int n = points.length;
        //distances array is a complete comprising of a minDist between each pair of points
        distances = new Distance[(n*(n-1))/2];
        int counter = 0;
        for (int p = 0; p < n; p++){
            for (int p2 = p+1; p2 < n; p2++){
                Point firstPoint = points[p];
                Point secondPoint = points[p2];
                Distance d = new Distance(firstPoint, secondPoint);
                distances[counter++] = d;
            }
        }
    }


    /**
     * Run clustering algorithm until k
     * @param k no of components
     */
    private void run(int k){
        //sort the distances
        Arrays.sort(distances);
        //exiting kruskal's algo when uf has k components
        int index = getKcomponents(k);
        //process distances to compute d;
        this.d = getMinDistance(index);

    }

    /**
     *  Run the clustering until no of components == k
     * @param k no of components
     * @return point distance index in distances
     */
    private int getKcomponents(int k){
        int i =0;
        while (uf.getCc() != k){
            Distance distance = distances[i++];
            Point p = distance.startPoint;
            Point q = distance.endPoint;
            //consider components that are not connected to prevent cycle
            if (!uf.find(p, q)){ //cycle check
                //fuse non connected components
                uf.union(p, q);
            }
        }
        return i;
    }

    /**
     *  Get minDistance spacing
     * @param index of the Distances array
     * @return min distance spacing
     */
    private double getMinDistance(int index){
        double d = 0;
        while (index < distances.length){
            Distance distance = distances[index++];
            Point p = distance.startPoint;
            Point q = distance.endPoint;
            if (!uf.find(p, q)){ //already part of same component
                //different components found at index i but i already incremented
                d = distances[index-1].distance;
                break;
            }
        }
        return d;
    }
}