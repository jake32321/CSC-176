/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kartutester;

/**
 *
 * @author Jacob Reed
 */
public abstract class KartuTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Kartusian mike = new Kartusian(2);
        Kartusian ike = new Smelly(5,3);
        System.out.println(ike.toString());
        System.out.println(mike.toString());
        
        mike.birthday();
        mike.birthday();
        mike.birthday();
        mike.birthday();
        mike.birthday();
        
        ike.birthday();
        ike.birthday();
        ike.birthday();
        ike.birthday();
        ike.birthday();
        
        System.out.println(ike.toString());
        System.out.println(mike.toString());
    }
    
}
