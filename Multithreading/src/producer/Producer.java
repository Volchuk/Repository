package producer;

import massege.Massege;
import blockingQueue.RealBlockingQueue;

public class Producer implements Runnable {

	public String nameProducer;
	private static int i = 0;
	volatile RealBlockingQueue<Massege> queue;

	public Producer (RealBlockingQueue<Massege> queue1, String name) {
		this.queue = queue1;
		this.nameProducer = name;
		System.out.println("Producer started");
	}
	
	@Override
	public void run() {
		while (true) {
		i ++;
		String s = "Thread "+nameProducer+" generated massege "+i;
		Massege mes = new Massege(i, s);
		queue.offer(mes);
		System.out.println(s+" and put into queue.");
		}
	}

}
