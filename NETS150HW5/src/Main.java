

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.swing.JFrame;

import org.jfree.ui.RefineryUtilities;

public class Main {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		//"../test.txt"
		FileParser fp = new FileParser("../test.txt");
		fp.addRemainingEdges();

		Graph g = fp.getGraph();
		
		GraphApplet graphVisual = new GraphApplet();
		graphVisual.init(g);
		JFrame frame = new JFrame("Graph Visualizer");
		frame.getContentPane().add(graphVisual);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(1200, 800);
		
		PageRank pr = new PageRank(g);
		pr.executePageRank(2000);
		
		Iterator<Entry<Vertex, Double>> itr = pr.scores.entrySet().stream().sorted(Entry.comparingByValue()).iterator();
		while (itr.hasNext()){
			System.out.println(itr.next());
		}

		PageRankChart chart = new PageRankChart("PageRank Statistics", "PageRank for each class", pr.scores.entrySet().stream().sorted(Entry.comparingByValue()).iterator(), g);
		chart.pack( );
		RefineryUtilities.centerFrameOnScreen( chart );        
		chart.setVisible( true ); 
		
	}

}
