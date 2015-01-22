package Kobolds;
/*
 *  puts all the equipment into one array and passes it to the Kobold object
 */
public class Equipment
{
   public Equipment()
   {
      
   }
   public String[] equipment()
   {
      String[] myArmor = armor.Armour(roll.d12());
      String[] myGear = gear.Gear(roll.d12());
      String[] myWeapon = aWeapon.Weapons(roll.d12());
      String[] myStuff = new String[11];
      myStuff[0] = "\nArmour:";
      for(int i = 1; i < 4; i++)
      {
         myStuff[i] = myArmor[i-1];
      }
      myStuff[4] = "\nGear:";
      for(int j = 5; j < 7; j++)
      {
         myStuff[j] = myGear[j-5];
      }
      myStuff[7] = "\nWeapon:";
      for(int z = 8; z < 11; z++)
      {
         myStuff[z] = myWeapon[z-8];
      }
      return myStuff;
   }
   Dice roll = new Dice();
   Armour armor = new Armour();
   Gear gear = new Gear();
   Weapons aWeapon = new Weapons();
}
