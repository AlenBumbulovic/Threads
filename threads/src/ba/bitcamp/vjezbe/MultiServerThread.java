package ba.bitcamp.vjezbe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServerThread {

	public static void main(String[] args) {

		try {
			ServerSocket server = new ServerSocket(1921);

			while (true) {
				Socket client = server.accept();

				Thread t = new Thread(new ClientThread(client));
				t.start();
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static class ClientThread implements Runnable {

		private Socket client;

		public ClientThread(Socket client) {
			this.client = client;
		}

		@Override
		public void run() {

			try {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(client.getInputStream()));

				System.out.println(reader.readLine());

			} catch (IOException e) {

				e.printStackTrace();
			}

		}

	}

}
