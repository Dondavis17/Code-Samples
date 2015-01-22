package Kobolds;
/*
 * this class is used for determining what weapon if any the Kobold starts with
 */
public class Weapons
{
   public String[] Weapons(int roll)
   {
      String[] weapon = {"", "", ""};
      
      switch(roll)
      {
      case 2: weapon[0] = "Iron Skillet";
               weapon[1] = "+3 dmg";
               weapon[2] = "+1d6 to cooking rolls";
               break;
      case 3: weapon[0] = "Large Bone";
               weapon[1] = "+3 dmg";
               weapon[2] = "This riquires 2 hands to use";
               break;
      case 4: weapon[0] = "Chain";
               weapon[1] = "+2 dmg";
               weapon[2] = "+1d6 Dungeon and athletic climbing rolls";
               break;
      case 5: weapon[0] = "Club";
               weapon[1] = "+2 dmg";
               weapon[2] = "+1d6 to bash rolls";
               break;
      case 6: weapon[0] = "Small Sword";
               weapon[1] = "+2 dmg";
               weapon[2] = "It looks pretty wimpy";
               break;
      case 7: weapon[0] = "Dagger";
               weapon[1] = "+1 dmg";
               weapon[2] = "It looks really cool";
               break;
      case 8: weapon[0] = "Hammer";
               weapon[1] = "+1 dmg";
               weapon[2] = "+1d6 to all dungeon rolls";
               break;
      case 9: weapon[0] = "SlingShot";
               weapon[1] = "+1 dmg";
               weapon[2] = "1 turn to find 1d6 stones when outside; stones do 1 dmg";
               break;
      case 10: weapon[0] = "Cooking Utensil";
               weapon[1] = "+1 dmg";
               weapon[2] = "+1d6 to cooking";
               break;
      case 11: weapon[0] = "Dead Rat";
               weapon[1] = "+0 dmg";
               weapon[2] = "-faul smelling";
               break;
      case 12: weapon[0] = "Squat";
               weapon[1] = "";
               weapon[2] = "You were last in line for weapons";
               break;
      }
      return weapon;
   }
}
