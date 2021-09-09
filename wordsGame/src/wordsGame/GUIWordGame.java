package wordsGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utilities.GokuObject;
import utilities.LoginGUI;
import utilities.TextFieldPanel;


public class GUIWordGame extends JFrame {
	
	//private JFrame myWindow;
	private JPanel homePanel, howToPlayPanel, gameZonePanel, rankingPanel;
	private JLabel jugarButton, comoJugarButton, salirButton, goBackButton, rankingButton;
	private JLabel homeBackground, gameZoneBackground, howToPlayBackground, rankingBackground;
	private Escucha escucha;
	private Login login;
	private LoginGUI loginGUI;
	private String usersDataFilePath, wordsListFilePath, username;
	//private boolean sigInSuccesful;
	private boolean flag;
	private GokuObject goku;
	private GameLogic gameLogic;
	private TextFieldPanel customTextFieldPanel;
	//private ArrayList<String> list;
	
	
	
	public GUIWordGame( String usersDataFilePath, String wordsListFilePath ) {
		
		this.usersDataFilePath = usersDataFilePath;
		this.wordsListFilePath = wordsListFilePath;
		this.login = new Login( this.usersDataFilePath );
		this.gameLogic = new GameLogic( usersDataFilePath, wordsListFilePath );
		
		this.username=null;
		this.flag = true;
		//this.goku = new GokuObject("");
		
		initGUI();
		
		this.setSize(1200,600);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	
	public void initGUI() {
		
		escucha = new Escucha();
		
		//myWindow   
		/*
		myWindow = new JFrame("Words Game");
		myWindow.setSize(1200,600);
		myWindow.setLayout(null);
		myWindow.setResizable(false);
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myWindow.setLocationRelativeTo(null);
		myWindow.setVisible(true); */
		
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
		//rankingButton.setForeground(Color.BLUE.darker());
		//rankingButton.setFont(  new Font("SansSerif", Font.ITALIC+Font.BOLD, 45) );
		rankingButton.addMouseListener(escucha);
		homePanel.add(rankingButton, 0);
		
		//how to play panel
		Image img = new ImageIcon( getClass().getResource("/imagenes/fondocomojugar.jpg") ).getImage() ;
		
		howToPlayPanel= new JPanel()  {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, null);
            }
        };				
		howToPlayPanel.setSize(1200,600);
		howToPlayPanel.setLocation(0,0);
		howToPlayPanel.setLayout(null);
		howToPlayPanel.setVisible(false);
		
		/*
		//how to play background
		howToPlayBackground = new JLabel();
		howToPlayBackground.setSize(1200,600);
		howToPlayBackground.setLocation(0,0);
		howToPlayBackground.setIcon(new ImageIcon("src/imagenes/fondocomojugar.jpg"));
		howToPlayBackground.setVisible(true);
		//howToPlayPanel.add(howToPlayBackground,0);
		*/
		
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
		
		JLabel aux = new JLabel("juan1  2");
		aux.setSize(100, 30);
		aux.setLocation(800, 100);
		//aux.setVisible(true);
		aux.setForeground(Color.BLUE.darker());
		aux.setFont(  new Font("SansSerif", Font.ITALIC+Font.BOLD, 18) );
		//rankingPanel.add(aux,0);
		
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
		
		//goku object
		//goku.setLocation(600,150);
		//gameZonePanel.add(goku,0);
	
		//go back button
		goBackButton = new JLabel();
		goBackButton.setSize(150,150);
		goBackButton.setLocation(1055,0);
		goBackButton.setIcon(new ImageIcon("src/imagenes/klipartz.com.png"));
		goBackButton.setVisible(true);
		goBackButton.addMouseListener(escucha);
		gameZonePanel.add(goBackButton,0);

				
		this.add(homePanel);
		this.add(howToPlayPanel);
		this.add(rankingPanel);
		this.add(gameZonePanel);

	}
	
	
	public void setRankingList() {
		
		ArrayList<User> rankingList = gameLogic.determineRanking();
		
		int x=800, y=100, counter=0;
		
		for( User u : rankingList ) {
			
			JLabel temp = new JLabel( u.getUsername()+"  "+u.getLevel() );
			temp.setSize(300, 30);
			temp.setLocation(800, 100+(counter*50));
			temp.setVisible(true);
			temp.setForeground(Color.BLUE.darker());
			temp.setFont(  new Font("SansSerif", Font.ITALIC+Font.BOLD, 18) );
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
		Timer timer = new Timer();
		TimerTask event = new TimerTask() {
		int ctr = 0;
		int x = 1200;
		
		@Override
			
			public void run() {
			
					if(x > -200) {
						goku.setLocation(x, 150);
						gameZonePanel.add(goku,0);
						x = x - 2;
						//System.out.println("goku sale sin la primera letra");
						//System.out.println("X: " + x);
						//System.out.println("CTR: " + ctr);
					}
					else if(x == -200) {
						x = 1200;
						if(ctr<wordsInGame.size()) {
							goku.setText(wordsInGame.get(ctr));
							//System.out.println("sale con letras");
							//System.out.println("OUT");
							//System.out.println("CTR2: " + ctr);
							ctr ++;
						}
						else {
							loginGUI = new LoginGUI(login); 
							System.out.println("Se acabaron las palabras");
							timer.cancel();
						}
					}
					
				};
			};
			
			timer.scheduleAtFixedRate(event, 120, 5);
	}
	
	
	
	
	
	
	private class Escucha extends MouseAdapter implements KeyListener {
		
		public void mouseClicked( MouseEvent eventMouse ) {
			
			if( eventMouse.getSource() == jugarButton ) {
				
				if( flag ) {
					flag=false;
					loginGUI = new LoginGUI( login );
				}
				
				boolean temp = loginGUI.getSignInSuccessful();
				
				if( temp ) {
					System.out.println( "username: "+ login.getUsername() );
					username = login.getUsername();
					gameLogic = new GameLogic( usersDataFilePath, wordsListFilePath, login.getUsername() );
					gameLogic.fillWordsInPlay();

					homePanel.setVisible(false);
					gameZonePanel.setVisible(true);
					temp=false;
					
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
				//homePanel.repaint();
				//howToPlayPanel.repaint();				
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
				//gameZonePanel.setVisible(true);
				//rankingPanel.repaint();
			}
			else if( eventMouse.getSource() == goBackButton ) {
				
				gameZonePanel.setVisible(false);
				homePanel.setVisible(true);
				jugarButton.setLocation(850,310);
				homePanel.add(jugarButton,0);

				flag=true;
			}
			
		}// END method mouseClicked

		
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}// END private class Escucha
	
	
}// END class GUIWordGame
