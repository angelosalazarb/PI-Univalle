package utilities;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;


/*
 * This class will create a specific font that will be used in the project
 */
public class GameFont {
	public static java.awt.Font pixeled = GameFont.textFont();

	private static Font textFont() {
		try {
			pixeled = Font.createFont(Font.TRUETYPE_FONT, new File(Titles.class.getResource("/fonts/pixeled.ttf").getFile()));
			GraphicsEnvironment graphicE = GraphicsEnvironment.getLocalGraphicsEnvironment();
			graphicE.registerFont(pixeled);
			
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pixeled;
	}
}
