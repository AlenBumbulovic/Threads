package ba.bitcamp.vjezbe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientThread {

	public static void main(String[] args) {

		Socket socket = new Socket();
		try {
			socket.connect(new InetSocketAddress("10.0.82.98", 8000));

			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream()));
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			Scanner in = new Scanner(System.in);
			String line = in.nextLine();

			writer.write("Alen");
			writer.newLine();
			writer.flush();
			writer.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
