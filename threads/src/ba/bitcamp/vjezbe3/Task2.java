package ba.bitcamp.vjezbe3;

public class Task2 {

	static int counter = 0;
	private static Object obj = new Object();

	public static void main(String[] args) throws InterruptedException {

		for (int i = 0; i <= 20; i++) {
			startThreads();
			System.out.println(counter);
			counter = 0;
			
		}
		
		
		

	}
	

	public static class MyThread implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					synchronized (obj) {
						counter += 10;
					}
					
					
				}
				
			}
			

		}
		

	}

	public static void startThreads() throws InterruptedException {

		Thread t = new Thread(new MyThread());
		Thread t1 = new Thread(new MyThread());
		t.start();
		t1.start();
		t.join();
		t1.join();
		
	}

}
