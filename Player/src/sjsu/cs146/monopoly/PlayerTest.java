package sjsu.cs146.monopoly;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class PlayerTest extends TestCase
{
   Player p1;
   Player p2;
   Player p3;
   
   @Before
   protected void setUp() throws Exception
   {
      super.setUp();
      String name1 = "Billy";
      String name2 = "Joe";
      String name3 = "Jhon";
      p1 = new Player(name1);
      p2 = new Player(name2);
      p3 = new Player(name3);
   }
   
   @Test
   public void testPlaya()
   {
      assertEquals("Billy", p1.getName());
      assertEquals(1500, p1.getMoney());
      assertFalse(p1.isInJail());
      
      assertEquals("Joe", p2.getName());
      assertEquals(1500, p2.getMoney());
      assertFalse(p2.isInJail());
      
      assertEquals("Jhon", p3.getName());
      assertEquals(1500, p3.getMoney());
      assertFalse(p3.isInJail());
      
   }
   
   @Test
   public void testBasicGetPosition()
   {
      assertFalse(p1.isOutOfGame());
      assertEquals(0, p1.getPosition());
      p1.move(4,5);
      assertEquals(9, p1.getPosition());
      p1.move(5,5);
      assertEquals(19, p1.getPosition());
      p2.move(2,3);
      assertEquals(19, p1.getPosition());
      assertEquals(5, p2.getPosition());
      
        
   }
   
   @Test
   public void testGoToJail()
   {
      assertEquals(0, p1.getPosition());
      p1.move(5,6);
      assertEquals(11, p1.getPosition());
      p1.move(5,4);
      assertEquals(20, p1.getPosition());
      assertFalse(p1.isInJail());
      
      //I've been framed (testing for not in jail)
      assertEquals(0, p2.getPosition());
      p2.getOutOfJail();
      assertEquals(1500, p2.getMoney());
      
      //lands on go to jail
      p1.move(6,4);
      assertEquals(10, p1.getPosition());
      assertTrue(p1.isInJail());
      
      //breakin the laaaw
      //three doubles to go to jail and consecutive turns is true
      assertTrue(p2.move(1, 1));
      assertTrue(p2.move(1, 1));
      assertFalse(p2.move(1, 1));
      assertTrue(p2.isInJail());
      p2.getOutOfJail();
      assertFalse(p2.isInJail());
      
      
      //smooth criminal (testing for doubles to reset)
      assertEquals(10, p2.getPosition());
      assertFalse(p2.move(1, 4));
      assertTrue(p2.move(3,3));
      assertTrue(p2.move(2,2));
      assertFalse(p2.move(2,5));
      assertTrue(p2.move(2,2));
      assertTrue(p2.move(2,2));
      assertFalse(p2.isInJail());
      assertFalse(p2.move(2,2));
      assertTrue(p2.isInJail());
    
   }
   public void testJailBreak()
   {
      p1.move(5, 5);
      assertFalse(p1.isInJail());
      p1.move(10, 10);
      assertTrue(p1.isInJail());
      assertEquals(10, p1.getPosition());
      p1.move(1, 1);
      
      //round 1 billy the kid jail break
      assertTrue(p2.move(1, 1));
      p2.move(14, 14);
      assertTrue(p2.isInJail());
      assertFalse(p2.move(1,1));
      assertEquals(12, p2.getPosition());
      assertEquals(1500, p2.getMoney());
      
      //round 2 John Dillinger jail break
      p1.move(15, 15);
      assertTrue(p1.isInJail());
      p1.move(2, 3);
      p1.move(2, 2);
      assertEquals(14, p1.getPosition());
      assertEquals(1500, p1.getMoney());
      
      //round 3 Frank Morris jail break
      p2.move(9, 9);
      assertTrue(p2.isInJail());
      p2.move(2, 3);
      p2.move(2, 5);
      p2.move(2, 2);
      assertEquals(14, p2.getPosition());
      assertEquals(1500, p2.getMoney());
      p2.move(1,1);
      p2.move(3, 3);
      assertFalse(p2.isInJail());
      
   }
   public void testFreeBird()
   {
      //round 1 AIG (bail out)
      p2.move(15, 15);
      assertTrue(p2.isInJail());
      p2.getOutOfJail();
      assertEquals(1450, p2.getMoney());
      p2.move(10, 10);
      
      //round 2 Goldman Sacks (bail out)
      assertTrue(p2.isInJail());
      p2.move(2,4);
      assertEquals(10, p2.getPosition());
      assertEquals(1450, p2.getMoney());
      p2.getOutOfJail();
      assertEquals(1400, p2.getMoney());
      
      //round 3 Washington Mutual (bail out)
      p2.move(10, 10);
      assertTrue(p2.isInJail());
      p2.move(2, 3);
      p2.move(2, 5);
      p2.getOutOfJail();
      assertTrue(p2.isInJail());
      assertEquals(10, p2.getPosition());
      assertEquals(1400, p2.getMoney());
      p2.move(1, 6);
      assertFalse(p2.isInJail());
      assertEquals(17, p2.getPosition());
      assertEquals(1350, p2.getMoney());
   }
   public void testDeathPenalty()
   {
      int monies = 1450;
      
      p1.move(15, 15);
      for (int i = 0; i < 30; i++)
      {
         assertTrue(p1.isInJail());
         p1.getOutOfJail();
         assertEquals(monies, p1.getMoney());
         p1.move(10, 10);
         monies -= 50;
      }
      assertEquals(0, p1.getMoney());
      p1.getOutOfJail();
      assertFalse(p1.isInJail());
      assertEquals(-50, p1.getMoney()); 
      assertTrue(p1.isOutOfGame());
      assertFalse(p1.move(2, 3));
      assertEquals(10, p1.getPosition());
   }
   public void testPayDay()
   {
      p1.move(20, 19);
      assertEquals(39, p1.getPosition());
      assertEquals(1500, p1.getMoney());
      
      p1.move(0, 1);
      assertEquals(0, p1.getPosition());
      assertEquals(1700, p1.getMoney());
   }
}