/*
 * Autor: JUAN JOSE BAILON
 * e-mail: juan.bailon@correounivalle.edu.co
 */
package wordsGame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


// TODO: Auto-generated Javadoc
/**
 * The Class InputOutput. this class reads and writes to .txt files
 */
public class InputOutput {
	
	/**
	 * Instantiates a new input output.
	 */
	public InputOutput() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Write file. writes data to a given file(.txt)
	 *
	 * @param filePath the file path
	 * @param content the content
	 * @param append the append
	 */
	public void writeFile( String filePath, String content, boolean append ) {
		
		try {
			BufferedWriter bw = new BufferedWriter( new FileWriter( filePath, append ) );
			
			bw.write(content);
			bw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Read file. extracts the data from a file(.txt) and stores it in a string
	 *
	 * @param filePath the file path
	 * @param keepFormat is true keeps the line breaks otherwise
	 * 		   will return a string without the original line breaks
	 * @return a string that contains the data from the given file
	 */
	public String readFile( String filePath, boolean keepFormat ) {
		
		String fullText="";
		
		try {
			BufferedReader br = new BufferedReader( new FileReader( filePath ) );
			
			String temp;
			while( (temp=br.readLine()) != null ) {
				
				if(keepFormat==true) {
					fullText += temp+"\n";					
				}else {
					fullText += temp+" ";
				}
				
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fullText;
		
	}
	
	
	/**
	 * Read file to an array. extracts the data from a file(.txt) and stores every word separated by a space
	 * 						  in a different position of an array
	 *
	 * @param filePath the file path
	 * @return the array list
	 */
	public ArrayList<String>  readFileToAnArray( String filePath ) {
		
		//ArrayList<String> myvector = new ArrayList<String>();
		
		String text = readFile(filePath, false);
		
		ArrayList<String> myvector = new ArrayList<String>( Arrays.asList(text.split(" ")) );
		
		return myvector;
		
	}
	

}
