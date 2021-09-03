package wordsGame;

import java.awt.EventQueue;





public class PrincipalGame {

	public static void main(String[] args) {

		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				GUIWordGame miVista = new GUIWordGame();
			}
		});

	}
	}

