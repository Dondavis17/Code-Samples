package Kobolds;
/*
 * this class asses how many skills a kobold
 * gets and then determines what those skills are
 */
public class Skills 
{  
   public Skills()
   {
       
   }
   public String[] getSkills(int ego)
   {
     // String[] skillz = new String[skillNum];
      skillNum = ego;
      
      if(skillNum >= skillMax)
      {
         String[] skills = new String[skillMax];
         skills[0] = "Cooking";
         skills[1] = b.brawnSkills(skillsDice.d6());
         skills[2] = eg.egoSkills(skillsDice.d6());
         skills[3] = e.extraneousSkills(skillsDice.d6());
         skills[4] = r.reflexSkills(skillsDice.d6());
         int fifthskill = skillsDice.d12()%4;
         switch(fifthskill)
         {
         case 0: skills[5] = b.brawnSkills(skillsDice.d6()); break;
         case 1: skills[5] = eg.egoSkills(skillsDice.d6()); break;
         case 2: skills[5] = e.extraneousSkills(skillsDice.d6()); break;
         case 4: skills[5] = r.reflexSkills(skillsDice.d6()); break;
         }  
            for(int i = 1; i < 5; i++)
            {
               if(skills[i].equals(skills[5]))
                  this.getNewSkill(skills);
            }   
            
         
          return skills;
      }
      else if(skillNum == 5)
      {
         String[] skills = new String[5];
         skills[0] = "Cooking";
         skills[1] = b.brawnSkills(skillsDice.d6());
         skills[2] = eg.egoSkills(skillsDice.d6());
         skills[3] = e.extraneousSkills(skillsDice.d6());
         skills[4] = r.reflexSkills(skillsDice.d6());
         
         return skills;
      }
      else if(skillNum == 4)
      {
         String[] skills = new String[4];
         skills[0] = "cooking";
         for(int i = 0; i < 3; i++)
         {
            int fifthskill = skillsDice.d12()%4;
            switch(fifthskill)
            {
            case 0: skills[i + 1] = b.brawnSkills(skillsDice.d6()); break;
            case 1: skills[i + 1] = eg.egoSkills(skillsDice.d6()); break;
            case 2: skills[i + 1] = e.extraneousSkills(skillsDice.d6()); break;
            case 3: skills[i + 1] = r.reflexSkills(skillsDice.d6()); break;
            }
         }
         return skills;
      }
      else if(skillNum == 3)
      {
         String[] skills = new String[4];
         skills[0] = "cooking";
         for(int i = 0; i < 3; i++)
         {
            int fifthskill = skillsDice.d12()%4;
            switch(fifthskill)
            {
            case 0: skills[i + 1] = b.brawnSkills(skillsDice.d6()); break;
            case 1: skills[i + 1] = eg.egoSkills(skillsDice.d6()); break;
            case 2: skills[i + 1] = e.extraneousSkills(skillsDice.d6()); break;
            case 4: skills[i + 1] = r.reflexSkills(skillsDice.d6()); break;
            }
         }
         return skills;
      }
      else if(skillNum == 2)
      {
         String[] skills = new String[3];
         skills[0] = "cooking";
         for(int i = 0; i < 2; i++)
         {
            int fifthskill = skillsDice.d12()%4;
            switch(fifthskill)
            {
            case 0: skills[i + 1] = b.brawnSkills(skillsDice.d6()); break;
            case 1: skills[i + 1] = eg.egoSkills(skillsDice.d6()); break;
            case 2: skills[i + 1] = e.extraneousSkills(skillsDice.d6()); break;
            case 4: skills[i + 1] = r.reflexSkills(skillsDice.d6()); break;
            }
         }
         return skills;
      }
      return null;
   }
   public String[] getNewSkill(String[] skills)
   {     
      int fifthskill = skillsDice.d12()%4;
      switch(fifthskill)
      {
      case 0: skills[5] = b.brawnSkills(skillsDice.d6()); break;
      case 1: skills[5] = eg.egoSkills(skillsDice.d6()); break;
      case 2: skills[5] = e.extraneousSkills(skillsDice.d6()); break;
      case 4: skills[5] = r.reflexSkills(skillsDice.d6()); break;
      }
      for(int i = 1; i < 5; i++)
      {
         if(skills[i].equals(skills[5]))
            this.getNewSkill(skills);
      }
      return skills;
   }
   
   
   Dice skillRolls = new Dice();
   int skillNum;
   int skillMax = 6;
   BrawnSkills b = new BrawnSkills();
   EgoSkills eg = new EgoSkills();
   ExtraneousSkills e = new ExtraneousSkills();
   ReflexSkills r = new ReflexSkills();
   Dice skillsDice = new Dice();
   
}
