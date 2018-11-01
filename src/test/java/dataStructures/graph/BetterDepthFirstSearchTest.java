package dataStructures.graph;

import dataStructures.graph.dfs.BetterDepthFirstSearch;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BetterDepthFirstSearchTest {

  @Test
  public void count() {
    MyGraph myGraph = new MyGraph(3);
    myGraph.addEdge(0, 1);
    myGraph.addEdge(0, 2);
    BetterDepthFirstSearch dfs = new BetterDepthFirstSearch(myGraph, 0);
    assertEquals(2, dfs.count());
  }

  /**
   * indirectly connected to 2
   */
  @Test
  public void count2() {
    MyGraph myGraph = new MyGraph(5);
    myGraph.addEdge(0, 1);
    myGraph.addEdge(1, 2);
    BetterDepthFirstSearch dfs = new BetterDepthFirstSearch(myGraph, 0);
    assertEquals(2, dfs.count());
  }

  @Test
  public void count3() {
    MyGraph myGraph = new MyGraph(5);
    myGraph.addEdge(0, 1);
    myGraph.addEdge(0, 2);
    myGraph.addEdge(3, 4);
    BetterDepthFirstSearch dfs = new BetterDepthFirstSearch(myGraph, 0);
    assertEquals(2, dfs.count());
  }

  @Test
  public void count4() {
    MyGraph myGraph = new MyGraph(6);
    myGraph.addEdge(0, 1);
    myGraph.addEdge(0, 2);
    myGraph.addEdge(1, 2);
    BetterDepthFirstSearch dfs = new BetterDepthFirstSearch(myGraph, 5);
    assertEquals(0, dfs.count());
  }

  @Test
  public void count5() {
    MyGraph myGraph = new MyGraph(6);
    myGraph.addEdge(0, 1);
    myGraph.addEdge(1, 2);
    myGraph.addEdge(2, 3);
    myGraph.addEdge(3, 4);
    myGraph.addEdge(4, 5);
    BetterDepthFirstSearch dfs = new BetterDepthFirstSearch(myGraph, 0);
    assertEquals(5, dfs.count());
  }

  @Test
  public void isConnectedToRoot1() {
    MyGraph myGraph = new MyGraph(3);
    myGraph.addEdge(0, 1);
    myGraph.addEdge(0, 2);
    BetterDepthFirstSearch dfs = new BetterDepthFirstSearch(myGraph, 0);
    assertTrue(dfs.isConnectedToRoot(1));
    assertTrue(dfs.isConnectedToRoot(2));
  }

  @Test
  public void isConnectedToRoot2() {
    MyGraph myGraph = new MyGraph(3);
    myGraph.addEdge(0, 1);
    BetterDepthFirstSearch dfs = new BetterDepthFirstSearch(myGraph, 0);
    assertTrue(dfs.isConnectedToRoot(1));
    assertFalse(dfs.isConnectedToRoot(2));
  }

  @Test
  public void isConnectedToRoot3() {
    MyGraph myGraph = new MyGraph(6);
    myGraph.addEdge(0, 1);
    myGraph.addEdge(0, 2);
    myGraph.addEdge(1, 2);
    BetterDepthFirstSearch dfs = new BetterDepthFirstSearch(myGraph, 5);
    assertFalse(dfs.isConnectedToRoot(0));
  }
  @Test
  public void isConnectedToRoot4() {
    MyGraph myGraph = new MyGraph(6);
    myGraph.addEdge(0, 1);
    myGraph.addEdge(1, 2);
    myGraph.addEdge(2, 3);
    myGraph.addEdge(3, 4);
    myGraph.addEdge(4, 5);
    BetterDepthFirstSearch dfs = new BetterDepthFirstSearch(myGraph, 0);
    assertTrue(dfs.isConnectedToRoot(4));
    assertTrue(dfs.isConnectedToRoot(5));
  }
}