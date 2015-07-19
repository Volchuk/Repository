package blockingQueue;

import java.util.NoSuchElementException;

public class RealBlockingQueue<E> implements BlockingQueue<E> {

	private int numberOfElem;
	private int max;
	private Element<E> first;
	private Element<E> last;
	
	private static class Element<E> {
		private E elem;
		private Element<E> next;
		
		public Element(E e) {
			this.elem = e;
			this.next = null;
		}
	}
	
	public RealBlockingQueue() {
		first = null;
		last = null;
		numberOfElem = 0;
	}
	
	public RealBlockingQueue(int max) {
		this();
		this.max = max;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return numberOfElem;
	}
	
	@Override
	public synchronized void offer(E e) {
		if(numberOfElem == max) {
			try {
				this.wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		Element<E> oldLast = last;
		last = new Element<E> (e);
		if (isEmpty()) {
			first = last;
		} else {
			oldLast.next = last;
		}
		numberOfElem ++;
		notifyAll();
	}

	@Override
	public synchronized E poll() throws NoSuchElementException {
		while (isEmpty()) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Element<E> temp = first;
		first = first.next;
		numberOfElem --;
		notifyAll();
		return temp.elem;
	}

}
