package testOfHomework2;

import blockingQueue.RealBlockingQueue;
import massege.Massege;
import producer.Producer;
import replacer.Replacer;

public class Homework2 {

	public static void main(String[] args) {
		RealBlockingQueue<Massege> queue1 = new RealBlockingQueue<> (50);
		RealBlockingQueue<Massege> queue2 = new RealBlockingQueue<> (200);
		
		Thread[] producer = new Thread[5];
		Thread[] replacer = new Thread[2];

		for (int k = 0; k < 5; k++) {
			producer[k] = new Thread(new Producer (queue1, "Producer"+k));
			producer[k].setName("Producer"+k);
			producer[k].start();
		}
			
		for (int j = 0; j < 2; j++) {
			replacer[j] = new Thread(new Replacer (queue1, queue2, "Replacer"+j));
			replacer[j].setName("Replacer"+j);
			replacer[j].start();
		}
		while (queue2.size() != 100 ) {
			if (queue2.size() == 100 ) {
			System.out.println("Done.");
			System.exit(0);
			break;
			}
		}
	}
	
}
