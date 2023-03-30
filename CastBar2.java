 /*
 *  File Name: CastBar2.java
 *  Program Name: Grid
 *  Author: Emily Schwartz
 *  Email:  ecs03300@ccv.vsc.edu
 *  Course: CCV introduction to Java,
 *  Assignment: FinalProject
 *  Date: 5/7/22
 *  Last Modified 5/7/22
    Open source for non commercial use with attribution. 
*/
public class CastBar2 extends Thread {

	private  int cast;
	private  Interface frame;

	//constructor
	
	public CastBar2(Interface frame) {
		 super();
		 this.frame = frame;
	}

	@Override
	public void run() {
		cast = 0;

		while(cast < 100) {
			frame.setCastPercent((cast));
			cast++;


			try
			{
			    Thread.sleep(10);  //pauses for 10 ms
			}
			catch(InterruptedException ex)
			{
			}

		}

		frame.heal(2);
		frame.setCastPercent(0);
		frame.cancelCastHold();
	}

}

