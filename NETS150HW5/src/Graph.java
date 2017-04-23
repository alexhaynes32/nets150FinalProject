import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class Graph {
	Map<Vertex, LinkedList<Vertex>> adjList = new HashMap<>();
	
	
	public void addVertex(Vertex v){
		LinkedList<Vertex> newList = new LinkedList<>();
		adjList.put(v, newList);
	}
	
	public void addEdge(Vertex v1, Vertex v2){
		if (!this.contains(v1)){
			this.addVertex(v1);
		}
		
		adjList.get(v1).add(v2);
		System.out.println("added " + v1.className + " to " + v2.className);
	}
	
	public boolean hasEdge(Vertex v1, Vertex v2){
		return adjList.containsKey(v1) && adjList.get(v1).contains(v2);
	}
	
	public boolean contains(Vertex v){
		return adjList.containsKey(v);
	}
	
	
	
	
}