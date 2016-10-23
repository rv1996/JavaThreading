package ProducerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {

	// Thread safe
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
	
	
	public static void main(String[] args) {
	
		Thread t1 = new Thread(new Runnable(){
			public void run(){
		
				Producer();
				
			}
				
		});
		Thread t2 = new Thread(new Runnable(){
			public void run(){
		
				try {
					Consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
				
		});

		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
						e.printStackTrace();
		}

	}

	private static void Producer(){
		Random number = new Random();
		
		while(true){
			try {
				queue.put(number.nextInt(100)); // define range 0 to 99
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void Consumer() throws InterruptedException{
		Random number = new Random();

		while(true){
			Thread.sleep(100);
			
			if(number.nextInt(10) == 0){
				Integer value = queue.take();
				System.out.println("Taken value is : "+value+".Queue size is"+queue.size());
			}
		}
	}
	
}
