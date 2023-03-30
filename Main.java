 /*
 *  File Name: Main.java
 *  Program Name: Healing Grid
 *  Author: Emily Schwartz
 *  Email:  ecs03300@ccv.vsc.edu
 *  Course: CCV introduction to Java,
 *  Assignment: FinalProject
 *  Date: 5/7/22
 *  Last Modified 5/7/22
 *  Open source for non commercial use with attribution. 
 * 	  
 * 
 *  description:
 *
 *  healing game inspired by grid/healbot addons from world of warcraft.
 *  
 *  Press start button, and click green bars to heal.  Don't let your party die, and be
 *  efficient with mana so you don't run out. 
 *  
 *  Main function and entry point to Interface.Java.
 *  
 *  Uses interface built in Jframe.  Program runs out of Interface.Java.
 *  and several worker threads using multithreading. 
 * 
 *  
 *  I generally got this working and mostly debugged. 
 *  
 *  Known issues: 
 *  Needs code to start/stop tracking score when game is over.
 *  code that does math to subtract overheal from score, is not fully implemented. 
 *  
 *  Things I would have liked to have implemented:  Multiple healing spells.  Maybe a
 *  Dispel mechanic.    I mostly need to work out how to do the mouse button listeners for different buttons,
 *  or mouse key combinations.   
 *  
 *  Some code is probably redundant.  This is my first time implementing a GUI, or JFrame so I stuck with what
 *  was getting the job done to get this up and running.   I am not sure I need the 4 cast bar or 4 mouse listener 
 *  classes.
 *   
 *  This took over 1000 lines of code in 2 days to get working so some of its is quick and dirty to get this working 
 *  as proof of concept.  Its probably a project I will play with some more. 
 *  
 *  This video was key for understanding how to get the constructor set up right and to instantiate the listeners,
 *  in a separate class file.  Nothing else I found seemed to address that.   That was the breakthrough that was the difference
 *  between scraping this this morning, and doing something else and getting this working.  
 *  
 *  https://www.youtube.com/watch?v=bTaJKm43KGs
 *  
 *  
 *
*/

public class Main{
	
public static void main(String[] args) {

	// I did not get around to using any overloaded methods.  All an overloaded method is is multiple methods of the same name,
	// but with parameters of different types.  The type of parameter we pass in determines which one is called.  So we could do something
	// like 2 methods of the same name.  In one if we pass in a string we print the string.   If we pass in a double, we print it formated 
	// as currency.  
	
	 String[] instructions = new String[] {   //added this in to demonstrate that I know how to do arrays 
			 
			 "Healing Grid",
			 "Instructions: ",
			 "Press start to begin",
			 "Click green health bars to heal",
			 "Don't let your party die",
			 "Use your mana carefully"
	 };
	 
	   //print instructions to console
	 
	   System.out.println(instructions[1].toUpperCase());  //demonstrating use of string method to upper case and accessing array index.  
	   
	   //i = 1 skip first array index.
	 
	   for (int i = 1; i < instructions.length; i++ ) {  //added to demonstrate that I know how to do for loops. 
		
		   System.out.println(instructions[i]); 
		   
	   }

	   new Interface();  //runner class.  

   

}
}