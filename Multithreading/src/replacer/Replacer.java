package replacer;

import massege.Massege;
import blockingQueue.RealBlockingQueue;

public class Replacer implements Runnable {
	
	public String nameReplacer;
	static volatile RealBlockingQueue<Massege> source;
	static volatile RealBlockingQueue<Massege> destination;
	
	public Replacer (RealBlockingQueue<Massege> queue2, RealBlockingQueue<Massege> queue3, String name) {
		source = queue2;
		destination = queue3;
		nameReplacer = name;
	}
	
	@Override
	public void run() {
		while(true) {
			int k = source.poll().num;
			Massege toDestination = new Massege(k,"");
			toDestination.massege = "Thread " + nameReplacer +" moved massege "+k;
			destination.offer(toDestination);
		}
	}
	
}
