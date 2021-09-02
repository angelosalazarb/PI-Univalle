package wordsGame;

import java.util.ArrayList;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		String temp, path = "src/storageFiles/listWords.txt", path2 = "src/storageFiles/userData.txt";
		
		gameLogic tryGameL = new gameLogic();
		
		//InputOutput varInputOutput = new InputOutput();
		//User user = new User("juan", "la vaca lola", 3);
		//Login login = new Login(path2);
		
	
		ArrayList<String> myvector = new ArrayList<String>();
		
		tryGameL.importWords("src/storageFiles/listWords.txt");
		tryGameL.userInputWords("PERRO");
		tryGameL.userInputWords("GATO");
		tryGameL.userInputWords("gallo");
		
	}

}
