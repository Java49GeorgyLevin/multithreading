package telran.race;

public class Runner extends Thread {
	private Race race;
	private int runnerId;

public Runner(Race race, int runnerId) {
		this.race = race;
		this.runnerId = runnerId;
	}

	@Override
	public void run() {

		int distance = race.getDistance();
		int minSleep = race.getMinSleep();
		int maxSleep = race.getMaxSleep();		
		
		for(int i = 0; i < distance; i++) {

			long loop = (long) (minSleep + Math.random() * (maxSleep - minSleep));
			try {
				sleep(loop);				

			} catch (InterruptedException e) {
				throw new IllegalStateException();
			
			}
			System.out.println(runnerId);
		}
		
		this.race.setWinner(runnerId);
	}

}
