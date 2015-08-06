package ba.bitcamp.predavanja;

public class NamedThread extends Thread {
	
	private String name;
	
	public NamedThread(String name){
		this.name = name;
	}
	
	@Override
	public void run(){
		for(int i = 0; i < 20; i++){
			System.out.println(name + " counted to: " + i);	
		}
	}
}
