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
		
		if(gameLogic.getRound()==1) {
			
			String tempUsername = gameLogic.getUserName();
			gameLogic = new GameLogic(usersDataFilePath, wordListFilePath, tempUsername);			
		}
		//if( gameLogic.getWordsInPlay().isEmpty() ) {
			gameLogic.fillWordsInPlay();			
		//}

		System.out.println("Estas son las palabras en juego: ");
		//System.out.println( gameLogic.getUserLevel() );
		//System.out.println( gameLogic.getUserName() );
		System.out.print( gameLogic.getWordsInPlay() );
		System.out.print( "     NIVEL= "+ gameLogic.getUserLevel()  /*+" \n" */ );
		System.out.print( "   IMPORTEDSIZE= "+ gameLogic.getImportedWords().size()  );
		System.out.print( "   inplaySIZE= "+ gameLogic.getWordsInPlay().size() + " \n" );
		System.out.println();
		System.out.println("Ahora Ingrese una por una las palabras que estan en juego.");
		System.out.println("Si desea dejar de ingresar palabras ingrese la palabra stop/STOP");
		
		boolean flag=true;
		
		while (true) {
			
			//boolean aux = gameLogic.getWordsInPlay().size()==((gameLogic.getUserLevel()+1)*4) ;
			
			System.out.print(" --> ");
			pregunta = input.nextLine();
			
			pregunta = pregunta.toUpperCase();
			
			if( gameLogic.memberOfCorrectWords(pregunta) ) {
				System.out.println("This is a CORRECT word, you already imputed this word.");
				System.out.println(" Please try anotherone: ");
			}
			else if( !pregunta.equals("STOP") ) {
				gameLogic.addUserInputWord(pregunta);				
			}
			
			
			
			if(!gameLogic.stillAlive()) {
				
				System.out.println("Numero maximo de fallos alcanzao, Haz muerto.");
				break;
			}
			else if( gameLogic.readyForSecondRound() &&  gameLogic.getRound()==1 ) {
				
				System.out.println("En hora buena! has acertado todas las palabras de la priemra ronda.");
				System.out.println(" Iniciando segunda ronda. ");  /*
				System.out.println( gameLogic.getUserLevel() );
				System.out.println(gameLogic.getWordsInPlay().size()==(gameLogic.getUserLevel()+1)*2 );
				System.out.println( (gameLogic.getUserLevel()+1) *4 );
				System.out.println(gameLogic.getWordsInPlay().size() ); 
				(gameLogic.getWordsInPlay().size()==((gameLogic.getUserLevel()+1)*4) ) */
				gameLogic.setSecondRound();
				playCorrspondingLevel();				
				break;
			}
			else if( gameLogic.readyForNextLevel()   ) {
				
				//if( gameLogic.getWordsInPlay().size()==((gameLogic.getUserLevel()+1)*4)  ) {					
					System.out.println("EXELENTE!! has ganado, vamos al siguiente nivel.");
					System.out.println("");
					break;
				//}
			}
			else if( pregunta.equals("STOP") ) {
				
				if( gameLogic.getRound()==1 ) {
					
					System.out.print("Desea iniciar la ronda/serie numero 2? y/n ");
					pregunta2 = input.nextLine();
					
					if( pregunta2.equals("y") || pregunta2.equals("Y") ) {
						
						System.out.println(" Iniciando segunda ronda. "); 
						gameLogic.setSecondRound();
						playCorrspondingLevel();	
						break;	
					}
					else {
						System.out.println(" ######## JUEGO TERMINADO ######### ");
						break;
					}
					
				}
				else {
					System.out.print("Desea subir de nivel? y/n ");
					pregunta2 = input.nextLine();
				
					if( pregunta2.equals("y") || pregunta2.equals("Y") ) {
						
						if( gameLogic.readyForNextLevel() ) {
							
							System.out.println("EXELENTE!! has ganado, vamos al siguiente nivel.");
							gameLogic.nextLevel();
							playCorrspondingLevel();
							//System.out.println("");
							break;
							
						}else {
							System.out.println("No acertaste las suficientes palabras, NO PUEDES SUBIR DE NIVEL");
							break;
						}
						
					}
					else {
						System.out.println(" ######## JUEGO TERMINADO ######### ");
						break;
					}
				
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
				
				System.out.println("######### GAME STARTED #########");
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
