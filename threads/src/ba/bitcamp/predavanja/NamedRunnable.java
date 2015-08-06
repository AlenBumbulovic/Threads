package ba.bitcamp.predavanja;

public class NamedRunnable implements Runnable {

	private String name;
	
	public NamedRunnable(String name){
		this.name = name;
	}
	
	
	
	
	
	@Override
	public void run() {
		
		for(int i = 0; i < 10; i++){
			System.out.println(name + " counted to: " + i);
		}
		
	}

}
