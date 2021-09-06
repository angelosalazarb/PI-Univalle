package wordsGame;

import java.awt.EventQueue;
import java.util.ArrayList;


public class main {

	public static void main(String[] args) {
		
		
		EventQueue.invokeLater( new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				GameGUI gui = new GameGUI();				
				
			}
		} );
		
		
		
		
		// TODO Auto-generated method stub
	
		/**
		 * System.out.println(gameLogic.getWordsInPlay().size());
   		   System.out.println(  ((gameLogic.getUserLevel()+1)*4)  );
		   System.out.println(  gameLogic.getWordsInPlay().size()==((gameLogic.getUserLevel()+1)*4)   );
		 */
		
		String temp, path = "src/storageFiles/listWords.txt", path2 = "src/storageFiles/userData.txt";
		
		//InputOutput varInputOutput = new InputOutput();
		//User user = new User("juan", "la vaca lola", 3);
		//Login login = new Login(path2);
		//GameLogic gamelogic = new GameLogic( path2, path, "juan1" );
		
		//ConsoleView consoleView = new ConsoleView(path2, path);
		
		//consoleView.startGame();
		
		//ArrayList<Integer> myvector = new ArrayList<>();
		//ArrayList<Integer> myvector2 = new ArrayList<>();
		/*
		myvector.add(1);
		myvector.add(2);
		myvector.add(3);
		myvector2.add(20);
		myvector2.add(21);
		myvector2.add(22);
		myvector.addAll(myvector2);
		System.out.println(myvector);
		System.out.println(myvector2);
		/*
		
		
		
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
