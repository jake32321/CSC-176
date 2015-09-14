/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gradeprocessor;

/**
 *
 * @author Jacob Reed
 */
public class Student {
    
    private int totalPnts;
    private int numTests;
    
    public void processGrade(int testGrade) throws RuntimeException
    {
        if(testGrade >= 0 && testGrade <= 100)
        {
            totalPnts = totalPnts+testGrade;
            numTests++;
        }
        else 
            throw new RuntimeException("Illegal test score: "+testGrade);
    }
    
    public int getTests()
    {
        return numTests;
    }
    
    public int totalPnts()
    {
        return totalPnts;
    }
    
    public double getAvg()
    {
        return (double) totalPnts/numTests;
    }
}
