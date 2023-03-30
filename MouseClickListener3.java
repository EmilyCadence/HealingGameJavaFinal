 /*
 *  File Name: MouseClickListener3.java
 *  Program Name: Grid
 *  Author: Emily Schwartz
 *  Email:  ecs03300@ccv.vsc.edu
 *  Course: CCV introduction to Java,
 *  Assignment: FinalProject
 *  Date: 5/7/22
 *  Last Modified 5/7/22
    Open source for non commercial use with attribution. 
*/
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClickListener3 extends MouseAdapter {

	private  Interface frame;

	//constructor
	
	public MouseClickListener3(Interface frame) {
		 super();
		 this.frame = frame;
	}


	@Override
	public void mouseClicked(MouseEvent e){

		frame.castBar3();

    }

	}

