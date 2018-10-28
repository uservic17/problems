package dataStructures.graph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyGraphTest {

  @Test
  public void getVerticesEdges() {
    MyGraph myGraph = new MyGraph(3);
    assertEquals(3, myGraph.getVertices());
    myGraph.addEdge(0, 1);
    assertEquals(1, myGraph.getEdges());
    myGraph.addEdge(0, 2);
    assertEquals(2, myGraph.getEdges());
    assertEquals(2, myGraph.degree(0));
    assertEquals(1, myGraph.degree(1));
    assertEquals(1, myGraph.degree(2));
  }

  @Test
  public void toStringTest1() {
    MyGraph myGraph = new MyGraph(1);
    assertEquals("Graph: 1 vertices 0 edges\n" +
            "Node: Connected to\n" +
            "0: []\n", myGraph.toString());
  }

  @Test
  public void toStringTest2() {
    MyGraph myGraph = new MyGraph(2);

    assertEquals("Graph: 2 vertices 0 edges\n" +
            "Node: Connected to\n" +
            "0: []\n" +
            "1: []\n", myGraph.toString());
  }

  @Test
  public void toStringTest3() {
    MyGraph myGraph = new MyGraph(2);
    myGraph.addEdge(0, 1);
    assertEquals("Graph: 2 vertices 1 edges\n" +
            "Node: Connected to\n" +
            "0: [1]\n" +
            "1: [0]\n", myGraph.toString());
  }

  @Test
  public void toStringTest4() {
    MyGraph myGraph = new MyGraph(3);
    myGraph.addEdge(0, 1);
    myGraph.addEdge(0, 2);
    assertEquals("Graph: 3 vertices 2 edges\n" +
            "Node: Connected to\n" +
            "0: [1, 2]\n" +
            "1: [0]\n" +
            "2: [0]\n", myGraph.toString());
  }

  @Test
  public void adjList1() {
    MyGraph myGraph = new MyGraph(3);
    myGraph.addEdge(0, 1);
    myGraph.addEdge(0, 2);
    assertEquals("[1, 2]", myGraph.adjList(0).toString());
    assertEquals("[0]", myGraph.adjList(2).toString());
  }

  @Test
  public void deepClone() {
    MyGraph myGraph = new MyGraph(3);
    myGraph.addEdge(0, 1);

    MyGraph myGraph1 = new MyGraph(myGraph);
    myGraph.addEdge(0,2);
    myGraph1.addEdge(1,2);

    assertEquals("Graph: 3 vertices 2 edges\n" +
            "Node: Connected to\n" +
            "0: [1, 2]\n" +
            "1: [0]\n" +
            "2: [0]\n", myGraph.toString());
    assertEquals("Graph: 3 vertices 2 edges\n" +
            "Node: Connected to\n" +
            "0: [1]\n" +
            "1: [0, 2]\n" +
            "2: [1]\n", myGraph1.toString());
  }
}