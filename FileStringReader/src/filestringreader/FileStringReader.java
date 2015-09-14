/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filestringreader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Jacob Reed
 */
public class FileStringReader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
       
        String fileName, word;
        Scanner keyIn = new Scanner(System.in);
        boolean success = false;
        
        while(!success)
        {
            try
            {
                System.out.println("Please entere a file name: ");
                fileName = keyIn.next();

                FileReader fileIn = new FileReader(fileName);
                Scanner in = new Scanner(fileIn);

                word = in.nextLine();
                System.out.println("The file contains this string: "+word);
                in.close();
            }
            catch(FileNotFoundException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
}
