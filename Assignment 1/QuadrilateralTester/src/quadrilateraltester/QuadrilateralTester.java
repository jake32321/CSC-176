/*
 * To change this license header, choose License 
 * Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quadrilateraltester;

import java.util.Scanner;

/**
 *
 * @author Jacob Reed
 */
public abstract class QuadrilateralTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        Quadrilateral q = new Quadrilateral(1.1,1.2,6.6,2.8,
                6.2,9.9,2.2,7.4);
        System.out.println(q.toString());
        System.out.println("   ");
        Quadrilateral t = new Trapezoid(0.0,0.0,10.0,0.0,
                8.0,5.0,3.3,5.0);
        System.out.println(t.toString());
        System.out.println("   ");
        Quadrilateral p = new Parallelogram(5.0,5.0,11.0,5.0,12.0
                ,20.0,6.0,20.0);
        System.out.println(p.toString());
    }
}
