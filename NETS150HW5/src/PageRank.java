import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class PageRank {
	
	Graph g;
	Map<Vertex, Double> scores = new HashMap<>();
	
	public PageRank(Graph g){
		this.g = g;
		initPageRank();
	}
	
	public void initPageRank(){
		//Initializing the starting value aka score of each vertex to 1 / # of vertices
		//Updated 1 to 100 so numbers are easier to think about
		
		double initScore = 10.0 / (g.size() * 1.0);
		for(Vertex v : g.adjList.keySet()){
			scores.put(v, initScore);
		}
		System.out.println("Starting score total: " + initScore * g.size());
	}
	
	public void executeStep(){
		Map<Vertex, Double> newScores = new HashMap<>();
		newScores.putAll(scores);
		
		//Resetting scores for new round
		for (Vertex v: newScores.keySet()){
			newScores.put(v, 0.0);
		}
		
		for(Entry<Vertex, LinkedList<Vertex>> e: g.adjList.entrySet()){
			double score = scores.get(e.getKey());
			Vertex v = e.getKey();
			//Sum of all edge weights leaving v
			if (e.getValue().size() == 0){
				newScores.put(v, score);
			} else {
				double neighborEdgeWeightSum = 0.0;
				for(Vertex q : e.getValue()){
					neighborEdgeWeightSum += g.getEdgeWeight(v, q);
				}
				double sum = 0;
				for(Vertex q : e.getValue()){
					sum += g.getEdgeWeight(v, q) / neighborEdgeWeightSum;
					double newScore = (g.getEdgeWeight(v, q) / neighborEdgeWeightSum) * score;
					newScores.put(q, newScores.get(q) + newScore);
				}
//				System.out.println(sum);
			}
		}
		this.scores = newScores;
//		System.out.println("total score: " + scoresSums());
	}
	
	public double scoresSums(){
		double sum = 0;
		for (Double d : scores.values()){
			sum += d;
		}
		return sum;
	}
	public Map<Vertex, Double> executePageRank(int stepCount){
		int progressNum = stepCount / 12;
		int threshold = progressNum;
		System.out.println("| Progress: |");
		System.out.print("#");
		for(int i = 0; i < stepCount; i++){
			if (i == threshold){
				System.out.print("#");
				threshold += progressNum;
			}
			executeStep();
		}
		System.out.println();
		return scores;
	}
	
	

}
