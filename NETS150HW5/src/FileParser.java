import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class FileParser {

	Graph g = new Graph();

	public FileParser(String filename) {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			g = new Graph();
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(" ");
				if (parts.length == 3) {
					String deck1 = parts[0];
					String deck2 = parts[1];
					double winRate = Double.parseDouble(parts[2]);
					Vertex v1 = new Vertex(deck1, deck1.substring(deck1.indexOf('_') + 1));
					Vertex v2 = new Vertex(deck2, deck2.substring(deck2.indexOf('_') + 1));
					// An edge from deck A to deck B with weight x means
					// deck A beats deck B with a probability of x
					g.addEdge(v1, v2, winRate);
					g.addEdge(v2, v1, 1.0 - winRate);
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addRemainingEdges() {
		HashSet<Vertex> setOfVertices = new HashSet<Vertex>(getGraph().setOfVertices());
		for (Vertex u : setOfVertices) {
			for (Vertex v : setOfVertices) {
				if (!g.hasEdge(u, v)) {
					g.addEdge(u, v, 0.5);
					g.addEdge(v, u, 0.5);

				}
			}
		}

	}

	public Graph getGraph() {
		return g;
	}

}
