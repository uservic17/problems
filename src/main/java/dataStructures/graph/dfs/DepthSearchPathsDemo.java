package dataStructures.graph.dfs;

import dataStructures.graph.MyGraph;

public class DepthSearchPathsDemo {
  public static void main(String[] args) {
//    MyGraph myGraph = new MyGraph(7);
//    myGraph.addEdge(0, 5);
//    myGraph.addEdge(2, 3);
//    myGraph.addEdge(3, 4);
//    myGraph.addEdge(0, 1);
//    myGraph.addEdge(1, 2);
//    myGraph.addEdge(2, 4);
//    DepthSearchPaths dfs = new DepthSearchPaths(myGraph, 0);
//    System.out.println(dfs.hasPath(4));
//    System.out.println(dfs.pathToString(4));
//    System.out.println(dfs.pathToString(5));
//    System.out.println(dfs.pathToString(6));

    MyGraph myGraph = new MyGraph(6);
    myGraph.addEdge(0, 2);
    myGraph.addEdge(0, 1);
    myGraph.addEdge(0, 5);
    myGraph.addEdge(1, 2);
    myGraph.addEdge(2, 3);
    myGraph.addEdge(2, 4);
    myGraph.addEdge(3, 5);
    myGraph.addEdge(3, 4);
    DepthSearchPaths dfs = new DepthSearchPaths(myGraph, 0);
        System.out.println(dfs.pathTo(4));


  }
}
