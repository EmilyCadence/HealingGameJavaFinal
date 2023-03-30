 /*
 *  File Name: StartButtonListener.java
 *  Program Name: Grid
 *  Author: Emily Schwartz
 *  Email:  ecs03300@ccv.vsc.edu
 *  Course: CCV introduction to Java,
 *  Assignment: FinalProject
 *  Date: 5/7/22
 *  Last Modified 5/7/22
    Open source for non commercial use with attribution. 
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButtonListener implements ActionListener   {


		private  Interface frame;

		//constructor
		
		public StartButtonListener(Interface frame) {
			 super();
			 this.frame = frame;
		}



		@Override
		public void actionPerformed(ActionEvent e){

			frame.gameRunning = true;

			frame.healthBar.setValue(100);
			frame.healthBar2.setValue(100);
			frame.healthBar3.setValue(100);
			frame.healthBar4.setValue(100);
			frame.manaBar.setValue(300);
			frame.score.setText("Score");


				frame.startBoss();
				frame.startManaRegen();



	    }

	}
