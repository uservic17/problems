package dataStructures.graph.bfs;

import dataStructures.graph.MyGraph;

public class BFSPathDemo {
  public static void main(String[] args) {
    MyGraph myGraph = new MyGraph(6);
    myGraph.addEdge(0, 2);
    myGraph.addEdge(0, 1);
    myGraph.addEdge(0, 5);
    myGraph.addEdge(1, 2);
    myGraph.addEdge(2, 3);
    myGraph.addEdge(2, 4);
    myGraph.addEdge(3, 5);
    myGraph.addEdge(3, 4);
    BreadthFirstPath dfs = new BreadthFirstPath(myGraph, 0);
    System.out.println(dfs.pathTo(4));


  }
}
