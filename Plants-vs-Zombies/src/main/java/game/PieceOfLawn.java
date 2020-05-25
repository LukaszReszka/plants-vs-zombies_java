package game;

import org.newdawn.slick.SlickException;

class PieceOfLawn {
	private final int CHOSEN_PIECE_HALF_SIZE = 20;
	
	private int left_x, upper_y, right_x, down_y;
	private int hero_x, hero_y;
	private int choosing_x, choosing_y;
	private Hero hero;
	private boolean isOccupied;
	
	public PieceOfLawn (int aleft_x, int aupper_y, int aright_x, int adown_y, int ahero_x, int ahero_y) {
		left_x = aleft_x;
		upper_y = aupper_y;
		right_x = aright_x;
		down_y = adown_y;
		hero_x = ahero_x;
		hero_y = ahero_y;
		choosing_x = ((left_x + right_x)/2)-CHOSEN_PIECE_HALF_SIZE;
		choosing_y = ((upper_y + down_y)/2)-CHOSEN_PIECE_HALF_SIZE;
		hero = null;
		isOccupied = false;
	}
	
	public void update (int delta) {
		if (isOccupied)
			hero.updateAnimation(delta);
	}
	
	public void draw()	{
	if (isOccupied)
		hero.drawHero(hero_x, hero_y);
	}
	
	public void placeHero(int size_x, int size_y, String path) throws SlickException {
		if (!isOccupied)
		{
			hero = new Hero(size_x, size_y, path);
			isOccupied = true;
		}
	}
	
	public void removeHero() {
		hero = null;
		isOccupied = false;
	}
	
	public boolean isMouseOver (int mouse_x, int mouse_y)
	{
		if (mouse_x < left_x || mouse_y < upper_y || mouse_x > right_x || mouse_y > down_y)
			return false;
		return true;
	}
	
	public boolean getIsOccupied() {
		return isOccupied;
	}
	
	public int getChoosingX ()
	{
		return choosing_x;
	}
	
	public int getChoosingY ()
	{
		return choosing_y;
	}
}