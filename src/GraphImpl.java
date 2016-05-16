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

	
	private int numNodes;
	private int numEdges;
	private List<Edge> edgeList;
	
	
	public GraphImpl(int numNodes, int numEdges){
		this.numNodes = numNodes;
		this.numEdges = numEdges;
		edgeList = new ArrayList<Edge>(numEdges);
	}
	
	
	@Override
	public int numNodes() {
		return this.numNodes;
	}

	
	@Override
	public List<Integer> nodes() {
		List<Integer> nodes = new ArrayList<Integer>(numNodes);
		for(int i = 0; i < numNodes; i++)
			nodes.add(i);
		return nodes;
	}


	@Override
	public List<Integer> outNodes(int node) {
		List<Integer> outEdges = new ArrayList<Integer>(numEdges);
		for (Edge e : edgeList)
			if (e.getInNode() == node)
				outEdges.add(e.getOutNode());
		return outEdges;
	}

	@Override
	public List<Integer> inNodes(int node) {
		List<Integer> inEdges = new ArrayList<Integer>(numEdges);
		for (Edge e : edgeList)
			if (e.getOutNode() == node)
				inEdges.add(e.getInNode());
		return inEdges;
	}

	@Override
	public void addEdge(int node1, int node2, int weight) {		
		edgeList.add(new EdgeImpl(node1,node2,weight));		
	}


	@Override
	public List<Edge> getGraphEdges() {
		return edgeList;
		//return new ArrayList<Edge>(edges);
	}

}
