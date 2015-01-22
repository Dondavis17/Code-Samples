package Kobolds;
/*
 * used for determining Ego skills if any
 */
public class EgoSkills 
{
   public EgoSkills()
   {
      
   }
   public String egoSkills(int roll)
   {
      String skill = "";
      
      switch(roll)
      {
      case 1 : skill = "Hide"; break;
      case 2 : skill = "Lackey"; break;
      case 3 : skill = "Sage"; break;
      case 4 : skill = "Shoot"; break;
      case 5 : skill = "Speak Human"; break;
      case 6 : skill =  "Trap"; break;
      }
      
      return skill;
   }
}
