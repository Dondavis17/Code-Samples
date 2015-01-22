package sjsu.cs146.TwoThreeTree;

import java.util.*;
/**
 * @author Don Davis
 */
public class TwoThreeTree 
{
   /**
    * Constructor for Two Three Tree that takes no parameters
    */
   public TwoThreeTree()
   {
      
   }
   /**
    * @param x
    * calls the nInsert method in Node class to insert in the tree
    */
   public void insert(int x)
   {
      tree = tree.nInsert(x);
   }
   /**
    * @return Contents of Node as string
    * @param x is data passed to search method
    */
   public String search(int x)
   {
      return tree.treeSearch(x);
   }
   /**
    * @author Don Davis
    *this is the node class which builds the tree
    */
   public static class Node
   {
      
      private ArrayList < Integer > values = new ArrayList < Integer > ();
      /**
       * this is the node constructor
       */
      Node() 
      {
         parent = this;
         left = null;
         mid = null;
         right = null;
         q = null;
      } 
      /**
       * @param data value passed to search method to see if it is in tree
       * @return Node array as a string
       */
      public String treeSearch(int data)
      {  
         if (values.isEmpty()) //checks for initial node
            return null;
         else if (values.contains(data)) //checks if node contains data
            return getString(values);
        //checks if data is less than the 0 index of values in left hand nodes
         else if (data < values.get(0))  
         { 
            if (left == null)
               return getString(values);
            else //owe child support (recursive call to next lvl
               return left.treeSearch(data);
         }
         else if (1 == values.size()) 
         { //checks size of values in node is == to 1
            if (left == null)  //checks for children
               return getString(values);
            
            else
               return right.treeSearch(data);
         } //this returns the values in values if there is more than one value
         else  
         { //this traverses the right or far right side of the tree
            if (left == null)
               return getString(values);
            
            else if (data < values.get(1))
               return mid.treeSearch(data);
            
            else
               return right.treeSearch(data); //.values.get(2).treeSearch(data);
         }
      }
      /**
       * @param data value to be inserted in tree
       * @return Node with data to recursivly construct the tree
       */
      public Node nInsert(int data)
      {
         if (values.isEmpty())
         {
            addValue(data);
            return this;
         }
         else
         {     
            if (!exists(data))
            {
               if (left == null) //if this is a leaf
                  return split(data);
               else if (left != null)
               {
                  Node temp = new Node();
                  //checks if data is > left most value and inserts if it is  
                  if (data < values.get(0))
                     temp = left.nInsert(data);     
                  else if (mid != null)
                  { //checks for mid child and traverses if between values
                     if (data > values.get(0) && data < values.get(1))
                        temp = mid.nInsert(data);
                     else //traverses right if greater than last value
                        temp = right.nInsert(data);
                  }
                  else //traverses the right child if no mid
                     temp = right.nInsert(data);
                  if (temp.parent != this)
                  { //popcorn node(the node was popped up) lose temp.right here
                     left.parent = this;
                     right.parent = this;
                     if (mid != null)
                        mid.parent = this;
                     if (1 == values.size()) 
                     { //this is parent node vs temp parent data comparison
                        if (temp.values.get(0) < values.get(0)) 
                        {
                           mid = temp.right;
                           if (temp.left.left != null)
                              left = temp.left;
                           return split(temp.values.get(0));
                        }
                        else if (temp.values.get(0) == values.get(0))
                           return this;
                        else //if ( values.size() == 2)
                        {
                           mid = temp.left;
                           mid.parent = this;
                           right = temp.right; 
                           right.parent = this;
                           return split(temp.values.get(0));
                        }
                     }
                     else if (!this.exists(temp.values.get(0))) 
                     {   
                        if (temp.values.get(0) < values.get(0))
                        {
                           q = temp.left;
                           left = temp.right;
                           left.parent = this;
                           q.parent = this;
                           return split(temp.values.get(0));
                        }
                        else if (values.get(0) < temp.values.get(0) 
                              && temp.values.get(0) < values.get(1))
                        {
                           q = left;
                           left = temp.left;
                           mid = temp.right;
                           left.parent = this;
                           q.parent = this;
                           mid.parent = this;
                           return split(temp.values.get(0));
                        }
                        else
                        {
                           q = left;
                           left = mid;
                           mid = temp.left;
                           right = temp.right;
                           left.parent = this;
                           q.parent = this;
                           mid.parent = this;
                           right.parent = this;
                           return split(temp.values.get(0));
                        }
                     }
                     else
                        return this;
                  }
               }
            }
            return this;
         }
      }
      /** 
       * @param data value to be added to tree 
       * @return Node to recursivly split and construct tree
       * also calls addvalues method for adding data to node
       */
      public Node split(int data)
      {
         if (values.size() < NFULL) //if we can just insert the value
         { 
            addValue(data);
            if (values.size() == NFULL) //if the node is full, split it  
            {
                  Node temp = new Node();
                  temp  = treeBuilder(data);
                  
                  if (q == null)
                  {
                     temp.left = this;
                     temp.left.parent = temp;
                  }
                  else
                  {  //building new tree
                     temp.left = new Node();
                     temp.left.addValue(values.get(0)); 
                     temp.left.left = q; 
                     q = null;  
                     temp.left.right = left; 
                     temp.right.parent = temp; 
                     temp.right.right = right; 
                     temp.right.left = mid; 
                     mid = null;
                     temp.right.right.parent = temp.right; 
                     temp.right.left.parent = temp.right; 
                     temp.left.parent = temp; 
                     temp.left.right.parent = temp.left; 
                     temp.left.left.parent = temp.left; 
                  }
               return temp.parent;
            }
         }
         return this.parent;
      }
      /**
       * @param data value to be added to tree
       * @return temp is new node template for tree branch
       */
      public Node treeBuilder(int data)
      {
         Node temp = new Node();
         temp.parent = temp;
         temp.addValue(values.get(1));
         temp.parent.right = new Node();  
         temp.parent.right.addValue(values.get(2)); 
         temp.right.parent = temp; 
         values.remove(1);
         values.remove(1);
         
         return temp;
      }
      /**
       * @param data value to be added to tree
       * adds values to nodes
       */
      public void addValue(int data)
      {
         values.add(data);
         values.trimToSize();
         Collections.sort(values);
      }
      /**
       * @param data value to be checked to see if exists in tree
       * @return true if value is in tree
       * else returns false
       */
      public boolean exists(int data)
      { //splits the string into a string array of numbers
         String[] str = treeSearch(data).split(" "); 
         
         for (int i = 0; i < str.length; i++)  //traverses the array
         { //parses the string #'s into integers and checks against data
            if (data == Integer.parseInt(str[i])) 
               return true; 
         }
         return false;  //returns false if no match
      }
      /**
       * @param strData array list of values to be converted to a string
       * @return the keys of node in string format
       */
      private static String getString(ArrayList < Integer > strData)
      {
         String balls = "";
         for (int i = 0; i < strData.size(); i++)
         {
            if (i == 1)
               balls += " ";
            balls += Integer.toString(strData.get(i));
         }
         return balls;
      }
      /**
       * private instance fields for Node class
       */
      private Node left;
      private Node right;
      private Node mid;
      private Node parent;
      private Node q;
      private static final int NFULL = 3;
   }
   /**
    * Constructs a new node for TwoThreeTree to build a new tree
    */
   private Node tree = new Node();     
}
