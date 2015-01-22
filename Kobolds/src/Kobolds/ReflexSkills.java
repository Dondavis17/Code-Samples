package Kobolds;
/*
 * chart used for determining reflex skills if any
 */
public class ReflexSkills 
{
   public ReflexSkills()
   {
      
   }
   public String reflexSkills(int roll)
   {
      String skill = "";
      
      switch(roll)
      {
      case 1 : skill = "Cower"; break;
      case 2 : skill = "Fast"; break;
      case 3 : skill = "Sneak"; break;
      case 4 : skill = "Steal"; break;
      case 5 : skill = "Ride"; break;
      case 6 : skill =  "Wiggle"; break;
      }
      
      return skill;
   }
}
