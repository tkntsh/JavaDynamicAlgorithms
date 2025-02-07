/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Question2 
{
    //method to figure out change required
    public static long Question2(int coin[], int num, int sumOf)
    {
        long tables[] = new long[sumOf + 1];
        //Initializing all table vaules as 0
        Arrays.fill(tables,0);
        
        //initializing table base case
        tables[0] = 1;
        
        //for loop to update the table (checking which index is greater than or equal to)
        for(int i = 0; i < num; i++)
        {
            for(int x = coin[i]; x <= sumOf; x++)
            {
                tables[x] += tables[x-coin[i]];
            }
        }
        //returning the value of the picked coin
        return tables[sumOf];
    }
    
    public static void main(String[] args)
    {
        try
        {
            //new scanner to process the csv file
            Scanner scFile = new Scanner(new File("C:/Users/27614/Desktop/TK - learning/UWC/3yr bsc com/2nd year/CSC211 S1/pracs/prac2semester2Q2/src/Entities/juice.csv"));
            //skips comment in file
            scFile.nextLine();
            
            int bill = 0;
            int tipAmount = 0;
            int amountReceived = 0;
            
            String line = "";
            
            //loop will run while the file has a next line
            while(scFile.hasNext())
            {
                //storing all the data in the first line into a string variable
                line = scFile.nextLine();
                //spliting the content up in the file using the delimiter ";"
                Scanner scLine = new Scanner(line).useDelimiter(";");
                
                //storing the data from the file into the following variables
                bill = scLine.nextInt();
                tipAmount = scLine.nextInt();
                amountReceived = scLine.nextInt();
                
                //creating an array to store the variables
                int[] amountArr = new int[]{bill, tipAmount, amountReceived};
                
                //outputing the content of the file
                System.out.println("Input:\tR" + bill + " (bill)"
                        + "\n" + "\t" + "\t" + tipAmount + " (tip amount)"
                                + "\n" + "\t" + "\t" + amountReceived + " (amount received)");
                scLine.close();
                
                int finalAmount = bill + tipAmount;
                int customerRequires = amountReceived = finalAmount;
                int[] denom = {1,2,5,10,20,50,100,200};
                int denomY = denom.length;
                int numOfWays = customerRequires;
                
                //outputing the change
                System.out.println("The final amount to pay is R" + finalAmount 
                        + "\n" + "\t" + "\tThe customer requires R" + customerRequires
                        + "\n" + "\t" + "\tThe number of ways to make the change of R" + customerRequires 
                        + " is " + Question2(denom,denomY,numOfWays));
            }
            scFile.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found - check path");
        }
    }
}
