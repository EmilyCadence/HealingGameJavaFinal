
/*
*  File Name: Boss.java
*  Program Name: Grid
*  Author: Emily Schwartz
*  Email:  ecs03300@ccv.vsc.edu
*  Course: CCV introduction to Java,
*  Assignment: FinalProject
*  Date: 5/7/22
*  Last Modified 5/7/22
   Open source for non commercial use with attribution. 
*/
import java.util.concurrent.ThreadLocalRandom;

public class Boss extends Thread {

	//private member variables
	
	private int slowAttack_dmg;
	private int slowAttack_castTime;
	private int fastAttack_dmg;
	private int fastAttack_castTime;
	private int AOEAttack_dmg;
	private int AOEAttack_castTime;
	private double difficultyMultiplier;
	private boolean death;

	// constructor
	private Interface frame;

	public Boss(Interface frame) {
		super();
		this.frame = frame;

		//variables for dmg 
		slowAttack_dmg = 5;
		fastAttack_dmg = 2;
		AOEAttack_dmg = 1;

		// variables for cast times
		slowAttack_castTime = 1500; // 1.5s
		fastAttack_castTime = 500; // 0.5s
		AOEAttack_castTime = 1000; // 1s;

		//scales difficulty increases by .01 each attack. 
		
		difficultyMultiplier = .01;  

		death = false;

	}
	// ----------------------------------------------------------------------------
	
	@Override
	public void run() {

		try {
			Thread.sleep(1000); // pauses for 1s
		} catch (InterruptedException ex) {
		}

		// generate some random numbers for our attacks

		while (!death) {
			
			//rng stuff
			
			int randomUnit = ThreadLocalRandom.current().nextInt(1, 4 + 1);

			int randomAbility = ThreadLocalRandom.current().nextInt(1, 3 + 1);

			

	// ----------------------------------------------------------------------------
			//randomly chooses 1 of 3 attacks 
			//sets delay based on desired cast time of each attack 
			//@param randomAbility
			//RNG to choose from the 3 attacks. 
			
			switch (randomAbility) {
			case 1:
				try {
					Thread.sleep(1500); // pauses for 1s
				} catch (InterruptedException ex) {

				}

			 
				slowAttack(randomUnit);
				System.out.println("slow attack for " + calculateSlowAttack());

				break;

			case 2:

				try {
					Thread.sleep(1500);
				} catch (InterruptedException ex) {

				}

				fastAttack(randomUnit);
				System.out.println("fast attack for " + calculateFastAttack());
				break;

			case 3:
				try {
					Thread.sleep(1000); // pauses for 1s
				} catch (InterruptedException ex) {

				}

 
				AOEAttack(randomUnit);
				System.out.println("aoe attack for " + calculateAoeAttack());
				break;

			}

			// makes slightly more difficult after each attack.

			difficultyMultiplier += .01;

		}

		frame.gameRunning = false;   //if loop ends sets this to false so we can
													  //end game in different parts of program.
			

	}
 
	// ----------------------------------------------------------------------------
	//calculates dmg with modifier value in method to streamline this. 
	
	private int calculateSlowAttack() {

		return (int) Math.round((slowAttack_dmg + (slowAttack_dmg * difficultyMultiplier)));
	}

	// ----------------------------------------------------------------------------
	//calculates dmg with modifier value in method to streamline this. 
	
	private int calculateFastAttack() {

		return (int) Math.round((fastAttack_dmg + (fastAttack_dmg * difficultyMultiplier)));
	}

	// ----------------------------------------------------------------------------
	//calculates dmg with modifier value in method to streamline this. 
	
	private int calculateAoeAttack() {

		return (int) Math.round((AOEAttack_dmg + (AOEAttack_dmg * difficultyMultiplier)));
	}

	// ----------------------------------------------------------------------------
    // if we call slow attack.  This randomly picks one of 4 
	// units (health bars) to attack.  
    //@param RNG number between 1 and 4.  
	
	private void slowAttack(int unitNumber) {

		switch (unitNumber) {

		case 1:

			slowAttackCondition_1();

			break;

		case 2:

			slowAttackCondition_2();

			break;

		case 3:

			slowAttackCondition_3();

			break;

		case 4:

			slowAttackCondition_4();

			break;

		} // end switch

	}

	// ----------------------------------------------------------------------------
    // if we call fast attack.  This randomly picks one of 4 
	// units (health bars) to attack.  
    //@param RNG number between 1 and 4.  
	
	private void fastAttack(int unitNumber) {

		switch (unitNumber) {

		case 1:

			fastAttackCondition_1();

			break;

		case 2:

			fastAttackCondition_2();

			break;

		case 3:

			fastAttackCondition_3();

			break;

		case 4:

			fastAttackCondition_4();

			break;

		}
	}

	// ----------------------------------------------------------------------------
     // if we call area of effect attack.  This randomly picks one of 4 
      // units (health bars) to attack.  
	   //@param RNG number between 1 and 4
	
	private void AOEAttack(int unitNumber) {

		switch (unitNumber) {

		case 1:

			AOEAttackCondition_1();

			break;

		case 2:
			AOEAttackCondition_2();

			break;

		case 3:
			AOEAttackCondition_3();

			break;

		case 4:
			AOEAttackCondition_4();

			break;

		}
	}

	// methods that handle each type of attack to each unit (healthbar) 
	
	// ----------------------------------------------------------------------------
	private void slowAttackCondition_1() {

		if ((frame.healthBar.getValue() - calculateSlowAttack()) > 0) {
			frame.healthBar.setValue((frame.healthBar.getValue() - calculateSlowAttack()));
		} else {
			frame.healthBar.setValue(0);
			death = true;
			System.out.println("Party Member Died Game Over");
		}

	}

	// ----------------------------------------------------------------------------
	private void slowAttackCondition_2() {

		if ((frame.healthBar2.getValue() - calculateSlowAttack()) > 0) {
			frame.healthBar2.setValue((frame.healthBar2.getValue() - calculateSlowAttack()));
		} else {
			frame.healthBar2.setValue(0);
			death = true;
			System.out.println("Party Member Died Game Over");
		}
	}

	// ----------------------------------------------------------------------------
	private void slowAttackCondition_3() {

		if ((frame.healthBar3.getValue() - calculateSlowAttack()) > 0) {
			frame.healthBar3.setValue((frame.healthBar3.getValue() - calculateSlowAttack()));
		} else {
			frame.healthBar3.setValue(0);
			death = true;
			System.out.println("Party Member Died Game Over");
		}

	}

	// ----------------------------------------------------------------------------
	private void slowAttackCondition_4() {
		if ((frame.healthBar4.getValue() - calculateSlowAttack()) > 0) {
			frame.healthBar4.setValue((frame.healthBar4.getValue() - calculateSlowAttack()));
		} else {
			frame.healthBar4.setValue(0);
			death = true;
		}
	}

	// ----------------------------------------------------------------------------
	private void fastAttackCondition_1() {

		if ((frame.healthBar.getValue() - calculateFastAttack()) > 0) {
			frame.healthBar.setValue((frame.healthBar.getValue() - calculateFastAttack()));
		} else {

			frame.healthBar.setValue(0);
			death = true;
			System.out.println("Party Member Died Game Over");
		}
	}

	// ----------------------------------------------------------------------------
	private void fastAttackCondition_2() {

		if ((frame.healthBar2.getValue() - calculateFastAttack()) > 0) {
			frame.healthBar2.setValue((frame.healthBar2.getValue() - calculateFastAttack()));
		} else {
			frame.healthBar2.setValue(0);
			death = true;
			System.out.println("Party Member Died Game Over");
		}
	}

	// ----------------------------------------------------------------------------
	private void fastAttackCondition_3() {

		if ((frame.healthBar3.getValue() - calculateFastAttack()) > 0) {
			frame.healthBar3.setValue((frame.healthBar3.getValue() - calculateFastAttack()));
		} else {
			frame.healthBar3.setValue(0);
			death = true;
			System.out.println("Party Member Died Game Over");
		}

	}

	// ----------------------------------------------------------------------------

	private void fastAttackCondition_4() {

		if (frame.healthBar4.getValue() - calculateFastAttack() > 0) {
			frame.healthBar4.setValue((frame.healthBar4.getValue() - calculateFastAttack()));
		} else {

			frame.healthBar4.setValue(0);
			death = true;
			System.out.println("Party Member Died Game Over");
		}

	}

	// ----------------------------------------------------------------------------

	private boolean AOEDeathCheck() {

		if ((frame.healthBar.getValue() - calculateAoeAttack()) > 0) {
			return false;
		}

		else if (frame.healthBar2.getValue() - calculateAoeAttack() > 0) {
			return false;
		}

		else if (frame.healthBar3.getValue() - calculateAoeAttack() > 0) {
			return false;
		} else if (frame.healthBar4.getValue() - calculateAoeAttack() > 0) {
			return false;
		} else
			return true;

	}

	private void AOEAttackCondition_1() {
		if (!AOEDeathCheck()) {
			frame.healthBar.setValue((frame.healthBar.getValue() - calculateAoeAttack()));
			frame.healthBar2.setValue((frame.healthBar2.getValue() - calculateAoeAttack()));
			frame.healthBar3.setValue((frame.healthBar3.getValue() - calculateAoeAttack()));
			frame.healthBar4.setValue((frame.healthBar4.getValue() - calculateAoeAttack()));
		} else {
			frame.healthBar.setValue(0);
			death = true;
			System.out.println("Party Member Died Game Over");
		}
	}

	// ----------------------------------------------------------------------------

	private void AOEAttackCondition_2() {
		if (!AOEDeathCheck()) {

			frame.healthBar.setValue((frame.healthBar.getValue() - calculateAoeAttack()));
			frame.healthBar2.setValue((frame.healthBar2.getValue() - calculateAoeAttack()));
			frame.healthBar3.setValue((frame.healthBar3.getValue() - calculateAoeAttack()));
			frame.healthBar4.setValue((frame.healthBar4.getValue() - calculateAoeAttack()));
		}

		else {
			frame.healthBar2.setValue(0);
			death = true;
			System.out.println("Party Member Died Game Over");
		}
	}

	// ----------------------------------------------------------------------------
	private void AOEAttackCondition_3() {

		if (!AOEDeathCheck()) {

			frame.healthBar.setValue((frame.healthBar.getValue() - calculateAoeAttack()));
			frame.healthBar2.setValue((frame.healthBar2.getValue() - calculateAoeAttack()));
			frame.healthBar3.setValue((frame.healthBar3.getValue() - calculateAoeAttack()));
			frame.healthBar4.setValue((frame.healthBar4.getValue() - calculateAoeAttack()));
		} else {
			frame.healthBar3.setValue(0);
			death = true;
			System.out.println("Party Member Died Game Over");
		}
	}

	// ----------------------------------------------------------------------------
	private void AOEAttackCondition_4() {

		if (!AOEDeathCheck()) {
			frame.healthBar.setValue((frame.healthBar.getValue() - calculateSlowAttack()));
			frame.healthBar2.setValue((frame.healthBar2.getValue() - calculateSlowAttack()));
			frame.healthBar3.setValue((frame.healthBar3.getValue() - calculateSlowAttack()));
			frame.healthBar4.setValue((frame.healthBar4.getValue() - calculateSlowAttack()));
		} else {
			frame.healthBar4.setValue(0);
			death = true;
			System.out.println("Party Member Died Game Over");
		}
	}
}
// ----------------------------------------------------------------------------
