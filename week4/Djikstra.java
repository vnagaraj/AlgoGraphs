package week4;

/**
 * Created by vnagarajan on 7/19/16.
 */
class Djikstra{
    private WeightedDirectedGraph graph;
    private boolean[] visited;
    private MinPQ<Vertex> minPQ;
    private int sourceVertex ;
    private int[] dist;
    private Vertex[] vertices;

    Djikstra(WeightedDirectedGraph graph, int sourceVertex){
        this.graph = graph;
        this.sourceVertex = sourceVertex;
        visited = new boolean[graph.getVertices() + 1];
        dist = new int[graph.getVertices() + 1];
        minPQ = new MinPQ<Vertex>(graph.getVertices());
        vertices = new Vertex[graph.getVertices() + 1];
        run();

    }

    public int dist(int destVertex){
        if (dist[destVertex] == Integer.MAX_VALUE){
            return -1;
        }
        return dist[destVertex];
    }

    private void run(){
        //initialize steps
        for (int i = 1; i <= graph.getVertices(); i++){
            Vertex vertex = new Vertex(i);
            vertices[i] = vertex;
            if (i == sourceVertex){
                vertex.setKey(0);
            }
            dist[i]= vertex.key;
            minPQ.insert(vertex);
        }
        while (!minPQ.isEmpty()){
            Vertex vertex = minPQ.deleteMin();
            visited[vertex.startVertex] = true; //belongs to set X
            if (vertex.key == Integer.MAX_VALUE){
                //graph not connected
                return;
            }
            dist[vertex.startVertex] = vertex.key;
            for (Edge edge: graph.adj[vertex.startVertex]){
                int endVertex = edge.endVertex;
                if (!visited[endVertex]){
                    //delete from heap
                    Vertex v = vertices[endVertex];
                    minPQ.deleteKey(v);
                    //recompute key
                    v.setKey(Math.min(v.key, dist[vertex.startVertex] + edge.weight));
                    //re-insert into heap
                    minPQ.insert(v);
                }
            }
        }


    }

    private class Vertex implements Comparable<Vertex> {
        int startVertex;
        int key;

        Vertex(int startVertex){
            this.startVertex = startVertex;
            key = Integer.MAX_VALUE;
        }

        void setKey(int key){
            this.key = key;
        }

        public String toString(){
            return "Vertex "+ startVertex + " Key " + key;
        }


        @Override
        public int compareTo(Vertex o) {
            if (this.key <  o.key){
                return -1;
            }
            if (this.key > o.key){
                return 1;
            }
            return 0;
        }
    }
}
