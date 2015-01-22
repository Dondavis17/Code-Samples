package Kobolds;
/*
 * used for determining Extraneous skills if any
 */
public class ExtraneousSkills 
{
   Dice aD6 = new Dice();
   
   public ExtraneousSkills()
   {
      
   }
   public String extraneousSkills(int roll)
   {
      String skill = "";
      
      switch(roll)
      {
      case 1 : skill = "Bard"; break;
      case 2 : roll = aD6.d6(); skill = this.extraneousSkills(roll); break;
      case 3 : skill = "Dungeon"; break;
      case 4 : skill = "Track"; break;
      case 5 : skill = "Trade"; break;
      case 6 : roll = aD6.d6(); skill = this.extraneousSkills(roll); break;
      }
      
      return skill;
   }
}
