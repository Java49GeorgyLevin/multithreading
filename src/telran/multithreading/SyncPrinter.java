package telran.multithreading;

public class SyncPrinter extends Thread {
	private static final int TIME_SLEEP = 10;
	private String symbol;
	private SyncPrinter nextPrinter;
	private int portions;
	private int numbers;
	private int ammount;

	public SyncPrinter(String symbol, SyncChain chain) {
		this.symbol = symbol;
		numbers = chain.numbers();
		portions = chain.portions();
		ammount = numbers / portions;
	}

	public void setNextPrinter(SyncPrinter printer) {
		nextPrinter = printer;
	}

	@Override
	public void run() {
		int currentLoop = 0;
		while (currentLoop < portions) {
			try {
				sleep(0);
			} catch (InterruptedException e) {
				for (int i = 0; i < ammount; i++) {
					System.out.print(symbol);

					try {
						sleep(TIME_SLEEP);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}

				}
				System.out.println("");
				nextPrinter.interrupt();
				currentLoop++;
			}
		}

	}

}
