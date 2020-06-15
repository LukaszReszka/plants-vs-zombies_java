package game;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import core.Core;

class Sun {
	public static final int SIZE_X = 50;
	public static final int SIZE_Y = 48;
	public static final int NUM_SUNS_ADDED = 25;
	public static final float FALLING_SPEED = 0.1f;
	
	private Animation sun_anim;
	private boolean isCollected, isFalling;
	private int sun_x, sun_y;
	
	Sun(int asun_x, int asun_y, boolean startFalling) throws SlickException {
		sun_anim = new Animation(new SpriteSheet("sun.png", SIZE_X, SIZE_Y), 250);
		isCollected = false;
		isFalling = false;
		sun_x = asun_x;
		sun_y = asun_y;
		isFalling = startFalling;
	}
	
	public void update(int delta, int mouse_x, int mouse_y, boolean isLeftButtonPressed, SunCounter sun_counter)
	{
		if (!isCollected) {
			sun_anim.update(delta);
			if (isLeftButtonPressed && (mouse_x >= sun_x) && (mouse_x <= (sun_x+SIZE_X)) 
				&& (mouse_y >= sun_y) && (mouse_y <= (sun_y+SIZE_Y))) {
				isCollected = true;
				sun_counter.addSuns(NUM_SUNS_ADDED);
			}
			else
			{
				if(isFalling)
				{
					if ((Core.HEIGHT-SIZE_Y) > sun_y)
						sun_y += (FALLING_SPEED * delta);
					else
						isFalling = false;
				}
			}
		}
	}
	
	public void draw() {
		if (!isCollected)
			sun_anim.draw(sun_x, sun_y);
	}
	
	public boolean getIsCollected() {
		return isCollected;
	}
}
