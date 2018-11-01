package dataStructures.graph.dfs;

import dataStructures.graph.MyGraph;

/**
 *  The {@code DepthFirstSearch} class represents a data type for
 *  determining the vertices connected to a given source vertex <em>s</em>
 *  in an undirected graph. For versions that find the paths, see
 *  <p>
 *  This implementation uses depth-first search.
 *  The constructor takes time proportional to <em>V</em> + <em>E</em>
 *  (in the worst case),
 *  where <em>V</em> is the number of vertices and <em>E</em> is the number of edges.
 *  It uses extra space (not including the graph) proportional to <em>V</em>.
 *  <p>
 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/41graph">Section 4.1</a>
 *  of <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 */
public class BetterDepthFirstSearch {

  private boolean[] marked;
  private int count = 0;
  BetterDepthFirstSearch(MyGraph graph, int root) {
    marked = new boolean[graph.getVertices()];
    marked[root] = true;
    validateVertex(root);
    dfs(graph, root);
  }

  private void dfs(MyGraph graph, int root) {
    for (int node: graph.adjList(root)) {
      if (!marked[node]) {
        marked[node] = true;
        count++;
        dfs(graph, node);
      }
    }
  }

  public boolean isConnectedToRoot(int v) {
    validateVertex(v);
    return marked[v];
  }

  /**
   * number of nodes connected to root (directly or indirectly)
   * @return
   */
  public int count() {
    return count;
  }


  private void validateVertex(int v) {
    int V = marked.length;
    if (v < 0 || v >= V) throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
  }
}
