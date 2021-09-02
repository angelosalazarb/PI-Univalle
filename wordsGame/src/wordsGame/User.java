/*
 * Autor: JUAN JOSE BAILON CALDERON
 * e-mail: juan.bailon@correounivalle.edu.co
 */
package wordsGame;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;


// TODO: Auto-generated Javadoc
/**
 * The Class User. creates the user object
 */
public class User {
	
	private String username, password;
	private int level;
	private InputOutput inputOutput;
	
	/**
	 * Instantiates a new user.
	 */
	public User() {
		this.inputOutput= new InputOutput();
		this.level=0;
		this.username=null;
		this.password= null;
	}
	
	/**
	 * Instantiates a new user.
	 *
	 * @param username the username
	 * @param password the password
	 * @param level the level, indicates the level in the game
	 */
	public User(String username, String password, int level) {
		this.inputOutput= new InputOutput();
		this.level=level;
		this.username=username;
		this.password= SHA_256(password);
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = SHA_256(password);
	}
	
	/**
	 * Sets the password already hashed.
	 *
	 * @param passwordHash the new password already hashed
	 */
	public void setPasswordAlreadyHashed(String passwordHash) {
		this.password = passwordHash;
	}

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Sets the level.
	 *
	 * @param level the new level
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	
	/**
	 * Adds the to data base. adds a new user to the end of the file (.txt) to the 
	 * 						   given file (the one that is been use as a data base)
	 *
	 * @param filePath the file path
	 */
	public void addToDataBase(String filePath) {
		String temp = this.username+" "+this.level+" "+this.password+"\n";
		inputOutput.writeFile(filePath, temp, true);
	}
	
	/**
	 * Sha 256. this method hash the given String and returns a new string that is the result of
	 * 			 passing the given String into a SHA-256 hashing function
	 *
	 * @param text the text
	 * @return the string
	 */
	public String SHA_256(String text) {
		
		MessageDigest digest;
		String encoded=null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
			encoded = Base64.getEncoder().encodeToString(hash);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return encoded;
	}
	
	/**
	 * Gets the all user info. returns all the user info in a HashMap
	 *
	 * @return the all user info
	 */
	public HashMap<String, String>  getAllUserInfo() {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("username", this.username);
		map.put("level", Integer.toString(this.level));
		map.put("password", this.password);
		
		return map;
	}
	
}
