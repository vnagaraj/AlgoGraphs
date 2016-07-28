package week1;
/**
 * DFS class - compute the connectivity from the source vertex
 *
 * @author Vivekanand Ganapathy Nagarajan
 * @version 2.0 July 28th, 2016
 */
class DFS {
    private int startVertex;
    private int destVertex;
    private UndirectedGraph graph;
    private boolean[] visited;

    DFS(int startVertex, int destVertex, UndirectedGraph graph){
        this.startVertex = startVertex;
        this.destVertex = destVertex;
        this.graph = graph;
        visited = new boolean[graph.getVertices()+1];
    }

    public int run(){
        explore(startVertex);
        if (visited[destVertex]){
            return 1;
        }
        return 0;
    }

    private void explore(int vertex){
        visited[vertex] = true;
        for (int neighbor : graph.adj(vertex)){
            if (!visited[neighbor]){
                explore(neighbor);
            }
        }
    }
}