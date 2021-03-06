public class Edge {
//An edge from deck A to deck B with weight x means deck A beats deck B with a probability of x
	Vertex src;
	Vertex dest;
	double weight;
	
	public Edge(Vertex src, Vertex dest, double weight){
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}
	
	public Vertex getDest(){
		return dest;
	}
	
	public Vertex getSrc(){
		return src;
	}
	
	public double getWeight(){
		return weight;
	}

}
