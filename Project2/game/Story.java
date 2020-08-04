package game;

import game2.OfficerAttack;
import game2.SuperOfficer;
import game2.WeaponBaton;
import game2.WeaponTaser;

public class Story { //handle all the dialogues
	
	GAME game;
	createGUI ui;
	VisibilityManager vm;
	Player player = new Player();
	SuperOfficer officer;
	
	public Story(GAME g, createGUI userInterface, VisibilityManager vManager) {
		
		game = g;
		ui = userInterface;
		vm = vManager;
	}
	
	public void GAMESetup() {
		
		player.HP = 15; 
		ui.hpLabelNum.setText("" + player.HP);
		
		player.currentWeapon = new WeaponBaton();
		ui.weaponLabelName.setText(player.currentWeapon.name);
		}
	
	public void selectPosition(String nextPosition) {
		
		switch(nextPosition) {
		case "hallway" : hallway(); break;
		case "breakWindow" : breakWindow(); break;
		case "officerRoom" : officerRoom(); break;
		case "medicRoom" : medicRoom(); break;
		case "fightOfficers" : fightOfficers(); break;
		case "gameOver" : gameOver(); break;
		case "frontGate" : frontGate(); break;
		case "emergencyExit" : emergencyExit(); break;
		case "fight" : fight(); break;
		case "playerAttack" : playerAttack(); break;
		case "officerAttack" : officerAttack(); break;
		case "WIN" : WIN(); break;
		case "DEFEAT" : DEFEAT(); break;
		case "FREEDOM" : freedom(); break;
		case "DEAD" : dead(); break;
		}
	}
	
	public void hallway() {
		ui.mainTextArea.setText("You're in the hallway.\nYou and other inmates are escaping the prison.\n\nWhat do you do?");
		ui.choice1.setText("Break the window");
		ui.choice2.setText("Go into the officer's room");
		ui.choice3.setText("Go into the Medic room ");
		ui.choice4.setText("Fight with officers");
		
		//these info tells the program where the next location is.
		game.nextPosition1 = "breakWindow";
		game.nextPosition2 = "officerRoom";
		game.nextPosition3 = "medicRoom";
		game.nextPosition4 = "fightOfficers";
	}
	public void breakWindow() {
		ui.mainTextArea.setText("The window broke.\nYou escape through the window.\n\nWhere do you go next?");
		ui.choice1.setText("Emergency exit");
		ui.choice2.setText("Front gate");
		ui.choice3.setText("Hallway");
		ui.choice4.setText("");
		
		//these info tells the program where the next location is.
		game.nextPosition1 = "emergencyExit";
		game.nextPosition2 = "frontGate";
		game.nextPosition3 = "hallway";
		game.nextPosition4 = "";
	}
	public void officerRoom() {
		ui.mainTextArea.setText("You found a taser!\n\n(Obtained taser)");
		
		player.currentWeapon = new WeaponTaser();
		ui.weaponLabelName.setText(player.currentWeapon.name);
		
		ui.choice1.setText("Go back to the hallway");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText(" ");
		
		//these info tells the program where the next location is.
		game.nextPosition1 = "hallway";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	public void medicRoom() {
		ui.mainTextArea.setText("You found an emergency kit!\nYou quickly dress your wounds.\n\n(HP recovered by 3)");
		player.HP = player.HP + 3;
		ui.hpLabelNum.setText("" + player.HP);
		ui.choice1.setText("Go back to the hallway");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText(" ");
		
		//these info tells the program where the next location is.
		game.nextPosition1 = "hallway";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	public void fightOfficers() {
		ui.mainTextArea.setText("Officer 1 : Do you think you can fight us!\nOfficer 2 : Stop being delusional.\nOfficer 3 : Catch him!\n\nYou've been caught!");
		player.HP = player.HP - player.HP ;
		ui.hpLabelNum.setText("" + player.HP);
		ui.choice1.setText("- GAME OVER -");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		//these info tells the program where the next location is.
		game.nextPosition1 = "gameOver";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	public void gameOver() {
		ui.mainTextArea.setText("PLESE CLOSE THE WINDOW AND TRY AGAIN .\n\nGOODLUCK! ^-^ ");
	}
	public void frontGate() {
		ui.mainTextArea.setText("Officer 1 : Well, what do we have here.\nOfficer 2 : It's our lucky day huh.\nOfficer 3 : Catch him!\n\nThey shot your arm.You've been caught!");
		player.HP = player.HP - player.HP ;
		ui.hpLabelNum.setText("" + player.HP);
		ui.choice1.setText("- GAME OVER -");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		//these info tells the program where the next location is.
		game.nextPosition1 = "gameOver";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	public void emergencyExit() {
		
		officer = new OfficerAttack(); //"officer" is a super class, so we put the "OfficerAttack" class in the super class
		
		ui.mainTextArea.setText("You run into an " + officer.name + "!"); 
		ui.choice1.setText("Run");
		ui.choice2.setText("Fight");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		//these info tells the program where the next location is.
		game.nextPosition1 = "breakWindow";
		game.nextPosition2 = "fight";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	public void fight() {
		
		ui.mainTextArea.setText(officer.name + " HP : " + officer.HP + "\n\nWhat do you do ?");
		ui.choice1.setText("Run");
		ui.choice2.setText("Attack");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		//these info tells the program where the next location is.
		game.nextPosition1 = "hallway";
		game.nextPosition2 = "playerAttack";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
    public void playerAttack() {
		
	    int playerDamage = 0 ;
	    
	    //to differentiate the damage based on what weapon you own
	    if(player.currentWeapon.name.equals("Baton")) {
			playerDamage = player.currentWeapon.damage;
		}
		else if (player.currentWeapon.name.equals("Taser")) {
			playerDamage = player.currentWeapon.damage;
		}
	    
		ui.mainTextArea.setText("You attack the officer and gave " + playerDamage + " damage!");
		
		officer.HP = officer.HP - playerDamage;
		
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		//need to make if-else statement to know if the officer is still alive or not
		if(officer.HP>0) {
			game.nextPosition1 = "officerAttack";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else if(officer.HP<1) {
			game.nextPosition1 = "WIN";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
    }
    public void officerAttack() {
    	
 		ui.mainTextArea.setText("The officer attack you back.\n\n(Recieved " + officer.attack + " damage)");
 		
 		player.HP = player.HP - officer.attack;
 		ui.hpLabelNum.setText("" + player.HP);
 		
 		ui.choice1.setText(">");
 		ui.choice2.setText("");
 		ui.choice3.setText("");
 		ui.choice4.setText("");
 		
 		//need to make if-else statement to know if the player is still alive or not
 		if(player.HP>0) {
 			game.nextPosition1 = "fight";
 			game.nextPosition2 = "";
 			game.nextPosition3 = "";
 			game.nextPosition4 = "";
 		}
 		else if(player.HP<1) {
 			game.nextPosition1 = "DEFEAT";
 			game.nextPosition2 = "";
 			game.nextPosition3 = "";
 			game.nextPosition4 = "";
 		}	
    }
    public void WIN() {
    	ui.mainTextArea.setText("You defeated the officer!\nThe officer dropped the key for the Emergency exit.\n\n(Obtained Key)");
    	
    	game.nextPosition1 = "FREEDOM";
    	
    	ui.choice1.setText("freedom");
    }
    public void DEFEAT() {
    	
        ui.mainTextArea.setText("You're dead!\n");
    	
    	game.nextPosition1 = "DEAD";
    	
    	ui.choice1.setText("dead");
    }
    public void freedom() {
    	ui.mainTextArea.setText("\tTHE DOOR UNLOCKED!\nCONGRATULATIONS! YOU'VE MADE YOUR WAY TO FREEDOM (^-^)/.\n\nPLESE CLOSE THE WINDOW TO EXIT");
    }
    public void dead() {
    	ui.mainTextArea.setText("YOU'VE  BEEN KILLED!\nPLESE CLOSE THE WINDOW AND TRY AGAIN .\n\nGOODLUCK! ^-^ ");
    }
}

