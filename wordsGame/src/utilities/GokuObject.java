package utilities;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * @Author: �ngelo Salazar, Juan Jos� Revelo, Juan Jos� Bailon
 * This class extends from JPanel and create a object of Goku with two JLabels, this allows 
 * to work and use this JPanel like and object and give facilities to implement it in the GUI
 */
public class GokuObject extends JPanel {
	
	private JLabel cloud, wordLabel;
	private String usedWord;
	private Font pixeled;
	
	public GokuObject(String newWord) {
		this.setOpaque(false);
		try {
			pixeled = Font.createFont(Font.TRUETYPE_FONT, new File(GokuObject.class.getResource("/fonts/pixeled.ttf").getFile()));
			GraphicsEnvironment graphicE = GraphicsEnvironment.getLocalGraphicsEnvironment();
			graphicE.registerFont(pixeled);
			
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.setLayout(null);
		this.usedWord = newWord;
		this.wordLabel = new JLabel(usedWord);
		float size = 17;
		wordLabel.setForeground(new Color(0,0,0));
		wordLabel.setBounds(26,5, 350, 350);
		wordLabel.setFont(pixeled.deriveFont(size));
		cloud = new JLabel();
		cloud.setIcon(new ImageIcon(GokuObject.class.getResource("/imagenes/gokuFlying.gif")));
		cloud.setBounds(0,0,250,250);
		
		add(wordLabel);
		add(cloud);
		this.setSize(250,250);
		this.setVisible(true);
		
	}
	
	public void setText(String text) {
		wordLabel.setText(text);
	}
}
