package wordsGame;

import java.awt.EventQueue;


public class Main {

	public static void main(String[] args) {		
		// TODO Auto-generated method stub
		
		String path = "src/storageFiles/listWords.txt", path2 = "src/storageFiles/userData.txt";		
		
		EventQueue.invokeLater( new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
			
				GUIWordGame guiWordGame = new GUIWordGame( path2, path );				
				
			}
		} );
		
		
		
	}

}
