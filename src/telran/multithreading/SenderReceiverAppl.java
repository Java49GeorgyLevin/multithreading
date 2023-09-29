package telran.multithreading;

import telran.multithreading.consumer.Receiver;
import telran.multithreading.messaging.MessageBox;
import telran.multithreading.producer.Sender;

public class SenderReceiverAppl {

	private static final int N_MESSAGES = 20;
	private static final int N_RECEIVERS = 10;

	public static void main(String[] args) throws InterruptedException {
		MessageBox messageBox = new MessageBox();
		Sender sender = new Sender(messageBox, N_MESSAGES);
		sender.start();
		startReceivers(messageBox);
	}

	private static void startReceivers(MessageBox messageBox) throws InterruptedException {
		for (int i = 0; i < N_RECEIVERS; i++) {
			new Receiver(messageBox).start();
		}

	}

}
