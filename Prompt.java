/**
 *  Prompt.java
 *  Provides utilities for user input.
 *  "Enhances" the Scanner class, so that
 *  our programs can recover from "bad" input,
 *  and also provide a way to limit numerical
 *  input to a range of values.  Methods for
 *  reading in Strings, ints, doubles, and chars.
 *  @author Your Name Here
 *  @version 1.0
 *  @since 8/22/2017
 */
import java.util.Scanner;
public class Prompt
{
        /**
         *  Prompts the user and picks up a String.
         *  @param ask       The String prompt to be displayed to the user.
         *  @return          The String entered by the user.
         */
        public static String getString (String ask)
        {
                Scanner keyboard = new Scanner(System.in);
                System.out.print(ask);
                String input = keyboard.nextLine();
                return input;
        }

        /**
         *  Prompts the user and picks up an int.  Checks for
         *  "bad" input and reprompts if not an int.
         *  @param ask       The String prompt to be displayed to the user.
         *  @return          The int entered by the user.
         */
        public static int getInt (String ask)
        {

                boolean badInput = false;
                String input = new String();
                int value = 0;
                do
                {
                        badInput = false;
                        input = getString(ask);
                        try
                        {
                                value = Integer.parseInt(input);
                        }
                        catch (NumberFormatException e)
                        {
                                badInput = true;
                        }
                } while (badInput);
                return value;
        }

        /**
         *  Prompts the user and picks up an int.  Checks for
         *  "bad" input and reprompts if not an int.  Also checks
         *  for input within a given range, and reprompts if outside
         *  that range.
         *  @param ask       The String prompt to be displayed to the user.
         *  @param min       The minimum integer value to be allowed as input.
         *  @param max       The maximum integer value to be allowed as input.
         *  @return          The int entered by the user.
         */
        public static int getInt (String ask, int min, int max)
        {
                int value = 0;
                do
                {
                        value = getInt(ask /*+ " (from " + min + " to " + max + "): "*/);
                } while (value < min || value > max);

                return value;

        }

        /**
         *  Prompts the user and picks up a double.  Checks for
         *  "bad" input and reprompts if not a double.
         *  @param ask       The String prompt to be displayed to the user.
         *  @return          The double entered by the user.
         */
        public static double getDouble (String ask)
        {

                boolean badInput = false;
                String input = new String();
                double value = 0;
                do
                {
                        badInput = false;
                        input = getString(ask);
                        try
                        {
                                value = Double.parseDouble(input);
                        }
                        catch (NumberFormatException e)
                        {
                                badInput = true;
                        }
                } while (badInput);
                return value;
        }

        /**
         *  Prompts the user and picks up a double.  Checks for
         *  "bad" input and reprompts if not a double.  Also checks
         *  for input within a given range, and reprompts if outside
         *  that range.
         *  @param ask       The String prompt to be displayed to the user.
         *  @param min       The minimum double value to be allowed as input.
         *  @param max       The maximum double value to be allowed as input.
         *  @return          The double entered by the user.
         */
        public static double getDouble (String ask, double min, double max)
        {
                double value = 0;
                do
                {
                        value = getDouble(ask /*+ " (from " + min + " to " + max + "): "*/);
                } while (value < min || value > max);

                return value;
        }

        /**
         *  Prompts the user and picks up a char.  Checks for
         *  "bad" input and reprompts if not a single char.
         *  @param ask       The String prompt to be displayed to the user.
         *  @return          The char entered by the user.
         */
        public static char getChar (String ask)
        {
                boolean badInput = false;
                String input = new String();
                char value = 0;
                do
                {
                        badInput = false;
                        input = getString(ask);
                        try
                        {
                                value = input.charAt(0);
                        }
                        catch (NumberFormatException e)
                        {
                                badInput = true;
                        }
                } while (badInput);
                return value;

        }

        /**
         *  Prompts the user and picks up a char.  Checks for
         *  "bad" input and reprompts if not a char.  Also checks
         *  for input from a given array of char, and reprompts if
         *  input does not belong to this array of possible inputs.
         *  @param ask         The String prompt to be displayed to the user.
         *  @param possible    The array containing the list of valid inputs.
         *  @return            The char entered by the user.
         */
        public static char getChar (String ask, char [] possible)
        {
                char value;
                do
                {
                        value = getChar(ask);
                } while (!(validChar(value, possible)));

                return value;
        }

        /**
         *  Checks to see if the char value is a member of the char []
         *  possible.  Returns true if value exists in the array,
         *  false otherwise.  This is a helper method for the last
         *  getChar method.
         *  @param value       The char to be checked.
         *  @param possible    The array of char that represents the list of
possible "good" input.
         *  @return            True if good input, false if bad input.
         */
        public static boolean validChar(char value, char [] possible)
        {
                boolean valid = false;
                for (int i = 0; i < possible.length; i++)
                {
                        if (possible[i] == value)
                        {
                                valid = true;
                        }

                }
                return valid;
        }
}