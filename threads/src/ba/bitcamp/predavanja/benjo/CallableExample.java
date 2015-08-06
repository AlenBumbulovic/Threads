package ba.bitcamp.predavanja.benjo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
	
	public static void runExample(){
		
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		Future<Integer> f = es.submit(new Calculator());
		
		try {
			System.out.println("Result: " +  f.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		es.shutdown();
	}
	
	
	private static class Calculator implements Callable<Integer>{
		int result = 0;
		@Override
		public Integer call() throws Exception {
			for(int i = 0; i < 5; i++){
				result += i;
				Thread.sleep(500);
			}
			return result;
		}
		
	}

}
