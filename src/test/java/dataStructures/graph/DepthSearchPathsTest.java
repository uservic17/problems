package dataStructures.graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class DepthSearchPathsTest {

  @Test
  public void pathToString() {
    MyGraph myGraph = new MyGraph(7);
    myGraph.addEdge(0, 5);
    myGraph.addEdge(2, 3);
    myGraph.addEdge(3, 4);
    myGraph.addEdge(0, 1);
    myGraph.addEdge(1, 2);
    myGraph.addEdge(2, 4);
    DepthSearchPaths dfs = new DepthSearchPaths(myGraph, 0);
    assertTrue(dfs.hasPath(4));
    assertEquals("0->1->2->4", dfs.pathToString(4));
    assertEquals("0->5", dfs.pathToString(5));
    assertEquals(null, dfs.pathToString(6));
  }

  /*
   *  %  java Graph tinyCG.txt
   *  6 8
   *  0: 2 1 5
   *  1: 0 2
   *  2: 0 1 3 4
   *  3: 5 4 2
   *  4: 3 2
   *  5: 3 0
   *
   *  % java DepthFirstPaths tinyCG.txt 0
   *  0 to 0:  0
   *  0 to 1:  0-2-1
   *  0 to 2:  0-2
   *  0 to 3:  0-2-3
   *  0 to 4:  0-2-3-4
   *  0 to 5:  0-2-3-5
   */
  @Test
  public void pathToStringTiny() {
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
    assertTrue(dfs.hasPath(5));
    assertEquals("0->2->4", dfs.pathToString(4));
  }
}