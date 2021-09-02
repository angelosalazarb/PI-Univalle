/*
 * Autors: Juan Jos� Bailon, �ngelo Salazar Berm�dez, Juan Jos� Revelo
 * Email: angelo.salazar@correounivalle.edu.co
 */

package wordsGame;

import java.util.ArrayList;
import java.util.Random;


public class GameLogic {

	private InputOutput inputOutput;
	private Login  login;
	private String userName;
	private int level, correctWordsCounter, badWordsCounter;
	private ArrayList<String> importedWords, correctWords, wordsInPlay, userInputWords;
	
	
	public GameLogic() {

        this.importedWords = new ArrayList<>();
        this.correctWords = new ArrayList<>();
        this.wordsInPlay = new ArrayList<>();
        this.userInputWords = new ArrayList<>();

        inputOutput = new InputOutput();
        login = new Login();
        userName=null;
        level = 0;
        correctWordsCounter=0;
        badWordsCounter=0;

    }

	public GameLogic(String usersDataFilePath, String wordsListFilePath, String username) {

        this.importedWords = new ArrayList<>();
        this.correctWords = new ArrayList<>();
        this.wordsInPlay = new ArrayList<>();
        this.userInputWords = new ArrayList<>();

        this.inputOutput = new InputOutput();
        this.login = new Login(usersDataFilePath);
        this.userName = username;
        this.level = 0;
        this.correctWordsCounter=0;
        this.badWordsCounter=0;
        
        importWords(wordsListFilePath);
        
        
	}
	

    public void importWords(String filePath) {
    	
        importedWords = inputOutput.readFileToAnArray(filePath);
    }

    public void addUserInputWord(String userWord){
    	userWord = userWord.toUpperCase();
    	userInputWords.add(userWord);    	
    }
    
    
    public int determineWordsInPlay() {
    	int wordsInPlay;
    	
    	if(level >= 5) {
    		wordsInPlay=12;
    	}
    	else {
			wordsInPlay = (level+1)*2;
		}
    	
    	return wordsInPlay;
    }
    
    
    public void fillWordsInPlay() {
    	
    	Random random = new Random();
    	int num = determineWordsInPlay();
    	
    	if( !wordsInPlay.isEmpty() ) {
    		wordsInPlay.clear();
    	}
    	
    	for(int i=0; i<num; i++) {
    		
    		int index = random.nextInt( importedWords.size()-1 );
    		String temp = importedWords.get(index);
    		
    		wordsInPlay.add(temp);
    	}
    	
    }
    
    
    public void setUserLevel(int newLevel) {
		this.level= newLevel;
	}
    
    public int  getUserLevel(String username) {
    	String strlvl;
    	strlvl = login.getUserInfo(username).get("level");
    	level = Integer.valueOf(strlvl);
    	return  level;
    }
    
   
	    
}
