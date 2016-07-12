package week2;

public class CycleCheck {
    private DirectedGraph graph;
    private boolean[] visited;
    private int cc =0;

    CycleCheck(DirectedGraph graph){
        this.graph = graph;
    }

    int run(){
        for (int i=1; i < graph.getVertices()+1; i++){
            visited = new boolean[graph.getVertices()+1];
            if (!visited[i]) {
                int cycle = explore(i, i);
                if (cycle == 1){
                    return cycle;
                }
            }
        }
        return 0;
    }

    private int explore(int vertex, int startVertex){
        visited[vertex] = true;
        for (int neighbor : graph.adj[vertex]){
            if (neighbor == startVertex){
                //cycle present
                return 1;
            }
            if (!visited[neighbor]){
                int cycle = explore(neighbor, startVertex);
                if (cycle == 1){
                    return cycle;
                }
            }
        }
        return 0;
    }
}