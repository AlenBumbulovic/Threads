package ba.bitcamp.predavanja;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {

	public static void main(String[] args) {
		
		
		File file = new File("file.txt");
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String search = "volatile";
			int counter = 0;
			String line;

			while((line = reader.readLine()) != null){
				counter++;
				int indexFound = line.indexOf(search);
				if(indexFound > -1){
					System.out.println("Word: " + search + " is at position: " + indexFound + " , on line: " + counter);
				}
				
		
				
					
				
				
			}
			
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
