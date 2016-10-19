
class App implements Runnable{
	public void run(){
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

public class Run2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new App());
		Thread t2 = new Thread(new App());
		Thread t3 = new Thread(new Runnable(){
			public void run(){
				for(int i=0;i<10;i+=2){
					System.out.println("Hello "+i);
					try{
						Thread.sleep(1000); //static function i.e accessed with class name
					}catch(InterruptedException e){
						e.printStackTrace();;
						}
				}
			}
		});
		
		t3.start();
		t1.start();
		t2.start(); 
		
	}

}
