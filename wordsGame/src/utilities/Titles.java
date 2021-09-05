package utilities;

import java.awt.Color;

import javax.swing.JLabel;
/*
 * This class create the Title JLabel to will use the GameFont in the project development
 */
public class Titles extends JLabel{

	private static final long serialVersionUID = 1L;
	
	public Titles(String text, float size) {
		this.setText(text);
		this.setFont(GameFont.pixeled.deriveFont(size));
		this.setForeground(Color.WHITE);
	}
	
}
