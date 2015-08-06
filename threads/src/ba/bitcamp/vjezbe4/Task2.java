package ba.bitcamp.vjezbe4;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class Task2 {
	static LinkedBlockingQueue<Task> queue;
	static ArrayList<Worker> workers;
	static Integer filesCounter = 0;
	static Integer directoryCounter = 0;
	static Object o = new Object();

	public static void main(String[] args) {
		File f = new File("/");

		queue = new LinkedBlockingQueue<>();
		queue.add(new Task(f));
		
		
		workers = new ArrayList<>();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 4; i++) {
			Worker w = new Worker();
			w.start();
			workers.add(w);
		}
		
		for(Worker w : workers){
			try {
				w.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long endTime = System.currentTimeMillis();
		
		System.out.println("There are: " + filesCounter + " files");
		System.out.println("There are: " + directoryCounter + " directories");
		System.out.println((endTime - start)/1000);

	}
	

	static class Worker extends Thread {

		@Override
		public void run() {
			while (!queue.isEmpty()) {
				try {
					Task job = queue.take();
					job.run();
				} catch (InterruptedException e) {
					break;
				}
			}
		}
	}

	static class Task implements Runnable {

		private File root;

		public Task(File root) {
			this.root = root;
		}

		@Override
		public void run() {
			
			
			
			try {
			for (File f : root.listFiles()) {
				if (f.isFile()) {
					synchronized (o) {
						filesCounter++;
					}
					
				} else if (f.isDirectory()) {
					synchronized (o) {
						directoryCounter++;
					}
					
					queue.add(new Task(f));
				}
				
			}
			}catch(NullPointerException e){
				
			}
			
			
		}
			

	}

}
