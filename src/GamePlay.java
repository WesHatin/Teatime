import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.List;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;

public class GamePlay{

	private static GameFrame frame;
	private static ArrayList<Character> characters = new ArrayList<>();
	public static boolean isSimulating;
	public static int currentStage;

	public static void main(String[] args){
		currentStage = 0;
		isSimulating = false;
		Play play = new Play();
		Stage stage = new Stage();

		frame = new GameFrame();
		frame.setVisible(true);

		characters = new ArrayList<>();
		characters.add(new Character(true, 100, 100, Color.RED));
		GameBoard.placeCharacters(characters);


		while(true){
			try {
				if(!isSimulating){
					Thread.sleep(50);
					frame.repaint();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static JFrame getFrame(){
		return frame;
	}
	public static ArrayList<Character> getCharacters(){
		return characters;
	}
	public static void addCharacter(Point point){
		characters.add(new Character(true, point.x, point.y, Color.RED));
		GameBoard.placeCharacters(characters);
	}


	public static void clear() {
		characters = new ArrayList<>();
		GameBoard.clear();
	}

	public static void simulate() {
		if(isSimulating)
			return;
		else
			isSimulating = true;

		for(int i=0; i<characters.size(); i++){
			characters.get(i).execute();
		}


		isSimulating = false;
	}

	public static void setCharacters(ArrayList<Character> characters) {
		GamePlay.characters = characters;
	}

	public static void nextStage() {
		
//		setCharacters(Play.getStages().get(currentStage).getCharacters());

		for(int i=0; i<getCharacters().size(); i++){
			System.out.println(GamePlay.getCharacters().get(i));
		}

		//Save to stage arraylist
		if(Play.getStages().size() == currentStage)
			Play.getStages().add(new Stage(getCharacters()));
		else
			System.out.println(Play.getStages().set(currentStage, new Stage(getCharacters())));

		
		Play.getStages().add(new Stage());
		currentStage++;

		//Move all to to end of action
		for(int i=0; i<getCharacters().size(); i++){
			getCharacters().get(i).execute();
		}
		
	}
	
	public static void initNextStage(Character c){
		System.out.println(c);
		Play.getStages().get(currentStage).getCharacters().add(c);
//		GameBoard.clear();
	}
}
