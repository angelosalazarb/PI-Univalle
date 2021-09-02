package wordsGame;

import java.util.ArrayList;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		String temp, path = "src/storageFiles/listWords.txt", path2 = "src/storageFiles/userData.txt";
		
		//InputOutput varInputOutput = new InputOutput();
		//User user = new User("juan", "la vaca lola", 3);
		//Login login = new Login(path2);
		GameLogic gamelogic = new GameLogic( path2, path, "juan1" );
		
		//ArrayList<String> myvector = new ArrayList<String>();
		
		int num = gamelogic.determineWordsInPlay();
		
		System.out.println();
		
		
	}

}
