package ba.bitcamp.vjezbe2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

	static BufferedWriter writer;
	
	public static void main(String[] args) {
		
		
		Socket client = new Socket();
		
		try {
			client.connect(new InetSocketAddress("10.0.82.31", 8000));
			
			new ClientGUI();
			
			writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	
	public static void sendToServer(String msg) {
		try {
			writer.write(msg);
			writer.newLine();
			writer.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
