/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kartutester;

import java.util.Random;

/**
 *
 * @author Jacob Reed
 */
public class Kartusian {
    
private int age = 0;
private int eyes;
private int[] arms = new int[4];
Random gen = new Random();

public Kartusian(int e)
{
   eyes = e;
   for(int index = 0; index < arms.length; index++)
   {
       arms[index] = gen.nextInt(6)+1;
   }
}

public void birthday()
{
    age = age+1;
    eyes = eyes*3;
    for(int index = 0; index<arms.length; index++)
    {
        arms[index] = getArmLength(index)+age;
    }
}

public int getArmLength(int k)
{
  return arms[k];
}

public void growArm(int k, int amt)
{
    arms[k] = getArmLength(k) + amt;
}

public void increaseAge()
{
    age = age+1;
}

public int getAge()
{
    return age;
}

public int getEyes()
{
    return eyes;
}

public String toString()
{
    return "\nAge: "+getAge()+"\nEyes: "+getEyes()+"\nArm #1: "+
            getArmLength(0)+"\nArm #2: "+getArmLength(1)+"\nArm #3: "+
            getArmLength(2)+"\nArm #4: "+getArmLength(3);
}
    
}
