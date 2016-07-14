package week1;

import java.util.ArrayList;

public class UndirectedGraph{

    private int vertices; //no of vertices
    private int edges; //no of edges;
    private ArrayList<Integer>[] adj = null; //adjList

    public UndirectedGraph(int vertices){
        this.vertices = vertices;
        adj = (ArrayList<Integer>[])new ArrayList[vertices+1];
        for (int i = 1; i < vertices+1; i++){
            adj[i] = new ArrayList<Integer>();
        }
    }

    public int getVertices(){
        return vertices;
    }

    public void addEdge(int u, int v){
        validateVertex(u);
        validateVertex(v);
        adj[u].add(v);
        adj[v].add(u);
        edges +=1;
    }

    private void validateVertex(int u){
        if (u < 1 || u >= adj.length ){
            throw new RuntimeException("Vertex index out of bounds");
        }

    }

    public ArrayList<Integer> adj(int vertex){
        return adj[vertex];
    }

}