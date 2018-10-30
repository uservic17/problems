package dataStructures.graph;

import java.util.ArrayList;
import java.util.List;

public class MyGraph {
  private static final String NEWLINE = System.getProperty("line.separator");
  private int V;
  private int E;
  private List<Integer>[] adjList;

  MyGraph(int v) {
    if (v < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
    V = v;
    E = 0;
    adjList = (ArrayList<Integer>[]) new ArrayList[V];
    for (int i = 0; i < v; i++) {
      adjList[i] = new ArrayList<>();
    }
  }

  /**
   * Creates a deep copy of given Graph G
   * @param G
   */
  MyGraph(MyGraph G) {
    this(G.V);
    this.E = G.E;
    for (int i = 0; i < G.V; i++) {
      this.adjList[i].addAll(G.adjList[i]);
    }
  }

  //todo equals method
  //todo comparator

  public int getVertices() {
    return V;
  }

  public int getEdges() {
    return E;
  }

  /**
   * find the number of nodes connected to v directly
   * @param v
   * @return
   */
  public int degree(int v) {
    validateVertex(v);
    return adjList[v].size();
  }

  public Iterable<Integer> adjList(int v) {
    validateVertex(v);
    return adjList[v];
  }

  public void addEdge(int nodeA, int nodeB) {
    validateVertex(nodeA);
    validateVertex(nodeB);
    adjList[nodeA].add(nodeB);
    adjList[nodeB].add(nodeA);
    E++;
  }

  private void validateVertex(int v) {
    if (v < 0 || v >= V)
      throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));

  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Graph: ").append(V).append(" vertices ").append(E).append(" edges").append(NEWLINE);
    sb.append("Node: ").append("Connected to").append(NEWLINE);
    int i = 0;
    for (List<Integer> list : adjList) {
      sb.append(i++).append(": ");
      sb.append(list).append(NEWLINE);
    }

    return sb.toString();
  }
}
