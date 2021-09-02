/*
 * Autors: Juan José Bailon, Ángelo Salazar Bermúdez, Juan José Revelo
 * Email: angelo.salazar@correounivalle.edu.co
 */

package wordsGame;

import java.util.ArrayList;

public class gameLogic {

	InputOutput inputOutput;
	Login  login;
	String userName;
	public int lvl, correctWordsCounter, badWordsCounter;
	private ArrayList<String> importedWords;
	public ArrayList<String> correctWords, droppedWords, userWords;
	
	
	public gameLogic() {

        this.importedWords = new ArrayList<>();
        this.correctWords = new ArrayList<>();
        this.droppedWords = new ArrayList<>();
        this.userWords = new ArrayList<>();

        inputOutput = new InputOutput();
        login = new Login();
        lvl = 0;

    }
	
	 public gameLogic(String usersPath) {

	        this.importedWords = new ArrayList<>();
	        this.correctWords = new ArrayList<>();
	        this.droppedWords = new ArrayList<>();
	        this.userWords = new ArrayList<>();

	        inputOutput = new InputOutput();
	        login = new Login(usersPath);
	        lvl = 0;

	    }

	    public void importWords(String filePath) {
	    	
	        importedWords = inputOutput.readFileToAnArray(filePath);
	        System.out.println(importedWords.get(4));
	    }
	
	    public void userInputWords(String userWord)
	    {
	    	userWord = userWord.toUpperCase();
	    	userWords.add(userWord);
	    	System.out.println(userWords.get(userWords.size()-1));
	    }
	    
	    public int  getUserLevel(String username) {
	    	String strlvl;
	    	strlvl = login.getUserInfo(username).get("level");
	    	lvl = Integer.valueOf(strlvl);
	    	return  lvl;
	    }
	    
	    public String getUserName(String username) {
	    	userName = login.getUserInfo(username).get("username");
	    	return  userName;
	    }

}
