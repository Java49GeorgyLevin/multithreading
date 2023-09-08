package telran.race;

import telran.view.*;

import java.util.Arrays;

public class RaceControllerAppl {
	private static final int MIN_SLEEP = 2;
	private static final int MAX_SLEEP = 5;
	private static final int MIN_RUNNERS = 3;
	private static final int MAX_RUNNERS = 10;
	private static final int MIN_DISTANCE = 100;
	private static final int MAX_DISTANCE = 3500;

	public static void main(String[] args) throws InterruptedException {

		InputOutput io = new ConsoleInputOutput();
		Menu menu = new Menu("Cockroaches Races", getItems());
		menu.perform(io);
	};

	private static Item[] getItems() {
		Item[] items = { 
				Item.of("Race", RaceControllerAppl::startRace), 
				Item.ofExit() };
		return items;
	}

	private static void startRace(InputOutput io) {
		int numThreads = io.readInt("Input number of runners", "The number is wrong", MIN_RUNNERS, MAX_RUNNERS);
		int distance = io.readInt("Input a distance", "The distance is wrong", MIN_DISTANCE, MAX_DISTANCE);
		Race race = new Race(distance, MIN_SLEEP, MAX_SLEEP);		
		Runner[] runners = new Runner[numThreads];
		
		prepareRunners(runners, race);
		joinRunners(runners);
		showWinner(race);


	}

	private static void showWinner(Race race) {
		System.out.println("Cogratulation to " + race.getWinner());
		
	}

	private static void joinRunners(Runner[] runners) {
		Arrays.stream(runners)
		.forEach(r -> {			
			try {
				r.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
	}

	private static void prepareRunners(Runner[] runners, Race race) {
			for(int i = 0; i < runners.length; i++) {
			int j = i + 1;
			runners[i] = new Runner(race, j);
			runners[i].start();
		}
		
	}

}
