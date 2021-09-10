package wordsGame;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import utilities.LoginGUI;


public class main {

	public static void main(String[] args) {		
		// TODO Auto-generated method stub
		
		String temp, path = "src/storageFiles/listWords.txt", path2 = "src/storageFiles/userData.txt";		
		
		EventQueue.invokeLater( new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Login login = new Login(path2);
				//LoginGUI loginGui = new LoginGUI(login);
				GUIWordGame guiWordGame = new GUIWordGame( path2, path );
				
				
			}
		} );
		
		
		//GameLogic gameLogic = new GameLogic(path2, path, "revelo");
		
		//System.out.println( gameLogic.getWordsInPlay() );
		
		
		
	}

}
