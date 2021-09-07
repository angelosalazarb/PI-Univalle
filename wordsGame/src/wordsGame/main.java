package wordsGame;

import java.awt.EventQueue;
import java.util.ArrayList;

import utilities.LoginGUI;


public class main {

	public static void main(String[] args) {		
		// TODO Auto-generated method stub

		String temp, path = "src/storageFiles/listWords.txt", path2 = "src/storageFiles/userData.txt" ;

		EventQueue.invokeLater( new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Login login = new Login(path2);
				//LoginGUI loginGui = new LoginGUI(login);
				GUIWordGame guiWordGame = new GUIWordGame( path2 );
				
				
			}
		} );
		
		
		
		//InputOutput varInputOutput = new InputOutput();
		//User user = new User("juan", "la vaca lola", 3);
		//Login login = new Login(path2);
		//GameLogic gamelogic = new GameLogic( path2, path, "juan5" );
		ConsoleView consoleView = new ConsoleView(path2, path);
		//GameLogic gamelogic = new GameLogic( path2, path, "juan1" );
		
		//ConsoleView consoleView = new ConsoleView(path2, path);
		
		consoleView.startGame();
		
		//ArrayList<Integer> myvector = new ArrayList<>();
		//ArrayList<Integer> myvector2 = new ArrayList<>();	
		
		
		/*
		int num = gamelogic.determineWordsInPlay();
		gamelogic.fillWordsInPlay();
		
		System.out.println( gamelogic.getUserLevel() );
		System.out.println( gamelogic.getWordsInPlay() );
		System.out.println( gamelogic.getImportedWords().size() );
		System.out.println( gamelogic.getImportedWords().size() );
		System.out.println( gamelogic.checkForMatchingWords("BICHO") );
		gamelogic.addUserInputWord("BICHO");
		System.out.println( gamelogic.getCorrectWords() );
		*/
		
	}

}
