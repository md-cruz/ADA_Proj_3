
public class NegativeCycleException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public NegativeCycleException () {
		super("Negative weight cycle found!");
	}

}
