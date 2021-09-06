package wordsGame;

import java.awt.EventQueue;
import java.util.ArrayList;

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
				//GameGUI gui = new GameGUI();
				LoginGUI loginGui = new LoginGUI(login); 
				
				//System.out.println( loginGui.getSignInSuccessful() );
				
			}
		} );
		
		
		
		//InputOutput varInputOutput = new InputOutput();
		//User user = new User("juan", "la vaca lola", 3);
		//Login login = new Login(path2);
		//GameLogic gamelogic = new GameLogic( path2, path, "juan1" );
		
		//ConsoleView consoleView = new ConsoleView(path2, path);
		
		//consoleView.startGame();
		
		//ArrayList<Integer> myvector = new ArrayList<>();
		//ArrayList<Integer> myvector2 = new ArrayList<>();	
		
		
		/*
		int num = gamelogic.determineWordsInPlay();
		gamelogic.fillWordsInPlay();
		
		System.out.println( gamelogic.getUserLevel() );
		System.out.println( gamelogic.getWordsInPlay() );
		System.out.println( gamelogic.getImportedWords().size() );
		System.out.println( gamelogic.getImportedWords().size() );
		System.out.println( gamelogic.checkForMatchingWords("ALQUILER") );
		gamelogic.addUserInputWord("ALQUILER");
		System.out.println( gamelogic.getCorrectWords() );
		*/
		
	}

}
