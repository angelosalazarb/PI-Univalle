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
	public ArrayList<String> correctWords, droppedWords, userInputWords;
	
	  public gameLogic() {

	        this.importedWords = new ArrayList<>();
	        this.correctWords = new ArrayList<>();
	        this.droppedWords = new ArrayList<>();

	        getGameWords = new InputOutput();


	    }

	    private void importWords() {

	        importedWords = getGameWords.readFileToAnArray("src/listWords.txt");
	        System.out.println(importedWords.get(1));
	    }
	
}
