package sjsu.cs146.monopoly;

/**
 * Class to simulate player's movement in a simplified 
 * Monopoly game.
 * @author taylor
 * @version 1.02 2010-10-11
 */
public class Player
{
   /**
    * Create a player with the given name.
    * @param myName the name of the player.
    */
   public Player(String myName)
   {
      name = myName;
      inJail = false;
      position = 0;
      money = INITIAL_MONEY;
      turnsInJail = 0;
   }

   /**
    * Moves the player on the monopoly board.  The player's position on
    * the board should wrap around:  once they go past position 39, they
    * reset to position 0, the starting position.
    *   
    * There are some special cases to consider:
    * If a player lands on the "Go to Jail" space (space 30), 
    * the player goes to Jail (space 10), and is "in Jail".  If
    * a player lands on the Jail space (space 10), they are "just
    * visiting", that is, they are not in jail.
    * 
    * If a player rolls doubles, they get to move again.  This method
    * returns true when that is the case.  (It does not roll the dice
    * for them.)  However, if a player rolls doubles three times in a row,
    * they go to jail, and their turn ends.
    * 
    * When a player is in jail, if they roll doubles, they get out
    * of jail and move, and their turn ends.  Here, I am trying to
    * use the moving rules that people tend to play use.  Rules at:
    * http://www.centralconnector.com/games/monopol.html
    * One rule I think is not explicitly stated, but I think people generally
    * play with, regarding "consecutive doubles":  if you are "in jail", and
    * roll a doubles, that doubles does not count as part of any 3 consecutive
    * doubles rolls.  So, for instance, if you roll (1,1), and then (2,2), and
    * that lands you on space 30 (go to jail), and then your first roll in jail
    * is a (4,4), it is not the 3rd consecutive doubles roll.  My code below
    * assumes that 3 consecutive doubles only count when not in jail.  (That is
    * how people play, and almost certainly what the game writers intended:  it
    * would be too easy to forget how many consecutive doubles you have, when
    * other players get to move in the interim.
    * 
    * 
    * After the player's 3rd attempt at doubles in jail, if they do not get
    * doubles, they must pay $50, and then leave jail with the given roll.
    * 
    * Note:  yes, the code can be cleaned.  It is purposely not cleaned, due
    * to some of the peculiarities of how WebCAT grades.
    * 
    * 
    * @param die1 the value of the first die.
    * @param die2 the value of the second die.
    * @return true if it is a player's turn to move again after this move.
    */
   public boolean move(int die1, int die2)
   {
      if (isOutOfGame())
         return false;
      if (inJail)
      {
         if (die1 == die2)
         {
            inJail = false;
            turnsInJail = 0;
            position += die1 + die2;
            return false;
         }
         turnsInJail++; 
         if (turnsInJail == MAX_TURNS_IN_JAIL)
         {
            getOutOfJail();
            position += die1 + die2;
         }
         return false;       
      }
      if (die1 == die2) 
         consecutiveDoubles++;
      else //got this
         consecutiveDoubles = 0;
      if (consecutiveDoubles >= JAIL_DOUBLES)
      {
         position = JAIL_POSITION;
         inJail = true;
         return false;
      }
      position += die1 + die2; 
      if (position == GO_TO_JAIL_POSITION)
      {
         position = JAIL_POSITION;
         inJail = true;
         return false;
      }
      boardSize();
      return (die1 == die2);
   }
   
   /**
    * sets board size and payday
    */
   public void boardSize()
   {
      money += PAYDAY * (position / BOARD_SIZE); 
      position %= BOARD_SIZE; 
   }

   /**
    * Return player's position on the board, an int 0 to 39.
    * @return player's position.
    */
   public int getPosition()
   {
      return position;
   }

   /**
    * Return player's name, given during construction.
    * @return player's name.
    */
   public String getName()
   {
      return name;
   }

   /**
    * Return whether or not a player is in jail.
    * @return true if a player is in jail, false otherwise.
    */
   public boolean isInJail()
   {
      return inJail;
   }

   /**
    * Buys a player's way out of jail for $50.  Has no effect
    * if the player is not in jail, or if a player has already been
    * in jail for 2 turns.  (By the written rules, strangely, you cannot buy
    * your way out just before the 3rd roll, only take your 3rd roll,
    * and if you do not get doubles, buy your way out.  It would make no
    * difference except if you roll doubles to get out:  if you had 
    * previously bought your way out, you would get a second turn, 
    * otherwise you do not.)
    */
   public void getOutOfJail()
   {
      if (isOutOfGame() || !inJail)
         return; 
      if (turnsInJail == MAX_TURNS_IN_JAIL - 1)
      {
         return;
      }
      money -= BAIL;
      inJail = false;
      turnsInJail = 0;
   }

   /**
    * Return amount of money a player has.
    * @return amount of money the player has.
    */
   public int getMoney()
   {
      return money;
   }
   
   /**
    * Return game over.
    * @return game over.
    */
   public boolean isOutOfGame()
   {
      return money < 0;
   }
   
   public static final int JAIL_DOUBLES = 3;
   public static final int MAX_TURNS_IN_JAIL = 3;
   public static final int JAIL_POSITION = 10;
   public static final int GO_TO_JAIL_POSITION = 30;
   public static final int BOARD_SIZE = 40;
   public static final int INITIAL_MONEY = 1500;
   public static final int PAYDAY = 200;
   public static final int BAIL = 50;
   private String name;
   private int position;
   private boolean inJail;
   private int consecutiveDoubles;
   private int money;
   private int turnsInJail;
}

