package ba.bitcamp.vjezbe2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private static Socket client;
	private static ServerGUI window;
	
	public static void main(String[] args) {
		
		
		try {
			ServerSocket server = new ServerSocket(8000);
				Socket client = server.accept();
				Thread t = new Thread(new ClientThread(client));
				t.start();
				
				window = new ServerGUI();
				

			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	
	static class ClientThread implements Runnable {
		
		private Socket client;
		
		public ClientThread(Socket client){
			this.client = client;
		}
		
		
		@Override
		public void run() {
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
				
				
				
				while(true){
					String s = reader.readLine();
					window.moveRect(s);
					
					
				}
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
		}
		
	}

}
