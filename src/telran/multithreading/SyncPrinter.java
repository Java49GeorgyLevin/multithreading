package telran.multithreading;
	
public class SyncPrinter extends Thread {
	private String name;
	private String symbol;
	private int portions;
	private int numbers;
	
	private boolean running = true;
	
	public void stopPrinter() {
		this.running = false;
	}
	
		
	public SyncPrinter(String symbol, int numbers, int portions) {		
		this.name = "Printer_".concat(symbol);
		this.symbol = symbol;
		this.numbers = numbers;
		this.portions = portions;
	}
	
	public String getPrinterName() {
		return name;		
	}
	
	public String getSymbol() {
		return symbol;		
	}
	

	
	@Override
	public void run() {
		int currentPortions = portions;
		while(running) {
			while(currentPortions > 0) {
				System.out.println(symbol);
				currentPortions--;
		}
		
	}

}
