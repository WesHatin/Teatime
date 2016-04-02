import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.List;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;

public class GamePlay{

	private static GameFrame frame;
	private static ArrayList<Character> characters = new ArrayList<>();
	public static boolean isSimulating;

	public static void main(String[] args){

		isSimulating = false;

		/*frame = new JFrame("Tea Time");

		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.GRAY);

		frame.setVisible(true);
		frame.addMouseListener(new MouseAdapter());
		frame.addMouseMotionListener(new MouseAdapter());

		board.setBorder(new EmptyBorder(5,5,5,5));
		board.setLayout(new BorderLayout(0,0));
		frame.setContentPane(board);

		frame.add(simPanel, BorderLayout.SOUTH);*/

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
}
