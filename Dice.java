/**
 * Dice.java
 * Simulate a single die. An instance of the Dice
 * class has a number of sides, a roll count, and
 * a face value (last rolled value). Two constructors
 * are included, along with getter and setter methods.
 * @author Arushi Arora
 * @version 1.0
 * @since 8/17/2017
 */

 public class Dice
 {
         /** The number of sides for the die. */
         private int sides;

         /** The number of times the die has been rolled. */
         private int rollCount;

         /** The last rolled value of the die. */
         private int value;

         /** Creates a Dice object, with 6 sides by default, roll
          * count set to 0, and the value set to -1. */
          public Dice()
          {
                 sides = 6;
                 rollCount = 0;
                 value = -1;
          }


         /** Creates a Dice object, with n sides by default, roll
          * count set to 0, and the value set to -1.
          * @param n The number of sides for the die.
          */
          public Dice (int n)
          {
                 sides = n;
                 rollCount = 0;
                 value = -1;
          }

          /** Rolls the die, the roll count increases by one.
           * The value is set to a random integer from 1
           * to sides.
           * @return The last rolled value of the die.
           */
          public int roll()
          {
                  value = (int)(Math.random() * sides + 1);
                  rollCount++;
                  return value;
          }

          /** Gets the roll count.
           * @return The current roll count.
           */
          public int getRollCount()
          {
                  return rollCount;
          }

          /** Gets the current value.
           * @return The current value.
           */
          public int getValue()
          {
                  return value;
          }

 }