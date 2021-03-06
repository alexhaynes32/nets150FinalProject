import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Graph {
	Map<Vertex, LinkedList<Vertex>> adjList = new HashMap<>();
	Set<Edge> edges = new HashSet<>();

	public void addVertex(Vertex v) {
		LinkedList<Vertex> newList = new LinkedList<>();
		adjList.put(v, newList);
	}

	public void addEdge(Vertex v1, Vertex v2, double weight) {
		if (!this.contains(v1)) {
			this.addVertex(v1);
		}
		if (!this.contains(v2)) {
			this.addVertex(v2);
		}

		adjList.get(v1).add(v2);
		Edge newEdge = new Edge(v1, v2, weight);
		edges.add(newEdge);
	}

	public int size() {
		return adjList.size();
	}

	public boolean hasEdge(Vertex v1, Vertex v2) {
		return adjList.containsKey(v1) && adjList.get(v1).contains(v2);
	}

	public boolean contains(Vertex v) {
		return adjList.containsKey(v);
	}

	public Set<Vertex> setOfVertices() {
		return adjList.keySet();
	}

	public double getEdgeWeight(Vertex src, Vertex dest) {
		for (Edge e : edges) {
			if (e.getSrc().equals(src) && e.getDest().equals(dest)) {
				return e.getWeight();
			}
		}
		System.out.println("edge from " + src + " to " + dest + " did not exist");
		return -1;
	}

}