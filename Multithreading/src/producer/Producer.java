package producer;

import massege.Massege;
import blockingQueue.RealBlockingQueue;

public class Producer implements Runnable {

	public String nameProducer;
	public volatile static int i = 0;
	volatile RealBlockingQueue<Massege> source;

	public Producer (RealBlockingQueue<Massege> queue, String name) {
		source = queue;
		this.nameProducer = name;
	}
	
	@Override
	public void run() {
		while (true) {
			synchronized(source){
			i++;
			String s = "Thread "+this.nameProducer+" generated massege "+ i;
			Massege newborn = new Massege(i, s);
			source.offer(newborn);
			//System.out.println("NEw"+newborn.massege+" "+i);
			}
		}
	}

}