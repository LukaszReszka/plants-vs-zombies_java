package game;

import java.awt.Font;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

class SunCounter {
	public static final int COUNTER_X= 800;
	public static final int COUNTER_Y = 0;
	public static final int NUMBER_Y = 0;
	public static final int NUM_SUNS_AT_BEGINNING = 200;
	
	private Image background;
	private int suns_number;
	private int number_x;
	private TrueTypeFont font;
	
	SunCounter () throws SlickException {
		background = new Image("sun_counter.png");
		suns_number = NUM_SUNS_AT_BEGINNING;
		Font awt_font = new Font("Arial", Font.BOLD, 40);
		font = new TrueTypeFont(awt_font, false);
	}
	
	public void draw(Graphics g) {
		background.draw(COUNTER_X, COUNTER_Y);
		g.setFont(font);
		g.drawString(Integer.toString(suns_number), number_x, NUMBER_Y);
	}
	
	public void update() {
		if (suns_number != 0)
			number_x = 950 - (25 * ((int) (Math.log10(suns_number) + 1)));
		else
			number_x = 925;
	}
	
	public void reset() {
		suns_number = NUM_SUNS_AT_BEGINNING;
	}
	
	public void addSuns(int numb) {
		suns_number += numb;
	}
	
	public void removeSuns(int numb) {
		suns_number -= numb;
	}
	
	public boolean areEnoughSuns(int price) {
		return suns_number >= price;
	}
}
