package week4;

import java.util.ArrayList;

/**
 * WeightedDirectedGraph class - to store vertices and weighted edges to be used in Djikstra's algorithm
 *
 * @author Vivekanand Ganapathy Nagarajan
 * @version 2.0 July 28th, 2016
 */
class WeightedDirectedGraph{

    private int vertices; //no of vertices
    private int edges; //no of edges;
    ArrayList<Edge>[] adj = null; //adjList

    WeightedDirectedGraph(int vertices){
        this.vertices = vertices;
        adj = (ArrayList<Edge>[])new ArrayList[vertices+1];
        for (int i = 1; i < vertices+1; i++){
            adj[i] = new ArrayList<Edge>();
        }
    }

    /**
     * Get vertex count
     * @return count of vertices
     */
    public int getVertices(){
        return vertices;
    }

    /**
     * Add  weighted edge to graph
     * @param u vertex
     * @param v vertex
     * @param w weight of edge
     */
    public void addEdge(int u, int v, int w){
        validateVertex(u);
        validateVertex(v);
        Edge edge = new Edge(u, v, w);
        adj[u].add(edge);
        edges += 1;
    }

    /**
     * Validate vertex range
     * @param u vertex
     */
    private void validateVertex(int u){
        if (u < 1 || u >= adj.length ){
            throw new RuntimeException("Vertex index out of bounds");
        }

    }

}

