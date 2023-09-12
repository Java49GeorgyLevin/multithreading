package telran.multithreading.games;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Race {
	Instant startTime = null;
	private int place = 0;
	private int distance;
	private int minSleep;
	private int maxSleep;
	private int winner = -1;
	public Race(int distance, int minSleep, int maxSleep) {
		this.distance = distance;
		this.minSleep = minSleep;
		this.maxSleep = maxSleep;
	}
	public void setStartTime(Instant startTime) {
		this.startTime = startTime;
	}
	
	public int getWinner() {
		return winner;
	}
	public void setWinner(int winner) {
		if (this.winner == -1) {
			this.winner = winner;
		}
	}
	public int getDistance() {
		return distance;
	}
	public int getMinSleep() {
		return minSleep;
	}
	public int getMaxSleep() {
		return maxSleep;
	}
	
	public synchronized void setPlace(Runner runner) {
		runner.setRunnerTime(ChronoUnit.MILLIS.between(startTime, Instant.now()));
		place++;
		runner.setRunnerPlace(place);
				
	}
	
}
