package ba.bitcamp.predavanja;

import java.util.Date;

public class Main {
	private static void extendThread() {
		// NamedThread t1 = new NamedThread("Ross");
		// NamedThread t2 = new NamedThread("Joey");
		// NamedThread t3 = new NamedThread("Rachel");
		//
		// t1.start();
		// t2.start();
		// t3.start();
		//
		//
		// try {
		// t1.join();
		// t2.join();
		// t3.join();
		//
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	private static void namedRunnable() {
		NamedRunnable r1 = new NamedRunnable("Ross");
		NamedRunnable r2 = new NamedRunnable("Joey");
		NamedRunnable r3 = new NamedRunnable("Chandler");

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);

		t1.start();
		t2.start();
		t3.start();

		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Date start = new Date();

		PrimeCounter[] counters = new PrimeCounter[16];
		int startInterval = 1;
		int endInterval = 3000000;
		int step = endInterval / counters.length;

		for (int i = 0; i < counters.length; i++) {
			//counters[i] = new PrimeCounter(i * step, (i + 1) * step);
			try {
				counters[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		int totalCount = 0;
		for (int i = 0; i < counters.length; i++) {

			try {
				counters[i].join();
				totalCount += counters[0].getCount();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Primes count: " +counters[0].getCount());

		Date end = new Date();
		long timeLapse = (end.getTime() - start.getTime()) / 1000;
		System.out.println("Time(s): " + timeLapse);

		System.out.println("End of main");

	}

}
