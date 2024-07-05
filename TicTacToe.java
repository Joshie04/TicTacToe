import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class TicTacToe extends JFrame implements ActionListener {

	//Variables 
	Random generate = new Random();
	JButton[] buttons = new JButton[9];;
	JPanel buttonPanel;
	JPanel titlePanel;
	JLabel textBox;
	ImageIcon iconLogo, resizedIcon;
	boolean player_turn;
	JLabel iconLabel;
	JTextField textField;
	int x_score, o_score;
	int a,b,c;
	
	//Constructor 
	TicTacToe()	{
		//JFrame
		//Setting the up the frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200,1000);
		this.getContentPane().setBackground(new Color(255,255,255));
		this.setLayout(new BorderLayout());
		this.setTitle("Tic-Tac-Toe");
		
		//Setting the Logo of the window
		iconLogo = new ImageIcon("TicTacToe Logo.png");
		
		//Setting up the text box background
		textBox = new JLabel();
		textBox.setBackground(new Color(255,0,0));
		textBox.setForeground(new Color(0,255,255));
		textBox.setFont(new Font("Ink Free", Font.BOLD, 65));
		textBox.setHorizontalAlignment(JLabel.CENTER);
		textBox.setText("Tic-Tac-Toe Game");
		textBox.setOpaque(true);
		

		//Setting up the title text box
		titlePanel = new JPanel();
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0,0,1200,200);
		titlePanel.add(textBox);

		
		//Making the X and O inside the boxes
		gridBoard();
		
		//JFrame
		this.add(buttonPanel);
		this.setIconImage(iconLogo.getImage());
		this.add(titlePanel, BorderLayout.SOUTH);
		this.setVisible(true);
		
		
		//Showing the user information
		messagePlayer();
		
		//calling the method firstTurn 
		firstTurn();
		
	}
	
	
	//Setting up the button to click
	public void gridBoard() {
		//Setting up the grid button where the x and o will be place on
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3,3));
		buttonPanel.setBackground(new Color(200,250,200));
		
		for(int i=0; i<9; i++) {
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setBackground(Color.BLACK);
			buttons[i].setFont(new Font("Ink Free",Font.BOLD, 160));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
	}
	
	
	
	//O - Player 1
	//X - Player 2
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<9; i++) {
			if(e.getSource()==buttons[i]) {
				if(player_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						player_turn=false;
						textBox.setText("Player 1 turn - O");	
						checkResult();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						player_turn=true;
						textBox.setText("Player 2 turn - X");	
						checkResult();
					}
				}
			
			}
		}	

	}

	
	public void messagePlayer() {
		JOptionPane.showMessageDialog(null, "O - Player 1\r\n" + "X - Player 2", "Title goes here", JOptionPane.PLAIN_MESSAGE);
	
	}
	
	//Find who will take the for turn
	public void firstTurn() {
		//Asking the user to guess the number 0 to 1
		String inputUser = null;
		inputUser = JOptionPane.showInputDialog("Guess the Number between 0 and 1");
		int inputNum = Integer.parseInt(inputUser);
		
		
		//This will check if the user guessed the number correct
		if(generate.nextInt(2) == inputNum) {
			player_turn=true; 
			textBox.setText("Player 2 turn - X");
		}
		else {
			player_turn=false; 
			textBox.setText("Player 1 turn - O");
		}
	}
	
	public void keepPlaying() {
		int answer = JOptionPane.showConfirmDialog(null, "Play Again", "KEEP PLAYING", JOptionPane.YES_NO_CANCEL_OPTION);
		if(answer == 0) {
			reset_board();
		}
		else if(answer == 1) {
			textBox.setText("Thank you for Playing!!!");
		}
		else if(answer == 2) {
			textBox.setText("GOODBYE!");
		}
	}
	
	
	//This will check the result if who won the game
	public void checkResult() {
		//check the X win combinations
		if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X") ) {
			x_Wins(0,1,2);	//this is the one of the combination of X might win
		}
		if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X") ) {
			x_Wins(3,4,5);	//this is the one of the combination of X might win
		}
		if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X") ) {
			x_Wins(6,7,8);	//this is the one of the combination of X might win
		}
		if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X") ) {
			x_Wins(0,3,6);	//this is the one of the combination of X might win
		}
		if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X") ) {
			x_Wins(1,4,7);	//this is the one of the combination of X might win
		}
		if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X") ) {
			x_Wins(2,5,8);	//this is the one of the combination of X might win
		}
		if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X") ) {
			x_Wins(0,4,8);	//this is the one of the combination of X might win
		}
		if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X") ) {
			x_Wins(2,4,6);	//this is the one of the combination of X might win
		}
		
		
		//Check the O win combinations
		if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O") ) {
			o_Wins(0,1,2);	//this is the one of the combination of O might win
		}
		if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O") ) {
			o_Wins(3,4,5);	//this is the one of the combination of O might win
		}
		if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O") ) {
			o_Wins(6,7,8);	//this is the one of the combination of O might win
		}
		if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O") ) {
			o_Wins(0,3,6);	//this is the one of the combination of O might win
		}
		if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O") ) {
			o_Wins(1,4,7);	//this is the one of the combination of O might win
		}
		if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O") ) {
			o_Wins(2,5,8);	//this is the one of the combination of O might win
		}
		if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O") ) {
			o_Wins(0,4,8);	//this is the one of the combination of O might win
		}
		if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O") ) {
			o_Wins(2,4,6);	//this is the one of the combination of O might win
		}
		
		//Check there is no winner
		if(
				(buttons[0].getText()!="") &&
				(buttons[1].getText()!="") &&
				(buttons[2].getText()!="") &&
				(buttons[3].getText()!="") &&
				(buttons[4].getText()!="") &&
				(buttons[5].getText()!="") &&
				(buttons[6].getText()!="") &&
				(buttons[7].getText()!="") &&
				(buttons[8].getText()!="") 
				) {
			draw();
		}
	}
	
	
	//Setting up a reset button 
	public void reset_board() {
		this.remove(buttonPanel);
		this.add(buttonPanel = new JPanel());
		
		buttonPanel.setLayout(new GridLayout(3,3));
		buttonPanel.setBackground(new Color(200,250,200));
		
		for(int i=0; i<9; i++) {
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setBackground(Color.BLACK);
			buttons[i].setFont(new Font("Ink Free",Font.BOLD, 160));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		firstTurn();
	}
	
	
	
	//Here we will create 2 method for the checkResult to determine who the winner is 
	//One method is check o if it wins the game
	public void o_Wins(int x, int y, int z) {
		buttons[x].setBackground(new Color(0,255,0));
		buttons[y].setBackground(new Color(0,255,0));
		buttons[z].setBackground(new Color(0,255,0));
		
		for(int i=0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
		
		textBox.setText(" O Wins this round");
		
		
		try {
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		o_WinsGame();
		
	}
	
	//This will determine if O user wins the game and reset
	public void o_WinsGame() {

		o_score++;
		if(o_score ==2) {
			textBox.setText("Player 1 WINS best 2 OUT of 3");
			
			//Ask the user if want to play again
			keepPlaying();
		}
		else {
			reset_board();
		}
	}
	
	
	
	//This is the second method to check if x wins the game
	public void x_Wins(int x, int y, int z) {
		buttons[x].setBackground(new Color(0,255,0));
		buttons[y].setBackground(new Color(0,255,0));
		buttons[z].setBackground(new Color(0,255,0));
	
		for(int i=0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
		
		textBox.setText("X Wins this round");
		
		
		try {
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		x_WinsGame();
	}
	
	//This will determine if X user wins the and reset
	public void x_WinsGame() {
		
		x_score++;
		if(x_score ==2) {
			textBox.setText("Player 2 WINS best 2 OUT of 3");
			
			//Ask the user if want to play again
			keepPlaying();
		}
		else {
			reset_board();
		}
	}
	
	
	//This is a method if the is no winner
	public void draw() { 
		
		for(int i=0; i<9; i++) {
			buttons[i].setBackground(new Color(255,0,0));
			buttons[i].setEnabled(false);
		}
		textBox.setText("DRAW");
		
		reset_board();
	}
	
}
