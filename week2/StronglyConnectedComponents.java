package week2;
import java.util.ArrayList;
/**
 * StronglyConnectedComponents class - compute the strongly connected components
 *
 * @author Vivekanand Ganapathy Nagarajan
 * @version 2.0 July 28th, 2016
 */
class StronglyConnectedComponents{

    private DirectedGraph graph;
    private boolean[] visited;
    private int scc = 0;

    StronglyConnectedComponents(DirectedGraph graph){
        this.graph = graph;
        visited = new boolean[graph.getVertices()+1];
    }

    int run(){
        DirectedGraph reverseGraph = reverseGraph(graph);
        //run DFS on reverseGraph
        int[] postorder = new ToplogicalSort(reverseGraph).run();
        // run DFS in original graph in reverse postorder
        for (int i = postorder.length-1; i >=1; i--){
            int vertex = postorder[i];
            if (!visited[vertex]){
                explore(vertex);
                scc ++;
            }
        }
        return scc;
    }

    private void explore(int vertex){
        visited[vertex] = true;
        for (int neighbor : graph.adj[vertex]){
            if (!visited[neighbor]){
                explore(neighbor);
            }
        }
    }

    private static DirectedGraph reverseGraph(DirectedGraph g){
        DirectedGraph reverseGraph = new DirectedGraph(g.getVertices());
        for (int i= 1; i < reverseGraph.getVertices() + 1; i++){
            ArrayList<Integer> edges = g.adj[i];
            for (Integer edge: edges){
                reverseGraph.addEdge(edge, i);
            }
        }
        return  reverseGraph;
    }
}