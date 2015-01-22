package Kobolds;
/*
 * this class determines what armor if any the kobold starts wiith
 */
public class Armour
{
   public String[] Armour(int roll)
   {
      String[] armor = {"", "", ""};
      
      switch(roll)
      {
      case 2: armor[0] = "Big Shield";
               armor[1] = "+10 hits";
               armor[2] = "requires 2 hands to use, 2Dmg";
               break;
      case 3: armor[0] = "Metal Pot Helm";
               armor[1] = "+10 hits";
               armor[2] = "+1d6 to Cooking";
               break;
      case 4: armor[0] = "Beer-Barrel";
               armor[1] = "+12 hits";
               armor[2] = "-1 to agi";
               break;
      case 5: armor[0] = "Leather Apron";
               armor[1] = "+8 hits";
               armor[2] = "this item can be used as a backpack";
               break;
      case 6: armor[0] = "Leather Jacket";
               armor[1] = "+8 hits";
               armor[2] = "Fonzie, ie you feel really really cool";
               break;
      case 7: armor[0] = "Small Shield";
               armor[1] = "+6 hits";
               armor[2] = "counts as an item for carrying character picks either this item or the other item for carrying";
               break;
      case 8: armor[0] = "Heavy T Shirt";
               armor[1] = "+4 hits";
               armor[2] = "";
               break;
      case 9: armor[0] = "Kids Cloths";
               armor[1] = "+2 hits";
               armor[2] = "";
               break;
      case 10: armor[0] = "Socks";
               armor[1] = "+1 hits";
               armor[2] = "";
               break;
      case 11: armor[0] = "Lintmail Vest";
               armor[1] = "+1 hits";
               armor[2] = "";
               break;
      case 12: armor[0] = "Nekkid";
               armor[1] = "+0 hits";
               armor[2] = "";
               break;
      }
      return armor;
   }
}
