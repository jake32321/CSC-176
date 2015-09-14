/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zarkaniantester;

/**
 *
 * @author Jacob
 */
public class InvalidCharacterException extends RuntimeException {

    /**
     * Creates a new instance of <code>InvalidCharacterException</code> without
     * detail message.
     */
    public InvalidCharacterException() {
    }

    /**
     * Constructs an instance of <code>InvalidCharacterException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidCharacterException(String msg) {
        super(msg);
    }
}
