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

public class Logi extends JFrame {	
	private JPanel panelUsuario;
	private JLabel usuario, contraseņa, fondo;
	private JFrame ventana;
	private JTextField usu;
	private JPasswordField contra;
	private JButton btnIng;
	public boolean usuar;
	
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
	
	contraseņa = new JLabel("Contraseņa:");
	contraseņa.setSize(70,40);
	contraseņa.setLocation(380,120);
	contraseņa.setVisible(true);
	panelUsuario.add(contraseņa,0);
	
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
	
	btnIng.addMouseListener(new MouseAdapter () {
		public void mousePressed(MouseEvent e) {
		
		String usuari = usu.getText();
		@SuppressWarnings("deprecation")
		String contraseņ = contra.getText();
		
		if(usuari.isEmpty() || contraseņ.isEmpty()) {
			JOptionPane.showMessageDialog(null,"Tiene un campo vacio");
		}else {
			if(usuari.equals("juan1") && contraseņ.equals(("1234"))){
				ventana.setVisible(false);
				JOptionPane.showMessageDialog(null,"BIENVENIDO");
				
			}else {
				usuar = false;
				JOptionPane.showMessageDialog(null,"su usuario o contraseņa es incorrecto");
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
		String contraseņ = this.contra.getText();
		
		if(usuari.isEmpty() || contraseņ.isEmpty()) {
			JOptionPane.showMessageDialog(null,"Tiene un campo vacio");
		}else {
			if(usuari.equals("juan1") && contraseņ.equals(("1234"))){
				JOptionPane.showMessageDialog(null,"bienvenido");
			}else {
				JOptionPane.showConfirmDialog(null,"su usuario o contraseņa es incorrecto");
			}
		}
	}*/
}
