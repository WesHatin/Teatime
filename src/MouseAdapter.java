import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;
import javax.xml.stream.events.Characters;

public class MouseAdapter extends MouseInputAdapter implements ActionListener {
	private static ArrayList<Point> action;
	private static boolean isDrag = false;
	
	public void mousePressed(MouseEvent e){
		isDrag = true;
		action = new ArrayList<Point>();
		System.out.println("Mouse Pressed");
	}

	public void mouseDragged(MouseEvent e){
		System.out.println("Mouse Dragged");
		action.add(e.getPoint());
		GameBoard.setAction(e.getPoint(), action);
	}

	public void mouseClicked(MouseEvent e){
		isDrag = false;
		
		if(SwingUtilities.isLeftMouseButton(e)){
			System.out.println("Left Click");
			
			if(GameBoard.isEmpty(e.getPoint()))
				GamePlay.addCharacter(e.getPoint());
			else
				GameBoard.changePosition(e.getPoint());
		} else if(SwingUtilities.isRightMouseButton(e)){
			System.out.println("Right Click");
			GameBoard.removePoint(e.getPoint());
		}
	}
	
	public void mouseReleased(MouseEvent e){
		System.out.println("Mouse Released");
		
		if(isDrag){
			GameBoard.setAction(e.getPoint(), action);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(arg0.getActionCommand() + " Pressed");
		
		System.out.println(arg0.getActionCommand());
		if(arg0.getActionCommand().equals("Run")){
			GamePlay.simulate();
		} else if(arg0.getActionCommand().equals("Clear")){
			GamePlay.clear();
		} else if(arg0.getActionCommand().equals("Next Stage")){
			GamePlay.nextStage();	
		} else if(arg0.getActionCommand().equals("Previous Stage")){
			//Save to stage arraylist
			if(Play.getStages().size()<= GamePlay.currentStage)
				Play.getStages().add(new Stage(GamePlay.getCharacters()));
			else			
				Play.getStages().set(GamePlay.currentStage, new Stage(GamePlay.getCharacters()));
			
			if(GamePlay.currentStage > 0)
			GamePlay.currentStage--;
			
			for(int i=0; i<GamePlay.getCharacters().size(); i++){
				GamePlay.setCharacters(Play.getStages().get(GamePlay.currentStage).getCharacters());
			}
		}
		
	}
}
