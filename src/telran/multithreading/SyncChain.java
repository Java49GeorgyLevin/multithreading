package telran.multithreading;

public record SyncChain(int numbers, int portions) {
	
}

//public class SyncChain {
//	private int numbers;
//	private int portions;
//	private boolean end = false; 
//	
//	public SyncChain(int numbers, int portions) {
//		this.numbers = numbers;
//		this.portions = portions;		
//	}
//	
//	public void setEnd() {
//		end = true;
//	}
//
//	public int getNumbers() {
//		return numbers;
//	}
//
//	public int getPortions() {
//		return portions;
//	}
//
//	public boolean isEnd() {
//		return end;
//	}
//	
//	
//	
//}
	
//	private SyncPrinter[] chain;
//	private boolean running = true;	
//	private SyncPrinter[] printers;
//	
//	private int numbers;
//	private int portion;
//	
//	public void stopChain() {
//		this.running = false;
//	}
//	
//	public SyncChain(int nPrinters, int numbers, int portion) {
//		this.printers = new SyncPrinter[nPrinters];		
//		for(int i = 0; i < nPrinters; i ++) {
//			String j = Integer.toString(i + 1);
//			printers[i] = new SyncPrinter(j, numbers, portion);
//		}		
//		
//		this.numbers = numbers;
//		this.portion = portion;
//	}
//	
//	@Override
//	public void run() {
//		int index = 0;
//		int currentPortion = portion;
//		while(running) {
//			
//			
//			while(currentPortion > 0) {
//				System.out.println(printers[index].getSymbol());
//				currentPortion--;
//				
//			}
//			
//			try {
//				this.interrupt();
//				//sleep(10);
//	
//				
//			}  
//			catch (InterruptedException e) {
//				index++;
//				if(index == printers.length) {
//					index = 0;					
//				}
//			}
//		}
//		
//	}
//
//}
