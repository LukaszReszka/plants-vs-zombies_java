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

public class Instrukcja extends JPanel implements ActionListener{
	public static final int H_PRZYCISK = 300;
	public static final int W_PRZYCISK = 300;
	private JButton powrot;
	private BufferedImage instrukcja;
	private JPanel okna;
	
	public Instrukcja(JPanel panel) {
		super();
		okna = panel;
		try {
				instrukcja = ImageIO.read(new File(getClass().getResource("instrukcja.png").toURI()));
		} catch (URISyntaxException er) {
			System.err.println("Nie znaleziono obrazka.");
			er.printStackTrace();
		} catch (IOException error) {
			System.err.println("Nie znaleziono obrazka.");
			error.printStackTrace();
		}
		
		Dimension instrukcja_wymiary = new Dimension(instrukcja.getWidth(), instrukcja.getHeight());
		setPreferredSize(instrukcja_wymiary);
		
		powrot = new JButton("Powrót");

		powrot.addActionListener(this);

		setLayout(new FlowLayout(FlowLayout.RIGHT, 50 ,375));
		add(powrot);
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(instrukcja, 0, 0, this);
	}
	
	public void actionPerformed(ActionEvent ev) {
		Object source = ev.getSource();

		if(source == powrot)
		{
            CardLayout cardLayout = (CardLayout) okna.getLayout();
            cardLayout.first(okna);
        }
	}

}

