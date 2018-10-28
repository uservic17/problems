package dataStructures.graph;

public class MyGraphDemo {
  public static void main(String[] args) {
    MyGraph myGraph = new MyGraph(3);


    myGraph.addEdge(0, 1);

    MyGraph myGraph1 = new MyGraph(myGraph);


    myGraph.addEdge(0,2);
    myGraph1.addEdge(1,2);
    System.out.println(myGraph);

    System.out.println(myGraph1);
  }
}
