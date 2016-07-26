package week4;

import week3.Queue;
import java.util.ArrayList;

class BellmanFord{
    private BellmanWeightedDirectedGraph graph;
    private Long[] A;
    private Integer sourceVertex = null;
    ArrayList<Integer> cycleVertices = null;


    BellmanFord(BellmanWeightedDirectedGraph graph, Integer sourceVertex){
        this.graph = graph;
        this.sourceVertex = sourceVertex;
        cycleVertices = new ArrayList<>();
        boolean cycle = isCycle();
        if (cycle){
            boolean[] visited  = new boolean[graph.getVertices()];
            //to compute vertices in neg cycle using BFS subroutine
            for (int vertex: cycleVertices) {
                if (!visited[vertex]) {
                    bfs(vertex, visited);
                }
            }
        }
    }

    private void bfs(Integer startVertex, boolean[] visited) {
        visited[startVertex] = true;
        A[startVertex] = Long.MIN_VALUE;
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(startVertex);
        while (!queue.isEmpty()) {
            int vertex = queue.dequeue();
            for (Edge edge : graph.adj[vertex]) {
                int neighbor = edge.endVertex;
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    A[neighbor] = Long.MIN_VALUE;
                    queue.enqueue(neighbor);
                }
            }
        }
    }

    private void explore(int vertex, boolean[] visited){
        visited[vertex] = true;
        //to indicate part of negative cycle
        A[vertex] = Long.MIN_VALUE;

        for (Edge edge : graph.adj[vertex]){
            int neighbor = edge.endVertex;
            if (!visited[neighbor]){
                explore(neighbor, visited);
            }
        }
    }


    public String dist(int vertex){
        long val = A[vertex];
        if (val == Long.MAX_VALUE){
            //no path from source vertex
            return "*";
        }
        if (val == Long.MIN_VALUE){
            //vertex part of negative cycle
            return "-";
        }
        return String.valueOf(val);
    }

    private boolean isCycle(){
        A = new Long[graph.getVertices()];
        for(int vertex=0; vertex < graph.getVertices(); vertex++){
            if (vertex == sourceVertex){
                A[vertex] = 0L;
            }else{
                A[vertex] = Long.MAX_VALUE;
            }
        }
        int lastIteration = graph.getVertices(); //checking cycle
        boolean changed = false;
        for (int edge =1; edge <=graph.getVertices(); edge++) {
            for (int vertex = 0; vertex < graph.getVertices(); vertex++) {
                Long prevValue = A[vertex];
                A[vertex] = Math.min(A[vertex], getMinFromInDegree(edge, vertex));
                if (!changed) {
                    if (prevValue == null){
                        changed = true;
                        if (edge == lastIteration) {
                            cycleVertices.add(vertex);
                        }
                    }
                    else if (!prevValue .equals(A[vertex])) {
                        changed = true;
                        if (edge == lastIteration) {
                            cycleVertices.add(vertex);
                        }
                    }
                }
            }
            if (!changed && edge == lastIteration) {
                //no change in last iteration , so no negative cycle
                return false;
            } else if (changed && edge == lastIteration) {
                //change in last iteration , so negative cycle
                return true;
            }
            else if (!changed){
                //in earlier iteration, no change
                return false;
            }
            //reset for next iteration
            changed = false;
        }
        return false;
    }

    private long getMinFromInDegree(int edge, int vertex){
        long min = Long.MAX_VALUE;
        for (Edge inDegree: this.graph.getInDegreeVertices(vertex)){
            long val = -1;
            if (A[inDegree.startVertex] == Long.MAX_VALUE){
                val = Long.MAX_VALUE;
            }else{
                val = A[inDegree.startVertex] + inDegree.weight;
            }
            if (min > val){
                min = val;
            }
        }
        return min;
    }
}