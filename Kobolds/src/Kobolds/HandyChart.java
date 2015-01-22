package Kobolds;
/*
 * the handy chart for assessing stats complementary attribute
 */
public class HandyChart 
{
   public int handyChart(int stat)
   {
      int handyNum = 1;
      switch(stat)
      {
      case 1 :
      case 2 : 
      case 3 :
      case 4 : break;
      case 5 : 
      case 6 :
      case 7 : 
      case 8 : handyNum = 2; break;
      case 9 : 
      case 10 :
      case 11 :
      case 12 : handyNum = 3; break;
      case 13 : 
      case 14 : 
      case 15 :
      case 16 :  handyNum = 4; break;
      case 17 : 
      case 18 : 
      case 19 :
      case 20 : handyNum = 5;
      
      }
      return handyNum;
   }
}
