package telran.multithreading.games;

public class Runner extends Thread {
private Race race;
private int runnerId;
private long runnerTime;
private int runnerPlace;

public void setRunnerTime(long runnerTime) {
	this.runnerTime = runnerTime;
}

public long getRunnerTime() {
	return runnerTime;
}

public void setRunnerPlace(int runnerPlace) {
	this.runnerPlace = runnerPlace;
}

public long getRunnerPlace() {
	return runnerPlace;
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
	race.setWinner(runnerId);
	race.setPlace(this);
}


}
