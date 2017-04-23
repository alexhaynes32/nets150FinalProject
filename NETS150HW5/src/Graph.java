import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Graph {
	Map<Vertex, LinkedList<Vertex>> adjList = new HashMap<>();
	
	public void addEdge(Vertex v1, Vertex v2){
		
	}
	
	public boolean hasEdge(Vertex v1, Vertex v2){
		return adjList.containsKey(v1) && adjList.get(v1).contains(v2);
	}
	
}
