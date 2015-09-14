package comparableexample;

import java.util.Random;
import java.util.Scanner;

/** This application allows the user to enter a number and a word of their
 * choice. It then counts how many of the numbers and words in two random
 * arrays are BIGGER than the number and word the user entered.
 * @author Jacob Reed
 */
public class ComparableExample {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter an integer that is less than 1000");
        Integer numValue = in.nextInt();
        System.out.println("Please enter a word that has 3 characters. ");
        System.out.println("Use ALL CAPITAL LETTERS in your word.");
        String wordChoice = in.next();

        Random generator = new Random();

        // Create an array containing 10 random integers from 0 to 999
        Integer [] numbers = new Integer[10];
        for (int index = 0; index < 10; index++)
        {
            numbers[index] = generator.nextInt(1000);
        }
        // Create an array containing 10 random strings of length 3
        String [] words = new String[10];
        for (int index = 0; index < 10; index++)
        {
            words[index] = Helper.makeRandomWord(3, generator);
        }

        // Show the contents of the random arrays
        System.out.println("Initial numbers: " + Helper.arrayToString(numbers));
        System.out.println("Initial words: " + Helper.arrayToString(words));


        // Count how many items are "larger" than the user's chosen values
        int numsBigger = Helper.countLarger(numbers, numValue);
        int wordsLater = Helper.countLarger(words, wordChoice);

        System.out.println("There are " + numsBigger + " numbers in the list "
                          + " that are larger than your number: " + numValue);
        System.out.println("There are " + wordsLater + " words in the list "
                          + " that are larger than your word: " + wordChoice);
    }
}