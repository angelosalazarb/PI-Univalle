/*
 * Autor: JUAN JOSE BAILON	
 * e-mail: juan.bailon@correounivalle.edu.co
 */
package utilities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class DrawRect. draws a rectangle that is gonna be use as a text field
 */
public class DrawRect extends JPanel {
	
	private int  width, height;
	private String word;
	
	
	/**
	 * Instantiates a new draw rect.
	 *
	 * @param width the width
	 * @param height the height
	 */
	public DrawRect(int width, int height) {
	
		this.word="";
		this.width = width;
		this.height = height;
		this.setOpaque(false);
	}
	
	/**
	 * Adds the charecter.
	 *
	 * @param userChar the user char
	 */
	public void addCharecter(char userChar) {
		
		this.word += String.valueOf(userChar);
		repaint();
	}
	
	/**
	 * Removes the last character.
	 */
	public void removeLastCharacter() {
		
		if( this.word.length()>0 ) {
			this.word = word.substring(0, word.length()-1 );
			repaint();			
		}
	}
	
	/**
	 * Paint part.
	 */
	public void paintPart() {
		repaint();
	}
	
	/**
	 * Paint component.
	 *
	 * @param g the g
	 */
	public void paintComponent(Graphics g) {
		
        g.setColor( Color.BLACK );
        g.fillRect(0, 0, this.width, this.height);
        
        g.setColor(Color.GREEN.brighter());
        g.draw3DRect(0, 0, width, height, true);
        
        g.setFont( new Font("DialogInput", Font.PLAIN, 28) );
        g.drawString(this.word, 10, height-10);
        
        super.paintComponent(g);
	}

	
	/**
	 * Gets the word.
	 *
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * Sets the word.
	 *
	 * @param word the new word
	 */
	public void setWord(String word) {
		this.word = word;
	}
	
	
	
}
