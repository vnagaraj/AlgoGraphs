package week4;

import java.util.ArrayList;

/**
 * Created by vnagarajan on 7/19/16.
 */
public class WeightedDirectedGraph{

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

    public int getVertices(){
        return vertices;
    }

    public void addEdge(int u, int v, int w){
        validateVertex(u);
        validateVertex(v);
        Edge edge = new Edge(u, v, w);
        adj[u].add(edge);
        edges += 1;
    }

    private void validateVertex(int u){
        if (u < 1 || u >= adj.length ){
            throw new RuntimeException("Vertex index out of bounds");
        }

    }

}
class Edge{
    int startVertex;
    int endVertex;
    int weight;

    Edge(int startVertex, int endVertex, int weight){
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.weight = weight;
    }
}
