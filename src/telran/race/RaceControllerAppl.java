package telran.race;

import telran.view.*;
import java.util.function.BiFunction;

public class RaceControllerAppl {

	public static void main(String[] args) throws InterruptedException {

		InputOutput io = new ConsoleInputOutput();
		Menu menu = new Menu("Cockroaches Races", getItems());
		menu.perform(io);
	};

	private static Item[] getItems() {
		Item[] items = { 
				Item.of("Race", io -> prepareRace(io, (a, b) -> new Race(a, b))), 
				Item.ofExit() };
		return items;
	}

	private static void prepareRace(InputOutput io, BiFunction<Integer, Integer, Race> operator) {
		int numThreads = io.readInt("Input number of racers", "The number is wrong", 3, 10);
		int distance = io.readInt("Input a distance", "The distance is wrong", 100, 3500);
	
		try {
			Racer winner = operator.apply(numThreads, distance).toStart();
			String str = String.format("\nCongratulations to %s with finishing time %d ms", winner.getRacerName(), winner.getFinishTime());
			io.writeLine(str);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}


}
