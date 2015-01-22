package Kobolds;
/*
 * used for determining Brawn skills if any
 */
class BrawnSkills 
{
   public BrawnSkills()
   {
      
   }
   public String brawnSkills(int roll)
   {
      String skill = "";
      
      switch(roll)
      {
      case 1 : skill = "Athlete"; break;
      case 2 : skill = "Bully"; break;
      case 3 : skill = "Duel"; break;
      case 4 : skill = "Lift"; break;
      case 5 : skill = "Swim"; break;
      case 6 : skill =  "Wrassle"; break;
      }
      
      return skill;
   }
}
