package Thread_Sync;

public class AppSync {

	private int count = 0;
	
	public synchronized void incerment(){
		this.count =this.count + 1;
	}
	
	public static void main(String[] args) {
		AppSync s = new AppSync();
		s.doWork();
	};
	
	public void doWork(){
		Thread t1 = new Thread(new Runnable(){
			
			public void run(){
				for(int i=0;i<10000;i++){
					incerment();
				}
			};
		});
		Thread t2 = new Thread(new Runnable(){
			
			public void run(){
				for(int i=0;i<10000;i++){
					incerment();
				}
			};
		});
		
		t1.start();
		t2.start();
		try{
			t1.join();
			t2.join();	
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		
		System.out.println("Count is : "+count);
		
	};

}
