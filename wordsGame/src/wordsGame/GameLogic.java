/*
 * Autors: Juan Jose Bailon, angelo Salazar Bermudez, Juan Jose Revelo
 * Email: angelo.salazar@correounivalle.edu.co
 * 		   juan.bailon@correounivalle.edu.co
 * 		   juan.jose.revelo@correounivalle.edu.co
 */

package wordsGame;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


// TODO: Auto-generated Javadoc
/**
 * The Class GameLogic.
 */
public class GameLogic {

	private InputOutput inputOutput;
	private Login  login;
	private String userName, wordListFile, usersDataFile;
	private int level, round, badWordsCounter;
	private ArrayList<String> importedWords, correctWords, wordsInPlay, userInputWords;
	
	
	/**
	 * Instantiates a new game logic.
	 */
	public GameLogic() {

        this.importedWords = new ArrayList<>();
        this.correctWords = new ArrayList<>();
        this.wordsInPlay = new ArrayList<>();
        this.userInputWords = new ArrayList<>();

        inputOutput = new InputOutput();
        login = new Login();
        userName=null;
        level = 0;
        round=1;      
        badWordsCounter=0;
        wordListFile=null;
        usersDataFile=null;

    }

	/**
	 * Instantiates a new game logic.
	 *
	 * @param usersDataFilePath the users data file path
	 * @param wordsListFilePath the words list file path
	 * @param username the username
	 */
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
        this.round = 1;
        this.badWordsCounter=0;
        this.wordListFile = wordsListFilePath;
        this.usersDataFile= usersDataFilePath;
        
        importWords(wordsListFilePath);    
        
	}
	
	
	/**
	 * Instantiates a new game logic.
	 *
	 * @param usersDataFilePath the users data file path
	 * @param wordsListFilePath the words list file path
	 */
	public GameLogic(String usersDataFilePath, String wordsListFilePath) {

        this.importedWords = new ArrayList<>();
        this.correctWords = new ArrayList<>();
        this.wordsInPlay = new ArrayList<>();
        this.userInputWords = new ArrayList<>();

        this.inputOutput = new InputOutput();        
        this.userName = null;
        this.level = 0;
        this.round = 1;
        this.badWordsCounter=0;
        this.wordListFile = wordsListFilePath;
        this.usersDataFile = usersDataFilePath;
        
        importWords(wordsListFilePath);
        
        
	}
	
	

    /**
     * Import words. extracs the words for the game from the given file
     *
     * @param filePath the file path
     */
    public void importWords(String filePath) {
    	
        importedWords = inputOutput.readFileToAnArray(filePath);
    }

    
    /**
     * Adds the user input word. 
     *
     * @param userWord the user word
     */
    public void addUserInputWord(String userWord){
    	userWord = userWord.toUpperCase();
    	userInputWords.add(userWord);    	
    	
    	if( checkForMatchingWords(userWord) ) {
    		correctWords.add(userWord);
    		wordsInPlay.remove(userWord);
    	}
    	else {
    		badWordsCounter++;
    	}
    	
    }
    
    
    /**
     * Determine words in play. determines the number of words that are gonna be in play according to the level
     *
     * @return the int
     */
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
    
    
    /**
     * Fill words in play. fill the array wordsInPlay with a set of words taken randomly form the array importedWords  
     */
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
    
    
    /**
     * Check for matching words. checks if the given word is part of the array wordsInPlay
     *
     * @param myWord the my word
     * @return true, if successful
     */
    public boolean checkForMatchingWords(String myWord) {
    	
    	boolean flag=false;
    	
    	for(int i=0; i<wordsInPlay.size(); i++ ) {
    		if( wordsInPlay.get(i).equals(myWord) ) {
    			flag=true;
    		}
    	}
    	
    	return flag;
    }
    
    
    /**
     * Member of correct words. checks if the given word is part of the array correctWords
     *
     * @param myWord the my word
     * @return true, if successful
     */
    public boolean memberOfCorrectWords(String myWord) {
    	
    	boolean flag=false;
    	
    	for( String i : this.correctWords ) {
    		if( i.equals(myWord) ) {
    			flag=true;
    		}
    	}
    	
    	return flag;
    }
    
    
    /**
     * Next level. prepares everything necessary for the level change, sets the new values that the attributes
     *             are gonna take in the next level
     */
    public void nextLevel() {
    	
    	if(level>5) {
    		setLevel(5);
    		level=5;
    	}
    	else if(level>0 && level<5) {
    		setLevel(level+1);
    		level++;
    	}
    	
    	badWordsCounter=0;
    	importedWords.addAll( correctWords );
    	importedWords.addAll(wordsInPlay);
    	
    	round=1;
    	correctWords.clear();
    	wordsInPlay.clear();
    	userInputWords.clear();
    	fillWordsInPlay();
    	
    }
    
    
    /**
     * Still alive. checks if the user has NOT reach the maximum number of errors for it's corresponding level
     *
     * @return true, if successful
     */
    public boolean stillAlive() {
    	boolean flag;
    	
    	switch (level) {
		case 1:
			flag = ( badWordsCounter >= 3 )? false : true;
			break;
		case 2:
			flag = ( badWordsCounter >= 4 )? false : true;
			break;
		case 3:
			flag = ( badWordsCounter >= 6 )? false : true;
			break;
		case 4:
			flag = ( badWordsCounter >= 7 )? false : true;
			break;
		case 5:
			flag = ( badWordsCounter >= 9 )? false : true;
			break;

		default:
			flag = false;
			System.out.println("You died!");
			break;
		}
    	
    	return flag;
    }
    
    
    /**
     * Ready for next level. checks  if the user has the minimum amount of requirements(correct words inputed) to go
     * 							the next level 
     *
     * @return true, if successful
     */
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
    
  
    /**
     * Sets the second round. sets the new values that some of the attributes need to have to start the second round
     */
    public void setSecondRound() {
    	
    	round=2;
    	importedWords.addAll( wordsInPlay );
    	wordsInPlay.clear();
    	fillWordsInPlay();
    }
    
    /**
     * Ready for second round. If true the user has inputted correctly all the words in play presented to him in the first round.
     *
     * @return true, if successful
     */
    public boolean readyForSecondRound() {
    	
    	boolean flag;
    	
    	switch (level) {
		case 1:
			flag = ( correctWords.size() >= 4 )? true : false;
			break;
		case 2:
			flag = ( correctWords.size() >= 6 )? true : false;
			break;
		case 3:
			flag = ( correctWords.size() >= 8 )? true : false;
			break;
		case 4:
			flag = ( correctWords.size() >= 10 )? true : false;
			break;
		case 5:
			flag = ( correctWords.size() >= 12 )? true : false;
			break;

		default:
			flag = false;
			System.out.println("The level should be an Integer beetwen the interval [1,5]");
			break;
		}
    	
    	return flag;
    }
    
    
    /**
     * Sets the level. sets a new value for the attribute level
     *
     * @param newLevel the new level
     */
    public void setLevel( int newLevel ) {
    	
    	String newFileContent="";
    	ArrayList<String> tempArray = inputOutput.readFileToAnArray(this.usersDataFile);
    	
    	for(int i=0; i<tempArray.size(); i++) {
    		
    		if( tempArray.get(i).equals(this.userName) ) {
    			
    			tempArray.set(i+1, Integer.toString(newLevel) );
    		}
    	}
    	
    	for(int i=0; i<tempArray.size(); i+=3) {
    		
    		newFileContent += tempArray.get(i) +" "+ tempArray.get(i+1) +" "+ tempArray.get(i+2) +"\n";
    		inputOutput.writeFile(this.usersDataFile, newFileContent, false);
    	}
    	
    }
    
    
    /**
     * Gets the user level.
     *
     * @return the user level
     */
    public int  getUserLevel() {
    	return  this.level;
    }
    
    /**
     * Gets the user level.
     *
     * @param username the username
     * @return the user level
     */
    public int  getUserLevel(String username) {
    	String strlvl;
    	strlvl = login.getUserInfo(username).get("level");
    	level = Integer.valueOf(strlvl);
    	return  level;
    }

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}
	
		
	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the round.
	 *
	 * @return the round
	 */
	public int getRound() {
		return round;
	}

	/**
	 * Sets the round.
	 *
	 * @param round the new round
	 */
	public void setRound(int round) {
		this.round = round;
	}


	/**
	 * Gets the bad words counter.
	 *
	 * @return the bad words counter
	 */
	public int getBadWordsCounter() {
		return badWordsCounter;
	}

	/**
	 * Sets the bad words counter.
	 *
	 * @param badWordsCounter the new bad words counter
	 */
	public void setBadWordsCounter(int badWordsCounter) {
		this.badWordsCounter = badWordsCounter;
	}

	/**
	 * Gets the correct words.
	 *
	 * @return the correct words
	 */
	public ArrayList<String> getCorrectWords() {
		return correctWords;
	}

	/**
	 * Sets the correct words.
	 *
	 * @param correctWords the new correct words
	 */
	public void setCorrectWords(ArrayList<String> correctWords) {
		this.correctWords = correctWords;
	}

	/**
	 * Gets the words in play.
	 *
	 * @return the words in play
	 */
	public ArrayList<String> getWordsInPlay() {
		return wordsInPlay;
	}

	/**
	 * Sets the words in play.
	 *
	 * @param wordsInPlay the new words in play
	 */
	public void setWordsInPlay(ArrayList<String> wordsInPlay) {
		this.wordsInPlay = wordsInPlay;
	}

	/**
	 * Gets the user input words.
	 *
	 * @return the user input words
	 */
	public ArrayList<String> getUserInputWords() {
		return userInputWords;
	}

	/**
	 * Sets the user input words.
	 *
	 * @param userInputWords the new user input words
	 */
	public void setUserInputWords(ArrayList<String> userInputWords) {
		this.userInputWords = userInputWords;
	}

	/**
	 * Gets the imported words.
	 *
	 * @return the imported words
	 */
	public ArrayList<String> getImportedWords() {
		return importedWords;
	}

	/**
	 * Sets the imported words.
	 *
	 * @param importedWords the new imported words
	 */
	public void setImportedWords(ArrayList<String> importedWords) {
		this.importedWords = importedWords;
	}
    
   
	    
}
