package comparableexample;

import java.util.Random;

/*
*@author Jacob Reed
*/
public class Helper {
    
    public static String makeRandomWord(int length, Random generator)
    {
        String word = "";
        for (int index = 0; index < length; index++)
        {
            int code = 65 + generator.nextInt(26);
            word = word + (char) code;
        }
        return word;
    }

    public static String arrayToString(Comparable [] values)
    {
        String output = "";
        for (Comparable value: values)
            output = output + " " + value + " ";
        return output;
    }

    public static int countLarger(Comparable [] data, Comparable item)
    {
        int count = 0;

        for (Comparable value : data)
        {
            if (value.compareTo(item) > 0)
                count++;
        }

        return count;
    }

}