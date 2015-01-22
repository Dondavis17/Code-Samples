package Kobolds;
/*
 * this class puts the kobold object together and prints it out for copying down on
 * on your character sheet
 */
public class Kobold 
{
   HandyChart chart = new HandyChart();
   Dice roll = new Dice();
   Edges edge3 = new Edges();
   Bogies bogie3 = new Bogies();
   Skills theSkills = new Skills();
   Equipment equip = new Equipment();
   
   public Kobold()
   {
      int brawn = roll.d12();
      int ego = roll.d12();
      int extraneous = roll.d12();
      int reflexes = roll.d12();
      int hits = brawn;
      int meat = chart.handyChart(brawn);
      int cunning = chart.handyChart(ego);
      int luck = chart.handyChart(extraneous);
      int agility = chart.handyChart(reflexes);
      //int extraBogie = roll.d6();
      String [] edges = {"Bark Like a Kobold", "Kobold Senses", 
         edge3.Edges(roll.d6())};
      String [] bogies = {"Fearless", "Taste Like Chicken",
         bogie3.Bogies(roll.d6())};
      if(edges[2].equals("Extra Padding"))
      {
         hits += roll.d6();
      }
      String[] mySkills = theSkills.getSkills(ego); 
      String[] myGear = equip.equipment();
      
      System.out.println("brawn: " + brawn + "\n" + "ego: " + ego + "\n" + 
            "extraneous: " + extraneous + "\n" + "reflexes: " + reflexes + "\n" +
            "hits: " + hits + "\n" + "meat: " + meat + "\n" + "cunning: " + cunning
            + "\n" + "luck: " + luck + "\n" + "agility: " + agility);
      System.out.println("\nedges: ");
      for(int i = 0; i < edges.length; i++)
      {
         System.out.println(" " + edges[i]);
      }
      System.out.println("\nbogies: ");
      for(int i = 0; i < bogies.length; i++)
      {
         System.out.println(" " + bogies[i]);
      }
      System.out.println("\nskills: ");
      for(int i = 0; i < mySkills.length; i++)
      {
         System.out.println(" " + mySkills[i]);
      }
      for(int i = 0; i < myGear.length; i++)
      {
         if(myGear[i].equals(""))
            i++;
         System.out.println(" " + myGear[i]);
      }
      
   }
      
      
      
    
      
   
   public static void main(String [] args)
   {
      Kobold a = new Kobold();
   }
}


