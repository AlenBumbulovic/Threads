package ba.bitcamp.vjezbe4;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class Task1MultipleThreads {

	static LinkedBlockingQueue<Runnable> queue;
	static ArrayList<Slave> slaves;
	static Integer counter = 0;
	static int start = 10;
	static int end = 10000;

	public static void main(String[] args) {

		queue = new LinkedBlockingQueue<>();
		// Produce the tasks and add them to the queue
		//for (int i = 0; i <= 100; i++) {
			queue.add(new Task(10, 10000);
			
			start += 9990;
			end += 10000;
			
		//}
			

		// Make the consumers and let them consume
		slaves = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			Slave s = new Slave();
			s.start();
			slaves.add(s);
		}
		
		

	}

	// Consumers
	static class Slave extends Thread {

		@Override
		public void run() {
			while (!queue.isEmpty()) {
				try {
					Runnable job = queue.take();
					job.run();
				} catch (InterruptedException e) {
					break;
				}
			}
		}
	}

	// Jobs to do
	static class Task implements Runnable {
		static int time = 0;
		
		static int start;
		static int end;

		public Task(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public void run() {

			long startTime = System.currentTimeMillis();
			for (int i = start; i < end; i++) {

				boolean isPrime = true;

				for (int j = 2; j < i; j++) {

					if (i % j == 0) {
						isPrime = false;
						break;
					}
				}

				if (isPrime)
					synchronized (counter) {
						counter++;
					}
					

			}
			System.out.println(counter);
			long endTime = System.currentTimeMillis();
			time += (endTime - startTime) / 1000;
			System.out.println("Time: " + time );
		}

	}

}
