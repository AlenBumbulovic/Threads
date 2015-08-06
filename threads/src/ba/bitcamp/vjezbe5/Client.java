package ba.bitcamp.vjezbe5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

public class Client {

	private static int counter;
	static boolean isPrime = true;

	public static void main(String[] args) {

		try {
			Socket client = new Socket("10.0.82.98", 8000);
			counter = 0;
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					client.getOutputStream()));

			String line = reader.readLine();

			String[] list = line.split(" ");
			int start = Integer.parseInt(list[0]);
			int end = Integer.parseInt(list[1]);

			Thread t = new Thread(new MyThread(start, end));
			t.start();
			

			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(counter);
			writer.write(counter + "");
			writer.newLine();
			writer.flush();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static class MyThread implements Runnable {
		private int start;
		private int end;

		public MyThread(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public void run() {
		
			for (int i = start; i < end; i++) {
				if (isPrime(i))
					counter++;

			}

		}
	}
	
	public static boolean isPrime(int num) {
		if (num == 0 || num == 1) {
			return false;
		}
		
		if (num == 2) {
			return true;
		}
		
		if (num % 2 == 0) {
			return false;
		}
		
		for (int i = 3; i <= Math.sqrt(num); i += 2) {
			if (num % i == 0) {
				return false;
			}
		}
		
		return true;
	}

}
