package game;

public class VisibilityManager {
	
	createGUI ui;
	
	public VisibilityManager(createGUI userInterface) {
		
		ui = userInterface;
	}
	
	public void showTitleScreen() {
		
		//TO SHOW THE TITLE SCREEN
		ui.titleNamePanel.setVisible(true);
		ui.journeyButtonPanel.setVisible(true);
		
		//HIDE THE GAME SCREEN
		ui.mainTextPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		ui.playerInfoPanel.setVisible(false);	
	}
	public void prison() {
		//TO HIDE THE TITLE SCREEN
		ui.titleNamePanel.setVisible(false);
		ui.journeyButtonPanel.setVisible(false);
				
		//SHOW THE GAME SCREEN
		ui.mainTextPanel.setVisible(true);
		ui.choiceButtonPanel.setVisible(true);
		ui.playerInfoPanel.setVisible(true);	
	}
	

}
