package gui;

import java.awt.*;
import javax.swing.*;

public class Gui {

    private Menu menu;
    private Plansza plansza;
    private Instrukcja instrukcja;
    
    private void uruchomGUI()
    {
        JFrame okienko = new JFrame("Plants vs Zombies - prototyp");
        JPanel okna = new JPanel();
        okna.setBorder(
            BorderFactory.createEmptyBorder(5, 5, 5, 5));
        okna.setLayout(new CardLayout());
        menu = new Menu(okna);
        plansza = new Plansza(okna);
        instrukcja = new Instrukcja(okna);
        okna.add(menu, "Plants vs Zombies - prototyp"); 
        okna.add(plansza, "Plants vs Zombies - prototyp");
        okna.add(instrukcja, "Plants vs Zombies - prototyp");
        okienko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okienko.setContentPane(okna);
        okienko.setResizable(false);
        okienko.pack();
        okienko.setLocationRelativeTo(null);
        okienko.setLocationByPlatform(true);
        okienko.setVisible(true);
    }
    
    public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new Gui().uruchomGUI();
            }
        });

	}

}
