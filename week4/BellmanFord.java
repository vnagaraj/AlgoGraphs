package week4;

class BellmanFord{
    private BellmanWeightedDirectedGraph graph;
    private Integer[][] A;

    BellmanFord(BellmanWeightedDirectedGraph graph){
        this.graph = graph;
        //add virtual node to graph connecting to all other nodes
        for (int i = 0; i < graph.getVertices()-1; i++){
            graph.addEdge(graph.getVertices()-1, i, 0);
        }
    }

    public int checkCycle(){
        if (run()){
           return 1;
        }
        return 0;
    }

    private boolean run(){
        int sourceVertex = graph.getVertices()-1;
        A = new Integer[graph.getEdges()][graph.getVertices()];
        for(int vertex=0; vertex < graph.getVertices(); vertex++){
            if (vertex == sourceVertex){
                A[0][vertex] = 0;
            }else{
                A[0][vertex] = Integer.MAX_VALUE;
            }
        }
        int lastIteration = graph.getVertices(); //checking cycle
        boolean changed = false;
        for (int edge =1; edge <=graph.getVertices(); edge++) {
            for (int vertex = 0; vertex < graph.getVertices(); vertex++) {
                Integer prevValue = A[edge-1][vertex];
                A[edge][vertex] = Math.min(A[edge - 1][vertex], getMinFromInDegree(edge, vertex));
                if (!changed) {
                    if (prevValue == null){
                        changed = true;
                    }
                    else if (!prevValue .equals(A[edge][vertex])) {
                        changed = true;
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

    private int getMinFromInDegree(int edge, int vertex){
        int min = Integer.MAX_VALUE;
        for (Edge inDegree: this.graph.getInDegreeVertices(vertex)){
            int val = -1;
            if (A[edge-1][inDegree.startVertex] == Integer.MAX_VALUE){
                val = Integer.MAX_VALUE;
            }else{
                val = A[edge-1][inDegree.startVertex] + inDegree.weight;
            }
            if (min > val){
                min = val;
            }
        }
        return min;
    }
}