import java.util.ArrayList;

public class Stage {
	private static ArrayList<Character> characters;
	
	public Stage(){
		characters = new ArrayList<Character>();
	}
	
	public static ArrayList<Character> getCharacters() {
		return characters;
	}

	public static void setCharacters(ArrayList<Character> characters) {
		Stage.characters = characters;
	}

	public Stage(ArrayList<Character> characters){
		Stage.characters = characters;
	}
	public String toString(){
		StringBuilder s = new StringBuilder();
		
		for(int i=0; i<characters.size(); i++){
			s.append("("+characters.get(i).getxLoc()+","+characters.get(i).getyLoc()+")");
		}
		
		return s.toString();
	}
}
