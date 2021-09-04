package wordsGame;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import utilities.GokuObject;

public class GameGraphics {
	GameLogic gameLogic;
	GokuObject gokuObj;
	GUIWordGame GUI;
	Login login;
	Timer timer;
	TimerTask event;
	public String wordListFilePath = "src/storageFiles/listWords.txt", usersDataFilePath = "src/storageFiles/userData.txt";
	ArrayList<String> wordsInGame;
	
	public GameGraphics() {
		
		gokuObj = new GokuObject("");
		gameLogic = new GameLogic(usersDataFilePath, wordListFilePath);
		login = new Login(usersDataFilePath);
		wordsInGame = gameLogic.getWordsInPlay();
		GUI = new GUIWordGame();
		
	}
	
	
	public void gokuFlying(ArrayList<String> wordsInGame) {
		Timer timer = new Timer();
		
		for (int i=0; i < wordsInGame.size(); i++) {	
		TimerTask event = new TimerTask() {
			int ctr = 0;
			int x = 1200;
			
			@Override
			
			
				public void run() {
								
						if(x >= -200) {
							gokuObj.setBounds(x, 150, 250, 250);
							x = x + 2;
						}
						else if(x>-200) {
							x = 1200;
							gokuObj.setText(wordsInGame.get(ctr));
							ctr ++;
						}
						else if(ctr == wordsInGame.size()) {
							//Ingresar interfaz de palabras 
							timer.cancel();
						}
					};
				};
			}
		timer.scheduleAtFixedRate(event, 1000, 30);
	}
	
} //Class breaker
