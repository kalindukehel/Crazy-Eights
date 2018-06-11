import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Window.Type;
import javax.swing.JTextPane;
//Hima, Kalindu, Shivani
///TO DO
///- Add method to check if move is valid, and when button is pressed it only moves on if true is returned for valid move
//Add list of available cards?

//GUI code

public class Crazy {

	static boolean validmove = false;
	static int turn = 0;
	static volatile boolean submit = false;
	final static CountDownLatch latch = new CountDownLatch(0);
	private JFrame frmCrazyEightsGui;
	private JFrame window;
	private JFrame about;
	private JFrame instructions;
	static int amount;

	/**
	 * Launch the application.
	 */
	static Hand[] players;
	static Pile r = new Pile();
	private JTextField textField;
	
	public static void main(String[] args) throws InterruptedException {

	;
		/**
		//Program starts
		Deck n = new Deck();
		boolean win = false
		int[][] used = new int[13][4];
		
		
		Random rand = new Random();
		for (int x = 0; x < 52; x ++) {
			int s = rand.nextInt(4);
			int v = rand.nextInt(13);
			if (used[v][s] == 0) {
				used[v][s] = 1;
				n.addcard(v+1,s+1);
			}
			else {
				x = x-1;
			}
		}

		Scanner in = new Scanner(System.in);
		System.out.println("Enter Amount of Players: ");
		amount = in.nextInt();
		in.nextLine();
		players = new Hand[amount];
		int y =0;
		for (int x = 0; x < amount; x ++) {
			System.out.println("Enter Player Name: ");
			players[x] = new Hand(in.nextLine());
			
			
			for(; y < 8*(x+1);y++) {
				int xx = n.getposition(y).value;
				int yy = n.getposition(y).suit;
				System.out.println(y);
				players[x].addcard(xx, yy);
			}

		}
		for(; y < 52; y++) {
			r.addcard(n.getposition(y).value, n.getposition(y).suit);
		}

		
		**/
		
		
		
		//PROGRAM ENDS
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crazy window = new Crazy();
					window.window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
	}

	/**
	 * Create the application.
	 */
	public Crazy() {
		//initialize();
		initialize2();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void initialize2() {
		window = new JFrame();
		window.setTitle("Crazy Eights");
		window.setBounds(100, 100, 521, 334);
		window.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(158, 175, 185, 20);
		window.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Play");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] names = textField.getText().split(",");
				
				amount = names.length;
				if (amount >= 2 && amount <= 6) {
					Deck n = new Deck();
	
	
					players = new Hand[amount];
					int[][] used = new int[13][4];
					
					
					Random rand = new Random();
					for (int x = 0; x < 52; x ++) {
						int s = rand.nextInt(4);
						int v = rand.nextInt(13);
						if (used[v][s] == 0) {
							used[v][s] = 1;
							n.addcard(v+1,s+1);
						}
						else {
							x = x-1;
						}
					}
					
					int y =0;
					for (int x = 0; x < amount; x ++) {
						players[x] = new Hand(names[x]);
						
						
						for(; y < 8*(x+1);y++) {
							int xx = n.getposition(y).value;
							int yy = n.getposition(y).suit;
							players[x].addcard(xx, yy);
						}
	
					}
					for(; y < 52; y++) {
						r.addcard(n.getposition(y).value, n.getposition(y).suit);
					}
					initialize();  //MAKE THE GAME WINDOW
					try {
						 frmCrazyEightsGui.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
					window.dispose();
			}
			}
		});
		btnNewButton.setBounds(213, 232, 89, 23);
		window.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Crazy Eights");
		lblNewLabel_4.setFont(new Font("Castellar", Font.PLAIN, 34));
		lblNewLabel_4.setBounds(99, 76, 352, 77);
		window.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Enter Names Min. 2 Max 6 ex. (Bob,Joe,Betty)");
		lblNewLabel_5.setBounds(122, 157, 256, 14);
		window.getContentPane().add(lblNewLabel_5);
		
		

	}
	public void initialize() {
		frmCrazyEightsGui = new JFrame();
		frmCrazyEightsGui.setTitle("Crazy Eights GUI");
		frmCrazyEightsGui.setAlwaysOnTop(true);
		frmCrazyEightsGui.setBounds(100, 100, 646, 511);
		frmCrazyEightsGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrazyEightsGui.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Player Turn:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(21, 11, 141, 53);
		frmCrazyEightsGui.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Your Hand:");
		lblNewLabel_1.setFont(new Font("Leelawadee UI", Font.BOLD, 31));
		lblNewLabel_1.setBounds(21, 86, 180, 46);
		frmCrazyEightsGui.getContentPane().add(lblNewLabel_1);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(21, 144, 89, 20);
		frmCrazyEightsGui.getContentPane().add(comboBox);
		comboBox.setVisible(false);
		

		
		final JLabel lblNewLabel_2 = new JLabel("None");
		lblNewLabel_2.setFont(new Font("Serif", Font.PLAIN, 36));
		lblNewLabel_2.setBounds(184, 14, 184, 40);
		frmCrazyEightsGui.getContentPane().add(lblNewLabel_2);

		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(196, 91, 209, 53);
		frmCrazyEightsGui.getContentPane().add(comboBox_1);
		
		final JLabel lblTopCard = new JLabel("Top Card");
		lblTopCard.setHorizontalAlignment(SwingConstants.CENTER);
		lblTopCard.setFont(new Font("Dialog", Font.BOLD, 29));
		lblTopCard.setBounds(49, 399, 299, 66);
		frmCrazyEightsGui.getContentPane().add(lblTopCard);
		
		final JLabel lblNewLabel_3 = new JLabel("IDLE");
		lblNewLabel_3.setForeground(new Color(255, 102, 0));
		lblNewLabel_3.setFont(new Font("Supercell-Magic", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(520, 49, 114, 21);
		frmCrazyEightsGui.getContentPane().add(lblNewLabel_3);
		
		
		final JLabel cardholder = new JLabel("New label");
		cardholder.setBounds(132, 230, 125, 182);
		final JButton btnNewButton = new JButton("PLAY");
		final JButton btnNewButton_2 = new JButton("Pick Up");
		final JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.setEnabled(false);
		btnNewButton_2.setEnabled(false);
		btnNewButton.setToolTipText("Refresh your hand");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox.removeAllItems();
				if(lblNewLabel_3.getText() == "IDLE") {
					lblNewLabel_3.setText("RUNNING");
					lblNewLabel_3.setForeground((Color.GREEN));
					btnNewButton_1.setEnabled(true);
					btnNewButton_2.setEnabled(true);
				}
				comboBox_1.removeAllItems();
				lblNewLabel_2.setText(players[turn].name);
				for(int x = 0; x< players[turn].counthand(); x++) {
					comboBox.addItem(players[turn].getposition(x).value + " " + players[turn].getposition(x).suit);

					lblTopCard.setText(convertcard(null,r.head) + " of " + convertsuit(null,r.head));
					comboBox_1.addItem(convertcard(players[turn].getposition(x),null) + " of " + convertsuit(players[turn].getposition(x),null) );
					btnNewButton.setVisible(false);
				}
				String[] n = lblTopCard.getText().split(" ");
				ImageIcon MyImage = new ImageIcon(getClass().getClassLoader().getResource("resources/"+convertname(n[0],n[2])));
				Image img = MyImage.getImage();
				Image newImg = img.getScaledInstance(cardholder.getWidth(), cardholder.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon image = new ImageIcon(newImg);
				cardholder.setIcon(image);

			}
		});
		btnNewButton.setBounds(272, 176, 100, 34);
		frmCrazyEightsGui.getContentPane().add(btnNewButton);
		final JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		final JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(447, 71, 246, 299);
		scroll.setSize(170,300);
		
		
		frmCrazyEightsGui.getContentPane().add(scroll);

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int prevturn = turn;
				pickcard();
				btnNewButton.doClick();
				if(validmove() == true) {
					textArea.append(players[prevturn].name + " drew a card\n");
				}
				else if(validmove() == false) {
					textArea.append(players[prevturn].name + "'s turn was skipped/pile empty\n");
				}
				//textArea.append(players[turn] + "picked up a card \n"); //IF
			}
		});
		btnNewButton_2.setToolTipText("Pick up a card if unable to go");
		btnNewButton_2.setBounds(31, 177, 89, 34);
		frmCrazyEightsGui.getContentPane().add(btnNewButton_2);
		
		

		

		ImageIcon MyImage = new ImageIcon(getClass().getClassLoader().getResource("resources/black_joker.png"));
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(cardholder.getWidth(), cardholder.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		cardholder.setIcon(image);

		frmCrazyEightsGui.getContentPane().add(cardholder);
		btnNewButton_1.setToolTipText("When you finish your turn click this");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] sendcard = ((String) comboBox.getItemAt(comboBox_1.getSelectedIndex())).split(" ");
				int prevturn = turn;
				placecard(sendcard,textArea);
				if(validmove() == true) {
					textArea.append(players[prevturn].name + " placed the " + convertcard(null, r.head) + " of " + convertsuit(null,r.head) + "\n");
					btnNewButton.doClick();
					
				}
				//textArea.append("Successful Move \n"); //IF

			}
		});
		btnNewButton_1.setBounds(145, 177, 100, 34);
		frmCrazyEightsGui.getContentPane().add(btnNewButton_1);

		
		
		

		

		
		
	
		

		
		JMenuBar menuBar = new JMenuBar();
		frmCrazyEightsGui.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Help");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("About");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				about();
				try {
					 about.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Instructions");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instruction();
				try {
					instructions.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		

		


	
		
	}
	
	public String convertname(String x, String y) {
		String suit = "";
		x= x.toLowerCase();
		if (x.equals("two")) {
			x = "2";
		}

		else if (x.equals("three")) {
			x = "3";
		}
		else if (x.equals("four")) {
			x = "4";
				}
		else if (x.equals("five")) {
			x = "5";
		}
		else if (x.equals("six")) {
			x= "6";
		}
		else if (x.equals("seven")) {
			x = "7";
		}
		else if (x.equals("eight")) {
			x= "8";
		}
		else if (x.equals("nine")) {
			x = "9";
		}
		else if (x.equals("ten")) {
			x = "10";
		}
		y=y.toLowerCase();
		return (x+"_of_"+y+".png");
	}
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
	
    public void about() {
		about = new JFrame();
		about.setType(Type.UTILITY);
		about.setTitle("About");
		about.setAlwaysOnTop(true);
		about.setBounds(100, 100, 392, 263);
		about.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Crazy Eights");
		lblNewLabel_6.setFont(new Font("Bodoni MT", Font.BOLD, 33));
		lblNewLabel_6.setBounds(101, 36, 191, 53);
		about.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("by: Shivani, Hima, Kalindu");
		lblNewLabel_7.setBounds(111, 112, 143, 16);
		about.getContentPane().add(lblNewLabel_7);
    }
    
    public void instruction() {
		instructions = new JFrame();
		instructions.setType(Type.UTILITY);
		instructions.setTitle("Instructions");
		instructions.setAlwaysOnTop(true);
		instructions.setBounds(100, 100, 392, 300);
		instructions.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Instructions");
		lblNewLabel_6.setFont(new Font("Bodoni MT", Font.BOLD, 33));
		lblNewLabel_6.setBounds(99, 11, 191, 53);
		instructions.getContentPane().add(lblNewLabel_6);
		
		JTextPane txtpnAV = new JTextPane();
		txtpnAV.setEditable(false);
		txtpnAV.setText("1. Play the same suit or value as the top card\r\n\r\n2. Eight can be played on any card\r\n\r\n3. Two makes next player pick up two cards\r\n\r\n4. Jack makes next player skip their turn\r\n\r\n5. If unable to go, pick up card until you can play");
		txtpnAV.setBounds(31, 83, 299, 150);
		instructions.getContentPane().add(txtpnAV);
    }
	
	public void pickcard() {
		Random rand = new Random();
		int index = rand.nextInt(r.countpile()); //Get a random index from length of pile
		if (index == 0) { //Can't get top card
			index =1;
		}
		if (r.getposition(index)!= null && r.head.link != null) { //Delete card at pile index from pile, add to player's hand
			int value = r.getposition(index).value;
			int suit = r.getposition(index).suit;
			r.deletecard(value, suit);
			players[turn].addcard(value, suit);
			validmove = true;
		}
		if(r.countpile() == 1) { //If no cards left in pile, check if unable to go
			boolean possible = false;
			for(Hand.card temp = players[turn].head; temp != null; temp = temp.link) {
				if(temp.suit == r.head.suit) {
					possible = true;
				}
				else if (temp.value == r.head.value) {
					possible = true;
				}
				else if(temp.value == 8) {
					possible = true;
				}
				validmove = false;
			}
			if (possible == false) {
				rotate();
				}
				validmove = false;
			
		}
		
	}
	public void rotate() {
		if(turn == amount -1) {
			turn = 0;
		}
		else {
			turn = turn +1;
		}
		
	}
	
	
	public void placecard(String[] x,JTextArea k) { //Player places a card on top of pile
		
		int value = Integer.parseInt(x[0]);
		int suit = Integer.parseInt(x[1]);
		
		if(value == r.head.value || suit == r.head.suit) { //Check if move is valid
			players[turn].deletecard(value, suit);
			r.addcard(value, suit);  // add card to pile
			if (players[turn].counthand() == 0) { //Check for win
				System.out.println(players[turn].name + " has won!");
				System.exit(0);
			}
			rotate();
			validmove = true;
			
		}
		if(value == 2 && validmove == true) {
			pickcard();
			pickcard();
			k.append(players[turn].name + " had to pick up two cards\n");
		}
		
		else if (value == 11 && validmove ==true) {  //Checks if card is a jack, which is a special card that skips
			k.append(players[turn].name + "'s turn was skipped\n");
			rotate();  //Adds another turn because next player's turn is skipped
			
		}
		else if (value == 8) {  //Eight can go on any card
			players[turn].deletecard(value, suit);
			r.addcard(value, suit);
			if (players[turn].counthand() == 0) { //Check for win
				System.out.println(players[turn].name + " has won!");
				System.exit(0);
			}
			rotate();
			validmove = true;
		}

		
		

	}
	
	public boolean validmove() {
		if (validmove == true) {
			validmove = false;
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public String convertsuit(Hand.card x, Pile.card y) { //Converting card to words so it's easier to understand
		int suitc;
		if(x != null) {
			suitc = x.suit;
		}
		else {
			suitc = y.suit;

		}
		
		if (suitc == 1) {
			return "Spades";
		}
		else if (suitc ==2) {
			return "Clubs";
		}
		else if (suitc == 3) {
			return "Diamonds";
		}
		else if (suitc == 4) {
			return "Hearts";
		}
		return "";

	}
	public String convertcard(Hand.card x, Pile.card y) { //Converting card to words so it's easier to understand
		int suitc;
		if(x != null) {
			suitc = x.value;	
		}

		
		else {
			suitc = y.value;
		}
		if (suitc == 1) {
			return "Ace";
		}
		else if (suitc == 2) {
			return "Two";
		}
		else if (suitc == 3) {
			return "Three";
		}
		else if (suitc == 4) {
			return "Four";
		}
		else if (suitc == 5) {
			return "Five";
		}
		else if (suitc == 6) {
			return "Six";
		}
		else if (suitc == 7) {
			return "Seven";
		}
		else if (suitc == 8) {
			return "Eight";
		}
		else if (suitc == 9) {
			return "Nine";
		}
		else if (suitc == 10) {
			return "Ten";
		}
		else if (suitc == 11) {
			return "Jack";
		}
		else if (suitc == 12) {
			return "Queen";
		}
		else if (suitc == 13) {
			return "King";
		}
		return "";
		
	}
}