import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameBoard extends JPanel {

	private static int x=100;
	private static int y=100;
	private static ArrayList<Character> characters;
	final private static int radius = 10;
	final private static Color OFFENSE = Color.RED;
	final private static Color DEFENSE = Color.BLUE;
	final private static Color PATH = Color.BLACK;
	final private static float FONTSIZE = 25.0f;

	public GameBoard(){
		characters = new ArrayList<>();
	}
	
	private static void setCharacters(ArrayList<Character> characters){
		GameBoard.characters = characters;
	}
	
	public static void placeCharacters(ArrayList<Character> characters){
		setCharacters(characters);
	}
	
	public static boolean isEmpty(Point p){
		for(int i=0; i<characters.size(); i++){
			if(Math.abs(characters.get(i).getxLoc()-p.getX()-(radius/2))<radius)
				if(Math.abs(characters.get(i).getyLoc()-p.getY()+(radius/2))< radius){
					return false;
				}
		}
		
		return true;
	}
	
	@Override
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		
		for(int i=0; i<GameBoard.characters.size(); i++){
			if(characters.get(i).isPosition())
				g2d.setColor(OFFENSE);
			else
				g2d.setColor(DEFENSE);
			
			g2d.setFont(g.getFont().deriveFont(FONTSIZE));
			g2d.drawString("X", characters.get(i).getxLoc(), characters.get(i).getyLoc());
			
			g2d.setColor(PATH);
			ArrayList<Point> temp = characters.get(i).getAction();
			for(int k=0; k<temp.size()-1; k++){
				g2d.drawLine((int)temp.get(k).getX(), (int)temp.get(k).getY(), (int)temp.get(k+1).getX(), (int)temp.get(k+1).getY());
			}
		}
	}

	public static void removePoint(Point point) {
		if(GamePlay.isSimulating)
			return;
		if(isEmpty(point))
			return;
		
		for(int i=0; i<characters.size(); i++){
			if(Math.abs(characters.get(i).getxLoc()-point.getX()-(radius/2))<radius)
				if(Math.abs(characters.get(i).getyLoc()-point.getY()+(radius/2))< radius){
					characters.remove(i);
					break;
				}
		}
		
	}

	public static void changePosition(Point point) {
		if(GamePlay.isSimulating)
			return;
		for(int i=0; i<characters.size(); i++){
			if(Math.abs(characters.get(i).getxLoc()-point.getX()-(radius/2))<radius)
				if(Math.abs(characters.get(i).getyLoc()-point.getY()+(radius/2))< radius){
					if(characters.get(i).isPosition())
						characters.get(i).setPosition(false);
					else
						characters.get(i).setPosition(true);
					break;
				}
		}
		
	}

	public static void setAction(Point point, ArrayList<Point> action) {
		if(GamePlay.isSimulating)
			return;
		if(characters.size()==0)
			return;
		for(int i=0; i<characters.size(); i++){
			if(Math.abs(characters.get(i).getxLoc()-point.getX()-(radius/2))<radius)
				if(Math.abs(characters.get(i).getyLoc()-point.getY()+(radius/2))< radius){
					characters.get(i).setAction(action);
				}
		}
	}

	public static void clear() {
		characters = new ArrayList<>();
	}

}