/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spellcheck;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import static spellcheck.SpellCheck.readWords;

/**
 *
 * @author Jake Reed
 */
public class SpellCheck {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException{
        
        Set<String> dictionaryWords = readWords("words");
        Set<String> documentWords = readWords("alice.txt");
        
        for(String word : documentWords)
        {
            if(!dictionaryWords.contains(word))
            {
                System.out.println(word);
            }
        }
    }
    
    public static Set<String> readWords(String filename)
        throws FileNotFoundException
    {
      Set<String> words = new HashSet<String>();
      Scanner in = new Scanner(new File(filename));
      
      in.useDelimiter("[^a-zA-Z]+");
      while(in.hasNext())
      {
          words.add(in.next().toLowerCase());
      }
      return words;
    }
}
