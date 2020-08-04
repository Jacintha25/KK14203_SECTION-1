package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GAME {
	
	ChoiceHandler cHandler = new ChoiceHandler();
	createGUI ui = new createGUI();
	VisibilityManager vm = new VisibilityManager(ui);//send this to class VisibilityManager
	Story story = new Story(this, ui, vm);
	
	String nextPosition1, nextPosition2, nextPosition3, nextPosition4;

	public static void main(String[] args) {
		
		new GAME();

	}
	
	public GAME() {
		
		ui.createGUI(cHandler);
		story.GAMESetup();//to call this GAMESetup
		vm.showTitleScreen();//to display title screen from class showTitleScreen
	}
	
public class ChoiceHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			String yourChoice = event.getActionCommand(); 
			
			switch (yourChoice) {
			case "start" :	vm.prison(); story.hallway(); break;
			case "c1" : story.selectPosition(nextPosition1);break;
			case "c2" : story.selectPosition(nextPosition2);break;
			case "c3" : story.selectPosition(nextPosition3);break;
			case "c4" : story.selectPosition(nextPosition4);break;
			}

		}
	}
}
