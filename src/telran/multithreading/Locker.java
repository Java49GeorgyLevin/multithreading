package telran.multithreading;

public class Locker extends Thread {
	private String name;
	private Object a;
	private Object b;
	
	public Locker (String name, Object a, Object b) {
		this.name = name;
		this.a = a;
		this.b = b;
	}
	
	@Override 
	public void run() {
		synchronized (a) {
			System.out.printf("%s is outside\n", name);
			synchronized(b) {
				System.out.printf("%s is inside\n", name);				
			}
		}		
	}

}
