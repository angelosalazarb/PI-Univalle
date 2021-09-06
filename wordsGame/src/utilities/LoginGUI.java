/*
 * Autor: JUAN JOSE BAILON, JUAN JOSE REVELO, ANGELO SALAZAR
 * E-MAIL: juan.bailon@correounivalle.edu.co
 * 			angelo.salazar@correounivalle.edu.co
 * 			juan.fose.revelo@correounivalle.edu.co
 */
package utilities;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import wordsGame.Login;


// TODO: Auto-generated Javadoc
/**
 * The Class LoginGUI.
 */
public class LoginGUI extends JFrame {
	
	private JPanel userPanel;
	private JLabel usernameLabel, passwordLabel, background;
	private JLabel createAccount, loginErrorMessage, goBackButton, titleCreateAccount;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton signIn, signUp;
	private Login login;
	private Escucha escucha;
	private boolean signInSuccessful;
	
	
	/**
	 * Instantiates a new login GUI.
	 *
	 * @param login the login
	 */
	public LoginGUI( Login login ) {
		
		this.login = login;
		this.signInSuccessful = false;
		
		initGUI();
		
		this.setTitle("LOGIN");
		this.setSize(600,338);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	
	/**
	 * Inits the GUI. initialize the GUI elements
	 */
	public void initGUI() {
		
		
		escucha = new Escucha();
		
		userPanel= new JPanel();				
		userPanel.setSize(600,338);
		userPanel.setLocation(0,0);
		userPanel.setLayout(null);
		
		background = new JLabel();
		background.setSize(600,338);
		background.setLocation(0,0);
		background.setIcon(new ImageIcon("src/imagenes/gokulogin.jpg"));
		background.setVisible(true);
		userPanel.add(background,0);
		
		usernameLabel = new JLabel("Username:");
		usernameLabel.setSize(100,40);
		usernameLabel.setLocation(370,70);
		usernameLabel.setVisible(true);
		userPanel.add(usernameLabel,0);
		
		passwordLabel = new JLabel(" Password:");
		passwordLabel.setSize(100, 40);
		passwordLabel.setLocation(370,120);
		passwordLabel.setVisible(true);
		userPanel.add(passwordLabel,0);
		
		usernameField = new JTextField();
		usernameField.setSize(90,20);
		usernameField.setLocation(460,80);
		usernameField.setVisible(true);
		userPanel.add(usernameField,0);
		
		passwordField = new JPasswordField();
		passwordField.setSize( 90, 20 );
		passwordField.setLocation(460,130);
		passwordField.setVisible(true);
		userPanel.add(passwordField,0);		
		
		createAccount = new JLabel("Create new account.");
		createAccount.setForeground(Color.BLUE.darker());
		createAccount.setSize(180, 10);
		createAccount.setLocation(380,170);
		createAccount.setVisible(true);
		createAccount.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
		createAccount.setFont(  new Font("SansSerif", Font.ITALIC, 11) );
		createAccount.addMouseListener(escucha);
		userPanel.add(createAccount,0);
		
		signIn= new JButton("SignIn");
		signIn.setSize(90,20);
		signIn.setLocation(420,200);
		signIn.setVisible(true);
		signIn.addActionListener(escucha);
		userPanel.add(signIn,0);
		
		signUp= new JButton("SignUp");
		signUp.setSize(90,20);
		signUp.setLocation(420,200);
		signUp.setVisible(false);
		signUp.addActionListener(escucha);
		userPanel.add(signUp,0);
		
		goBackButton = new JLabel();
		goBackButton.setSize(150,150);
		goBackButton.setLocation(13,182);
		goBackButton.setIcon(new ImageIcon("src/imagenes/klipartz.com.png"));
		goBackButton.setVisible(false);
		goBackButton.addMouseListener(escucha);
		userPanel.add(goBackButton,0);
		
		loginErrorMessage = new JLabel();
		loginErrorMessage.setForeground(Color.BLUE.darker() );
		loginErrorMessage.setSize(250, 30);
		loginErrorMessage.setLocation(373,45);
		loginErrorMessage.setVisible(false);
		loginErrorMessage.setFont(  new Font("SansSerif", Font.ITALIC, 11) );
		loginErrorMessage.addMouseListener(escucha);
		userPanel.add(loginErrorMessage,0);
		
		titleCreateAccount = new JLabel("Create new account");
		titleCreateAccount.setForeground(Color.GREEN.brighter() );
		titleCreateAccount.setSize(300,40);
		titleCreateAccount.setLocation(270,5);
		titleCreateAccount.setVisible(false);
		titleCreateAccount.setFont(  new Font("SansSerif", Font.BOLD+Font.ITALIC, 20) );
		userPanel.add(titleCreateAccount,0);
		
		
		this.add(userPanel);
		
	}
	
	
	/**
	 * Checks if is sign in successful.
	 *
	 * @return true, if is sign in successful
	 */
	public boolean getSignInSuccessful() {
		return signInSuccessful;
	}


	/**
	 * Sets the sign in successful.
	 *
	 * @param signInSuccessful the new sign in successful
	 */
	public void setSignInSuccessful(boolean signInSuccessful) {
		this.signInSuccessful = signInSuccessful;
	}



	private class Escucha extends MouseAdapter implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent eventAction ) {
			// TODO Auto-generated method stub
			
			if( eventAction.getSource()==signIn ) {
				
				boolean flag;
				flag = login.signIn( usernameField.getText() , String.valueOf( passwordField.getPassword() ) );								
				System.out.println( "SignIn succesful: " + flag );
				
				if(flag) {
					signInSuccessful = true;
					System.exit(0);
				}
				else {
					
					loginErrorMessage.setText("<html>please try again.<br/> credenditals do NOT match.</html>");
					loginErrorMessage.setVisible(true);
					
				}
				
			}
			else if( eventAction.getSource() == signUp ) {

				boolean flag; 
				
				if( !usernameField.getText().isBlank() &&  !String.valueOf(passwordField.getPassword()).isBlank() ) {
					
					flag = !login.userExist( usernameField.getText() );
					System.out.println( "SignUp succesful: " + flag );
					
					if(flag) {
						login.addNewUser( usernameField.getText(), String.valueOf(passwordField.getPassword()) );
						signInSuccessful = true;
						System.exit(0);
					}
					else {
						System.out.println( "This username already exist" );
						loginErrorMessage.setText("<html>please try again.<br/>this username alredy exists.</html>");
						loginErrorMessage.setVisible(true);
						
						userPanel.repaint();
					}
				}
				else {
				
					flag=false;
					System.out.println( "SignUp succesful: " + flag );
					loginErrorMessage.setText("<html>please try again.<br/> fill both spaces.</html>");
					loginErrorMessage.setVisible(true);
					
					userPanel.repaint();
				}
				
			}
			
		}// END method actionPerformed
		
		
		public void mouseClicked( MouseEvent eventMouse ) {
			
			
			if( eventMouse.getSource() == createAccount ) {
				
				titleCreateAccount.setVisible(true);
				createAccount.setVisible(false);
				signIn.setVisible(false);
				signUp.setVisible(true);
				goBackButton.setVisible(true);
				loginErrorMessage.setVisible(false);
				
				userPanel.repaint();
			}
			 if( eventMouse.getSource() == goBackButton ) {							 
				 
				titleCreateAccount.setVisible(false);
				createAccount.setVisible(true);
				signIn.setVisible(true);
				signUp.setVisible(false);
				goBackButton.setVisible(false);
				loginErrorMessage.setVisible(false);
				
				userPanel.repaint();
			}
			
		}// END method mouseClicked
		
		
	} // END Escucha class
	

} // END of LoginGUI class
