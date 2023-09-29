package telran.multithreading.consumer;

import telran.multithreading.messaging.MessageBox;

public class Receiver extends Thread {
	private MessageBox messageBox;

	public Receiver(MessageBox messageBox) {
		this.messageBox = messageBox;
	}
	@Override
	public void run() {
		while(messageBox.take() != null) {
			try {
				String message = messageBox.get();
				System.out.printf("Thread %d has got message: %s\n", getId(), message);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
