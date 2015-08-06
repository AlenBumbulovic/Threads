package ba.bitcamp.vjezbe2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClientGUI extends JFrame {
	private static final long serialVersionUID = -6112886804499965635L;

	JPanel panel = new JPanel();
	JLabel[][] label = new JLabel[20][20];

	private int x = 0;
	private int y = 0;

	public ClientGUI() {

		add(panel);
		panel.setLayout(new GridLayout(20, 20));

		for (int i = 0; i < label.length; i++) {
			for (int j = 0; j < label.length; j++) {
				label[i][j] = new JLabel();
				label[i][j].setHorizontalAlignment(JLabel.CENTER);
				label[i][j].setBorder(BorderFactory
						.createLineBorder(Color.BLACK));
				label[i][j].setOpaque(true);
				label[i][j].setBackground(Color.WHITE);
				panel.add(label[i][j]);

			}
		}

		label[x][y].setOpaque(true);
		label[x][y].setBackground(Color.BLACK);

		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					try {
						label[x][y].setBackground(Color.WHITE);
						x--;
						label[x][y].setOpaque(true);
						label[x][y].setBackground(Color.BLACK);
						Client.sendToServer("UP");
					} catch (IndexOutOfBoundsException ex) {
						x++;
						label[x][y].setBackground(Color.BLACK);

					}

				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					try {
						label[x][y].setBackground(Color.WHITE);
						x++;
						label[x][y].setOpaque(true);
						label[x][y].setBackground(Color.BLACK);
						Client.sendToServer("DOWN");
					} catch (IndexOutOfBoundsException ex) {
						x--;
						label[x][y].setBackground(Color.BLACK);
					}

				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

					try {
						label[x][y].setBackground(Color.WHITE);
						y--;
						label[x][y].setOpaque(true);
						label[x][y].setBackground(Color.BLACK);
						Client.sendToServer("LEFT");
					} catch (IndexOutOfBoundsException ex) {
						y++;
						label[x][y].setBackground(Color.BLACK);
					}
					
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					try {
						label[x][y].setBackground(Color.WHITE);
						y++;
						label[x][y].setOpaque(true);
						label[x][y].setBackground(Color.BLACK);
						Client.sendToServer("RIGHT");
					} catch (IndexOutOfBoundsException ex) {
						y--;
						label[x][y].setBackground(Color.BLACK);
					}

				}

			}
		});
		
		setTitle("Client");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setVisible(true);

	}

//	public static void main(String[] args) {
//
//		new ClientGUI();
//
//	}

}
