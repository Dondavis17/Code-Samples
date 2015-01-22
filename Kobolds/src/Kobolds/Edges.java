package Kobolds;
/*
 * used for determining edges if any for Kobold 
 */
public class Edges 
{
   /*
    * 
    */
   public String Edges(int roll)
   {
      String edge = "";
      
      switch(roll)
      {
      case 1 : edge = "Animal Chum"; break;
      case 2 : edge = "Bouncy"; break;
      case 3 : edge = "Extra Padding"; break;
      case 4 : edge = "Troll Blood"; break;
      case 5 : edge = "Winning smile"; break;
      case 6 : edge = "zilch"; break;
      }
      return edge;
   }
}
