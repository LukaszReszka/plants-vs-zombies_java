package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JPanel;

import javax.imageio.ImageIO;


public class Obraz extends JPanel implements ActionListener {
	
	public static final int H_PRZYCISK = 300;
	public static final int W_PRZYCISK = 300;
	private JButton start;
	private JButton instrukcja;
	private JButton wyjscie;
	private JButton powrot;
	private BufferedImage menu;
	private BufferedImage plansza;

	public Obraz() {
		super();	
		try {
				menu = ImageIO.read(new File(getClass().getResource("menu.jpg").toURI()));
				plansza = ImageIO.read(new File(getClass().getResource("plansza.jpg").toURI()));
		} catch (URISyntaxException er) {
			System.err.println("Nie znaleziono obrazka.");
			er.printStackTrace();
		} catch (IOException error) {
			System.err.println("Nie znaleziono obrazka.");
			error.printStackTrace();
		}
		
		Dimension menu_wymiary = new Dimension(menu.getWidth(), menu.getHeight());
		Dimension plansza_wymiary = new Dimension(plansza.getWidth(), plansza.getHeight());
		setPreferredSize(menu_wymiary);
		
		start = new JButton("Start");
		instrukcja = new JButton("Instrukcja");
		wyjscie = new JButton("Wyjście");
		powrot = new JButton ("Powrót");

		start.addActionListener(this);
		instrukcja.addActionListener(this);
		wyjscie.addActionListener(this);
		powrot.addActionListener(this);

		setLayout(new FlowLayout(FlowLayout.CENTER, 100 , 350));
		add(start);
		add(instrukcja);
		add(wyjscie);
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(menu, 0, 0, this);
	}
	
	public void actionPerformed(ActionEvent ev) {
		Object source = ev.getSource();

		if(source == start)
			start.setBackground(new Color(160,160,160));

		else if(source == instrukcja)
			instrukcja.setBackground(new Color(160,160,160));

		else if(source == wyjscie)
			 System.exit(0);
	}
}
