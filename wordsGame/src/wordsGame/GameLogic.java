/*
 * Autors: Juan Jos� Bailon, �ngelo Salazar Berm�dez, Juan Jos� Revelo
 * Email: angelo.salazar@correounivalle.edu.co
 */

package wordsGame;

import java.util.ArrayList;
import java.util.HashMap;
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
        
        HashMap<String, String> map = this.login.getUserInfo(username);
        
        this.userName = map.get("username");
        this.level =  Integer.valueOf( map.get("level") );
        this.correctWordsCounter=0;
        this.badWordsCounter=0;
        
        importWords(wordsListFilePath);    
        
	}
	
	
	public GameLogic(String usersDataFilePath, String wordsListFilePath) {

        this.importedWords = new ArrayList<>();
        this.correctWords = new ArrayList<>();
        this.wordsInPlay = new ArrayList<>();
        this.userInputWords = new ArrayList<>();

        this.inputOutput = new InputOutput();        
        this.userName = null;
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
    	
    	if( checkForMatchingWords(userWord) ) {
    		correctWords.add(userWord);
    	}
    	
    }
    
    
    public int determineWordsInPlay() {
    	int num;
    	
    	if(level >= 5) {
    		num=12;
    	}
    	else {
			num= (level+1)*2;
		}
    	
    	return num;
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
    		importedWords.remove(temp);
    	}
    	
    }
    
    
    public boolean checkForMatchingWords(String myWord) {
    	
    	boolean flag=false;
    	
    	for(String i : wordsInPlay) {
    		flag = (i.equals(myWord))? true : false;
    	}
    	
    	return flag;
    }
    
    /*
    public void playCorrespondingLevel() {
    	
    	fillWordsInPlay();
    	
    }*/
    
    
    public void nextLevel() {
    	
    	level= (level>=5)? 5 : level++;
    	correctWordsCounter=0;
    	badWordsCounter=0;
    	importedWords.addAll(wordsInPlay);
    	
    	wordsInPlay.clear();
    	correctWords.clear();
    	userInputWords.clear();
    	fillWordsInPlay();
    	
    }
    
    public boolean readyForNextLevel() {
    	
    	boolean flag;
    	
    	switch (level) {
		case 1:
			flag = ( correctWords.size() >= 7 )? true : false;
			break;
		case 2:
			flag = ( correctWords.size() >= 9 )? true : false;
			break;
		case 3:
			flag = ( correctWords.size() >= 12 )? true : false;
			break;
		case 4:
			flag = ( correctWords.size() >= 15 )? true : false;
			break;
		case 5:
			flag = ( correctWords.size() >= 18 )? true : false;
			break;

		default:
			flag = false;
			System.out.println("The level should be an Integer beetwen the interval [1,5]");
			break;
		}
    	
    	return flag;
    }
    
    
    //ESTE METODO FAlTA POR TERMINAR
    public void setSecondRound() {
    	
    	importedWords.addAll( wordsInPlay );
    	wordsInPlay.clear();
    	fillWordsInPlay();
    }
    
    
    public void setUserLevel(int newLevel) {
		this.level= newLevel;
	}
    
    public int  getUserLevel() {
    	return  this.level;
    }
    
    public int  getUserLevel(String username) {
    	String strlvl;
    	strlvl = login.getUserInfo(username).get("level");
    	level = Integer.valueOf(strlvl);
    	return  level;
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String username, String usersDataFilePath ) {
			
			this.login = new Login(usersDataFilePath);	   
	        HashMap<String, String> map = this.login.getUserInfo(username);	        
	        this.userName = map.get("username");			
	}

	public int getCorrectWordsCounter() {
		return correctWordsCounter;
	}

	public void setCorrectWordsCounter(int correctWordsCounter) {
		this.correctWordsCounter = correctWordsCounter;
	}

	public int getBadWordsCounter() {
		return badWordsCounter;
	}

	public void setBadWordsCounter(int badWordsCounter) {
		this.badWordsCounter = badWordsCounter;
	}

	public ArrayList<String> getCorrectWords() {
		return correctWords;
	}

	public void setCorrectWords(ArrayList<String> correctWords) {
		this.correctWords = correctWords;
	}

	public ArrayList<String> getWordsInPlay() {
		return wordsInPlay;
	}

	public void setWordsInPlay(ArrayList<String> wordsInPlay) {
		this.wordsInPlay = wordsInPlay;
	}

	public ArrayList<String> getUserInputWords() {
		return userInputWords;
	}

	public void setUserInputWords(ArrayList<String> userInputWords) {
		this.userInputWords = userInputWords;
	}

	public ArrayList<String> getImportedWords() {
		return importedWords;
	}

	public void setImportedWords(ArrayList<String> importedWords) {
		this.importedWords = importedWords;
	}
    
    
    
   
	    
}
