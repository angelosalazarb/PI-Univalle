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
		
		/*
		ArrayList<User> myvector = new ArrayList<>();
		
		myvector.add( new User( "juan1", "hola", 1 ) );
		myvector.add( new User( "juan2", "hola", 2 ) );
		myvector.add( new User( "juan5", "hola", 5 ) );
		myvector.add( new User( "juan3", "hola", 3 ) );
		myvector.add( new User( "juan9", "hola", 9 ) );
		myvector.add( new User( "juan4", "hola", 4 ) );
		
		if(myvector.size()>5)  myvector.subList(4, 6).clear();
		
		System.out.println( myvector );
		
		for(User i : myvector) {
			System.out.println( i.getUsername()+" "+i.getLevel() );
		}
		
		
		myvector.sort( (User us1, User us2)->  us2.getLevel()-us1.getLevel()  );
		System.out.println( myvector );
		
		for(User i : myvector) {
			System.out.println( i.getUsername()+" "+i.getLevel() );
		}
		*/
		
		
		EventQueue.invokeLater( new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Login login = new Login(path2);
				//LoginGUI loginGui = new LoginGUI(login);
				GUIWordGame guiWordGame = new GUIWordGame( path2, path );
				
				
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
