
public class BellmanFord implements Search {
	
	private Graph graph;
	private int numNodes;
	private int numEdges;
	
	public BellmanFord (Graph g, int numNodes, int numEdges){
		this.graph = g;
		this.numEdges = numEdges;
		this.numNodes = numNodes;
	}

	@Override
	public void bellmanFord(int originNode, int destNode) throws NegativeCycleException {
		int [] distance = new int[numNodes];
		int [] predecessor = new int[numNodes];
		
		for(int i : graph.nodes())
			distance[i] = Integer.MAX_VALUE;
		distance[originNode] = 0;
		predecessor[originNode] = originNode;
		
		boolean changes = false;
		
		for(int i = 1; i < numNodes; i++){
			changes = updateLength(distance,predecessor);
			if(!changes)
				break;
		}
		if(changes && updateLength(distance,predecessor))
			throw new NegativeCycleException();
		
		// nao sei se e para retornar

	}
	
	private boolean updateLength(int[] distance, int[] predecessor){
		boolean changes = false;
		for(Edge e : graph.getGraphEdges()){
			int head = e.getInNode();
			int tail = e.getOutNode();
			if(distance[tail] < Integer.MAX_VALUE){
				int newLength = distance[tail] + e.getWeight();
				if(newLength < distance[tail]){
					distance[head] = newLength;
					predecessor[head] = tail;
					changes = true;
				}
			}
			
		}		
		return changes;
		
	}

}
