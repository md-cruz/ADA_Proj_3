import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 */

/**
 * @author Duarte
 *
 */
public class GraphImpl implements Graph {

	private Map<Integer,List<Edge>> graphEdges;
	
	private Set<Edge> edges;
	private int numNodes;
	private int numEdges;
	private boolean sorted;
	private List<Edge> edgeList;
	
	
	public GraphImpl(int numNodes, int numEdges){
		this.numNodes = numNodes;
		this.numEdges = numEdges;
		this.sorted = false;
		graphEdges = new HashMap<Integer,List<Edge>>(numNodes);
		edgeList = new ArrayList<Edge>(numEdges);
		
		/*edges = new TreeSet<Edge>(new Comparator<Edge>(){
			@Override
			public int compare(Edge arg0, Edge arg1) {
				if(arg0.getOutNode() > arg1.getOutNode())
					return 1;
				return -1;
			}
			
		});*/
	}
	
	
	@Override
	public int numNodes() {
		return this.numNodes;
	}

	
	@Override
	public List<Integer> nodes() {
		return new ArrayList<Integer>(graphEdges.keySet());
	}


	@Override
	public List<Integer> outNodes(int node) {
		List<Integer> outEdges = new ArrayList<Integer>(numEdges);
		for(Edge e : graphEdges.get(node))
			outEdges.add(e.getOutNode());
		return outEdges;
	}
	

	@Override
	public List<Integer> inNodes(int node) {
		List<Integer> inEdges = new ArrayList<Integer>(numEdges);
		for(Edge e : graphEdges.get(node))
			inEdges.add(e.getInNode());
		return inEdges;	
	}

	@Override
	public void addEdge(int node1, int node2, int weight) {
		// TODO: verificar se e necessario todos os nodos guardarem informacao
		// sobre as edges que estao associados, ou se basta ter um array de edges
	/*	List<Edge> node1Edges = graphEdges.get(node1);
		if(node1Edges == null)
			node1Edges = new ArrayList<Edge>(numEdges);
		Edge newEdge = new EdgeImpl(node1,node2,weight);
		node1Edges.add(newEdge);
		graphEdges.put(node1, node1Edges);
		
		List<Edge> node2Edges = graphEdges.get(node2);
		if(node2Edges == null)
			node2Edges = new ArrayList<Edge>(numEdges);
		node2Edges.add(newEdge);
		graphEdges.put(node2, node2Edges);*/
		//edges.add(new EdgeImpl(node1,node2,weight));
		edgeList.add(new EdgeImpl(node1,node2,weight));
	}


	@Override
	public List<Edge> getGraphEdges() {
		/*Set<Edge> edges = new HashSet<Edge>(numEdges);
		for(int node : graphEdges.keySet()){
			edges.addAll(graphEdges.get(node));
		}*/
		//return new ArrayList<Edge>(edges);

		if(!sorted){
			Collections.sort(edgeList, new Comparator<Edge>(){
			@Override
			public int compare(Edge arg0, Edge arg1) {
				if(arg0.getOutNode() > arg1.getOutNode())
					return 1;
				return -1;
			}
			
		});
			sorted = true;
		}
		
		return edgeList;
	}

}
