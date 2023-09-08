package telran.multithreading;

public class SyncPrintersControllerAppl {
		private static final int N_PRINTERS = 4;
		private static final int N_NUMBERS = 100;
		private static final int N_PORTIONS = 10;
		
	public static void main(String[] args) {		

		SyncChain chain = new SyncChain(N_NUMBERS, N_PORTIONS);
		SyncPrinter[] printers = new SyncPrinter[N_PRINTERS];
		
		startPrinters(printers, chain);
		printers[0].interrupt();	

	}

	private static void startPrinters(SyncPrinter[] printers, SyncChain chain) {
		printers[0] = new SyncPrinter("1", chain);
		for(int i = 1;i < printers.length;i++) {
			String j = Integer.toString(i + 1);
			printers[i] = new SyncPrinter(j, chain);
			printers[i - 1].setNextPrinter(printers[i]);
			printers[i - 1].start();
		}
		printers[printers.length - 1].setNextPrinter(printers[0]);
		printers[printers.length - 1].start();
	}

} 