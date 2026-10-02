import java.util.ArrayList;

public class ScoreTrakker {
	private ArrayList<Student> students = new ArrayList<>();

	public void loadDataFile(String fileName) {
	
	}

	public void printInOrder() {

	}

	public void processFiles() {
		loadDataFile("scores.txt");
		printInOrder();
	}

	public static void main(String[] args) {
		ScoreTrakker scoreTrakker = new ScoreTrakker();
		scoreTrakker.processFiles();
	}
}

