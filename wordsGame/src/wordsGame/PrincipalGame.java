package wordsGame;

import java.awt.EventQueue;

import utilities.Logi;





public class PrincipalGame {

	public static void main(String[] args) {

		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				GUIWordGame miVista = new GUIWordGame();
				//Logi miVista = new Logi();
			}
		});

	}
	}

