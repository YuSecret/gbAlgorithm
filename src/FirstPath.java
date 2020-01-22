import java.util.LinkedList;

public class FirstPath {
    boolean[] marked;
    int[] edgeTo;
    int source;

    public FirstPath(Graph g, int source) {
        this.source = source;
        this.marked = new boolean[g.getVertexCount()];
        this.edgeTo = new int[g.getVertexCount()];
    }

    public boolean hasPathTo(int dist) {
        return marked[dist];
    }

    public LinkedList<Integer> pathTo(int dist) {
        if (!hasPathTo(dist)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = dist;
        while (vertex != source){
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }
}
