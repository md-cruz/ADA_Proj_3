import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	
	private static final String POSITIVE = "B";
	
	public static void main(String[] args) {
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int numberOfRooms = 0;
			int numberOfCorridors = 0;
			
			String [] line = reader.readLine().split("\\s+");
			numberOfRooms = Integer.parseInt(line[0]);
			numberOfCorridors = Integer.parseInt(line[1]);
			System.out.println("\nSleeping 2 seconds (for testing purposes)");
			Thread.sleep(2000);
			System.out.println("Awake!");
			long startTime = System.nanoTime();
			Graph wGraph = new GraphImpl(numberOfRooms,numberOfCorridors);
			for(int i = 0; i < numberOfCorridors; i++){
				line = reader.readLine().split("\\s+");
				
				if(line[2].equalsIgnoreCase(POSITIVE))
					wGraph.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[3]));
				else
					wGraph.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[1]), -Integer.parseInt(line[3]));
			}
			// grafo preenchido, executar bellmanford
			Search bellman = new BellmanFord(wGraph, numberOfRooms, numberOfCorridors);
			boolean result = bellman.bellmanFord(0, numberOfRooms-1);
			double timeTaken = (double) ((System.nanoTime() - startTime) / 1000000.0);		
			System.out.println(timeTaken + " ms");
			String res = result ? "yes" : "no";
			System.out.println(res);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
			
}
