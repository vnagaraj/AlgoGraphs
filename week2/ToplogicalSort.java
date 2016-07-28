package week2;
/**
 * TopologicalSort class - compute the topological sort in directed acyclic graph
 *
 * @author Vivekanand Ganapathy Nagarajan
 * @version 2.0 July 28th, 2016
 */
class ToplogicalSort {
    private DirectedGraph graph;
    private boolean[] visited;
    private int[] startTime;
    private int timer =0;

    ToplogicalSort(DirectedGraph graph){
        this.graph = graph;
        visited = new boolean[graph.getVertices()+1];
        startTime = new int[graph.getVertices() + 1];
    }

    int[] run(){
        for (int i=1; i < graph.getVertices()+1; i++){
            if (!visited[i]) {
                explore(i);
            }
        }
        return startTime;
    }

    private void explore(int vertex){
        visited[vertex] = true;
        for (int neighbor : graph.adj[vertex]){
            if (!visited[neighbor]){
                explore(neighbor);
            }
        }
        startTime[++timer] =vertex;
    }
}