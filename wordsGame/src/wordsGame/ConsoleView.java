package wordsGame;

import java.util.Scanner;


public class ConsoleView {
	
	private Scanner input;
	public GameLogic gameLogic;
	public Login login;
	public String pregunta, pregunta2; 
	public String wordListFilePath = "src/storageFiles/listWords.txt", usersDataFilePath = "src/storageFiles/userData.txt";
	
	
	public ConsoleView( String _usersDataFilePath, String _wordListFilePath ) {
		
		this.usersDataFilePath = _usersDataFilePath;
		this.wordListFilePath = _wordListFilePath;
		
		input = new Scanner(System.in);
		gameLogic = new GameLogic(usersDataFilePath, wordListFilePath);
		login = new Login(usersDataFilePath);
	}
	
	
	public void startGame() {
		
		loginConsoleView();
		playCorrspondingLevel();
		
	}
	
	public void playCorrspondingLevel() {
		
		
		
		gameLogic.fillWordsInPlay();

		System.out.println("Estas son las palabras en juego: ");
		//System.out.println( gameLogic.getUserLevel() );
		//System.out.println( gameLogic.getUserName() );
		System.out.println( gameLogic.getWordsInPlay() );
		System.out.println();
		System.out.println("Ahora Ingrese una por una las palabras que estan en juego.");
		System.out.println("Si desea dejar de ingresar palabras ingrese la palabra stop/STOP");
		
		boolean flag=true;
		
		while (flag) {
			
			System.out.print(" --> ");
			pregunta = input.nextLine();
			
			pregunta = pregunta.toUpperCase();
			
			if( gameLogic.checkForMatchingWords(pregunta) ) {
				
				gameLogic.addUserInputWord(pregunta);
				
			}
			else if( pregunta.equals("STOP") ) {
				System.out.print("Desea iniciar la ronda/seria numero 2? y/n ");
				pregunta2 = input.nextLine();
				
				if( pregunta2.equals("y") || pregunta2.equals("Y") ) {
					flag = false;
				}
				else {
					break;
				}
				
			}
			
		}
		
		//gameLogic.getImportedWords();
	}
	
	
	public void loginConsoleView() {
		
		while (true) {			
			
			System.out.println("Bienvenido, por favor ingresa tus datos.");
			System.out.print("USERNAME: ");
			pregunta = input.nextLine();
			System.out.print("PASSWORD: ");
			pregunta2 = input.nextLine();
			System.out.println();
			
			if( login.signIn(pregunta, pregunta2) ) {
				
				this.gameLogic = new GameLogic(usersDataFilePath, wordListFilePath, pregunta);
				
				System.out.println("######### GAAME STARTED #########");
				break;
			}
			else if( !login.userExist(pregunta) ) {
				System.out.print("User does NOT exist, wanna create a new user? y/n ");
				pregunta = input.nextLine();
				
				if( pregunta.equals("y") || pregunta.equals("Y") ) {
					
					System.out.print("USERNAME: ");
					pregunta = input.nextLine();
					System.out.print("PASSWORD: ");
					pregunta2 = input.nextLine();
					
					this.login.addNewUser(pregunta, pregunta2, this.usersDataFilePath);
					this.gameLogic = new GameLogic(usersDataFilePath, wordListFilePath, pregunta);
					
					System.out.print("New user added successfuly.");
					break;
				}
				
			}
			
			System.out.print("credentials dont match, please try again.\n");	
		}//while loop end
		
		
	}// END loginConsoleView

}// END of the class
