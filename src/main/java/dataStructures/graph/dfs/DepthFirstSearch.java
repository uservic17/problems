package dataStructures.graph.dfs;

import dataStructures.graph.MyGraph;

import java.util.HashSet;
import java.util.Set;

/**
 *  The {@code DepthFirstSearch} class represents a data type for
 *  determining the vertices connected to a given source vertex <em>root</em>
 */
public class DepthFirstSearch {

  private MyGraph graph;
  private int root;
  private Set<Integer> connectedTo;
  private Set<Integer> visited;
  public DepthFirstSearch(MyGraph inputGraph, int root) {
    graph = new MyGraph(inputGraph);
    this.root = root;
    connectedTo = new HashSet<>();
    visited = new HashSet<>();
    visited.add(root);
    dfs(graph, root);
  }

  private void dfs(MyGraph graph, int root) {
    for (int node: graph.adjList(root)) {
      if (!visited.contains(node)) {
        visited.add(node);
        connectedTo.add(node);
        dfs(graph, node);
      }
    }
  }

  public boolean isConnectedToRoot(int v) {
    return connectedTo.contains(v);
  }

  /**
   * number of nodes connected to root (directly or indirectly)
   * @return
   */
  public int count() {
    return connectedTo.size();
  }
}
