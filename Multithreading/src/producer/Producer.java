package producer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import massege.Massege;
import blockingQueue.RealBlockingQueue;

public class Producer implements Runnable {

	public String nameProducer;
	public volatile static int i = 0;
	public volatile RealBlockingQueue<Massege> source;

	public Producer (RealBlockingQueue<Massege> queue, String name) {
		source = queue;
		this.nameProducer = name;
	}
	
	static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	private final Lock r = rwl.readLock();
	private final Lock w = rwl.writeLock();
	
	@Override
	public void run() {
		try {
			r.lock();
		while (true) {
			r.unlock();
			w.lock();
			Massege newborn = new Massege(i, "Thread "+this.nameProducer+" generated massege "+ i ++);
			w.unlock();
			r.lock();
			source.offer(newborn);
			}
		} finally {
			r.unlock();
		}
	}

}