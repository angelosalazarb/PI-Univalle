package utilities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class DrawRect extends JPanel {
	
	int x, y, width, height, arcRadius, arcHeight, radius;
	String word;
	
	
	public DrawRect(int width, int height) {
		
		//this.x = x;
		//this.y = y;
		this.word="";
		this.width = width;
		this.height = height;
		this.setOpaque(false);
		//this.setFocusable(true);
	}
	
	public void addCharecter(char userChar) {
		//String temp = this.word+ String.valueOf(userChar) ;
		this.word += String.valueOf(userChar);
		repaint();
	}
	
	public void removeLastCharacter() {
		
		if( this.word.length()>0 ) {
			this.word = word.substring(0, word.length()-1 );
			repaint();			
		}
	}
	
	public void paintPart() {
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		
        g.setColor( Color.BLACK );
        g.fillRect(0, 0, this.width, this.height);
        
        g.setColor(Color.GREEN.brighter());
        g.draw3DRect(0, 0, width, height, true);
        
        g.setFont( new Font("DialogInput", Font.PLAIN, 28) );
        g.drawString(this.word, 10, height-10);
        
        super.paintComponent(g);
	}

	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	
	
}
