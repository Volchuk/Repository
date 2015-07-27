package blockingQueue;

import massege.Massege;

public class testOfQueue {

	public static void main(String[] args){
		RealBlockingQueue<Massege> testQueue = new RealBlockingQueue<>(100);
		System.out.println(testQueue.isEmpty());

		for (int t = 0; t < 100; t ++){
			int z = (int) (Math.random()*10);
			Massege mes = new Massege(z, "Massege #"+ z);
			System.out.println(mes.massege);
			testQueue.offer(mes);
		}
		System.out.println(testQueue.isEmpty());
		//testQueue.print();
		
		for (int t = 0; t < 100; t ++){
			int k = testQueue.poll().num;
			System.out.println(k);
		}
		System.out.println(testQueue.isEmpty());
	}
}
