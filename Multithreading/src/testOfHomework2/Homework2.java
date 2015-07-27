package testOfHomework2;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import blockingQueue.RealBlockingQueue;
import massege.Massege;
import producer.Producer;
import replacer.Replacer;

public class Homework2 {

	public static void main(String[] args) {
		
		RealBlockingQueue<Massege> source = new RealBlockingQueue<> (20);
		RealBlockingQueue<Massege> destination = new RealBlockingQueue<> (50);
		
		CustomThreadFactory ctf = new CustomThreadFactory();
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool(ctf);
		
		for (int i = 0; i < 5; i++) {
			Producer producer = new Producer(source, "Producer"+i);
			producer.nameProducer = "Producer" + i;
			executor.execute(producer);
		}

		for (int i = 0; i < 2; i++) {
			Replacer replacer = new Replacer(source, destination, "Replacer"+i);
			replacer.nameReplacer = "Replacer" + i;
			executor.execute(replacer);
		}
		
		int count = 0;
		
		while (count < 100) {
			System.out.println(destination.poll().massege);
			count++;
		}
		executor.shutdown();
	}
	
}
