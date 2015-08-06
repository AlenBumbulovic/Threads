package ba.bitcamp.vjezbe3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Server1 {
	
	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(8000);
			while(true){
			MyThread t = new MyThread(server.accept());
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	private static class MyThread extends Thread{
		File file = new File("file.txt");
		private Socket client;
		
		public MyThread(Socket client){
			
			this.client = client;
			start();
		}
		
		@Override
		public void run() {
			
			
			BufferedReader reader;
			try {
				reader = new BufferedReader(new InputStreamReader(
						client.getInputStream()));
				
				BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
				
				
			String line = "";
			line = reader.readLine();
			
			String[] list = line.split(" ");
			
			HashMap<String, String> map = new HashMap<>();
			map.put(list[0], list[1]);
			
			switch(list[0]){
			case "1": 
				writer.write("Temperature: " + list[1] + " Kelvin");
				writer.newLine();
				writer.flush();
				break;
			
			case "2":
				writer.write("Pressure: " + list[1] + " hPa");
				writer.newLine();
				writer.flush();
				break;
				
			case "3":
				writer.write("Movement: " + list[1]);
				writer.newLine();
				writer.flush();
				break;
				
			case "4":
				writer.write("Error");
				writer.newLine();
				writer.flush();
				break;
				
			default:
				writer.write("The number is not recognized");
				writer.newLine();
				writer.flush();
				
			}
			
			reader.close();
			writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}

}
