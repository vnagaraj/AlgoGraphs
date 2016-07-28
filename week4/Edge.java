package week4;

/**
 * Edge class - weighted edge representation
 *
 * @author Vivekanand Ganapathy Nagarajan
 * @version 2.0 July 28th, 2016
 */
class Edge {
    int startVertex;
    int endVertex;
    int weight;

    Edge(int startVertex, int endVertex, int weight){
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.weight = weight;
    }
}
