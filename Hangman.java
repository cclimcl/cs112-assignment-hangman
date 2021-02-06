/**
 *
 * @author Chiara Lim
 * @version 1.0
 * @since -DATE FINISHED-
 * Hangman.java
 *
 * This program allows a user to play Hangman with the computer.
 * --EXPLAIN THE RULES--
 * 
 */
import java.util.*;
import java.lang.*;

public class Hangman
{
    static String movieList[] = {"Star Wars: The Last Jedi","The Matrix","Avatar", "Forrest Gump", "White Chicks", "Up", "Mary Poppins Returns", "A Star Is Born", "The Lion King", "Black Panther", "Crazy Rich Asians", "Sorry To Bother You", "Ready Player One", "Christopher Robin", "Get Out", "Lady Bird"};
   /**
    * Entry point of the program
    * @param args input arguments
    */
    public static void main(String[] args)
    {
    	Scanner sc = new Scanner(System.in);
    	Random generator = new Random();


    	char[] alphabet = {'a', 'A', 'b', 'B', 'c', 'C','d', 'D','e','E','f','F','g','G','h','H',
                    		'i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P', 
                    		'q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z'};

    boolean again = true;
    while(again== true)
    {
    	int life=7;
    	boolean win = false;
    	//generates random movie from the list
    	String movie = movieList[generator.nextInt(15)+1]; 
    	//rebuild string
      	StringBuilder currentGuess = new StringBuilder(movie.length());
      	//create new movie array
      	char[] movieArray = new char[movie.length()];
    	//appends letters in movie to the movieArray
    	for(int i=0; i<movie.length(); i++)
    	{
        	char letter = movie.charAt(i);
        	if(!Character.isLetter(letter))
        		movieArray[i]=letter;
        	else
        	{
                for(int a=0; a<alphabet.length;a++)
                {
                	if(letter==alphabet[a])
                		movieArray[i]=letter;            
                }
          	}
      	}

      	// prints out the movie in * form
	    for(int i =0; i<movie.length();i++)
	    {
        	char letter = movie.charAt(i);
          	if(!Character.isLetter(letter))
            	currentGuess.append(letter);
          	else
          	{
                for(int a=0; a<alphabet.length;a++) //you use length because alphabet is an array
                {
                  	if(letter==alphabet[a])
                    	currentGuess.append("*");            
                }
          	}
      	}

      	while(life>0 && win == false)
      	{
      		//prints out movie in *** form
	        System.out.println(currentGuess);
	        System.out.println("Guess a letter!");
     	   	char guessAlphabet = sc.next().charAt(0);
          	//create a variable to check character guess
          	boolean guess = false;
          	for(int i=0; i<movieArray.length; i++)
          	{
            	if(guessAlphabet==movieArray[i])
            	{
              		currentGuess.setCharAt(i, guessAlphabet);
              		guess = true;
            	}
            	else if(Character.toUpperCase(guessAlphabet)==movieArray[i])
            	{
              		currentGuess.setCharAt(i, Character.toUpperCase(guessAlphabet));
              		guess = true;
            	}
            	else if(Character.toLowerCase(guessAlphabet)==movieArray[i])
            	{
		            currentGuess.setCharAt(i, Character.toLowerCase(guessAlphabet));
		            guess = true;
            	}
          	}
          	//check which statements to print based on whether it was a true or false guess
          	if(guess==false)
          	{
            	life--;
            	System.out.println(guessAlphabet+ " is not a letter!");
            	System.out.println("LIFE: "+ life);
          	}
          	else if(guess == true)
          	{
           		System.out.println(guessAlphabet+ " is a letter!");
            	System.out.println("LIFE: "+ life);
          	}
          	//to check if user has all characters right
          	for(int i=0; i<movieArray.length;i++)
          	{
              	if(currentGuess.charAt(i)=='*')
              	{ 
                  	win = false;
                  	break; //breaks the for loop
              	}
              	else
                  	win = true;
          	}
        }

		if(win == false)
      	{
		    System.out.println("You lost!");
		    System.out.println("The movie was: "+ movie);
      	}
      	else
      	{
      		System.out.println("You won!");
        	System.out.println("The movie was: "+ movie);
      	}

    	// ask user if he wants to play again
    	System.out.println("Do you want to play again? (0 for No and 1 for Yes)");
    	int answer = sc.nextInt();
    	if(answer!=1)
    	{
      		System.out.println("Thank you for playing!");
      		again=false;
    	}
    }
    }  
}