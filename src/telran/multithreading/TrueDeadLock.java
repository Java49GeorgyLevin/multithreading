package telran.multithreading;

public class TrueDeadLock {
	private static Object mutex1 = new Object();
	private static Object mutex2 = new Object();
	private static Locker locker1 = new Locker("locker1", mutex1, mutex2);
	private static Locker locker2 = new Locker("locker2", mutex2, mutex1);
	
	public static void main(String[] args) throws InterruptedException {
		locker1.start();
		locker2.start();
	}

}
