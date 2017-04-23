import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileParser {
	
	Graph g;

	public FileParser(String filename){
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			g = new Graph();
		    String line;
		    while ((line = br.readLine()) != null) {
		       System.out.println(line);
		       String[] parts =line.split(" ");
		       String deck1 = parts[0];
		       String deck2 = parts[1];
		       double winRate = Double.parseDouble(parts[2]);
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
