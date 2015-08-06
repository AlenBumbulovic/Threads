package ba.bitcamp.vjezbe4;

import ba.bitcamp.vjezbe3.Task3.MyThread;

public class Task1 {

	static Integer counter = 0;

	public static void main(String[] args) {
		
		Thread t = new Thread(new MyThread());
		t.start();

	}

	public static class MyThread implements Runnable {

		@Override
		public void run() {
			long startTime = System.currentTimeMillis();
			for (int i = 10; i < 10000; i++) {

				boolean isPrime = true;

				for (int j = 2; j < i; j++) {

					if (i % j == 0) {
						isPrime = false;
						break;
					}
				}

				if (isPrime)
					counter++;

			}
			System.out.println(counter);
			long endTime = System.currentTimeMillis();
			System.out.println((endTime - startTime) / 1000);

		}

	}

}
