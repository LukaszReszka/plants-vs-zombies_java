package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

public class Plansza extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	public static final int H_PRZYCISK = 300;
	public static final int W_PRZYCISK = 300;
	private JButton powrot;
	private BufferedImage plansza;
	private JPanel okna;
	
	public Plansza(JPanel panel) {
		super();
		okna = panel;
		try {
			plansza = ImageIO.read(getClass().getResourceAsStream("plansza.jpg"));
		} catch (IOException error) {
			System.err.println("Nie znaleziono obrazka.");
			error.printStackTrace();
		}
		
		Dimension plansza_wymiary = new Dimension(plansza.getWidth(), plansza.getHeight());
		setPreferredSize(plansza_wymiary);
		
		powrot = new JButton("Powrót");

		powrot.addActionListener(this);

		setLayout(new FlowLayout(FlowLayout.RIGHT, 50 ,375));
		add(powrot);
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(plansza, 0, 0, this);
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
