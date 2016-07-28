package week5;
import java.util.HashMap;

/**
 * UnionFind class - data structure based on union by size(smaller comp links to bigger comp) to speed up Clustering Algorithm
 *
 * @author Vivekanand Ganapathy Nagarajan
 * @version 1.0 July 28th, 2016
 */
class UnionFind {
    HashMap<Point, Integer> map; //keep track of mapping from point to value in id array;
    private int[] id;
    private int[] size; // keep track of size of each component for union by size
    private int counter = 0;
    private int cc = 0; //no of components

    UnionFind(int n) {
        id = new int[n];
        size = new int[n];
        map = new HashMap<Point, Integer>();
        //initialize id array , each object points to its own component
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
            size[i] = 1;
        }
        cc = n;
    }

    void addPoint(Point p){
        if (!map.containsKey(p)){
            map.put(p, counter++);
        }
    }

    /**
     * Find root of the component
     * @param index
     * @return
     */
    private int root(int index) {
        while (index != id[index]) {
            index = id[index];
        }
        return index;
    }

    /**
     * Return if points are connected
     * @param p Point
     * @param q Point
     * @return true if connected
     */
    boolean find(Point p, Point q) {
        int pIndex = map.get(p);
        int qIndex = map.get(q);
        return root(pIndex) == root(qIndex);
    }

    /**
     * Merge components containing point P with point Q
     * @param p Point
     * @param q Point
     */
    void union(Point p, Point q) {
        int pIndex = map.get(p);
        int qIndex = map.get(q);
        int rootP = root(pIndex);
        int rootQ = root(qIndex);
        if (rootP == rootQ) {
            return;
        }
        int size_p_index = size[rootP];
        int size_q_index = size[rootQ];
        if (size_p_index < size_q_index) {
            id[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            id[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        cc --;
    }

    /**
     * Return the no of connected components
     * @return
     */
    public int getCc(){
        return cc;
    }

}