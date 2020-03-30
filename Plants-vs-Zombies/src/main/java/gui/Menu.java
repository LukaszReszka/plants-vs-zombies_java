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

public class Menu extends JPanel implements ActionListener{
	
	public static final int H_PRZYCISK = 300;
	public static final int W_PRZYCISK = 300;
	private JButton start;
	private JButton instrukcja;
	private JButton wyjscie;
	private BufferedImage menu;
	private JPanel okna;

	public Menu(JPanel panel) {
		super();	
		okna = panel;
		try {
				menu = ImageIO.read(new File(getClass().getResource("menu.jpg").toURI()));
		} catch (URISyntaxException er) {
			System.err.println("Nie znaleziono obrazka.");
			er.printStackTrace();
		} catch (IOException error) {
			System.err.println("Nie znaleziono obrazka.");
			error.printStackTrace();
		}
		
		Dimension menu_wymiary = new Dimension(menu.getWidth(), menu.getHeight());
		setPreferredSize(menu_wymiary);
		
		start = new JButton("Start");
		instrukcja = new JButton("Instrukcja");
		wyjscie = new JButton("Wyjście");

		start.addActionListener(this);
		instrukcja.addActionListener(this);
		wyjscie.addActionListener(this);

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
		CardLayout ukladOkien = (CardLayout) okna.getLayout();

		if(source == start)
            ukladOkien.next(okna);

		else if(source == instrukcja)
			ukladOkien.last(okna);

		else if(source == wyjscie)
			 System.exit(0);
	}
}
