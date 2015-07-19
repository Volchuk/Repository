package replacer;

import massege.Massege;
import blockingQueue.RealBlockingQueue;

public class Replacer implements Runnable {
	
	private static int k = 0;
	public String nameReplacer;
	volatile RealBlockingQueue<Massege> queue1;
	volatile RealBlockingQueue<Massege> queue2;
	
	public Replacer (RealBlockingQueue<Massege> queue1, RealBlockingQueue<Massege> queue2, String name) {
		this.queue1 = queue1;
		this.queue2 = queue2;
		this.nameReplacer = name;
		System.out.println("Replacer started");
	}
	
	@Override
	public void run() {
		while(true) {
		Massege old = queue1.poll();
		k = old.num;
		String s = "Thread "+nameReplacer+" moved massege "+ k;
		Massege mes2 = new Massege(k, s);
		queue2.offer(mes2);
		System.out.println(s);
		}
	}
	
}
