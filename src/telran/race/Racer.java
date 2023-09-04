package telran.race;

public class Racer extends Thread {
	private String name;
	private int distance;
	private int finishTime;
	
	public Racer(String name, int distance) {
		this.name = name;
		this.distance = distance;
		this.finishTime = 0;
			
	}
	
	public String getRacerName() {
		return name;
	}
	
	public int getFinishTime() {
		return finishTime;
	}


	@Override
	public void run() {
		int time = 0;
		for(int i = 0; i < distance; i++) {
			int loop = (int) (2 + Math.random() * 3);
			try {
				sleep(loop);				
				time += loop;
				System.out.printf("loop %d: %s: %d ms\n", i, this.getRacerName(), time);
			} catch (InterruptedException e) {
				
			}
			this.finishTime = time;
		}
		
		
	}

}
