 /*
 *  File Name: ManaRegen.java
 *  Program Name: Grid
 *  Author: Emily Schwartz
 *  Email:  ecs03300@ccv.vsc.edu
 *  Course: CCV introduction to Java,
 *  Assignment: FinalProject
 *  Date: 5/7/22
 *  Last Modified 5/7/22
    Open source for non commercial use with attribution. 
*/
public class ManaRegen extends Thread{

	private  int  mp5;
	private Interface frame;

	//constructor
	
	public ManaRegen(Interface frame) {
		 super();
		 this.frame = frame;

		 mp5 = 80;  //mana regen per 5 seconds 
	}

	@Override
	public void run() {

		while(frame.gameRunning) {

			try
			{
			    Thread.sleep(5000);  //pauses for 5s
			}
			catch(InterruptedException ex)
			{

			}

			if ((frame.manaBar.getValue() + mp5) < 300) {
			frame.manaBar.setValue(frame.manaBar.getValue() + mp5);
			System.out.println("+ mana");
			}

			else {
				frame.manaBar.setValue(300);
				System.out.println("+ mana");
			}


		}
	}
}
