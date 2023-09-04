package telran.race;

import java.io.*;

public class RaceControllerAppl {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		PrintStream output = new PrintStream(System.out);
		
		int numThreads = Integer.parseInt(args[0]);
		int distance = Integer.parseInt(args[1]);
		
		Race race = new Race(numThreads, distance);
		Racer winner = race.toStart();

		output.printf("\nCongratulations to %s with finishing time %d ms", winner.getRacerName(), winner.getFinishTime());

	}

}
