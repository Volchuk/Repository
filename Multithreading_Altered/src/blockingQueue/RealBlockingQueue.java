package blockingQueue;

import java.util.NoSuchElementException;

public class RealBlockingQueue<E> implements BlockingQueue<E> {

	private int numberOfElem;
	public final int max;
	private volatile Element<E> first;
	private volatile Element<E> last;
	
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
	
	public void add(E e) {
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
	public synchronized void offer(E e) {
		if(numberOfElem == max) {
			try {
				this.wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		add(e);
		notifyAll();
	}

	public E remove(){
		E temp = first.elem;
		first = first.next;
		numberOfElem --;
		return temp;
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
		if (!isEmpty()) {
			notifyAll();	
		}
		return remove();
	}

}