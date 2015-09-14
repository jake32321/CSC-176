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
public class Smelly extends Kartusian {
    
private int noses;
private int[] arms = new int[4];
    
public Smelly(int e, int n)
{
    super(e);
    noses = n;
    for(int index = 0; index<arms.length; index++)
    {
        arms[index] = 1;
    }
}

public int getNoses()
{
    return noses;
}

public void birthday()
{
    increaseAge();
    noses = getNoses()*2;
    for(int index = 0; index<arms.length; index++)
    {
        arms[index] = getArmLength(index)+getAge();
    }
}

public String toString()
{
    return super.toString()+"\nNoses: "+getNoses();
}
}
