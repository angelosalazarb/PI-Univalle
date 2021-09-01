package wordsGame;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class User {
	
	private String username, password;
	private int level;
	private InputOutput inputOutput;
	
	public User(String username, String password, int level) {
		this.inputOutput= new InputOutput();
		this.level=level;
		this.username=username;
		this.password= SHA_256(password);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = SHA_256(password);
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public void addToDataBase(String filePath) {
		String temp = username+" "+level+" "+password+"\n";
		inputOutput.writeFile(filePath, temp, true);
	}
	
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
	
}
