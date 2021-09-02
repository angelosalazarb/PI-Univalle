/*
 * Autors: Juan José Bailon, Ángelo Salazar Bermúdez, Juan José Revelo
 * Email: angelo.salazar@correounivalle.edu.co
 */

package wordsGame;

import java.util.ArrayList;

public class gameLogic {

	InputOutput getGameWords;
	public int lvl, correctWordsCounter, badWordsCounter;
	private ArrayList<String> importedWords;
	public ArrayList<String> correctWords, droppedWords, userWords;
	
	 public gameLogic() {

	        this.importedWords = new ArrayList<>();
	        this.correctWords = new ArrayList<>();
	        this.droppedWords = new ArrayList<>();
	        this.userWords = new ArrayList<>();

	        getGameWords = new InputOutput();


	    }

	    public void importWords(String filePath) {
	    	
	        importedWords = getGameWords.readFileToAnArray(filePath);
	        System.out.println(importedWords.get(4));
	    }
	
	    public void userInputWords(String userWord)
	    {
	    	userWord = userWord.toUpperCase();
	    	userWords.add(userWord);
	    	System.out.println(userWords.get(userWords.size()-1));
	    }
}
