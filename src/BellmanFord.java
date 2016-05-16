
public class BellmanFord implements Search {
	
	private Graph graph;
	private int numNodes;
	
	public BellmanFord (Graph g, int numNodes, int numEdges){
		this.graph = g;
		this.numNodes = numNodes;
	}

	@Override
	public boolean bellmanFord(int originNode, int destNode) {
		boolean loseMoney = false;
		int [] distance = new int[numNodes];
		
		for(int i = 0; i < graph.numNodes() ;i++)
			distance[i] = Integer.MAX_VALUE;
		distance[originNode] = 0;
		
		boolean changes = false;
		
		for(int i = 1; i < numNodes && !loseMoney; i++){
			changes = updateLength(distance);
			if(distance[destNode] < 0)
				loseMoney = true;
			if(!changes)
				break;
		}
		if(!loseMoney && changes && updateLength(distance))
			loseMoney = true;
		
		if(!loseMoney && distance[destNode] < 0 )
			loseMoney = true;
		
		
		return loseMoney;

	}
	
	private boolean updateLength(int[] distance){
		boolean changes = false;
		for(Edge e : graph.getGraphEdges()){
			int head = e.getInNode();
			int tail = e.getOutNode();
			if(distance[tail] < Integer.MAX_VALUE){
				int newLength = distance[tail] + e.getWeight();
				if(newLength < distance[head]){
					distance[head] = newLength;
					changes = true;
				}
			}
			
		}		
		return changes;
		
	}

}
