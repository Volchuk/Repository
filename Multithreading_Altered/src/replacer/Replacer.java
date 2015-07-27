package replacer;

import massege.Massege;
import blockingQueue.RealBlockingQueue;

public class Replacer implements Runnable {
	
	public String nameReplacer;
	volatile RealBlockingQueue<Massege> source;
	volatile RealBlockingQueue<Massege> destination;
	
	public Replacer (RealBlockingQueue<Massege> queue2, RealBlockingQueue<Massege> queue3, String name) {
		source = queue2;
		destination = queue3;
		nameReplacer = name;
	}
	
	@Override
	public void run() {
		while(true) {
			int k = source.poll().num;
			//System.out.println(k);
			Massege toDestination = new Massege(k,"");
			toDestination.massege = "Thread " + nameReplacer +" moved massege "+k;
			destination.offer(toDestination);
		}
	}
	
}
