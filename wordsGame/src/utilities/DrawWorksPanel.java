/*
 * Author: JUAN JOSE BAILON
 * e-mail: juan.bailon@correounivalle.edu.co
 */
package utilities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;


// TODO: Auto-generated Javadoc
/**
 * The Class DrawWorksPanel.this class is the JPanel in witch the words inputed by the palyer
 * 							are gonna be draw
 */
public class DrawWorksPanel extends JPanel {

	/** The words list. */
    private	ArrayList< HashMap<String, String> > wordsList;
	
	/**
	 * Instantiates a new draw works panel.
	 */
	public DrawWorksPanel() {
		setOpaque(false);
		//setBackground(Color.ORANGE);
		this.wordsList = new ArrayList<>();
	}
	
	
	/**
	 * Show word in panel.
	 *
	 * @param userWord the user word
	 * @param isWrong the is wrong
	 */
	public void showWordInPanel(String userWord, boolean isWrong ) {
		
		HashMap<String, String> newWord = new HashMap<String, String>();
		
		newWord.put("word", userWord );
		newWord.put("isWrong", String.valueOf(isWrong) );
		wordsList.add(newWord);
		
		repaint();
	}
	
	/**
	 * Clear panel.
	 */
	public void clearPanel() {
		
		wordsList.clear();
		repaint();
	}
	
	
	/**
	 * Paint component.
	 *
	 * @param g the g
	 */
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.setFont( new Font("DialogInput", Font.BOLD, 22) );
		
		
		int row=0, col=0, y=0;
		
		for( HashMap<String, String> myWord : wordsList ) {

			y = (row==0)? 22 : (col==0)? y+22+10 : y ;
			
			if( Boolean.valueOf( myWord.get("isWrong") ) ) {
				
				g.setColor( Color.RED );				
				g.drawString( myWord.get("word") , 170*col, y );				
			}
			else {
								
				g.setColor( Color.GREEN );
				g.drawString( myWord.get("word") , 170*col, y );
			}
			
			
			if(col==2) {
				row++;
				col=0;
			}
			else {
				col++;
			}
			
		}
		
		
	}
	
	
}
