import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Queue;

import javax.swing.SwingWorker;

public class Character extends SwingWorker{
	private boolean position;
	private int xLoc;
	private int yLoc;
	private Color color;
	private ArrayList<Point> action;
	//private Shape shape;
	
	public Character(boolean position, int xLoc, int yLoc, Color color){
		this.position = position;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.color = color;
		action = new ArrayList<Point>();
	}

	public boolean isPosition() {
		return position;
	}

	public int getxLoc() {
		return xLoc;
	}

	public int getyLoc() {
		return yLoc;
	}

	public Color getColor() {
		return color;
	}
	
	public ArrayList<Point> getAction() {
		return action;
	}

	public void setPosition(boolean position) {
		this.position = position;
	}

	public void setxLoc(int xLoc) {
		this.xLoc = xLoc;
	}

	public void setyLoc(int yLoc) {
		this.yLoc = yLoc;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setAction(ArrayList<Point> action){
		this.action = action;
	}
	
	public void setPoint(Point point){
		this.xLoc = point.x;
		this.yLoc = point.y;
	}

	@Override
	protected Object doInBackground() throws Exception {
		for(int i=0; i<action.size(); i++){
			setPoint(action.get(i));
			Thread.sleep(50);
		}
		return true;
	}
	
}
