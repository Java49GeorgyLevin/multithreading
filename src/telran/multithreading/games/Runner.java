package telran.multithreading.games;

import java.time.Instant;

public class Runner extends Thread {
private Race race;
private int runnerId;
private Instant runnerTime;


public void setRunnerTime(Instant runnerTime) {
	this.runnerTime = runnerTime;
}

public Instant getRunnerTime() {
	return runnerTime;
}


public Runner(Race race, int runnerId) {
	this.race = race;
	this.runnerId = runnerId;
}


public int getRunnerId() {
	return runnerId;
}

@Override
public void run() {
	int sleepRange = race.getMaxSleep() - race.getMinSleep() + 1;
	int minSleep = race.getMinSleep();
	int distance = race.getDistance();
	for (int i = 0; i < distance; i++) {
		try {
			long loop = (long) (minSleep + Math.random() * sleepRange);
			sleep(loop);
		} catch (InterruptedException e) {
			throw new IllegalStateException();
		}
		System.out.println(runnerId);
	}
	synchronized (race) {

		setRunnerTime(Instant.now());
		race.getWinnerTable().add(this);
		race.setWinner(runnerId);
	}

}


}
