
public class Task1 implements Runnable {

	@Override
	public void run() {
		for (int k = 0; k < 100; k++) {
			System.out.println("Hello, World from Thread "+k+" time");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Start");
		Thread aThread = new Thread(new Task1());
		aThread.start();
		try {
			aThread.join();
		} catch (InterruptedException e) {}
		System.out.println("Exit");
	}
	
	
}
