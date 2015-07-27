package deadlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Example of deadlock. 2 friends bowing to each other.
 */

public class DeadlockCourtesy {

	static class Friend{
		
		private String name;
		public volatile boolean myBow = false;
		public volatile boolean hisBow = false;
		
		Lock lock = new ReentrantLock();
		Condition bowed = lock.newCondition();
		
		public Friend(String newName) {
			this.name = newName;
		}
		
		public String getName() {
			return name;
		}
		
		public void bow(Friend bowingFriend) throws InterruptedException{
			try {
				lock.lock();
				myBow = true;
				while(hisBow) {
					bowed.await();
					System.out.println(this.getName()+" is bowing.");
				}
			} finally {
				lock.unlock();
			}
		}
		
	}
	
	public static void main(String[] args){
		
		Friend gaston = new Friend("Gaston");
		Friend alphonse = new Friend("Alphonse");
		
		new Thread(new Runnable(){
			public void run() { try {
				gaston.bow(alphonse);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}}
		}).start();
		
		new Thread(new Runnable(){
			public void run() { try {
				alphonse.bow(gaston);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}}
		}).start();

	}
	
}