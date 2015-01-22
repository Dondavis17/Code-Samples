package sjsu.cs146.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Don Davis
 *
 */
public class Graph
{
   /**
    * Constructor for putting graph together using vertex objects 
    * and edge objects from passed 
    * string arraylist
    * @param passedAl incoming string array
    */
   public Graph(ArrayList < String > passedAl)
   {
      for (int i = 0; i < passedAl.size(); i++)
      {
         Vertex tempV = new Vertex();
         String input = passedAl.get(i);
         String [] edge = input.split(" ");
         int destination = -1;
         int weight = -1;
         for (int j = 0; j < edge.length; j += 2)
         {
            if (edge.length == 1)
               break;
            if (edge.length > 1)
            {
               destination = Integer.parseInt(edge[j]);
               weight = Integer.parseInt(edge[j + 1]);
            }      
            Edge outTemp = new Edge(i, destination, weight);
            tempV.outEdges.add(outTemp);
         }
         graph.add(tempV);
         Collections.sort(graph.get(i).outEdges, new Comparator < Edge > ()
               {
                  public int compare(Edge o1, Edge o2)
                  {
                     return o1.dest - o2.dest;
                  }
               }
         );
      }
      for (int z = 0; z < graph.size(); z++)
      {
         for (int x = 0; x < graph.get(z).outEdges.size(); x++)
         {
            Edge inTemp = new Edge(graph.get(z).outEdges.get(x).dest,
                  z, graph.get(z).outEdges.get(x).weight);
            graph.get(graph.get(z).outEdges.get(x).dest).inEdges.add(inTemp);
         }
      }
   }
   /**
    * @return outGoing string representation of graph
    */
   public ArrayList < String > getOutgoingGraphRepresentation()
   {
      
      ArrayList < String > outGoing = new ArrayList < String > ();
      
      for (int i = 0; i < graph.size(); i++)
      {
         String vertex = "";
         
         for (int j = 0; j < graph.get(i).outEdges.size(); j++)
         {
            if (j != graph.get(i).outEdges.size() && j != 0)
               vertex += " ";
            vertex += (Integer.toString(graph.get(i).outEdges.get(j).dest)) 
            + " " + Integer.toString(graph.get(i).outEdges.get(j).weight);
         }
         outGoing.add(vertex);
      }
      return outGoing;
   }
   /*
    * gives a representation of the incoming edges of the graph in string format
    */
   /**
    * @return incoming incoming string representation of graph
    *
    */
   public ArrayList < String > getIncomingGraphRepresentation()
   {
      ArrayList < String > incoming = new ArrayList < String > ();
      
      for (int i = 0; i < graph.size(); i++)
      {
         String vertex = "";
         
         for (int j = 0; j < graph.get(i).inEdges.size(); j++)
         {
            if (j != graph.get(i).inEdges.size() && j != 0)
               vertex += " ";
            vertex += (Integer.toString(graph.get(i).inEdges.get(j).dest)) 
            + " " + Integer.toString(graph.get(i).inEdges.get(j).weight);
         }
         incoming.add(vertex);
      }
   return incoming;
   }
   /*
    * checks if the graph has a particular edge
    */
   /**
    * @param  source source of the edge
    * @param destination of the edge used to find edge  
    *  @return true if edge exists
    */
   public boolean hasEdge(int source, int destination)
   {
      for (int i = 0; i < graph.get(source).outEdges.size(); i++)
      {
         if (graph.get(source).outEdges.get(i).dest == destination)
         {
            return true;
         }
      }
      return false;   
   }
   /**
    * @param  source source of the edge
    * @param destination of the edge  for finding the weight
    *  @return weight of the edge
    */
   public int getEdgeWeight(int source, int destination)
   {
      int i = 0;
      int wgt = 0;
      
      do
      {
         wgt = graph.get(source).outEdges.get(i).weight;
         i++;
      }
      while (graph.get(source).outEdges.get(i - 1).dest != destination); 
      return wgt;
   }
   /**
    * get the # of edges coming into a vertex
    * @param vertexIndex the index of the vertex
    * @return size of the outgoing arraylist
    * giving the amount of outgoing edges
    */
   public int inDegree(int vertexIndex)
   {
      return graph.get(vertexIndex).inEdges.size();
   }
   /**
    * get the # of edges coming into a vertex
    * @param vertexIndex the index of the vertex
    * @return size of the outgoing arraylist
    * giving the amount of outgoing edges
    */
   public int outDegree(int vertexIndex)
   {  
      return graph.get(vertexIndex).outEdges.size();
   }
   /**
    * creates a vertex object
    * that holds two arraylists of edges
    * for incomiong and outgoing edges 
    * 
    */
   public class Vertex
   {  
      private ArrayList < Edge > outEdges = new ArrayList < Edge > ();
      private ArrayList < Edge > inEdges = new ArrayList < Edge > ();
      /**
       * constructor for vertex object with no parameters 
       * 
       */   
      private Vertex()
      {
            
      } 
   }
   /*
    * creates a edge object
    */
   /**
    * creates an edge object 
    * 
    */
   public class Edge
   {
      int source;
      int dest;
      int weight;
      /**
       * constructor for edge object 
       * @param the source destination and width 
       */
      Edge(int s, int d, int w)
      {
         source = s;
         dest = d;
         weight = w;
      }
   }   
   private ArrayList < Vertex > graph = new ArrayList < Vertex > ();
}
