package ba.bitcamp.predavanja.benjo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorExample {
	
	public static void runExample(){
		
		ExecutorService es = Executors.newFixedThreadPool(5);
		es.submit(new Runnable(){
	
			
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Prvi task");
				
			}
		});
		
		es.submit(new Runnable(){

			@Override
			public void run() {
				System.out.println("Drugi task");
				
			}
			
		});
		es.shutdown();
	}

}
