package telran.multithreading;

public class SyncPrintersControllerAppl {
		private static final int N_PRINTERS = 4;
		private static final int N_NUMBERS = 100;
		private static final int N_PORTIONS = 10;
		
	public static void main(String[] args) {
		

		SyncChain chain = new SyncChain(N_PRINTERS, N_NUMBERS, N_PORTIONS);
		chain.start();
		

	}
	
	

}
