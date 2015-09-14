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
public class NameTooLongException extends RuntimeException {

    /**
     * Creates a new instance of <code>NameTooLongException</code> without
     * detail message.
     */
    public NameTooLongException() {
    }

    /**
     * Constructs an instance of <code>NameTooLongException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NameTooLongException(String msg) {
        super(msg);
    }
}
