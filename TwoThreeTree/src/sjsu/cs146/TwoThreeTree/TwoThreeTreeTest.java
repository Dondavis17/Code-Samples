package sjsu.cs146.TwoThreeTree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

public class TwoThreeTreeTest 
{
   
   TwoThreeTree a = new TwoThreeTree();
   
   @Before
   public void setUp() throws Exception 
   {
      
   }
   @Test
   public void testSearch()
   {
      a.insert(24);
      a.insert(49);
      a.insert(24);
      a.insert(30);
      a.insert(16);
      a.insert(50);
      a.insert(69);
      a.insert(69);
      a.insert(50);
      a.insert(10);
      a.insert(5); 
      a.insert(4);
      a.insert(77); 
      a.insert(100);
      a.insert(65);
      a.insert(59);
      a.insert(25);
      a.insert(75);
      a.insert(115);
      a.insert(43);
      //a.insert(99);
      a.insert(17);
      a.insert(31);
      a.insert(35);
      a.insert(39);//this is where it is known good to
      a.insert(45);
      a.insert(200); //good to here
      a.insert(70);
      a.insert(44);
      a.insert(97);
      a.insert(44);
      a.insert(1);
      a.insert(245);
      a.insert(12);
      a.insert(29);
      a.insert(27);
      a.insert(6);
      a.insert(15);
      a.insert(87);
      a.insert(79);
      a.insert(83);
      a.insert(400);
      a.insert(-54);
      a.insert(367);
      a.insert(255);
      a.insert(-300);
      a.insert(154);
      a.insert(175);
      a.insert(-185);
      a.insert(267);
      a.insert(294);
      a.insert(3);
      a.insert(2);
      a.insert(11);
      a.search(24);
      a.search(49);
      a.search(24);
      a.search(30);
      a.search(16);
      a.search(50);
      a.search(69);
      a.search(69);
      a.search(50);
      a.search(99);
      a.search(25);
      a.search(55);
      a.search(100);
      a.search(65);
      a.search(59);
      a.search(25);
      a.search(75);
      a.search(115);
      a.search(43);
      a.insert(17);
      a.insert(31);
      a.insert(35);
      a.insert(39);//this is where it is known good to
      a.insert(45);
      a.insert(200); //good to here
      a.insert(70);
      a.search(25);
      a.search(55);
      a.search(300);
      a.search(34);

      //fail()
      //assert(null, a.insert(24));
   }


}
