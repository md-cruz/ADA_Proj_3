import java.util.List;

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
	public boolean bellmanFord(int originNode, int destNode) {
		boolean loseMoney = false;
		int [] distance = new int[numNodes];
		int [] predecessor = new int[numNodes];
		
		for(int i = 0; i < graph.numNodes() ;i++)
			distance[i] = Integer.MAX_VALUE;
		distance[originNode] = 0;
		predecessor[originNode] = originNode;
		
		boolean changes = false;
		
		for(int i = 1; i < numNodes && !loseMoney; i++){
			changes = updateLength(distance,predecessor);
			if(distance[destNode] < 0)
				loseMoney = true;
			
			if(!changes)
				break;
		}
		if(!loseMoney && changes && updateLength(distance,predecessor))
			loseMoney = true;
		
		if(!loseMoney && distance[destNode] < 0 )
			loseMoney = true;
		
		
		return loseMoney;

	}
	
	private boolean updateLength(int[] distance, int[] predecessor){
		boolean changes = false;
		for(Edge e : graph.getGraphEdges()){
			int head = e.getInNode();
			int tail = e.getOutNode();
			if(distance[tail] < Integer.MAX_VALUE){
				int newLength = distance[tail] + e.getWeight();
				if(newLength < distance[head]){
					distance[head] = newLength;
					predecessor[head] = tail;
					changes = true;
				}
			}
			
		}		
		return changes;
		
	}

}
