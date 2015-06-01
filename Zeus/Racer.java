/* running race of 100 meters
 * number of runners is 10 with name for each
 * print the winner and all threads should complete the race
 * print the time taken by each runner to complete race
 * highlight the winner's time
 */

// class Racer is runnable target
public class Racer implements Runnable{
	
	public static String winner;
	final long startTime = System.nanoTime();
	
	public void run(){
		for(int dist = 1; dist <= 50; dist++){
			/*System.out.println("Distance covered by "+
					Thread.currentThread().getName()+
					" is "+dist);*/
			//check if race is complete
			if (Racer.winner == null){
				isRaceWon(dist, startTime);
			}
			if (dist == 50 && !(Thread.currentThread().getName().equals( Racer.winner) ) ){
				System.out.println("Runner "+Thread.currentThread().getName()+
						" finished with time : "+
						(System.nanoTime() - startTime )/10000);
			}
		}
		
	}
	
	private boolean isRaceWon(int totalDistance, long startTime){
		boolean isRaceWon = false;
		if ((Racer.winner == null) && (totalDistance == 50)){
			Racer.winner = Thread.currentThread().getName();
			isRaceWon = true;
			System.out.println("The winner is "+Racer.winner+" with time "+(System.nanoTime() - startTime) / 10000);
		} else {
			isRaceWon = false;
		}
		return isRaceWon;
	}
	
	public static void main(String[] args){
		
		Racer racer = new Racer();
		Thread VovaThread = new Thread(racer, "Vova");
		Thread VladThread = new Thread(racer, "Vlad");
		Thread PetroThread = new Thread(racer, "Petro");
		Thread IgorThread = new Thread(racer, "Igor");
		Thread LukakuThread = new Thread(racer, "Lukaku");
		
		//startTime = System.nanoTime(); 
		
		VovaThread.start();
		VladThread.start();
		PetroThread.start();
		IgorThread.start();
		LukakuThread.start();
	}
	
}
