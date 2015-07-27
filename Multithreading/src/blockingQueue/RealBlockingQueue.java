package blockingQueue;

import java.util.NoSuchElementException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RealBlockingQueue<E> implements BlockingQueue<E> {

	private int numberOfElem;
	public final int max;
	private volatile Element<E> first;
	private volatile Element<E> last;
	
	Lock lock = new ReentrantLock();
	Condition notFull = lock.newCondition();
	Condition notEmpty = lock.newCondition();
	
	private static class Element<E> {
		private E elem;
		private Element<E> next;
		
		public Element(E e) {
			this.elem = e;
			this.next = null;
		}
	}
	
	public RealBlockingQueue(int max) {
		first = null;
		last = null;
		numberOfElem = 0;
		this.max = max;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	private void add(E e) {
		Element<E> oldLast = last;
		last = new Element<E> (e);
		if (isEmpty()) {
			first = last;
		} else {
			oldLast.next = last;
		}
		numberOfElem ++;
	}
	
	@Override
	public void offer(E e) {
		lock.lock();
		try {
			while(numberOfElem == max) {
				try {
					notFull.await();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
			}
			add(e);
			notEmpty.signal();
		}
		finally {
			lock.unlock();
		}
	}

	private E remove(){
		E temp = first.elem;
		first = first.next;
		numberOfElem --;
		return temp;
	}
	
	@Override
	public E poll() throws NoSuchElementException {
		lock.lock();
		try {
			while (isEmpty()) {
				try {
					notEmpty.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
				notFull.signal();
				return remove();
		} 
		finally {
			lock.unlock();
		}
	}

}