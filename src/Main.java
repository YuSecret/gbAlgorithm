public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(11);

        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,6);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        graph.addEdge(4,8);
        graph.addEdge(5,7);
        graph.addEdge(7,6);
        graph.addEdge(7,8);
        graph.addEdge(8,10);
        graph.addEdge(7,10);
        graph.addEdge(7,9);

        System.out.println(graph.getAdjList(7));
        System.out.println(graph.getEdgeCount());

        BreadthFirstPath bfp = new BreadthFirstPath(graph, 1);
        System.out.println(bfp.hasPathTo(10));

        System.out.println(bfp.pathTo(10));
    }
}
