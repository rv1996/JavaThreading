package CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable{
	private CountDownLatch latch;
	// we don't require synchronized keyword because above is the Thread save class
	
	public Processor(CountDownLatch latch){
		this.latch = latch;
		}
	public void run(){
		System.out.println("Thread started");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		latch.countDown();
	}
}
public class App {

	public static void main(String[] args) {
		// A thread safe class
		CountDownLatch latch = new CountDownLatch(3);
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for(int i=0;i<3;i++){
			executor.submit(new Processor(latch));
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}//wait till the counted down latch count down to 0
		
		System.out.println("Completed");
	}

}
