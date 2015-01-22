package Kobolds;
import java.util.Random;
/*
 * this class is the random number generator for the entire program set up for 
 * either 1 d 6 or 2 d 6 pending on needs for character generation
 */
public class Dice 
{
	Random die = new Random();
	
	public int d12()
	{
		int oneD6 = die.nextInt(6) + 1;
		int twoD6 = die.nextInt(6) + 1;
		int oneD12 = oneD6 + twoD6;
		return oneD12;
	}
	public int d6()
	{
	   int oneD6 = die.nextInt(6) + 1;
	   return oneD6;
	}
	/*public int roller (int size, int num)
	{//pass the size of the die (default:6) and the number to 
	 //roll (default:1), it will add automatically
		int out=0; //declare output variiable
		f; i < num; i++)
		{
			out += die.nextInt(6); //getting the rolls
		}
		return out;// guess what is does!!
	}*/
}
