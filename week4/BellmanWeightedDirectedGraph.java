package week4;

import java.util.ArrayList;
/**
 * BellmanFordWeightedDirectedGraph class - graph used by BellmanFord's algorithm
 *
 * @author Vivekanand Ganapathy Nagarajan
 * @version 2.0 July 28th, 2016
 */
class BellmanWeightedDirectedGraph{

    private int vertices; //no of vertices
    private int edges; //no of edges;
    ArrayList<Edge>[] adj = null; //adjList
    private ArrayList<Edge>[] inDeg = null; //adjList

    BellmanWeightedDirectedGraph(int vertices){
        this.vertices = vertices;
        adj = (ArrayList<Edge>[])new ArrayList[vertices+1];
        inDeg = (ArrayList<Edge>[])new ArrayList[vertices+1];
        for (int i = 0; i < vertices; i++){
            adj[i] = new ArrayList<Edge>();
            inDeg[i] = new ArrayList<Edge>();

        }
    }

    ArrayList<Edge> getInDegreeVertices(int vertex){
        return inDeg[vertex];
    }

    public int getVertices(){
        return vertices;
    }

    public int getEdges(){
        return edges;
    }

    public void addEdge(int u, int v, int w){
        Edge edge = new Edge(u, v, w);
        adj[u].add(edge);
        inDeg[v].add(edge);
        edges += 1;
    }

}