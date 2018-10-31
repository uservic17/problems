package dataStructures.graph;

public class DepthSearchPaths {
  int[] paths;
  DepthSearchPaths(MyGraph graph, int v) {
    int V = graph.getVertices();
    paths = new int[V];
    validateVertex(v);
    for (int i = 0; i < V; i++ ) {
      paths[i] = -1;  //-1 signifies it is not connected.
    }
    dfsPath(graph, v);
  }

  private void dfsPath(MyGraph graph, int v) {

    for (int node : graph.adjList(v)) {
      paths[node] = v;
      dfsPath(graph, node);
    }
  }



  private void validateVertex(int v) {
    int V = paths.length;
    if (v < 0 || v >= V) throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));

  }
}
