import java.util.ArrayList;

public class Play {
	private static ArrayList<Stage> stages;
	
	public Play(){
		stages = new ArrayList<Stage>();
		stages.add(new Stage());
	}

	public static ArrayList<Stage> getStages() {
		return stages;
	}
}
