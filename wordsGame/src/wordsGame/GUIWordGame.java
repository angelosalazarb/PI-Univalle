/*
 * Author: JUAN JOSE BAILON,  ANGELO SALAZAR, JUAN JOSE REVELO
 * e-mail:  juan.bailon@correounivalle.edu.co
 * 			angelo.salazar@correounivalle.edu.co
 * 			juan.jose.revelo@correounivalle.edu.co
 * 			
 */
package wordsGame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import utilities.DrawRect;
import utilities.DrawWorksPanel;
import utilities.GokuObject;
import utilities.LoginGUI;



// TODO: Auto-generated Javadoc
/**
 * The Class GUIWordGame.
 */
public class GUIWordGame extends JFrame {
	
	private JPanel homePanel, howToPlayPanel, gameZonePanel, rankingPanel;
	private JLabel jugarButton, comoJugarButton, salirButton, goBackButton, rankingButton, startRound2, nextLevelButton;
	private JLabel homeBackground, gameZoneBackground, howToPlayBackground, rankingBackground, pergamino;
	private Escucha escucha;
	private Login login;
	private LoginGUI loginGUI;
	private String usersDataFilePath, wordsListFilePath;
	
	/* flag determines if the user is NOT signIn already
	 * 	if flag=true the user is NOT signIN
	 * 	if flag=false the user is signIn
	 * */
	private boolean flag;
	
	private GokuObject goku;
	private GameLogic gameLogic;
	private DrawRect customTextField;
	private DrawWorksPanel drawWorksPanel;
	private JScrollPane scrollPane;
	private JLabel currentLevel, restartButton, gameOver;
	private Timer timer;
	private TimerTask timerTask;
	private JLabel angelo, angeloText, clickme, messageLabel;
	private int angeloCounter=0;
	
	
	
	/**
	 * Instantiates a new GUI word game.
	 *
	 * @param usersDataFilePath the users data file path
	 * @param wordsListFilePath the words list file path
	 */
	public GUIWordGame( String usersDataFilePath, String wordsListFilePath ) {
		
		this.usersDataFilePath = usersDataFilePath;
		this.wordsListFilePath = wordsListFilePath;
		this.login = new Login( this.usersDataFilePath );
		this.gameLogic = new GameLogic( usersDataFilePath, wordsListFilePath );
		
		this.flag = true;
		
		initGUI();
		
		this.setSize(1200,600);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	
	/**
	 * Inits the GUI.
	 */
	public void initGUI() {
		
		//escucha
		escucha = new Escucha();
		
		
		//home panel
		homePanel = new JPanel();		
		homePanel.setSize(1200,600);
		homePanel.setLocation(0,0);
		homePanel.setLayout(null);
		homePanel.setVisible(true);
		
		//home background
		homeBackground = new JLabel();
		homeBackground.setSize(1200,600);
		homeBackground.setLocation(0,0);
		homeBackground.setIcon(new ImageIcon("src/imagenes/homeBackground_kameHouse.jpg"));
		homeBackground.setVisible(true);
		homePanel.add(homeBackground,0);
		
		//jugar button
		jugarButton = new JLabel();
		jugarButton.setSize(212,116);
		jugarButton.setLocation(850,310);
		jugarButton.setIcon(new ImageIcon("src/imagenes/botonjugar1.png"));
		jugarButton.setVisible(true);
		jugarButton.addMouseListener(escucha);
		homePanel.add(jugarButton,0);
		
		
		// como jugar button
		comoJugarButton = new JLabel();
		comoJugarButton.setSize(318,106);
		comoJugarButton.setLocation(820,410);
		comoJugarButton.setIcon(new ImageIcon("src/imagenes/comojugar.png"));
		comoJugarButton.setVisible(true);
		comoJugarButton.addMouseListener(escucha);
		homePanel.add(comoJugarButton,0);
		
		//ranking buttton
		rankingButton = new JLabel();
		rankingButton.setSize(244,81);
		rankingButton.setLocation(15,450);
		rankingButton.setIcon(new ImageIcon("src/imagenes/botonRanking.png"));
		rankingButton.setVisible(true);
		rankingButton.addMouseListener(escucha);
		homePanel.add(rankingButton, 0);
		
		//angelo
		angelo =  new JLabel();
		angelo.setIcon( new ImageIcon( "src/imagenes/angelo1.png") );
		angelo.setSize(120,218);
		angelo.setLocation(300, 350);
		angelo.setVisible(true);
		angelo.setBorder(null);
		angelo.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
		angelo.addMouseListener(escucha);
		
		clickme = new JLabel("Do NOT click me");
		clickme.setSize(280,20);
		clickme.setLocation(270, 535);
		clickme.setForeground(Color.YELLOW.brighter());
		clickme.setFont( new Font("DialogInput", Font.ITALIC+Font.BOLD, 18) );
		clickme.setVisible(true);
		
		angeloText = new JLabel();
		angeloText.setSize(280,80);
		angeloText.setLocation(430, 410);
		angeloText.setForeground(Color.green);
		angeloText.setFont( new Font("DialogInput", Font.ITALIC+Font.BOLD, 18) );
		angeloText.setVisible(true);
		angeloText.setSize( angeloText.getWidth(), angeloText.getHeight()+25 );
		
		
		//how to play panel		
		howToPlayPanel= new JPanel();			
		howToPlayPanel.setSize(1200,600);
		howToPlayPanel.setLocation(0,0);
		howToPlayPanel.setLayout(null);
		howToPlayPanel.setVisible(false);
	
		//how to play background
		howToPlayBackground = new JLabel();
		howToPlayBackground.setSize(1200,600);
		howToPlayBackground.setLocation(0,0);
		howToPlayBackground.setIcon(new ImageIcon("src/imagenes/fondocomojugar.jpg"));
		howToPlayBackground.setVisible(true);
		howToPlayPanel.add(howToPlayBackground,0);
		
		//pergamino
		pergamino = new JLabel();
		pergamino.setSize(520, 520);
		pergamino.setLocation(630, 20);
		pergamino.setIcon( new ImageIcon("src/imagenes/pergamino.jpeg") );
		pergamino.setVisible(true);
		howToPlayPanel.add(pergamino,0);
		
		//salir button
		salirButton = new JLabel();
		salirButton.setSize(318,106);
		salirButton.setLocation(110,450);
		salirButton.setIcon(new ImageIcon("src/imagenes/botonsalir1.png"));
		salirButton.setVisible(true);
		salirButton.addMouseListener(escucha);
		
		//ranking panel
		rankingPanel = new JPanel();
		rankingPanel.setSize(1200,600);
		rankingPanel.setLocation(0,0);
		rankingPanel.setLayout(null);
		rankingPanel.setVisible(false);
		
		//ranking background
		rankingBackground = new JLabel();
		rankingBackground.setSize(1200,600);
		rankingBackground.setLocation(0,0);
		rankingBackground.setIcon(new ImageIcon("src/imagenes/homeBackground_kameHouse.jpg"));
		rankingBackground.setVisible(true);
		rankingPanel.add(rankingBackground,0);
		
		
		//game zone panel
		gameZonePanel = new JPanel();				
		gameZonePanel.setSize(1200,600);
		gameZonePanel.setLocation(0,0);
		gameZonePanel.setLayout(null);
		gameZonePanel.setVisible(false);
			
		//game zone background
		gameZoneBackground = new JLabel();
		gameZoneBackground.setSize(1200,600);
		gameZoneBackground.setLocation(0,0);
		gameZoneBackground.setIcon(new ImageIcon("src/imagenes/gameZone_background.gif"));
		gameZoneBackground.setVisible(true);
		gameZonePanel.add(gameZoneBackground,0);
	
		//go back button
		goBackButton = new JLabel();
		goBackButton.setSize(75,75);
		goBackButton.setLocation(1055,15);
		goBackButton.setIcon(new ImageIcon("src/imagenes/klipartz.com.png"));
		goBackButton.setVisible(true);
		goBackButton.addMouseListener(escucha);
		gameZonePanel.add(goBackButton,0);
		
		// current level label
		currentLevel = new JLabel("Level: " + gameLogic.getUserLevel() );
		currentLevel.setSize(100, 30);
		currentLevel.setLocation(10, 10);
		currentLevel.setForeground(Color.GREEN);
		currentLevel.setFont( new Font("DialogInput", Font.BOLD, 20) );
		currentLevel.setVisible(true);
		gameZonePanel.add(currentLevel,0);
		
		//restart button
		restartButton = new JLabel("  RESTART ");
		restartButton.setSize(160,35);
		restartButton.setLocation(18, 510);
		restartButton.setBackground(Color.DARK_GRAY);
		restartButton.setForeground(Color.RED);
		restartButton.setFont( new Font("DialogInput", Font.BOLD, 24) );
		restartButton.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
		restartButton.setBorder( BorderFactory.createRaisedBevelBorder() );
		restartButton.setOpaque(true);
		restartButton.setVisible(true);
		restartButton.addMouseListener(escucha);
		gameZonePanel.add(restartButton,0);
		
		//custom text field
		customTextField = new DrawRect(390, 50);
		customTextField.setSize(392,60);
		customTextField.setLocation(50, 225);
		customTextField.setCursor( new Cursor( Cursor.TEXT_CURSOR ) );
		customTextField.setFocusable(true);
		customTextField.setVisible(false);
		gameZonePanel.add(customTextField, 0);
		
		//meassage label
		messageLabel = new JLabel("<html>You DONT have enough correct words<br/> to go to the next level</html>");
		messageLabel.setSize(350, 35);
		messageLabel.setLocation(55,185);
		messageLabel.setForeground(Color.GREEN);
		messageLabel.setFont( new Font("DialogInput", Font.BOLD, 15) );
		messageLabel.setVisible(false);
		gameZonePanel.add(messageLabel,0);
		
		//start second round button
		startRound2 = new JLabel( "<html><pre>    GO TO<br/>   ROUND 2</pre></html>" );
		startRound2.setSize(100, 50);
		startRound2.setLocation(110, 320);
		startRound2.setBackground(Color.DARK_GRAY);
		startRound2.setForeground( Color.GREEN );
		startRound2.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
		startRound2.setBorder( BorderFactory.createRaisedBevelBorder() );
		startRound2.setOpaque(true);
		startRound2.setVisible(false);
		startRound2.addMouseListener(escucha);
		gameZonePanel.add(startRound2,0);
		
		//next level button
		nextLevelButton = new JLabel( "<html><pre>    GO TO<br/>  NEXT LEVEL</pre></html>" );
		nextLevelButton.setSize(100, 50);
		nextLevelButton.setLocation(110, 320);
		nextLevelButton.setBackground(Color.DARK_GRAY);
		nextLevelButton.setForeground( Color.GREEN );
		nextLevelButton.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
		nextLevelButton.setBorder( BorderFactory.createRaisedBevelBorder() );
		nextLevelButton.setOpaque(true);
		nextLevelButton.setVisible(false);
		nextLevelButton.addMouseListener(escucha);
		gameZonePanel.add(nextLevelButton,0);		
		
		/*
		//scroll pane
		scrollPane = new JScrollPane(customTextFie, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setSize(310,100);
		scrollPane.setLocation(500, 100);
		*/
		
		// draw works panel
		drawWorksPanel = new DrawWorksPanel();
		drawWorksPanel.setSize(530,430);  
		drawWorksPanel.setLocation(650, 120); 
		drawWorksPanel.setVisible(false);
		gameZonePanel.add(drawWorksPanel, 0);
		
		
		//game over label
		gameOver = new JLabel("  GAME OVER");
		gameOver.setSize(500, 150);
		gameOver.setLocation(350, 150);
		gameOver.setBackground(Color.BLACK);
		gameOver.setForeground(Color.RED);
		gameOver.setBorder( BorderFactory.createLineBorder(Color.RED) );
		gameOver.setFont( new Font("DialogInput", Font.BOLD+Font.ITALIC, 65) );
		gameOver.setOpaque(true);
		gameOver.setVisible(false);
		gameZonePanel.add(gameOver,0);  
		
		
		gameZonePanel.add(angelo,0);
		gameZonePanel.add(clickme,0);
		gameZonePanel.add(angeloText,0);
		
		this.add(homePanel);
		this.add(howToPlayPanel);
		this.add(rankingPanel);
		this.add(gameZonePanel);
		this.addKeyListener(escucha);

	}
	
	
	/**
	 * Sets the ranking list. takes the top 10 users with the highest level, and add then to 
	 * 						   the ranking panel
	 */
	public void setRankingList() {
		
		ArrayList<User> rankingList = gameLogic.determineRanking();
		
		int counter=0;
		
		for( User u : rankingList ) {
			
			JLabel temp = new JLabel( u.getUsername()+"  ............. Level: "+u.getLevel() );
			temp.setSize(500, 30);
			temp.setLocation(350, 30+(counter*50));
			temp.setVisible(true);
			temp.setForeground(Color.GREEN.brighter());
			temp.setFont(  new Font("SansSerif", Font.ITALIC+Font.BOLD, 22) );
			rankingPanel.add(temp,0);
			
			counter++;
		}
		
		
	}	
	
	/*
	 * @Author: Angelo Salazar
	 * Contract: <gokuFlying><void><ArrayList<String>> ---> <List>
	 * Purpose: This method will move Goku from side to side of the screen
	 * and will showing the words that are in the array this words are the words in play
	 * @param ArrayList<String> wordsInGame
	 * @return <void>
	 * */
	public void gokuFlying( ArrayList<String> wordsInGame ) {
		
		//music.play("src/music/nubecita.wav");
		this.goku = new GokuObject("");
		timer = new Timer();
		timerTask = new TimerTask() {
		int ctr = 0;
		int x = 1200;
		
		@Override
			
			public void run() {
			
					if(x > -200) {
						goku.setLocation(x, 150);
						gameZonePanel.add(goku,0);
						x = x - 2;						
						//System.out.println("X: " + x);
						//System.out.println("CTR: " + ctr);
					}
					else if(x == -200) {
						x = 1200;
						if(ctr<wordsInGame.size()) {
							goku.setText(wordsInGame.get(ctr));							
							//System.out.println("OUT");
							//System.out.println("CTR2: " + ctr);
							ctr ++;
						}
						else {
							 
							System.out.println("Se acabaron las palabras");
							timer.cancel();
							
							customTextField.setVisible(true);
							drawWorksPanel.setVisible(true);
							
							if( gameLogic.getRound()==1 ) {
								startRound2.setVisible(true);								
							}
							else{
								nextLevelButton.setVisible(true);
							}
						
						}
					}
					
				};
			};
			
			timer.scheduleAtFixedRate( timerTask, 120, 5);
	}
	
	
	
	
	
	private class Escucha extends MouseAdapter implements KeyListener{

		
		public void mouseClicked( MouseEvent eventMouse ) {
			
			if( eventMouse.getSource() == jugarButton ) {
				
				if( flag ) {
					flag=false;
					loginGUI = new LoginGUI( login );
				}
				
				boolean temp = loginGUI.getSignInSuccessful();
				
				if( temp ) {
					System.out.println( "username: "+ login.getUsername() );
			
					gameLogic = new GameLogic( usersDataFilePath, wordsListFilePath, login.getUsername() );
					gameLogic.fillWordsInPlay();

					homePanel.setVisible(false);
					gameZonePanel.setVisible(true);
					temp=false;
					currentLevel.setText("Level: "+gameLogic.getUserLevel() );
					
					System.out.println( gameLogic.getWordsInPlay() );
					gokuFlying( gameLogic.getWordsInPlay() );
				}
				else {
					loginGUI.setVisible(true);
				}
				
			}
			else if ( eventMouse.getSource() == comoJugarButton ) {
								
				homePanel.setVisible(false);
				homePanel.remove(jugarButton);
				
				salirButton.setLocation(110,450);
				howToPlayPanel.add(salirButton,0);
				jugarButton.setLocation(350,425);
				howToPlayPanel.add(jugarButton,0);
				howToPlayPanel.setVisible(true);
				
			}
			else if( eventMouse.getSource() == salirButton ) {
				
				if( howToPlayPanel.isVisible() ) {
					
					howToPlayPanel.setVisible(false);
					howToPlayPanel.remove(jugarButton);
					
					jugarButton.setLocation(850,310);
					homePanel.add(jugarButton,0);
					homePanel.setVisible(true);
				}
				else if( rankingPanel.isVisible() ) {
					
					rankingPanel.setVisible(false);
					homePanel.setVisible(true);
				}
	
			}
			else if( eventMouse.getSource() == rankingButton ) {
				
				homePanel.setVisible(false);
				salirButton.setLocation(860,430);
				rankingPanel.add(salirButton,0);
				rankingPanel.setVisible(true);
				
				setRankingList();
			}
			else if( eventMouse.getSource() == goBackButton ) {
				
				timerTask.cancel();
				timer.cancel();
				gameZonePanel.remove(goku);
				
				messageLabel.setVisible(false);
				startRound2.setVisible(false);
				nextLevelButton.setVisible(false);
				drawWorksPanel.setVisible(false);
				customTextField.setVisible(false);
				gameOver.setVisible(false);
				drawWorksPanel.clearPanel();
				
				gameZonePanel.setVisible(false);
				homePanel.setVisible(true);
				jugarButton.setLocation(850,310);
				homePanel.add(jugarButton,0);

				flag=true;
			}
			else if ( eventMouse.getSource() == startRound2 ) {
				
				System.out.println(" Iniciando segunda ronda. "); 
				
				gameLogic.setSecondRound();
				drawWorksPanel.setVisible(false);
				customTextField.setVisible(false);
				startRound2.setVisible(false);
				drawWorksPanel.clearPanel();
				
				System.out.println( gameLogic.getWordsInPlay() );
				
				gokuFlying( gameLogic.getWordsInPlay() );
				
			}
			else if ( eventMouse.getSource() == nextLevelButton ) {
				
				if( gameLogic.readyForNextLevel() ) {
					
					System.out.println("EXELENTE!! has ganado, vamos al siguiente nivel.");
					
					gameLogic.nextLevel();
					messageLabel.setVisible(false);
					drawWorksPanel.setVisible(false);
					customTextField.setVisible(false);
					nextLevelButton.setVisible(false);
					drawWorksPanel.clearPanel();
					currentLevel.setText("Level: "+gameLogic.getUserLevel() );
					
					System.out.println( gameLogic.getWordsInPlay() );
					
					gokuFlying( gameLogic.getWordsInPlay() );
				}
				else {
					messageLabel.setVisible(true);
				}
				
			}
			else if( eventMouse.getSource() == restartButton ) {
				
				timerTask.cancel();
				timer.cancel();
				
				gameZonePanel.remove(goku);
				
				messageLabel.setVisible(false);
				startRound2.setVisible(false);
				nextLevelButton.setVisible(false);
				drawWorksPanel.setVisible(false);
				customTextField.setVisible(false);
				gameOver.setVisible(false);
				drawWorksPanel.clearPanel();
				
				gameLogic.restart();
				
				System.out.println( gameLogic.getWordsInPlay() );
				
				gokuFlying( gameLogic.getWordsInPlay() );
				
			}
			else if( eventMouse.getSource() == angelo ) {
				
				switch (angeloCounter) {
				case 0:
					angelo.setIcon( new ImageIcon( "src/imagenes/angelo1.png" ) );
					angeloText.setText("<html>Why did you click me!<br/>Do it again, I DARE YOU</html>" );
					angeloCounter++;
					break;
				case 1:	
					angelo.setIcon( new ImageIcon( "src/imagenes/angelo3.png" ) );
					angeloText.setText("<html>Con este proyecto ya le debo como 500 paninos a Bailon</html>" );
					angeloCounter++;
					break;
				case 2:
					angelo.setIcon( new ImageIcon( "src/imagenes/angelo2.png" ) );
					angeloText.setText("<html>Y recuerden amigos Electrica es pa las perras. <br/> Chauu amigas MUUA! <br/>P.D Revelo es una perra  </html>" );
					clickme.setText("Click me again");		
					angeloCounter++;
					break;
				default:
					angelo.setIcon( new ImageIcon( "src/imagenes/angelo1.png" ) );
					angeloText.setText("");
					clickme.setText("Do NOT click me");
					angeloCounter=0;
					break;
				}
				
			}
			
		}// END method mouseClicked

		
		@Override
		public void keyTyped(KeyEvent eventKey) {
			// TODO Auto-generated method stub

			if( !(eventKey.getKeyChar() == KeyEvent.VK_BACK_SPACE) ) {
				
				if( !(eventKey.getKeyChar() == KeyEvent.VK_ENTER) ) {
					
					customTextField.addCharecter( eventKey.getKeyChar() );
				}
				
			}
						
		}

		@Override
		public void keyPressed(KeyEvent eventKey) {
			// TODO Auto-generated method stub
			
			if( eventKey.getKeyCode() == KeyEvent.VK_BACK_SPACE ) {
				customTextField.removeLastCharacter();
			}
			else if( eventKey.getKeyCode() == KeyEvent.VK_ENTER ) {
				
				System.out.println("%%%%%%%%%%%%%%%");
				
				String myWord =  customTextField.getWord() ;
				myWord = myWord.toUpperCase();
				
				gameLogic.addUserInputWord(myWord);
								
				customTextField.setWord("");
				customTextField.repaint();
												
				System.out.println("myWord: "+myWord);
				System.out.println("wordsInPlay: " + gameLogic.getWordsInPlay() );
				System.out.println("correctWords: " + gameLogic.getCorrectWords() );
				System.out.println("Errors: " + gameLogic.getBadWordsCounter() );
				System.out.println("round: " + gameLogic.getRound() );				
				
				if( gameLogic.memberOfCorrectWords(myWord) ) {
					
					drawWorksPanel.showWordInPanel(myWord, false);						
				}
				else{
					
					drawWorksPanel.showWordInPanel(myWord, true);
				}
				
				
				if(!gameLogic.stillAlive()) {
					
					System.out.println("Numero maximo de fallos alcanzao, Haz muerto.");
					
					startRound2.setVisible(false);
					nextLevelButton.setVisible(false);
					gameOver.setVisible(true);
				}
				else if( gameLogic.readyForSecondRound() &&  gameLogic.getRound()==1 ) {
					
					System.out.println("En hora buena! has acertado todas las palabras de la priemra ronda.");
					System.out.println(" Iniciando segunda ronda. "); 
					
					gameLogic.setSecondRound();
					drawWorksPanel.setVisible(false);
					customTextField.setVisible(false);
					startRound2.setVisible(false);
					drawWorksPanel.clearPanel();
					
					
					System.out.println( gameLogic.getWordsInPlay() );
					
					gokuFlying( gameLogic.getWordsInPlay() );
					
				}
				
			}
			
		}// END method ketPressed

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
			
		
	}// END private class Escucha
	
	
}// END class GUIWordGame
