package game;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

class Hero {
	private int size_x, size_y;
	private Animation basic_behavior;
	
	public Hero (int x, int y, String basic_beh_path) throws SlickException {
		size_x = x;
		size_y = y;
		basic_behavior = new Animation(new SpriteSheet(basic_beh_path, size_x, size_y), 1000);
	}
	
	public void updateAnimation (int delta)
	{
		basic_behavior.update(delta);
	}
	
	public void drawHero (int pos_x, int pos_y) {
		basic_behavior.draw(pos_x, pos_y);
	}
}
