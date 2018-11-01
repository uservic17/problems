package dataStructures.graph.bfs;

import dataStructures.graph.MyGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstPath {
  private Queue<Integer> queue = new ArrayDeque<>();
  private int[] paths;
  private int root;

  BreadthFirstPath(MyGraph graph, int root) {
    int vertices = graph.getVertices();
    paths = new int[vertices];
    validateVertex(root);
    intializaeArray(vertices);
    queue.add(root);
    this.root = root;
    bfs(graph);
  }

  private void intializaeArray(int v) {
    for (int i = 0; i < v; i++) {
      paths[i] = -1;  //-1 signifies it is not connected.
    }
  }

  private void bfs(MyGraph graph) {
    while (!queue.isEmpty()) {
      int element = queue.poll();
      for (int node : graph.adjList(element)) {
        if (paths[node] == -1) {
          paths[node] = element;
          queue.add(node);
        }
      }
    }
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

  public boolean hasPath(int v) {
    validateVertex(v);
    return paths[v] != -1;
  }

  private void validateVertex(int v) {
    int V = paths.length;
    if (v < 0 || v >= V) {
      throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }
  }
}
