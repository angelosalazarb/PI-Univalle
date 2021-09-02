package wordsGame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUIWordGame extends JFrame {
	private JPanel panelJuego, panelInicio, panelComoJugar;
	private JLabel botonJugar,botonComoJugar, fondoInicio,fondoJuego, fondoComoJugar;
	private JFrame ventana;
	
	public GUIWordGame() {
		
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
		panelJuego.add(fondoJuego,0);
		
		
		botonJugar.addMouseListener(new MouseAdapter () {
			public void mousePressed(MouseEvent e) {
				panelInicio.setVisible(false);
				ventana.add(panelJuego);
				panelJuego.setVisible(true);
			}
		});
		
		botonComoJugar.addMouseListener(new MouseAdapter () {
			public void mousePressed(MouseEvent e) {
				panelInicio.setVisible(false);
				ventana.add(panelComoJugar);
				panelComoJugar.setVisible(true);
			}
		});
		
		
		
		
		ventana.add(panelInicio);
		ventana.setVisible(true);
			
			
			}
}