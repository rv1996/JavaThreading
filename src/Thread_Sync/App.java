package Thread_Sync;
import java.util.Scanner;

class Processor extends Thread{
	
	private volatile boolean running = true;
	// prevent thread catching variable of the variable value while the programming is running
	
	public void run(){
		while(running){
			System.out.println("Processor is running");
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
	}
	
	public void shutdown(){
		this.running = false;
		System.out.println("Processor stops runnning");
	}
}

// Thread synchronization
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Processor p1 = new Processor();
		p1.start();
		
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		
		p1.shutdown();
		scanner.close();
	}

}
