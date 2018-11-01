package dataStructures.graph.dfs;

import dataStructures.graph.MyGraph;

public class DFSDemo {
  public static void main(String[] args) {
    MyGraph myGraph = new MyGraph(5);
    myGraph.addEdge(0, 1);
    myGraph.addEdge(1, 2);
    DepthFirstSearch dfs = new DepthFirstSearch(myGraph, 0);
    System.out.println(dfs.count());
    System.out.println("Is connected? " + dfs.isConnectedToRoot(3));
  }
}
