package wordsGame;

<<<<<<< HEAD
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.MouseListener;
import java.util.concurrent.TimeUnit;
=======
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

>>>>>>> 5938b68a60e068d115611c719b8040f7698d9a9f
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

<<<<<<< HEAD
import utilities.GameFont;
import utilities.GokuObject;
import utilities.Logi;
import utilities.Titles;
import utilities.PlayMusic;

public class GUIWordGame extends JFrame {
	private JPanel panelJuego, panelInicio, panelComoJugar, panelUsuario;
	private JLabel botonJugar,botonComoJugar,botonAtras, botonSalir, botonJugar1;
	private JLabel fondoInicio,fondoJuego, fondoComoJugar;
	private JFrame ventana;
	private GokuObject goku;
	private PlayMusic music; 
	private Logi login;
	

	public GUIWordGame() {
		this.goku = new GokuObject("");
		this.login = new Logi();
		this.goku = new GokuObject("");
		this.music = new PlayMusic();
		
		
		ArrayList<String> wordsInGame;
		wordsInGame = new ArrayList<String>();
		
		wordsInGame.add("Prueba1");
		wordsInGame.add("Prueba2");
		wordsInGame.add("Prueba3");
		wordsInGame.add("Prueba4");
		wordsInGame.add("Prueba5");
		
		//ventana
		ventana = new JFrame("Words Game");
		ventana.setSize(1200,600);
		ventana.setLayout(null);
		ventana.setResizable(false);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		
		//panel incio
		panelInicio = new JPanel();
		
		panelInicio.setSize(1200,600);
		panelInicio.setLocation(0,0);
		panelInicio.setLayout(null);
		panelInicio.setVisible(true);
		
		//fondo inicio
		fondoInicio = new JLabel();
		fondoInicio.setSize(1200,600);
		fondoInicio.setLocation(0,0);
		fondoInicio.setIcon(new ImageIcon("src/imagenes/fondopri1.jpg"));
		fondoInicio.setVisible(true);
		panelInicio.add(fondoInicio,0);
		
		//boton jugar
		botonJugar = new JLabel();
		botonJugar.setSize(212,116);
		botonJugar.setLocation(850,310);
		botonJugar.setIcon(new ImageIcon("src/imagenes/botonjugar1.png"));
		botonJugar.setVisible(true);
		panelInicio.add(botonJugar,0);
		
		
		//Boton como jugar
		botonComoJugar = new JLabel();
		botonComoJugar.setSize(318,106);
		botonComoJugar.setLocation(820,410);
		botonComoJugar.setIcon(new ImageIcon("src/imagenes/comojugar (1).png"));
		botonComoJugar.setVisible(true);
		panelInicio.add(botonComoJugar,0);
		
		//panel como jugar
		panelComoJugar= new JPanel();				
		panelComoJugar.setSize(1200,600);
		panelComoJugar.setLocation(0,0);
		panelComoJugar.setLayout(null);
		
		//fondo como jugar
		fondoComoJugar = new JLabel();
		fondoComoJugar.setSize(1200,600);
		fondoComoJugar.setLocation(0,0);
		fondoComoJugar.setIcon(new ImageIcon("src/imagenes/fondocomojugar.jpg"));
		fondoComoJugar.setVisible(true);
		panelComoJugar.add(fondoComoJugar,0);
		
		//panel usuario
		panelUsuario= new JPanel();				
		panelUsuario.setSize(1200,600);
		panelUsuario.setLocation(0,0);
		panelUsuario.setLayout(null);
		
		//boton salir
		botonSalir = new JLabel();
		botonSalir.setSize(318,106);
		botonSalir.setLocation(110,450);
		botonSalir.setIcon(new ImageIcon("src/imagenes/botonsalir1.png"));
		botonSalir.setVisible(true);
		panelComoJugar.add(botonSalir,0);
		
		//boton jugar de la pantalla de como jugar
		botonJugar1 = new JLabel();
		botonJugar1.setSize(212,116);
		botonJugar1.setLocation(350,425);
		botonJugar1.setIcon(new ImageIcon("src/imagenes/botonjugar1.png"));
		botonJugar1.setVisible(true);
		panelComoJugar.add(botonJugar1,0);
				
		//panel juego
		panelJuego = new JPanel();				
		panelJuego.setSize(1200,600);
		panelJuego.setLocation(0,0);
		panelJuego.setLayout(null);
			
		//fondo juego
		fondoJuego = new JLabel();
		fondoJuego.setSize(1200,600);
		fondoJuego.setLocation(0,0);
		fondoJuego.setIcon(new ImageIcon("src/imagenes/IjQ1.gif"));
		fondoJuego.setVisible(true);
		goku.setLocation(600,150);
		panelJuego.add(fondoJuego,0);
	
		//boton atras
		botonAtras = new JLabel();
		botonAtras.setSize(150,150);
		botonAtras.setLocation(1055,0);
		botonAtras.setIcon(new ImageIcon("src/imagenes/klipartz.com.png"));
		botonAtras.setVisible(true);
		panelJuego.add(botonAtras,0);
		
		
		//evento del boton jugar con click panel inicio
		botonJugar.addMouseListener(new MouseAdapter () {
			
			public void mousePressed(MouseEvent e) {
				panelInicio.setVisible(true);
				ventana.add(panelJuego);
				panelJuego.setVisible(true);
				gokuFlying(wordsInGame);
			     
			}
		});
				
		//evento del boton jugar con click panel como jugar
		botonJugar1.addMouseListener(new MouseAdapter () {
			public void mousePressed(MouseEvent e) {
				panelComoJugar.setVisible(true);
				ventana.add(panelJuego);				
				panelJuego.setVisible(true);
				gokuFlying(wordsInGame);
			}
		});
			
		//evento del boton como jugar con click
		botonComoJugar.addMouseListener(new MouseAdapter () {
			public void mousePressed(MouseEvent e) {
				panelInicio.setVisible(false);
				ventana.add(panelComoJugar);
				panelComoJugar.setVisible(true);
				
			}
		});
		
		//evento del boton salir con click
		botonSalir.addMouseListener(new MouseAdapter () {
			public void mousePressed(MouseEvent e) {
				panelComoJugar.setVisible(false);
				ventana.add(panelInicio);
				panelInicio.setVisible(true);
			}
		});
		
		//evento del boton atras con click
		botonAtras.addMouseListener(new MouseAdapter () {
			public void mousePressed(MouseEvent e) {
				panelJuego.setVisible(false);
				ventana.add(panelInicio);
				panelInicio.setVisible(true);
			}
		});
					
		ventana.add(panelInicio);
		ventana.setVisible(true);
		login = new Logi();	
			

			
			}
	
	/*
	 * @Author: Ángelo Salazar
	 * Contract: <gokuFlying><void><ArrayList<String>> ---> <List>
	 * Purpose: This method will move Goku from side to side of the screen
	 * and will showing the words that are in the array this words are the words in play
	 * @param ArrayList<String> wordsInGame
	 * @return <void>
	 * */
	
	public void gokuFlying(ArrayList<String >wordsInGame) {
		music.play("src/music/nubecita.wav");
	Timer timer = new Timer();
	TimerTask event = new TimerTask() {
		int ctr = 0;
		int x = 1200;
		
		@Override
			
			public void run() {
			
					if(x > -200) {
						goku.setLocation(x, 150);
						panelJuego.add(goku,0);
						x = x - 2;
						System.out.println("X: " + x);
						System.out.println("CTR: " + ctr);
					}
					else if(x == -200) {
						x = 1200;
						if(ctr<wordsInGame.size()) {
							goku.setText(wordsInGame.get(ctr));
							System.out.println("OUT");
							System.out.println("CTR2: " + ctr);
							ctr ++;
						}
						else {
							login = new Logi(); 
							System.out.println("Se acabaron las palabras");
							timer.cancel();
						}
					}
					
				};
			};
	timer.scheduleAtFixedRate(event, 120, 5);
	}


}



	

=======
import utilities.LoginGUI;


public class GUIWordGame extends JFrame {
	
	private JFrame myWindow;
	private JPanel homePanel, howToPlayPanel, gameZonePanel;
	private JLabel jugarButton, comoJugarButton, salirButton, goBackButton;
	private JLabel homeBackground, gameZoneBackground, howToPlayBackground;
	private Escucha escucha;
	private Login login;
	private LoginGUI loginGUI;
	private String usersDataFilePath, wordsListFilePath;
	//private boolean sigInSuccesful;
	private boolean flag;
	
	
	
	public GUIWordGame( String usersDataFilePath ) {
		
		this.usersDataFilePath = usersDataFilePath;
		login = new Login( this.usersDataFilePath );
		
		this.flag = true;
		//loginGUI = new LoginGUI( login );
		//this.sigInAlready=false;
		
		//loginGUI lgui = new LoginGUI(login, this);
		
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
		
		//salir button in how to play screen
		salirButton = new JLabel();
		salirButton.setSize(318,106);
		salirButton.setLocation(110,450);
		salirButton.setIcon(new ImageIcon("src/imagenes/botonsalir1.png"));
		salirButton.setVisible(true);
		salirButton.addMouseListener(escucha);
		howToPlayPanel.add(salirButton,0);
		
		
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
		//goku.setLocation(600,150);
		gameZonePanel.add(gameZoneBackground,0);
	
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
		this.add(gameZonePanel);

	}
	
	
	
	
	
	
	private class Escucha extends MouseAdapter {
		
		public void mouseClicked( MouseEvent eventMouse ) {
			
			if( eventMouse.getSource() == jugarButton ) {
				
				if( flag ) {
					flag=false;
					loginGUI = new LoginGUI( login );
				}
				
				boolean temp = loginGUI.getSignInSuccessful();
				
				if( temp ) {
					homePanel.setVisible(false);
					gameZonePanel.setVisible(true);
					temp=false;
				}
				else {
					loginGUI.setVisible(true);
				}
				
			}
			else if ( eventMouse.getSource() == comoJugarButton ) {
								
				homePanel.setVisible(false);
				homePanel.remove(jugarButton);
				
				jugarButton.setLocation(350,425);
				howToPlayPanel.add(jugarButton,0);
				howToPlayPanel.setVisible(true);
				//homePanel.repaint();
				//howToPlayPanel.repaint();				
			}
			else if( eventMouse.getSource() == salirButton ) {
				
				howToPlayPanel.setVisible(false);
				howToPlayPanel.remove(jugarButton);

				jugarButton.setLocation(850,310);
				homePanel.add(jugarButton,0);
				homePanel.setVisible(true);
	
			}
			else if( eventMouse.getSource() == goBackButton ) {
				
				gameZonePanel.setVisible(false);
				homePanel.setVisible(true);
				jugarButton.setLocation(850,310);
				homePanel.add(jugarButton,0);

				flag=true;
			}
			
		}// END method mouseClicked
		
	}// END private class Escucha
	
	
}// END class GUIWordGame
>>>>>>> 5938b68a60e068d115611c719b8040f7698d9a9f
