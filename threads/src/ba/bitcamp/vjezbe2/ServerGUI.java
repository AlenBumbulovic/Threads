package ba.bitcamp.vjezbe2;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ServerGUI extends JFrame {
	private static final long serialVersionUID = 1332890022791286500L;
	
	JPanel panel = new JPanel();
	static JLabel[][] label = new JLabel[20][20];

	private static int x = 0;
	private static int y = 0;
	
	public ServerGUI(){
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
		
		setTitle("Server");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setVisible(true);
	}
	
	public static void moveRect(String s){
		if(s.equals("UP")){
			try {
				label[x][y].setBackground(Color.WHITE);
				x--;
				label[x][y].setOpaque(true);
				label[x][y].setBackground(Color.BLACK);
				
			} catch (IndexOutOfBoundsException ex) {
				x++;
				label[x][y].setBackground(Color.BLACK);

			}
		}else if(s.equals("DOWN")){
			try {
				label[x][y].setBackground(Color.WHITE);
				x++;
				label[x][y].setOpaque(true);
				label[x][y].setBackground(Color.BLACK);
				
			} catch (IndexOutOfBoundsException ex) {
				x--;
				label[x][y].setBackground(Color.BLACK);
			}
		}else if(s.equals("LEFT")){
			try {
				label[x][y].setBackground(Color.WHITE);
				y--;
				label[x][y].setOpaque(true);
				label[x][y].setBackground(Color.BLACK);
			} catch (IndexOutOfBoundsException ex) {
				y++;
				label[x][y].setBackground(Color.BLACK);
			}
		}else if(s.equals("RIGHT")){
			try {
				label[x][y].setBackground(Color.WHITE);
				y++;
				label[x][y].setOpaque(true);
				label[x][y].setBackground(Color.BLACK);
			} catch (IndexOutOfBoundsException ex) {
				y--;
				label[x][y].setBackground(Color.BLACK);
			}
		}
	}

//	public static void main(String[] args) {
//		new ServerGUI();
//
//	}

}
