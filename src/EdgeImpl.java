
public class EdgeImpl implements Edge {
	
	
	private int inNode;
	private int outNode;
	private int weight;

	public EdgeImpl(int node1, int node2, int weight) {
		this.inNode = node2;
		this.outNode = node1;
		this.weight = weight;
	}

	@Override
	public int getWeight() {
		return this.weight;
	}

	@Override
	public int getInNode() {
		return this.inNode;
	}

	@Override
	public int getOutNode() {
		return this.outNode;
	}
	
}
