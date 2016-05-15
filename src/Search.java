import java.util.List;

public interface Search {

	void bellmanFord(int originNode, int destNode) throws NegativeCycleException;
}
