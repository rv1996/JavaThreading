package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;




class Processor implements Runnable{
	
	private int id;
	public Processor(int id){
		this.id = id;
	}
	
	public int getId(){
		return (this.id);
	}
	public void run(){
		System.out.println("Starting P"+this.id);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("completed P"+this.id);
		
	}
}
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newFixedThreadPool(4); //parameter tell how many thread are to be executed at that time
		// like this we don't have to create and manage 5 different threads 
		// this service do that for us
		for(int i=0;i<5;i++){
			executor.submit(new Processor(i));
		}
		executor.shutdown();
		
		System.out.println("All tasked submitted");
		
		try {
			executor.awaitTermination(1,TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("All tasked completed");


	}

}
