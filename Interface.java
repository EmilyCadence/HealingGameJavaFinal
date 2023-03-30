 /*
 *  File Name: Interface.java
 *  Program Name: Grid
 *  Author: Emily Schwartz
 *  Email:  ecs03300@ccv.vsc.edu
 *  Course: CCV introduction to Java,
 *  Assignment: FinalProject
 *  Date: 5/7/22
 *  Last Modified 5/7/22
    Open source for non commercial use with attribution. 
*/

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.WindowConstants;

public class Interface extends JFrame   {

	//member variables
	//ideally some of these variables would come from their own classes.
	//But I am writing this with limited time, and goal is to just make this work.


	 private int castPercent;
	 private int playerscore;
	 private int playermana;
	 private final int healAmount = 10;
	 public boolean gameRunning;

	 private boolean isCasting = false;


	//class instances

	JFrame frame;
	JButton button;
	JLabel score;
	JProgressBar healthBar;
	JProgressBar healthBar2;
	JProgressBar healthBar3;
	JProgressBar healthBar4;
	JProgressBar castBar;
	JProgressBar manaBar;


	//Constructor for GUI

	public Interface() {

		  frame = new JFrame();  //creates panel object
		  button = new JButton ("Start");
		  score = new JLabel("Score");
		  healthBar = new JProgressBar(0,100);
		  healthBar2 = new JProgressBar(0,100);
		  healthBar3 = new JProgressBar(0,100);
		  healthBar4 = new JProgressBar(0,100);
		  castBar = new JProgressBar(0, 100);
		  manaBar = new JProgressBar(0,300);
		  gameRunning = false;

		//initializes some of our member values

		  playermana = 300;
		  playerscore = 0;

		//JFrame configuration stuff

		frame.setSize(500,500); //size of frame in pixles 
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setTitle("Press Start then click green bars to play");   //sets title
		frame.setVisible(true); //makes frame visible 
		frame.setLayout(new GridLayout (4,4));  //sets layout 
		frame.add(button);
		frame.add(score);
		frame.add(healthBar);
		frame.add(healthBar2);
		frame.add(healthBar3);
		frame.add(healthBar4);
		frame.add(castBar);
		frame.add(manaBar);

		//Initialize event listener for start button

		button.addActionListener(new StartButtonListener(this));

		//health bar.
		//I presume there is probably a way if I look into it to configure this once.
		//instead of doing this 4 times here.  Like extending the class, or something
		//and creating instances for each.  But that would take time I don't have to
		//figure that out.

		//unit health bar 1

		healthBar.setStringPainted(true);
		healthBar.addMouseListener(new MouseClickListener(this));
		healthBar.setForeground(Color.green);
		healthBar.setBackground(Color.red);
		healthBar.setValue(50);

		//unit health bar 2

		healthBar2.setStringPainted(true);
		healthBar2.addMouseListener(new MouseClickListener2(this));
		healthBar2.setForeground(Color.green);
		healthBar2.setBackground(Color.red);
		healthBar2.setValue(50);

		//unit health bar 3

		healthBar3.setStringPainted(true);
		healthBar3.addMouseListener(new MouseClickListener3(this));
		healthBar3.setForeground(Color.green);
		healthBar3.setBackground(Color.red);
		healthBar3.setValue(50);

		//unit health bar 4

		healthBar4.setStringPainted(true);
		healthBar4.addMouseListener(new MouseClickListener4(this));
		healthBar4.setForeground(Color.green);
		healthBar4.setBackground(Color.red);
		healthBar4.setValue(50);

		//mana bar


		manaBar.setStringPainted(true);
		manaBar.setForeground(Color.BLUE);

		//cast bar

		castBar.setValue(castPercent);
		castBar.setForeground(Color.DARK_GRAY);
		castBar.setStringPainted(true);
		castBar.setString("Cast Bar");

	}

	//setter method for cast bar percentage value. 
	//realized its kind of redundant after implementing.
	
	public void setCastPercent(int castPercent_) {

		 castPercent = castPercent_;
		 castBar.setValue(castPercent);
	 }

	//starts worker thread for boss

	public void startBoss() {

		Boss boss = new Boss(this);

		boss.start();
	}

	//starts worker thread to handle mana regen, and mana bar. 
	
	public void startManaRegen() {

		ManaRegen Mana = new ManaRegen(this);

		Mana.start();

	}

	 //starts new worker thread to handle cast bar animation.
	 //and related function calls

	 //There are 4 versions of this to handle casts for each
	 //health bar.   Probably could simplify this but I knew I
	 //could get it working this way.

	 public void castBar() {

		 if (!isCasting && manaBar.getValue() > 7) {   //tests if out of mana, or currently casting. 
			 																//could improve this to account for spells of different costs. 
			 isCasting = true;										//or even interrupt mechanic, etc.

			 CastBar Cast = new CastBar(this);

			 Cast.start();

		 }

	 }

	 public void castBar2() {

			 if (!isCasting && manaBar.getValue() > 7) {   
				 																 
				 isCasting = true;								 
				 CastBar2 Cast2 = new CastBar2(this);

				 Cast2.start();

			 }

		 }

	 public void castBar3() {

		 if (!isCasting && manaBar.getValue() > 7) {  
			 															  
			 isCasting = true;

			 CastBar3 Cast3 = new CastBar3(this);

			 Cast3.start();

		 }

	 }

		 public void castBar4() {

			 if (!isCasting && manaBar.getValue() > 7) {  
				 															   
				 isCasting = true;

				 CastBar4 Cast4 = new CastBar4(this);

				 Cast4.start();

			 }

		 }

		//ability to start new cast worker thread is blocked when already casting.
	    //via bool value. This is called when worker is completed to free that hold
		//and allow another to be started.

		public void cancelCastHold() {

			isCasting = false;

		}

		
		//todo fix this.
		
		public int subtractOverHeal(int health, int heal) {

			return (health + heal);

		}
		//--------------------------------------------------------------------------------------------------------
		//method handles healing 
		//@param playerNumber sets which health bar the method heals.
		
		public void heal(int playerNumber) {


			playermana -= 7;

			manaBar.setValue(playermana);

			switch (playerNumber) {

			case 1:

			healCondition_1();
			break;

			case 2:

			healCondition_2();

			break;

			case 3:

			healCondition_3();

			break;

			case 4:

			healCondition_4();
			break;

			} //end switch

			score.setText("Total Healing Done = : " + playerscore);  //updates score 

		}  //end method

		//-----------------------------------------------------------

		private void healCondition_1(){

			if ((healthBar.getValue() + healAmount) > 100)
			{
				playerscore += ((healthBar.getValue() + healAmount) - 100);  //calculates score - overheal.
				healthBar.setValue(100);
			}
			else
			{
				healthBar.setValue((healthBar.getValue() + healAmount));
				playerscore += healAmount;
			}

		}

		//-----------------------------------------------------------
		private void healCondition_2() {

			if ((healthBar2.getValue() + healAmount ) > 100)
			{
				playerscore += ((healthBar2.getValue() + healAmount) - 100);  //calculates score - overheal.
				healthBar2.setValue(100);
			}

			else
			{
				healthBar2.setValue(healthBar2.getValue() + healAmount);
				playerscore += healAmount;
			}


		}

		//-----------------------------------------------------------
		private void healCondition_3() {

			if ((healthBar3.getValue() + healAmount ) > 100)
			{
				playerscore += ((healthBar3.getValue() + healAmount) - 100);  //calculates score - overheal.
				healthBar3.setValue(100);
			}

			else
			{
				healthBar3.setValue(healthBar3.getValue() + healAmount);
				playerscore += healAmount;
			}


		}
		//-----------------------------------------------------------
		private void healCondition_4() {
			if ((healthBar4.getValue() + healAmount ) > 100)
			{
				playerscore += ((healthBar4.getValue() + healAmount) - 100);  //calculates score - overheal.
				healthBar4.setValue(100);
			}

			else
			{
				healthBar4.setValue(healthBar4.getValue() + healAmount);
				playerscore += healAmount;
			}


		}
		//-----------------------------------------------------------
 }


