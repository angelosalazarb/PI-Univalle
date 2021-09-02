package wordsGame;

import java.util.ArrayList;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		String temp, path = "src/storageFiles/listWords.txt", path2 = "src/storageFiles/userData.txt";
		
		gameLogic tryGameL = new gameLogic("src/storageFiles/userData.txt");
		
		//InputOutput varInputOutput = new InputOutput();
		//User user = new User("juan", "la vaca lola", 3);
		//Login login = new Login(path2);
		
	
		ArrayList<String> myvector = new ArrayList<String>();
		
		Login juan1 = new Login("src/storageFiles/userData.txt");
		
		tryGameL.importWords("src/storageFiles/listWords.txt");
		tryGameL.userInputWords("PERRO");
		tryGameL.userInputWords("GATO");
		tryGameL.userInputWords("gallo");
		juan1.getUserInfo("juan1");
		System.out.println(tryGameL.getUserLevel("juan1"));
		System.out.println(tryGameL.getUserName("juan1"));

	}

}
