import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker {
	private ArrayList<Student> students = new ArrayList<>();
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt"};

	public void loadDataFile(String fileName) throws FileNotFoundException {
		Scanner in = new Scanner(new File(fileName));
		students.clear();
		String name = "";
		String line = "";
		while (in.hasNextLine()) {
			try {
				name = in.nextLine();
				line = in.nextLine();
				students.add(new Student(name, Integer.parseInt(line)));
			} catch (NumberFormatException e) {
				System.out.println("Invalid score for " + name + ": " + line);
			}
		}
		in.close();
	}

	public void printInOrder() {
		Collections.sort(students);
		for (Student s : students) {
			System.out.println(s);
		}
	}


	public void processFiles() {
		for (String file : files) {
			try {
				loadDataFile(file);
				printInOrder();
			} catch (FileNotFoundException e) {
				System.out.println("Can't open file " + file);
			}
		}
	}

	public static void main(String[] args) {
		ScoreTrakker scoreTrakker = new ScoreTrakker();
		scoreTrakker.processFiles();
	}
}

