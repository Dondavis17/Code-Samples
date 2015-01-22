package sjsu.cs146.graph;

//import java.util.ArrayList;
import java.util.*;

import junit.framework.TestCase;

public class GraphTest extends TestCase
{
    ArrayList<String> input;
    Graph graph;
   
    protected void setUp() throws Exception
    {
   super.setUp();
   input = new ArrayList<String>();
   input.add("4 5");
   input.add("0 3 3 -3");
   input.add("");
   input.add("1 2 4 0");
   input.add("0 5 1 0 4 9 2 -8");
   for(int i = 0; i <= 100000; i++)
/*   {
      int v;
      int e;
      String vs;
      String es;
      Random a = new Random();
      v = a.nextInt(1000);
      e = a.nextInt(1000);
      vs = Integer.toString(v);
      es = Integer.toString(e);
      
      input.add(vs + " " + es);
   }*/
   graph = new Graph(input);
    }
   
    public void testOutgoingExample()
    {
   ArrayList<String> output = graph.getOutgoingGraphRepresentation();
   input.set(4, "0 5 1 0 2 -8 4 9");
   assertEquals(input, output);
    }

    public void testIncomingExample()
    {
   ArrayList<String> output = graph.getIncomingGraphRepresentation();
   input.set(0, "1 3 4 5");
   input.set(1, "3 2 4 0");
   input.set(2, "4 -8");
   input.set(3, "1 -3");
   input.set(4, "0 5 3 0 4 9");
   assertEquals(input, output);
    }

    public void testHasEdge()
    {
   boolean actual = graph.hasEdge(0, 4);
   assertTrue(actual);
   actual = graph.hasEdge(1, 0);
   assertTrue(actual);
   actual = graph.hasEdge(1, 3);
   assertTrue(actual);
   actual = graph.hasEdge(3, 1);
   assertTrue(actual);
   actual = graph.hasEdge(3, 4);
   assertTrue(actual);
   actual = graph.hasEdge(4, 0);
   assertTrue(actual);
   actual = graph.hasEdge(4, 1);
   assertTrue(actual);
   actual = graph.hasEdge(4, 2);
   assertTrue(actual);
   actual = graph.hasEdge(4, 4);
   assertTrue(actual);

   actual = graph.hasEdge(0, 0);
   assertFalse(actual);
   actual = graph.hasEdge(0, 1);
   assertFalse(actual);
   actual = graph.hasEdge(0, 2);
   assertFalse(actual);
   actual = graph.hasEdge(0, 3);
   assertFalse(actual);
   actual = graph.hasEdge(1, 1);
   assertFalse(actual);
   actual = graph.hasEdge(1, 2);
   assertFalse(actual);
   actual = graph.hasEdge(1, 4);
   assertFalse(actual);
   actual = graph.hasEdge(2, 0);
   assertFalse(actual);
   actual = graph.hasEdge(2, 1);
   assertFalse(actual);
   actual = graph.hasEdge(2, 2);
   assertFalse(actual);
   actual = graph.hasEdge(2, 3);
   assertFalse(actual);
   actual = graph.hasEdge(2, 4);
   assertFalse(actual);
   actual = graph.hasEdge(3, 0);
   assertFalse(actual);
   actual = graph.hasEdge(3, 2);
   assertFalse(actual);
   actual = graph.hasEdge(3, 3);
   assertFalse(actual);
   actual = graph.hasEdge(4, 3);
   assertFalse(actual);
    }
   
    public void testGetEdgeWeight()
    {
   int actual = graph.getEdgeWeight(0, 4);
   int expected = 5;
   assertEquals(expected,actual);
   actual = graph.getEdgeWeight(1, 0);
   expected = 3;
   assertEquals(expected,actual);
   actual = graph.getEdgeWeight(1, 3);
   expected = -3;
   assertEquals(expected,actual);
   actual = graph.getEdgeWeight(3, 1);
   expected = 2;
   assertEquals(expected,actual);
   actual = graph.getEdgeWeight(3, 4);
   expected = 0;
   assertEquals(expected,actual);
   actual = graph.getEdgeWeight(4, 0);
   expected = 5;
   assertEquals(expected,actual);
   actual = graph.getEdgeWeight(4, 1);
   expected = 0;
   assertEquals(expected,actual);
   actual = graph.getEdgeWeight(4, 2);
   expected = -8;
   assertEquals(expected,actual);
   actual = graph.getEdgeWeight(4, 4);
   expected = 9;
   assertEquals(expected,actual);
   actual = graph.getEdgeWeight(4, 4);
   expected = 9;
   assertEquals(expected,actual);
    }

    public void testInDegree()
    {
   int actual = graph.inDegree(0);
   int expected = 2;
   assertEquals(expected,actual);
   actual = graph.inDegree(1);
   expected = 2;
   assertEquals(expected,actual);
   actual = graph.inDegree(2);
   expected = 1;
   assertEquals(expected,actual);
   actual = graph.inDegree(3);
   expected = 1;
   assertEquals(expected,actual);
   actual = graph.inDegree(4);
   expected = 3;
   assertEquals(expected,actual);
    }
   
    public void testOutDegree()
    {
   int actual = graph.outDegree(0);
   int expected = 1;
   assertEquals(expected,actual);
   actual = graph.outDegree(1);
   expected = 2;
   assertEquals(expected,actual);
   actual = graph.outDegree(2);
   expected = 0;
   assertEquals(expected,actual);
   actual = graph.outDegree(3);
   expected = 2;
   assertEquals(expected,actual);
   actual = graph.outDegree(4);
   expected = 4;
   assertEquals(expected,actual);
    }
}