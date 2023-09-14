package telran.multithreading.games;

import java.time.Instant;
import java.util.ArrayList;

public class Race {
	private int distance;
	private int minSleep;
	private int maxSleep;
	private ArrayList<Runner> winnerTable; 
	private Instant timeStart;
	
	private int winner = -1;
	public Race(int distance, int minSleep, int maxSleep, ArrayList<Runner> winnerTable, Instant timeStart ) {
		this.distance = distance;
		this.minSleep = minSleep;
		this.maxSleep = maxSleep;
		this.winnerTable = winnerTable;
		this.timeStart = timeStart;
	}
	
	public Instant getTimeStart() {
		return timeStart;
	}

	public ArrayList<Runner> getWinnerTable() {
		return winnerTable;
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

	
}
