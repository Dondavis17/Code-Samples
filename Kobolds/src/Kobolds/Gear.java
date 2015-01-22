package Kobolds;
/*
 * gets the gear for the kobold and passes it to the Equipment class
 */
public class Gear
{
   public String[] Gear(int roll)
   {
      Dice gearRoll = new Dice();
      String[] gear = {"", ""};
      switch(roll)
      {
      case 2: gear[0] = "Cup of milk Elemental Summoning";
               gear[1] = "10";
               break;
      case 3: gear[0] = "Bag of Holding: Chickens";
               gear[1] = "";
               break;
      case 4: gear[0] = "Ring of Human Speaking";
               gear[1] = "";
               break;
      case 5: String temp[] = spellChart(gearRoll.d6());
               gear[0] = "Codex of Tabriz the Archane";
               gear[1] = temp[0];
               break;
      case 6: String temp1[] = booze(gearRoll.d6());
               gear[0] = temp1[0];
               gear[1] = temp1[1];
               break;
      case 7: gear[0] = "Spice Sack";
               gear[1] = "";
               break;
      case 8: gear[0] = "BackPack";
               gear[1] = "";
               break;
      case 9: String[]temp2 = castOff(gearRoll.d6());
               gear[0] = temp2[0];
               gear[1] = temp2[1];
               break;
      case 10: gear[0] = "25 Feet of Rope";
               gear[1] = "";
               break;
      case 11: gear[0] = "10 Foot Pole";
               gear[1] = "";
               break;
      case 12: gear[0] = "Lint";
               gear[1] = "";
               break;
      }
      return gear;
   }
   public String[] castOff(int rolled)
   {
      String[] equipt = {"", ""};
      String affect = "";
      switch(rolled)
      {
      case 1: equipt[0] = "Broken Holy Water Vail";
               equipt[1] = "Throw at undead for 1d6 dmg";break;
      case 2: equipt[0] = "Flask of Oil"; 
               equipt[1] = "Throw at fire for 1d6 dmg in square";
               break;
      case 3: equipt[0] = "WhetStone"; 
               equipt[1] = "Kobold takes 1d6 dmg and does +2 dmg for that many rounds";
               break;
      case 4: equipt[0] = "Iron Ration"; 
               equipt[1] = "contains a snack that replenshes 2 hits";
               break;
      case 5: equipt[0] = "Flaming Club"; 
               equipt[1] = "Once lit can be used for 2d6 rounds for light and 3 dmg before crubling to ash";
               break;     
      case 6: equipt[0] = "Empty Wineskin"; 
               equipt [1] = "";
               break;
      }
      return equipt;
   }
   public String[] booze(int rolled)
   {
      String[] boose = {"", ""};
      switch(rolled)
      {
      case 1: boose[0] = "Grog";
               boose[1] = "+1 Dice to Brawn and -1 Dice to all other Rolls";
               break;
      case 2: boose[0] = "Mead"; 
               boose[1] = "Headache, + 1d6 lost Hits, -1d6 on ego rolls";
               break;
      case 3: boose[0] = "Beer"; 
               boose[1] = "Ignore the effects of hunger for 1d6 rounds";
               break;
      case 4: boose[0] = "Wine"; 
               boose[1] = "Amore, kobold is in heat for 1d6 rounds";
               break;
      case 5: boose[0] = "Brandy";
               boose[1] = "Sophisticated, take 2 dmg and gain Bard skill for 1d6 rounds";
               break;
      case 6: boose[0] = "Ta-Kill-Ya"; 
            break;
      }
      return boose; 
   }
   public String[] spellChart(int rolled)
   {
      String[] spell = {""};
      switch(rolled)
      {
      case 2: spell[0] = "Spell of Mostly Unspeakable Horrors"; break;
      case 3: spell[0] = "Wall of Beer"; break;
      case 4: spell[0] = "Hagen's Larpsfucation"; break;
      case 5: spell[0] = "Pimpy's slapping hand"; break;
      case 6: spell[0] = "Bail's Floating Frying Pan"; break;
      case 7: spell[0] = "Restors's Spell of Smolence"; break;
      case 8: spell[0] = "Iabris' Ball of Flaming Death"; break;
      case 9: spell[0] = "Lord Elmer's Ball of Glue"; break;
      case 10: spell[0] = "Sandor's Spell of Summoning Chicken"; break;
      case 11: spell[0] = "Poof"; break;
      case 12: spell[0] = "Summon Horriblew Demon"; break;
      }
      return spell;
   }
}
