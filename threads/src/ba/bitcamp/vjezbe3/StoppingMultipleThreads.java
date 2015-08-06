package ba.bitcamp.vjezbe3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class StoppingMultipleThreads extends JFrame {
	JButton button = new JButton("Add");
	JButton button2 = new JButton("Stop");
	ArrayList<Thread> list = new ArrayList<>();

	public StoppingMultipleThreads() {

		add(button);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Thread t = new Thread(new MyThread());

				t.start();
				
				list.add(t);
				

			}
		});
		add(button2);
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i = 0; i < list.size(); i++){
					list.get(i).interrupt();
					try {
						list.get(i).sleep(50);
					} catch (InterruptedException e1) {
						
						e1.printStackTrace();
					}
					System.out.println(list.get(i).isAlive());
				}
				

			}
		});
		
		
		setLayout(new GridLayout());
		setLocationRelativeTo(null);
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) {

		new StoppingMultipleThreads();

	}

	public static class MyThread implements Runnable {

		@Override
		public void run() {

			for (int i = 0; i <= 100; i++) {
				System.out.println(i);
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					break;
					
				}

			}
		}

	}

}
