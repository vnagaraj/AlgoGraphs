package week3;

import week1.UndirectedGraph;

class BFS {

    private int startVertex;
    private UndirectedGraph graph;
    private Integer[] dist;
    private boolean[] visited;
    public boolean isBipartite = true;


    BFS(int startVertex, UndirectedGraph graph) {
        this.startVertex = startVertex;
        this.graph = graph;
        this.dist = new Integer[graph.getVertices() + 1];
        this.visited = new boolean[graph.getVertices() + 1];
    }

    public void run() {
        dist[startVertex] = 0;
        visited[startVertex] = true;
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(startVertex);
        while (!queue.isEmpty()) {
            int vertex = queue.dequeue();
            for (int neighbor : graph.adj(vertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.enqueue(neighbor);
                    dist[neighbor] = dist[vertex] + 1;
                }else{
                    //vertex has been visited, so edges between vertices in same layer
                    //not bipartite
                    if (dist[neighbor] == dist[vertex]) {
                        isBipartite = false;
                    }
                }
            }
        }
    }

    int distTo(int destVertex) {
        run();
        Integer val = dist[destVertex];
        if (val == null) {
            return -1;
        }
        return val;
    }
}