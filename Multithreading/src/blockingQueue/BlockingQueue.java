package blockingQueue;

public interface BlockingQueue<E> {
	
	public void offer(E e) ;
	
	public E poll();

}