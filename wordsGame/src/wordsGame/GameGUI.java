package wordsGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GameGUI extends JFrame {
	
	private JButton exit;
	private Escucha escucha;
	
	public GameGUI(){
		
		
		this.escucha= new Escucha();
		
		exit = new JButton("Exit");
		exit.addActionListener(escucha);
		this.add(exit);
		
		
		this.setTitle("PRUEBA");
		pack();
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	public GameGUI(Escucha escu){
		
		
		this.escucha= new Escucha();
		
		exit = new JButton("Exit");
		exit.addActionListener(escu);
		this.add(exit);
		
		
		this.setTitle("PRUEBA");
		pack();
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	
	
	public JButton getExit() {
		return exit;
	}

	public void setExit(JButton exit) {
		this.exit = exit;
	}


	

	private class Escucha  implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent eventAction) {
			// TODO Auto-generated method stub
			
			if(eventAction.getSource() == exit ) {
				System.exit(0);
			}
			
		}
		
		
		
	}
	

}
