/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Ntshangase
 * Ntokozo
 * 4123601
 * CSC212 2022 Practical 4 Term 2
 * Question1.java
 */
public class Question1 
{
    //creating array to store
    private int memo[] = new int[30+1];
    
    //default constructor
    public Question1()
    {
        for(int i = 0; i<memo.length;i++) 
        {
            memo[i] = -1;
        }
    }
    
    //calculation for catalan
    public int catalan(int n)
    {
        long tmp = 0;
        if(n<=1)
        {
            return 1;
        }
        if(memo[n] == -1 && n <= 30)
        {
            for(int i = 0; i <= n;i++)
            {
                tmp = catalan(i) * catalan(n-i-1);
            }
            memo[n] = (int) tmp;
        }
        return memo[n];
    }

    //main method
    public static void main(String[] args)
    {
        //creating object to store catalan variables
        Question1 obj = new Question1();
        
        try
        {
            //creating file and scanner to store variavles in csv file
            File file = new File("C:/Users/27614/Desktop/TK - learning/UWC/3yr bsc com/2nd year/CSC211 S1/pracs/prac2term4/src/catalan.csv");
            Scanner scan = new Scanner(file);
            
            //checking if the file has a next line
            while(scan.hasNext())
            {
                //ignoring first line as a comment
                scan.next();
                //checking if the file has further data
                while(scan.hasNextInt())
                {
                    //for loop will run 10 times to produce output for the catalan
                    for(int i = 0; i<10; i++)
                    {
                        //storing and displaying variable to be calculated
                        String x = scan.next();
                        System.out.println("Input:\t" + Integer.parseInt(x));
                        System.out.println("Output:\t" + "catalan(" + x + ") = " + obj.catalan(Integer.parseInt(x)) + "\n");
                    }
                }
            }
            //closing scanner
            scan.close();
        }
        //catching error or exception if file wasn't found
        catch(FileNotFoundException e)
        {
            //displaying error
            System.out.println("File not found - check path");
        }
        
        System.out.println("---------end of program-------");
    }
}
