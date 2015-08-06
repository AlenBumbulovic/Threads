package ba.bitcamp.vjezbe3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Task3 extends JFrame {
	private static JLabel label = new JLabel();
	JButton button = new JButton("Start");
	static int counter = 0;

	public Task3() {

		add(label);

		add(button);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				startThread();
				
			}
		});

		setLayout(new GridLayout(2, 1));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 400);
		setVisible(true);

	}

	public static void main(String[] args) {

		new Task3();

	}

	public static class MyThread implements Runnable {

		@Override
		public void run() {
			for (int i = 10; i < 1000000; i++) {

				boolean isPrime = true;

				for (int j = 2; j < i; j++) {

					if (i % j == 0) {
						isPrime = false;
						break;
					}
				}

				if (isPrime)
					counter++;
					

				

			}
			
			label.setText(counter + "");
		}
	}
	
	public static void startThread() {
		Thread t = new Thread(new MyThread());
		t.start();
		
	}

}
