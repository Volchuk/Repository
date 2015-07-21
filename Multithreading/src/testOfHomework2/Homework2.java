package testOfHomework2;

import blockingQueue.RealBlockingQueue;
import massege.Massege;
import producer.Producer;
import replacer.Replacer;

public class Homework2 {

	public static void main(String[] args) {
		RealBlockingQueue<Massege> source = new RealBlockingQueue<> (20);
		RealBlockingQueue<Massege> destination = new RealBlockingQueue<> (50);
		
		Thread[] producer = new Thread[5];
		Thread[] replacer = new Thread[2];

		for (int k = 0; k < 5; k++) {
			producer[k] = new Thread(new Producer (source, "Producer"+k));
			producer[k].setName("Producer"+k);
			producer[k].setDaemon(true);
			producer[k].start();
		}
			
		for (int j = 0; j < 2; j++) {
			replacer[j] = new Thread(new Replacer (source, destination, "Replacer"+j));
			replacer[j].setName("Replacer"+j);
			replacer[j].setDaemon(true);
			replacer[j].start();
		}
		
		int count = 0;
		
		while (count < 100) {
			//destination.poll();
			System.out.println("Console: "+destination.poll().massege);
			count++;
		}
		System.exit(0);
	}
	
}
