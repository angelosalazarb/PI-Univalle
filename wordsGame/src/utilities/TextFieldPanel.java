package utilities;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TextFieldPanel extends JPanel {
	
	private int x, y, width, height, arcWidth, arcHeight;
	
	public TextFieldPanel( int x, int y, int width, int height, int arcWidth, int arcHeight ) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.arcWidth = arcWidth;
		this.arcHeight = arcHeight;
	}
	
	public void paintComponent( Graphics g ) {
		
		super.paintComponent(g);
		
		g.setColor(Color.ORANGE);
		g.drawRoundRect( this.x, this.y, this.width, this.height, this.arcWidth, this.arcHeight);
		
	}

}
