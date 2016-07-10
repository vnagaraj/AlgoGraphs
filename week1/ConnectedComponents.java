package week1;

class ConnectedComponents {
    private UndirectedGraph graph;
    private boolean[] visited;
    private int cc =0;

    ConnectedComponents(UndirectedGraph graph){
        this.graph = graph;
        visited = new boolean[graph.getVertices()+1];
    }

    int run(){
        for (int i=1; i < graph.getVertices()+1; i++){
            if (!visited[i]) {
                cc++;
                explore(i);
            }
        }
        return cc;
    }

    private void explore(int vertex){
        visited[vertex] = true;
        for (int neighbor : graph.adj[vertex]){
            if (!visited[neighbor]){
                explore(neighbor);
            }
        }
    }
}