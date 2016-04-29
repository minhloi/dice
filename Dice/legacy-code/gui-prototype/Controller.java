package graphics;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;

//Prototype of what the game could look like

public class Controller extends JFrame {

	private static JPanel contentPane, menu, game, rankings, username, fight;
	private static JProgressBar progressBar;
	private static Task task;
	private static String username1;
	private static String username2;


	public Controller() {
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				createGUI();
			}
		});
	}

	public void addPanels(Container container) {

		createMenuPanel();
		createUsernamePanel();
//		createGamePanel();
		createRankingsPanel();
		createFightPanel();

		contentPane = new JPanel(new CardLayout());

		contentPane.add(menu, "Menu");
		contentPane.add(username, "Usernames");
//		contentPane.add(game, "Game");
		contentPane.add(rankings, "Rankings");
		contentPane.add(fight, "Fight");

		container.add(contentPane, BorderLayout.CENTER);
	}
	private static void activateRollBar() {
		for(int i = 0; i < 100; i++) {
			final int percent = i;
			try {

						progressBar.setValue(percent);

				Thread.sleep(100);
			}
			catch (InterruptedException e) {
			}
	    }
	}

	private static void createGUI() {
		JFrame frame = new JFrame("Fighting Dice");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Controller controller = new Controller();
		controller.addPanels(frame.getContentPane());

		frame.setSize(450, 300);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	private static void createFightPanel() {
		fight = new JPanel();
		fight.setLayout(null);

		progressBar = new JProgressBar();
		progressBar.setBounds(142, 89, 146, 20);
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		fight.add(progressBar);


		JLabel rollingLabel = new JLabel("Rolling Dice");
		rollingLabel.setBounds(181, 57, 76, 16);
		fight.add(rollingLabel);

		fight.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				//task = new Task();

			}
		});

	}

	private static void createUsernamePanel() {
		username = new JPanel();
		username.setLayout(null);

		JLabel usernameLabel = new JLabel("Enter Usernames");
		usernameLabel.setBounds(168, 45, 114, 16);
		username.add(usernameLabel);

		JLabel playerLabel1 = new JLabel("Player 1");
		playerLabel1.setBounds(126, 113, 57, 16);
		username.add(playerLabel1);

		JLabel playerLabel2 = new JLabel("Player 2");
		playerLabel2.setBounds(126, 151, 57, 16);
		username.add(playerLabel2);

		JTextField textField1 = new JTextField();
		textField1.setBounds(189, 108, 130, 26);
		username.add(textField1);
		textField1.setColumns(10);

		JTextField textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(189, 146, 130, 26);
		username.add(textField2);

		JLabel errorLabel = new JLabel("Invalid Input: Both Usernames must be filled");
		errorLabel.setForeground(Color.RED);
		errorLabel.setVisible(false);
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setBounds(73, 80, 303, 16);
		username.add(errorLabel);

		JButton continueButton = new JButton("Continue");
		continueButton.setBounds(165, 202, 117, 29);
		username.add(continueButton);

		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField1.getText().equals("") || textField2.getText().equals("")) {
					errorLabel.setVisible(true);
				}
				else {
					username1 = textField1.getText();
					username2 = textField2.getText();
					createGamePanel();
					contentPane.add(game, "Game");
					CardLayout cardLayout = (CardLayout)(contentPane.getLayout());
					cardLayout.show(contentPane, "Game");
				}
			}
		});
	}

	private static void createMenuPanel() {
		menu = new JPanel();
		menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
		menu.setVisible(true);

		JLabel welcomeLabel = new JLabel("Welcome to the Game");
		welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		menu.add(welcomeLabel);

		JButton startButton = new JButton("Start Game");
		startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		menu.add(startButton);

		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					CardLayout cardLayout = (CardLayout)(contentPane.getLayout());
					cardLayout.show(contentPane, "Usernames");
			}
		});

		JButton rankingsButton = new JButton("View Rankings");
		rankingsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		menu.add(rankingsButton);

		rankingsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					CardLayout cardLayout = (CardLayout)(contentPane.getLayout());
					cardLayout.show(contentPane, "Rankings");
			}
		});

		JButton exitButton = new JButton("Exit");
		exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		menu.add(exitButton);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					JFrame parentFrame = (JFrame)SwingUtilities.getWindowAncestor(menu);
					parentFrame.dispose();
			}
		});
	}

	private static void createGamePanel() {
		game = new JPanel();
		game.setVisible(true);
		game.setLayout(null);

		JLabel attackLabel1 = new JLabel("Attack  | Q");
		attackLabel1.setBounds(57, 178, 77, 16);
		game.add(attackLabel1);

		JLabel blockLabel1 = new JLabel("Block   | W");
		blockLabel1.setBounds(57, 195, 77, 16);
		game.add(blockLabel1);

		JLabel specialLabel1 = new JLabel("Special | E");
		specialLabel1.setBounds(57, 206, 77, 25);
		game.add(specialLabel1);

		JLabel attackLabel2 = new JLabel("Attack  | J");
		attackLabel2.setBounds(312, 178, 77, 16);
		game.add(attackLabel2);

		JLabel blockLabel2 = new JLabel("Block   | K");
		blockLabel2.setBounds(312, 195, 77, 16);
		game.add(blockLabel2);

		JLabel specialLabel2 = new JLabel("Special | L");
		specialLabel2.setBounds(312, 210, 77, 16);
		game.add(specialLabel2);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(Color.BLACK);
		separator.setBounds(220, 6, 11, 266);
		game.add(separator);

		JLabel playerLabel1 = new JLabel(username1 + "'s\tHealth: " + 10);
		playerLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		playerLabel1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		playerLabel1.setBounds(19, 25, 189, 25);
		game.add(playerLabel1);

		JLabel playerLabel2 = new JLabel("<html><body style='width: 189px'>" + username2 + "'s\tHealth: " + 10);
		playerLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		playerLabel2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		playerLabel2.setBounds(243, 26, 189, 23);
		game.add(playerLabel2);

//		JLabel healthLabel1 = new JLabel("Health: 10");
//		healthLabel1.setHorizontalAlignment(SwingConstants.CENTER);
//		healthLabel1.setBounds(19, 62, 189, 16);
//		game.add(healthLabel1);
//
//		JLabel healthLabel2 = new JLabel("Health: 10");
//		healthLabel2.setHorizontalAlignment(SwingConstants.CENTER);
//		healthLabel2.setBounds(258, 62, 161, 16);
//		game.add(healthLabel2);

		JLabel promptLabel1 = new JLabel("Enter Key to Select Move");
		promptLabel1.setBounds(19, 150, 161, 16);
		game.add(promptLabel1);

		JLabel promptLabel2 = new JLabel("Enter Key to Select Move");
		promptLabel2.setBounds(258, 150, 161, 16);
		game.add(promptLabel2);

		JLabel moveLabel1 = new JLabel("Move Selected");
		moveLabel1.setForeground(Color.green.darker());
		moveLabel1.setVisible(false);
		moveLabel1.setBounds(57, 150, 161, 16);
		game.add(moveLabel1);

		JLabel moveLabel2 = new JLabel("Move Selected");
		moveLabel2.setBounds(312, 150, 161, 16);
		moveLabel2.setForeground(Color.green.darker());
		moveLabel2.setVisible(false);
		game.add(moveLabel2);

		JLabel IncorrectLabel1 = new JLabel("Incorrect Selection");
		IncorrectLabel1.setVisible(false);
		IncorrectLabel1.setForeground(Color.red);
		IncorrectLabel1.setBounds(57, 150, 161, 16);
		game.add(IncorrectLabel1);

		JLabel IncorrectLabel2 = new JLabel("Move Selected");
		IncorrectLabel2.setBounds(312, 150, 161, 16);
		IncorrectLabel2.setForeground(Color.red);
		IncorrectLabel2.setVisible(false);
		game.add(IncorrectLabel2);

		JButton quitButton = new JButton("Quit Game");
		quitButton.setBounds(334, 238, 110, 29);
		game.add(quitButton);
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					CardLayout cardLayout = (CardLayout)(contentPane.getLayout());
					cardLayout.show(contentPane, "Menu");

			}
		});

		JPasswordField passwordField1 = new JPasswordField();
		passwordField1.setBounds(178, 145, 30, 26);
		((AbstractDocument)passwordField1.getDocument()).setDocumentFilter(new TextFieldLimiter(1));
		game.add(passwordField1);


		JPasswordField passwordField2 = new JPasswordField();
		passwordField2.setBounds(414, 145, 30, 26);
		((AbstractDocument)passwordField2.getDocument()).setDocumentFilter(new TextFieldLimiter(1));
		game.add(passwordField2);
		passwordField2.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();

				if(key == KeyEvent.VK_BACK_SPACE) {
					IncorrectLabel2.setVisible(false);
					promptLabel2.setVisible(true);
					moveLabel2.setVisible(false);
				}
				else if(key == KeyEvent.VK_J || key == KeyEvent.VK_K || key == KeyEvent.VK_L) {
					promptLabel2.setVisible(false);
					IncorrectLabel2.setVisible(false);
					moveLabel2.setVisible(true);
					passwordField2.setEnabled(false);
					if(passwordField1.isEnabled() == false && passwordField2.isEnabled() == false) {
						CardLayout cardLayout = (CardLayout)(contentPane.getLayout());
						cardLayout.show(contentPane, "Fight");
					}
				}
				else if(key == KeyEvent.VK_SHIFT)  { }
				else {
					promptLabel2.setVisible(false);
					moveLabel2.setVisible(false);
					IncorrectLabel2.setVisible(true);
				}
			}
		});

		passwordField1.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {

				int key = e.getKeyCode();

				if(key == KeyEvent.VK_BACK_SPACE) {
					IncorrectLabel1.setVisible(false);
					promptLabel1.setVisible(true);
					moveLabel1.setVisible(false);
				}
				else if(key == KeyEvent.VK_Q || key == KeyEvent.VK_W || key == KeyEvent.VK_E) {
					promptLabel1.setVisible(false);
					IncorrectLabel1.setVisible(false);
					moveLabel1.setVisible(true);
					passwordField1.setEnabled(false);
					if(passwordField1.isEnabled() == false && passwordField2.isEnabled() == false) {
						CardLayout cardLayout = (CardLayout)(contentPane.getLayout());
						cardLayout.show(contentPane, "Fight");
					}
				}
				else if(key == KeyEvent.VK_SHIFT)  { }
				else {
					promptLabel1.setVisible(false);
					moveLabel1.setVisible(false);
					IncorrectLabel1.setVisible(true);
				}

			}

		});

	}

	private static void createRankingsPanel() {
		rankings = new JPanel();
		rankings.setLayout(new BorderLayout());
		rankings.setVisible(true);

		JLabel titleLabel = new JLabel("Ranking History");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(160, 6, 130, 29);
		rankings.add(titleLabel, BorderLayout.NORTH);

		JButton backButton = new JButton("Main Menu");
		backButton.setBounds(5, 244, 440, 29);
		rankings.add(backButton, BorderLayout.SOUTH);

		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					CardLayout cardLayout = (CardLayout)(contentPane.getLayout());
					cardLayout.show(contentPane, "Menu");
			}
		});

		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);
		JScrollPane tableContainer = new JScrollPane(table);
		model.addColumn("Username");
		model.addColumn("Wins");
		model.addColumn("Losses");
		model.addColumn("DIFF");

		rankings.add(tableContainer, BorderLayout.CENTER);
	}
	private class Task extends SwingWorker<Void, Void> {

		@Override
		protected Void doInBackground() throws Exception {
			Random random = new Random();
			int progress = 0;
		      setProgress(0);
		      while (progress < 100) {
		        try {
		          Thread.sleep(random.nextInt(1000));
		        } catch (InterruptedException ignore) {
		        }
		        progress += random.nextInt(10);
		        setProgress(Math.min(progress, 100));
		      }
			return null;
		}

	}
}
