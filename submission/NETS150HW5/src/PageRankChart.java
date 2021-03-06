import java.awt.Font;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

public class PageRankChart extends ApplicationFrame {
   
	Iterator<Entry<Vertex, Double>> pagerank;
	Graph graph;
	public PageRankChart( String applicationTitle , String chartTitle, Iterator<Entry<Vertex, Double>> pagerank, Graph graph ) {
		super( applicationTitle );
		this.pagerank = pagerank;
		this.graph = graph;
		JFreeChart barChart = ChartFactory.createBarChart(
				chartTitle,           
				"Category",            
				"Score",            
				createDataset(),          
				PlotOrientation.VERTICAL,           
				true, true, false);

		ChartPanel chartPanel = new ChartPanel( barChart );        
		chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
		setContentPane( chartPanel ); 
		
		CategoryPlot plot = barChart.getCategoryPlot();
		CategoryAxis axis = plot.getDomainAxis();

        Font font = new Font("Dialog", Font.PLAIN, 4);
        axis.setTickLabelFont(font);
	}

	private CategoryDataset createDataset() {
		final String winrateString = "Win Rate";
		final String pagerankString = "Page Rank";
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  

		while(pagerank.hasNext())
		{
			Entry<Vertex, Double> entry = pagerank.next();
			dataset.addValue(entry.getValue(), pagerankString, entry.getKey().name);
		}
//        for(Entry<Vertex, LinkedList<Vertex>> entry : graph.adjList.entrySet())
//        {
//			dataset.addValue(entry.getKey().name, pagerankString, entry.getKey().);
//        }

		return dataset; 
	}
}