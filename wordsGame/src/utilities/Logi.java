package utilities;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

// TODO: Auto-generated Javadoc
/**
 * The Class Logi. Esta clase permite ver la venta de login
 */
public class Logi extends JFrame {	
	
	/** The panel usuario. */
	private JPanel panelUsuario;
	
	/** The fondo. */
	private JLabel usuario, contraseña, fondo;
	
	/** The ventana. */
	private JFrame ventana;
	
	/** The usu. */
	private JTextField usu;
	
	/** The contra. */
	private JPasswordField contra;
	
	/** The btn ing. */
	private JButton btnIng;
	
	/** The usuar. */
	public boolean usuar;
	
	/**
	 * Instantiates a new logi.
	 */
	public Logi() {
	ventana =new JFrame();
	ventana.setSize(600,338);
	ventana.setLocation(430,200);
	ventana.setVisible(true);
	ventana.setResizable(false);
	
	
		
	panelUsuario= new JPanel();				
	panelUsuario.setSize(600,338);
	panelUsuario.setLocation(0,0);
	panelUsuario.setLayout(null);
	
	fondo = new JLabel();
	fondo.setSize(600,338);
	fondo.setLocation(0,0);
	fondo.setIcon(new ImageIcon("src/imagenes/gokulogin.jpg"));
	fondo.setVisible(true);
	panelUsuario.add(fondo,0);
	
	usuario = new JLabel("Usuario:");
	usuario.setSize(70,40);
	usuario.setLocation(390,70);
	usuario.setVisible(true);
	panelUsuario.add(usuario,0);
	
	contraseña = new JLabel("Contraseña:");
	contraseña.setSize(70,40);
	contraseña.setLocation(380,120);
	contraseña.setVisible(true);
	panelUsuario.add(contraseña,0);
	
	usu = new JTextField();
	usu.setSize(90,20);
	usu.setLocation(460,80);
	usu.setVisible(true);
	panelUsuario.add(usu,0);
	
	contra = new JPasswordField();
	contra.setSize(90,20);
	contra.setLocation(460,130);
	contra.setVisible(true);
	panelUsuario.add(contra,0);
	
	btnIng= new JButton("Ingresar");
	btnIng.setSize(90,20);
	btnIng.setLocation(440,200);
	btnIng.setVisible(true);
	
	panelUsuario.add(btnIng,0);
	

	ventana.add(panelUsuario);
	
	//Boton ingresar
	
	btnIng.addMouseListener(new MouseAdapter () {
		public void mousePressed(MouseEvent e) {
		
		String usuari = usu.getText();
		@SuppressWarnings("deprecation")
		String contraseñ = contra.getText();
		
		if(usuari.isEmpty() || contraseñ.isEmpty()) {
			JOptionPane.showMessageDialog(null,"Tiene un campo vacio");
		}else {
			if(usuari.equals("juan1") && contraseñ.equals(("1234"))){
				ventana.setVisible(false);
				JOptionPane.showMessageDialog(null,"BIENVENIDO");
				
			}else {
				usuar = false;
				JOptionPane.showMessageDialog(null,"su usuario o contraseña es incorrecto");
			}
		}
		}
	});
	
	}
	/*
	@SuppressWarnings("unused")
		btnIng.ActionPerformed(ActionEvent e) {
		String usuari = this.usu.getText();
		@SuppressWarnings("deprecation")
		String contraseñ = this.contra.getText();
		
		if(usuari.isEmpty() || contraseñ.isEmpty()) {
			JOptionPane.showMessageDialog(null,"Tiene un campo vacio");
		}else {
			if(usuari.equals("juan1") && contraseñ.equals(("1234"))){
				JOptionPane.showMessageDialog(null,"bienvenido");
			}else {
				JOptionPane.showConfirmDialog(null,"su usuario o contraseña es incorrecto");
			}
		}
	}*/
}
