package Kobolds;
/*
 * this class sets the third bogie for the kobold
 */
public class Bogies 
{
   public String Bogies(int roll)
   {
      String bogie = "";
      
      switch(roll)
      {
      case 1 : bogie = "Angry Friends"; break;
      case 2 : bogie = "Animal Foe"; break;
      case 3 : bogie = "Foul Smelling"; break;
      case 4 : bogie = "Hungry"; break;
      case 5 : bogie = "In Heat"; break;
      case 6 : bogie = "Tastes Like Baby"; break;
      }
      return bogie;
   }
}
