package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Okno extends JFrame {
	
	public Okno() {
		super("Plants vs Zobies - prototyp");

		JPanel obraz = new Obraz();
		add(obraz);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}
