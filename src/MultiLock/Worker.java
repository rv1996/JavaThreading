package MultiLock;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
// added this project to Git repository

public class Worker {

	private Random random = new Random();
	
	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();
	
	public void stage1(){
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list1.add(random.nextInt());
		
	}
	
	public void stage2(){
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list2.add(random.nextInt());
		
	}
	
	public void process(){
		for(int i =0;i<1000;i++){
			stage1();
			stage2();
		}
	}
	
	public void main() {
		// TODO Auto-generated method stub
		System.out.println("Starting..... ");
		
		long start = System.currentTimeMillis();
//		process();
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				process();	
			}
		});
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				process();	
			}
		});
		
		t1.start();
		t2.start();
		//this cause the error, there are two thread but we didn't get the output equivalent to 2000
		
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("Time taken is "+(end-start));
		System.out.println("List1 :" +list1.size()+ " List2 :"+list2.size());
		
	}

}
