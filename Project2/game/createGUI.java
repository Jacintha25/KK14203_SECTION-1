package game;

import java.awt.Color;//package for color
import java.awt.Container;
import java.awt.Font;//package for font
import java.awt.GridLayout;//to use grid layout

//package for swing
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import game.GAME.ChoiceHandler;

public class createGUI {
	
	JFrame window;//for window
	Container con;
	JPanel titleNamePanel, journeyButtonPanel, mainTextPanel, choiceButtonPanel, playerInfoPanel;
	JLabel titleNameLabel, titleNameLabel2, hpLabel, hpLabelNum, weaponLabel, weaponLabelName;
	Font titleFont = new Font("Times New Roman", Font.CENTER_BASELINE, 70);// set the font styles and font size
	Font titleFont2 = new Font("Times New Roman", Font.CENTER_BASELINE, 30);
	Font titleFont3 = new Font("Times New Roman", Font.CENTER_BASELINE, 23); 
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	
	public void createGUI(ChoiceHandler cHandler) {
		
		//FOR WINDOW
		window = new JFrame();//initialization
		window.setSize(750, 500);//(width,height)
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// so the window can close "X" button yg merah2 tu
		window.getContentPane().setBackground(Color.PINK);
		window.setLayout(null);// using no layout managers or can customize the layout
		con = window.getContentPane();
		
		//FOR TITLE SCREEN
		titleNamePanel = new JPanel(); 
		titleNamePanel.setBounds(70, 80, 600, 200); 
		titleNamePanel.setBackground(Color.PINK);
		titleNameLabel = new JLabel("PRISON BREAK");
		titleNameLabel2 = new JLabel("- CHOOSE YOUR PATH -");
		titleNameLabel.setForeground(Color.BLACK);// set the font color
		titleNameLabel2.setForeground(Color.BLACK);
		titleNameLabel.setFont(titleFont);// call the title font
		titleNameLabel2.setFont(titleFont2);
		
		journeyButtonPanel = new JPanel();
		journeyButtonPanel.setBounds(250, 300, 200, 60);
		journeyButtonPanel.setBackground(Color.PINK);
		
		startButton = new JButton("LET'S GO");
		startButton.setBackground(Color.PINK);
		startButton.setForeground(Color.BLACK);
		startButton.setFont(titleFont3);
		startButton.addActionListener(cHandler);// if we click the start button, than this function will react = the TitleScreenHandler will activated
		startButton.setActionCommand("start");
		startButton.setFocusPainted(false);// supaya tidak lagi nampak line time click button
		
		titleNamePanel.add(titleNameLabel);
		titleNamePanel.add(titleNameLabel2);
		journeyButtonPanel.add(startButton);
		
		con.add(titleNamePanel);// add title name in the container
		con.add(journeyButtonPanel);// add the button panel
		
		//FOR GAME SCREEN
		titleNamePanel.setVisible(false);
		journeyButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(40, 80, 600, 200);
		mainTextPanel.setBackground(Color.PINK);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea("these is the main test area");
		mainTextArea.setBounds(40, 80, 550, 200);
		mainTextArea.setBackground(Color.PINK);
		mainTextArea.setForeground(Color.BLACK);
		mainTextArea.setFont(titleFont3);
		mainTextArea.setLineWrap(true);// convenient function to have( automatically lock text if write too much)
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(240, 280, 300, 150);
		choiceButtonPanel.setBackground(Color.PINK);
		choiceButtonPanel.setLayout(new GridLayout(4,1));// to set the choice buttons horizontally
		con.add(choiceButtonPanel);
		
		choice1 = new JButton("CHOICE 1");
		choice1.setBackground(Color.PINK);
		choice1.setForeground(Color.BLACK);
		choice1.setFont(titleFont3);
		choice1.setFocusPainted(false);
		choice1.addActionListener(cHandler);
		choice1.setActionCommand("c1");//to differentiate between the title button and these 4 choice buttons
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton("CHOICE 2");
		choice2.setBackground(Color.PINK);
		choice2.setForeground(Color.BLACK);
		choice2.setFont(titleFont3);
		choice2.setFocusPainted(false);
		choice2.addActionListener(cHandler);
		choice2.setActionCommand("c2");//to differentiate between the title button and these 4 choice buttons
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("CHOICE 3");
		choice3.setBackground(Color.PINK);
		choice3.setForeground(Color.BLACK);
		choice3.setFont(titleFont3);
		choice3.setFocusPainted(false);
		choice3.addActionListener(cHandler);
		choice3.setActionCommand("c3");//to differentiate between the title button and these 4 choice buttons
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("CHOICE 4");
		choice4.setBackground(Color.PINK);
		choice4.setForeground(Color.BLACK);
		choice4.setFont(titleFont3);
		choice4.setFocusPainted(false);
		choice4.addActionListener(cHandler);
		choice4.setActionCommand("c4");//to differentiate between the title button and these 4 choice buttons
		choiceButtonPanel.add(choice4);

		playerInfoPanel = new JPanel();
		playerInfoPanel.setBounds(80, 15, 600, 50);
		playerInfoPanel.setBackground(Color.PINK);
		playerInfoPanel.setLayout(new GridLayout(1,4)); //custom layout
		con.add(playerInfoPanel);
		 
		hpLabel = new JLabel("HP: ");
		hpLabel.setFont(titleFont3);
		hpLabel.setForeground(Color.BLACK);
		playerInfoPanel.add(hpLabel); 
		
		hpLabelNum = new JLabel();
		hpLabelNum.setFont(titleFont3);
		hpLabelNum.setForeground(Color.BLACK);
		playerInfoPanel.add(hpLabelNum);
		
		weaponLabel = new JLabel("Weapon: ");
		weaponLabel.setFont(titleFont3);
		weaponLabel.setForeground(Color.BLACK);
		playerInfoPanel.add(weaponLabel);
		
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(titleFont3);
		weaponLabelName.setForeground(Color.BLACK);
		playerInfoPanel.add(weaponLabelName);
		
		
		window.setVisible(true);// can show the window
	}

}
