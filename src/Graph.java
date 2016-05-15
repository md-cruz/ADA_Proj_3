import java.util.List;

public interface Graph {
int numNodes();
	
	List<Integer> nodes();
	
	List<Integer> outNodes(int node);
	
	List<Integer> inNodes(int node);
	
	List<Edge> getGraphEdges();
	
	void addEdge(int node1, int node2, int weight);
		
}
