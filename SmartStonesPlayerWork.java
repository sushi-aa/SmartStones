/**
 * Stones.java
 * This program will print out 3 rows, each with a random number of "stones" (3-10).
 * The program will then invite the user to choose a row (1, 2, or 3, error checked),
 * then a number of Stones (error checked).  It will show the new "gameboard" and have
 * the user hit the enter key for the computer to take it's turn.  The game
 * continues until all the Stones are gone.  The player to remove the last Stone(s)
 * loses!  If there are no more Stones in a row, then the player can't choose that row!
 * @author Arushi Arora
 * @version 1.0
 * @since 8/24/17
 */

public class SmartStonesPlayerWork
{
        /** Number of stones in each pile.  */
        private int pile1, pile2, pile3;

        /** Toggle for player's turn (playing against the computer).  */
        private boolean playerTurn;

        /** Boolean to determine if game is done (no stones left).  */
        private boolean done;

        /** Name of player.  */
        private String name;

        /** Setup field variables, placing from 3 to 10 stones (at random)
         *  in each pile.  Have the user (player) go first against the
         *  computer, and assume that the game has not ended yet (done set
         *  to false
         */
        public SmartStonesPlayerWork ( )
        {
                Dice die = new Dice(8);
                //pile1 = die.roll() +2;
                //pile2 = die.roll() +2;
                //pile3 = die.roll() +2;
                
                pile1 = 5;
                pile2 = 4;
                pile3 = 5;

                playerTurn = true;
                done = false;
        }
        /** Play the game.  */
        public static void main (String [] args)
        {
                SmartStonesPlayerWork game = new SmartStonesPlayerWork();
                game.intro();
                game.play();
                game.printWinner();
        }

        /** Introduction, providing the rules, and prompting the player (user) to
enter his/her name.  */
        public void intro ( )
        {
                System.out.println("\n\n\n        **************************************************************************");
                System.out.println("        * Welcome to the GAME OF STONES(TM)! *");          
                System.out.println("        * The Game of Stones(TM) is played between the user and the computer.    *");
                System.out.println("        * First, your program will create 3 piles of stones, with each pile      *");
                System.out.println("        * containing between 3 and 10 stones (the Dice class is used to choose   *");
                System.out.println("        * random values).  Then, the user and the computer will take turns       *");
                System.out.println("        * removing stones from the piles.  The user will always go first.  The   *");
                System.out.println("        * player (user) must choose the pile (1, 2, or 3), and then the number   *");
                System.out.println("        * of stones in the pile to remove (from 1 to the number of stones        *");
                System.out.println("        * remaining in the pile).  Of course, if no stones remain in a pile,     *");
                System.out.println("        * then it is not possible for stones to be removed from that pile.  The  *");
                System.out.println("        * Prompt class is used to get this user input.  The player and the       *");
                System.out.println("        * computer alternate turns until no stones remain.  THE LOSER IS THE     *");
                System.out.println("        * LAST PLAYER TO TAKE A TURN (REMOVING THE LAST STONE).                  *");
                System.out.println("        **************************************************************************");
                System.out.println("\n        GOOD LUCK!\n");
                do
                {
                        name = Prompt.getString("Player, please enter your name: ");
                }
                while(name.equals(""));
        }

        /** Plays the game, alternating between the user and the "computer". When all of the
         *  "rows" have zero stones, the boolean done should be set to true, and the loop will
         *  come to an end.
         */
        public void play()
        {
                while (!done)
                {
                        showTable();
                        playerMakeChoice();
                        if(!done)
                        {
                                showTable();
                                playerTurn = !playerTurn;
                                computerMakeChoice();
                                if(!done)
                                {
                                        playerTurn = !playerTurn;
                                }
                        }
                }
        }

        /**  Uses printf to print the stones (represented by O's) in the three rows.  */
        public void showTable()
        {
                System.out.printf("\n\nPile 1 - %2d STONES: ", pile1);
                for(int i = 0; i < pile1; i++)
                {
                        System.out.print("O ");
                }
                System.out.printf("\nPile 2 - %2d STONES: ", pile2);
                for(int i = 0; i < pile2; i++)
                {
                        System.out.print("O ");
                }
                System.out.printf("\nPile 3 - %2d STONES: ", pile3);
                for(int i = 0; i < pile3; i++)
                {
                        System.out.print("O ");
                }
                findBestMove();
                
        }

        /** The player chooses the pile number, and then the number of stones to remove from
         *  the chosen row.  The input from the user should be checked.
         */
        public void playerMakeChoice()
        {
                if (pile1 == 0 && pile2 == 0 && pile3 == 0)
                {
                       done = true;
                       playerTurn = false;
                       printWinner();
                        
                }
                int userPile = 0;
                int userRemove = 0;
                int maxRemove = 0;
                Prompt p = new Prompt();
                userPile = p.getInt("\n" + name + ", please choose a pile number (1, 2, or 3): ", 1, 3);
                 
                if (pile1 == 0)
                {

                    while (userPile == 1)
                    {
  
                        userPile = p.getInt("\n" + name + ", please choose a pile number (1, 2, or 3): ", 1, 3);
                    }
                }
                if (pile2 == 0)
                {
    
                    while (userPile == 2)
                    
                    {
             
                        userPile = p.getInt("\n" + name + ", please choose a pile number (1, 2, or 3): ", 1, 3);
                    }
                    
                }
                if (pile3 == 0)
                {
          
                    while (userPile == 3)
                    {
           
                        userPile = p.getInt("\n" + name + ", please choose a pile number (1, 2, or 3): ", 1, 3);
                    }
                    
                }
                


                if (userPile == 1)
                {
                        maxRemove = pile1;
                }
                else if (userPile == 2)
                {
                        maxRemove = pile2;
                }
                else
                {
                        maxRemove = pile3;
                }

                if (maxRemove == 0)
                {
                        maxRemove = -1;
                }
                userRemove = p.getInt("\n" + name + ", please enter the number of stones to remove in pile " + userPile + ": ", 1, maxRemove);

                System.out.println("\n" + name + " removed " + userRemove + " stone(s) from pile " + userPile);


                if (userPile == 1)
                {
                        pile1 = pile1 - userRemove;
                }
                else if (userPile == 2)
                {
                        pile2 = pile2 - userRemove;
                }
                else if (userPile == 3)
                {
                        pile3 = pile3 - userRemove;
                }
                showTable();

                if (pile1 == 0 && pile2 == 0 && pile3 == 0)
                {
                        done = true;
                        playerTurn = true;
                        printWinner();
                }
                
                p.getString("\nIt is the computer's turn. Please press enter to continue.");
                
                computerMakeChoice();

        }

        /** The "computer" chooses a row and removes stones from this chosen row. This can be a simple, "dumb"
         *  removal (the method needs to make a valid choice, but it does not need to be a smart choice).  For
         *  up to 3 extra credit points, use an algorithm to make better choices for this method.
         */
        public void computerMakeChoice()
        {
                if (pile1 == 0 && pile2 == 0 && pile3 == 0)
                {
                    done = true;
                    playerTurn = true;
                    printWinner();
                        
                }
                int computerPile = 0;
                int computerRemove = -1;
                computerPile = (int)(Math.random()*3 + 1);
                if (computerPile == 1 && pile1 != 0)
                {
                        computerRemove = (int)(Math.random()*pile1 + 1);
                        pile1 = pile1-computerRemove;
                }
                else if (computerPile == 2 && pile2 != 0)
                {
                        computerRemove = (int)(Math.random()*pile2 + 1);
                        pile2 = pile2-computerRemove;
                }
                else if (computerPile == 3 && pile3 != 0)
                {
                        computerRemove = (int)(Math.random()*pile3 + 1);
                        pile3 = pile3-computerRemove;
                }
                else
                {
                        computerPile = (int)(Math.random()*3+1);
                        computerMakeChoice();
                }
                //showTable();
                System.out.println("\nThe computer removed " + computerRemove + " stone(s) from pile " + computerPile);
                if (pile1 == 0 && pile2 == 0 && pile3 == 0)
                {
                        done = true;
                        playerTurn = false;
                        printWinner();
                }
                else
                {
                    play();
                }
        }

        /** You may create other methods, used by playerMakeChoice and computerMakeChoice.  Be sure to
         *  comment each new method you create.
         */

        /** Shows the table, then tells the user who won, followed by an exit message.  */
        public void printWinner()
        {
                
                if (playerTurn == true)
                {
                        System.out.println("\n\nThe computer won!\n");
                        System.out.println("Thank you for playing the Game of Stones (TM)\n\n\n");
                        System.exit(1);
                }
                else
                {
                        System.out.println("\n\nCongratulations! You won!\n\n");
                        System.out.println("Thank you for playing the Game of Stones (TM)\n\n\n");
                        System.exit(1);
                }
        }
        
        public void findBestMove()
        {
                if (pile1 == 0 && pile2 == 0 && pile3 !=0)
                {
                    System.out.println("Remove " + (pile3 - 1) + " stones from pile 3");
                }
                else if (pile2 == 0 && pile3 == 0 && pile1 !=0)
                {
                     System.out.println("Remove " + (pile1 - 1) + " stones from pile 1");
                    }
                else if (pile1 == 0 && pile3 == 0 && pile2 !=0)
                {
                    System.out.println("Remove " + (pile2 - 1) + " stones from pile 2");
                }   
                    
                else
                {
                    
                    int nimSum = (pile1^pile2^pile3);
                    int r1Sum = pile1^nimSum;
                    int diff1value = 0;
                    int diff2value = 0;
                    int diff3value = 0;
                    boolean diff1 = false;
                    boolean diff2 = false;
                    boolean diff3 = false;
                    if (r1Sum < pile1)
                    {
                        diff1value = pile1 - r1Sum;
                        diff1 = true;
                    }
                 
                    int r2Sum = pile2^nimSum;
                    if (r2Sum < pile2)
                    {
                        diff2value = pile2 - r2Sum;
                        diff2 = true;
                    }
                    
                    int r3Sum = pile3^nimSum;
                    if (r3Sum < pile3)
                    {
                        diff3value = pile3 - r3Sum;
                        diff3 = true;
                    }
                        
                    
                    System.out.println("\n\nSum of all: " + nimSum);
                    System.out.println("\nXOR Pile 1 and Sum : " + r1Sum);
                    System.out.println("\nXOR Pile 2 and Sum : " + r2Sum);
                    System.out.println("\nXOR Pile 3 and Sum : " + r3Sum);
                    
                    int greatest = 0;
                    
                    if (diff1 && diff2)
                    {
                        if (diff1value > diff2value)
                            greatest = pile1;
                        else
                            greatest = pile2;
                    }
                    if (diff1 && diff3)
                    {
                        if (diff1value > diff3value)
                            greatest = pile1;
                        else
                            greatest = pile3;
                           
                    }
                    if (diff2 && diff3)
                    {
                        if (diff2value > diff3value)
                            greatest = pile2;
    
                        else
                            greatest = pile3;
                    }
                    else if (diff1 == true && diff2 == false && diff3 == false)
                        greatest = pile1;
         
                    else if (diff2 == true && diff1 == false && diff3 == false)
                   
                        greatest = pile2;
                    
                    else if (diff3 == true && diff2 == false && diff1 == false)
                    
                        greatest = pile3;
                    
                    System.out.println("Remove " + (nimSum^greatest) + "stones from the pile with " + greatest + " stones.");
                }

            }
        }