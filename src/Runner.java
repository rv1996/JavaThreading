import java.lang.*;

class Run extends Thread{

	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println("Hello "+i);
		
		try{
			Thread.sleep(1000); //static function i.e accessed with class name
		}catch(InterruptedException e){
			e.printStackTrace();;
		}
		}
		
	}
}

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Run r1 = new Run();
		Run r2 = new Run();
		
		r1.start();
		r2.start ();
			
	}

} 


