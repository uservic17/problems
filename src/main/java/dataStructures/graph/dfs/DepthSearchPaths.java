package dataStructures.graph.dfs;

import dataStructures.graph.MyGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class DepthSearchPaths {
  private int[] paths;
  private int root;

  public DepthSearchPaths(MyGraph graph, int v) {
    int V = graph.getVertices();
    paths = new int[V];
    validateVertex(v);
    intializaeArray(V);
    paths[v] = v;
    root = v;
    dfsPath(graph, v);
  }

  private void intializaeArray(int v) {
    for (int i = 0; i < v; i++) {
      paths[i] = -1;  //-1 signifies it is not connected.
    }
  }

  private void dfsPath(MyGraph graph, int v) {
    for (int node : graph.adjList(v)) {
      //this still does not find the shortest path..optimizes a little but the second test fails. BFS will take care of it
//      if (paths[node] == -1 || (paths[node] != v && node > v)) {
      if (paths[node] == -1) {
        paths[node] = v;
        dfsPath(graph, node);
      }
    }
  }

  public boolean hasPath(int v) {
    return paths[v] != -1;
  }

  public Iterable<Integer> pathTo(int v) {
    if (!hasPath(v)) {
      return null;
    }
    Stack<Integer> stack = new Stack<>();
    List<Integer> list = new ArrayList<>();
    int value = v;
    while (value != root) {
      stack.push(paths[value]);
      value = paths[value];
    }
    while (!stack.isEmpty()) {

      Integer poped = stack.pop();
      list.add(poped);
    }
    list.add(v);
    return list;
  }

  public String pathToString(int v) {
    Iterable<Integer> integers = pathTo(v);
    if (integers == null) {
      return null;
    }
    return StreamSupport.stream(integers.spliterator(), false).map(String::valueOf).collect(Collectors.joining("->"));
  }

  private void validateVertex(int v) {
    int V = paths.length;
    if (v < 0 || v >= V) {
      throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }

  }
}
