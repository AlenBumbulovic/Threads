package ba.bitcamp.vjezbe3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {

	public static void main(String[] args) {
		Socket client = new Socket();

		try {
			client.connect(new InetSocketAddress(8000));
			System.out.println("Input a number from 1 to 4");
			Scanner in = new Scanner(System.in);
			Scanner in2 = new Scanner(System.in);
			String str = in.nextLine();
			String str1 = in2.nextLine();
			switch(){
			
			case "1":
				System.out.println("Input the value in kelvins");
				
				break;
			case "2":
				System.out.println("Input the value for pressure");
				in2.nextLine();
				break;
				
			case "3":
				System.out.println("Input true if there is movement or false if there is not movement");
				in.nextLine();
				break;
				
				default: 
					System.out.println("Not reckonized");
			}
			
			
			
			String line = str + " " + str1;

			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					client.getOutputStream()));

			writer.write(line);
			writer.newLine();
			writer.flush();
			writer.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	

}
