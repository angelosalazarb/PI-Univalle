/*
 * Autor: JUAN JOSE BAILON CALDERON
 * e-mail: juan.bailon@correounivalle.edu.co
 */
package wordsGame;

import java.util.ArrayList;
import java.util.HashMap;


// TODO: Auto-generated Javadoc
/**
 * The Class Login. this class takes care of all the login related actions
 */
public class Login {
	
	/** The users data. */
	private ArrayList< User > usersData;
	private String userDataFilePath, username;
	
	
	
	/**
	 * Instantiates a new login.
	 */
	public Login() {
		this.usersData = new ArrayList< User >();
		this.userDataFilePath=null;
		this.username=null;
	}
	
	/**
	 * Instantiates a new login.
	 *
	 * @param filePath the file path
	 */
	public Login(String filePath) {
		this.usersData = extractUsersData( filePath );
		this.userDataFilePath = filePath;
		this.username=null;
	}
	
	
	/**
	 * Sign in. if return true that means that the user is in the data base and his credentials are correct.
	 * 			If return false then the user is not in the data base or their credentials are incorrect,
	 *
	 * @param username the username
	 * @param password the password
	 * @return true, if successful
	 */
	public boolean signIn(String username, String password) {
		
		boolean flag=false;
		
		if( userExist(username) ) {
			 
			User u = new User();
			password = u.SHA_256( password );
			
			int index = userPositionInTheArray(username);
			
			String user = usersData.get(index).getUsername();
			String userPassword = usersData.get(index).getPassword();
			
			if( user.equals(username) && userPassword.equals(password) ) {
				flag=true;
				this.username = username;
			}
			
		}
		
		return flag;		
	}
	
	
	/**
	 * User exist. returns true if the user is in the data base otherwise returns false
	 *
	 * @param username the username
	 * @return true, if successful
	 */
	public boolean userExist(String username) {
		
		boolean flag=false;
		int index = userPositionInTheArray(username);
		
		if(index > -1) {
			flag=true;
		}
		
		return flag;
	}
	
	
	/**
	 * Extrac users data. this method extracts all the data related to users info from the given
	 * 					   file(.txt) and returns it in an ArayList of users 
	 *
	 * @param filePath the file path
	 * @return the array list
	 */
	public ArrayList< User > extractUsersData(String filePath){
		
		ArrayList<User> tempUsersData = new ArrayList<User> ();
		ArrayList<String> tempVector;
		InputOutput inputOutput = new InputOutput();
		
		tempVector = inputOutput.readFileToAnArray(filePath);
		
		for(int i=0; i<tempVector.size(); i+=3) {
			
			String username = tempVector.get(i);
			String level = tempVector.get(i+1);
			String passwordHash = tempVector.get(i+2);
			
			User user = new User();
			user.setUsername(username);
			user.setPasswordAlreadyHashed(passwordHash);
			user.setLevel( Integer.valueOf(level) );
			
			tempUsersData.add(user);			
		}		
	
		return tempUsersData;
	}
	
	
	/**
	 * User position in the array.
	 *
	 * @param username the username. returns the index of an user related to the given username.
	 * 								 					
	 * @return the int index.  This index is the position of the user in the attribute usersData which is
	 * 							an ArrayList
	 */
	public int userPositionInTheArray(String username) {
		
		int index=0;
		
		for(User u : this.usersData) {
			String temp = u.getUsername();
			
			if( temp.equals(username) ) {	
				break;
			}
			
			index++;
		}
		
		if(index >= usersData.size() ) {
			index= -1;
		}
		
		return index;		
	}
	
	
	/**
	 * Adds the new user. Adds a new user to the given file and to the attribute usersData
	 *
	 * @param username the username
	 * @param password the password
	 * @param filePath the file path. This file should be the one use as a data base for the user info
	 */
	public void addNewUser(String username, String password, String filePath) {
		
		if( userExist(username) ) {
			System.out.println("This user: "+ username + " already exist.");
		}
		else {
			User user = new User(username, password, 1);
			user.addToDataBase(filePath);
			this.usersData.add(user);
			this.username = username;
		}
	}
	
	
	
	/**
	 * Adds the new user. Adds a new user to the file locate in the path specific by the attribute
	 * 					  usersDataFilePath, and to the attribute usersData
	 *
	 * @param username the username
	 * @param password the password
	 */
	public void addNewUser(String username, String password) {
		
		if( userExist(username) ) {
			System.out.println("This user: "+ username + " already exist.");
		}
		else {
			User user = new User(username, password, 1);
			user.addToDataBase( this.userDataFilePath );
			this.usersData.add(user);
			this.username = username;
		}
	}
	
	
	
	/**
	 * Gets the user info. returns all the info related to an specific user.  
	 *
	 * @param username the username
	 * @return the user info. in a HashMap format
	 */
	public HashMap<String, String> getUserInfo(String username){
		
		int index = userPositionInTheArray(username);
		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			map = this.usersData.get(index).getAllUserInfo();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR! this username do NOT exist, plese create a new user.");
		}
				
		return map;
	}
	
	
	/**
	 * Gets the users data. Return the attribute usersData
	 *
	 * @return the users data
	 */
	public ArrayList<User> getUsersData() {
		return usersData;
	}

	/**
	 * Sets the users data. Sets a new value for the attribute usersData
	 *
	 * @param usersData the new users data
	 */
	public void setUsersData(ArrayList<User> usersData) {
		this.usersData = usersData;
	}

	/**
	 * Sets the users data. Sets a new value for the attribute usersData
	 *
	 * @param filePath the new users data
	 */
	public void setUsersData(String filePath) {
		this.usersData = extractUsersData(filePath);
	}

	
	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	
	
}
