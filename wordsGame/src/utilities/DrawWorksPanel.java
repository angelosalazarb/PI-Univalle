package utilities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;


public class DrawWorksPanel extends JPanel {

	ArrayList< HashMap<String, String> > wordsList;
	
	public DrawWorksPanel() {
		setOpaque(false);
		//setBackground(Color.ORANGE);
		this.wordsList = new ArrayList<>();
	}
	
	
	public void showWordInPanel(String userWord, boolean isWrong ) {
		
		HashMap<String, String> newWord = new HashMap<String, String>();
		
		newWord.put("word", userWord );
		newWord.put("isWrong", String.valueOf(isWrong) );
		wordsList.add(newWord);
		
		repaint();
	}
	
	public void clearPanel() {
		
		wordsList.clear();
		repaint();
	}
	
	
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
		
		/*
		g.setColor( Color.GREEN );
		g.drawString("RASCACIELOS", 0, 22);
		g.drawString("ADOLESCENTE", 170, 22);
		g.drawString("RASCACIELOS", 340, 22);
		
		g.setColor( Color.RED );
		g.drawString("ADOLESCENTE", 0, 22+22+10);
		*/
	}
	
	
}
