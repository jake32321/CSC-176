/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zarkaniantester;

/**
 *
 * @author Jacob Reed
 */
public class Zarkanian {
    
    private String name;
    
    public Zarkanian(String s)
    {
        if(s.length() > 5)
            throw new NameTooLongException("Too many characters!");
        else if(s.contains("r")||s.contains("R"))
            throw new InvalidCharacterException("Character 'R' is not allowed!");
        else
            name = s;
    }
    
    public String toString()
    {
        return "Zarkanian ["+name+"] ";
    }
}
