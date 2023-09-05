package telran.race;

import java.util.Arrays;
import java.util.Comparator;

public class Race {

	private int numThreads;
	private int distance;
	public Race(int numThreads, int distance) {
		this.numThreads = numThreads;
		this.distance = distance;
	}
	
	public Racer toStart() throws InterruptedException {
		Racer[] racers = new Racer[numThreads];
		for(int i = 0; i < racers.length; i++) {
			int j = i + 1;
			racers[i] = new Racer("Cockroach-" + j ,distance);
		}
		
		
		Arrays.stream(racers)
		.forEach(r -> r.start());
		
		Arrays.stream(racers)
		.forEach(r -> {			
			try {
				r.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		return Arrays.stream(racers)
				.min(Comparator.comparing(r -> r.getFinishTime()))
				.orElseThrow();		
		
	}
	
}
