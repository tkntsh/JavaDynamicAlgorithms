/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Question3 
{
    //method to find minimun distance
    public static int Question3(int min, int min2, int min3)
    {
        //if and else statements to check which component is the minimum
        if(min <= min2 && min <= min3)
        {
            return min;
        }
        
        if(min2 <= min && min2 <= min3)
        {
            return min2;
        }
        
        else
        {
            return min3;
        }
    }
    
    //method to check the edit distance between two strings
    public static int editDistance(String first, String second, int no1, int no2)
    {
        //storing results of subproblems
        int subProb[][] = new int[no1+1][no2+1];
        
        //filling subProb array from bottom up
        for(int i = 0; i <= no1; i++)
        {
            for(int x = 0; x <= no2; x++)
            {
                //checking if first string is empty
                if(i == 0)
                {
                    subProb[i][x] = x;
                }
                
                //checking if second string is empty
                else if(x == 0)
                {
                    subProb[i][x] = i;
                }
                
                //checking if last characters are the same
                else if(first.charAt(i-1) == second.charAt(x-1))
                {
                    subProb[i][x] = subProb[i-1][x-1];
                }
                
                //checking to find the min, if the last two characters are the same
                else
                {
                    //inserting, removing, and replacing
                    subProb[i][x] = 1 + Question3(subProb[i][x-1], subProb[i-1][x], subProb[i-1][x-1]);
                }
            }
        }
        return subProb[no1][no2];
    }
    
    public static void main(String[] args)
    {
        //welcome the user and ask for their name
        System.out.println("Welcome. Please enter your name: ");
        Scanner inputName = new Scanner(System.in);
        String username = inputName.nextLine();
        username = username + ".txt";
        
        //try and catch statement to create a txt file
        try
        {
            File userTxt = new File(username);
            userTxt.createNewFile();
        }
        catch(IOException e)
        {
            //if file couldnt be created error displayed
            System.out.println("Error - Couldn't create file");
        }
        
        //round categories
        String round = "";
        String round1 = "Animal";
        String round2 = "Football";
        String round3 = "Clothing Brands";
        String round4 = "Video Games";
        String round5 = "TV Shows";
        String round6 = "Actors";
        String round7 = "Actresses";
        String round8 = "Phone Brands";
        String round9 = "Microsoft Applications";
        String round10 = "US Presidents";
        
        //correct answers for different categories
        String correct = "";
        String correct1 = "mouse";
        String correct2 = "ronaldo";
        String correct3 = "nike";
        String correct4 = "fifa";
        String correct5 = "euphoria";
        String correct6 = "jason bateman";
        String correct7 = "viola davis";
        String correct8 = "iphone";
        String correct9 = "microsoft word";
        String correct10 = "george bush";
        
        //size to keep track of the number of rounds
        int size = 1;
        //int to keep track of the users score
        int finalScore = 0;
        
        //for loop that will run 10 times for the number of rounds
        for(int i = 0; i<10; i++)
        {
            //if statements to determine which round is currently being played and the correct answer to correspond
            if(size==1)
            {
                round = round1;
                correct = correct1;
            }
            if(size==2)
            {
                round = round2;
                correct = correct2;
            }
            if(size==3)
            {
                round = round3;
                correct = correct3;
            }
            if(size==4)
            {
                round = round4;
                correct = correct4;
            }
            if(size==5)
            {
                round = round5;
                correct = correct5;
            }
            if(size==6)
            {
                round = round6;
                correct = correct6;
            }
            if(size==7)
            {
                round = round7;
                correct = correct7;
            }
            if(size==8)
            {
                round = round8;
                correct = correct8;
            }
            if(size==9)
            {
                round = round9;
                correct = correct9;
            }
            if(size==10)
            {
                round = round10;
                correct = correct10;
            }
            
            //displaying first round and asking user to input their answer
            System.out.println("Round "+ size + ": " + round + "\n" + "\nAnswer 1: ");
            Scanner userInput = new Scanner(System.in);
            String input = userInput.nextLine(); 

            //checking if answer is correct
            if(input.equalsIgnoreCase(correct))
            {
                System.out.println("Correct");
                size++;
            }

            //while loop that will run 3 times or until the user guesses the right answer
            while(!(input.equalsIgnoreCase(correct)))
            {
                //telling user their answer was incorrect and increasing size to keep track of the round
                System.out.println("Incorrect -> " + editDistance(correct,input,correct.length(),input.length()));
                size++;
                //updating the users score
                finalScore = finalScore + editDistance(correct,input,correct.length(),input.length());

                //storing the users second answer
                System.out.println("Answer 2: ");
                Scanner userInput2 = new Scanner(System.in);
                String input2 = userInput2.nextLine(); 

                //checking if second answer is correct
                if(input2.equalsIgnoreCase(correct))
                {
                    System.out.println("Correct");
                    break;
                }

                //displaying the users second answer is incorrect and their score
                System.out.println("Incorrect -> " + editDistance(correct,input2,correct.length(),input2.length()));
                finalScore = finalScore + editDistance(correct,input2,correct.length(),input2.length());
                
                //asking user for their final answer
                System.out.println("Answer 3: ");
                Scanner userInput3 = new Scanner(System.in);
                String input3 = userInput3.nextLine(); 

                //checking if their third answer is correct
                if(input3.equalsIgnoreCase(correct))
                {
                    System.out.println("Correct");
                    break;
                }

                //if final answer is incorrect message below will display
                System.out.println("Incorrect -> " + editDistance(correct,input3,correct.length(),input3.length()));
                finalScore = finalScore + editDistance(correct,input3,correct.length(),input3.length());
                
                //telling user the round is over 
                System.out.println("Round Over");
                break;
            }
        }
        
        //try and catch statement to write in the txt file created to show their final score
        try
        {
            FileWriter txtFileWriter = new FileWriter(username);
            //checking if the user scored 0 points 
            if(finalScore == 0)
            {
                txtFileWriter.write("Winner!!!\n");
            }
            //displaying the users final score
            txtFileWriter.write("Your final score is: " + finalScore);
            txtFileWriter.close();
        }
        //catching error if couldn't write in the created file
        catch(IOException e)
        {
            System.out.println("Error - Couldn't write in file");
        }
    }
}
