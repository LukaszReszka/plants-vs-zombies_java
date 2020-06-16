package game;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import menu.Button;

class BuyHeroButton {
	private static final int BUTTON_X_Y = 96;
	public static final char WALLNUT = 'W', SUNFLOWER = 'S', PEASHOOTER = 'P', BEETROOT = 'B';
			
	private Button active_button, inactive_button;
	private Image placing_pic;
	private char hero_type;
	private String basic_animation_path;
	private boolean canPayFor = true;
	private boolean isPlacingHero;
	private int hero_size_x, hero_size_y;
	private int price;
	
	
	public BuyHeroButton(int apos_x, int apos_y, char ahero_type, String active_path, String inactive_path, String placing_path, 
			String animation_path, int aprice) throws SlickException {
		active_button = new Button(apos_x, apos_y, BUTTON_X_Y, BUTTON_X_Y, active_path);
		inactive_button = new Button(apos_x, apos_y, BUTTON_X_Y, BUTTON_X_Y, inactive_path);
		hero_type = ahero_type;
		placing_pic = new Image(placing_path);
		isPlacingHero = false;
		basic_animation_path = animation_path;
		setHeroSizes();
		price = aprice;
	}
	
	public void update (int mouse_x, int mouse_y, boolean isLeftMouseButtonPressed, boolean isLeftMouseButtonDown,
						Lawn board, SunCounter sun_counter) throws SlickException {
		canPayFor = sun_counter.areEnoughSuns(price);
		if (canPayFor)
		{
			if (!isPlacingHero)
			{
				if (isLeftMouseButtonPressed && active_button.isButtonPressed(mouse_x, mouse_y))
					isPlacingHero = true;
			}
			else if (!isLeftMouseButtonDown)
			{
				isPlacingHero = false;
				board.putHeroOnBoard(hero_size_x, hero_size_y, basic_animation_path, sun_counter, price);
			}
		}
	}
	
	public void drawButton () {
		if(canPayFor)
			active_button.drawButton();
		else
			inactive_button.drawButton();
	}
	
	public void drawFollowingHero (int mouse_x, int mouse_y, Lawn board) {
		if(isPlacingHero)
		{
			board.markChosenPiece();
			placing_pic.draw(mouse_x, mouse_y);
		}
	}
	
	private void setHeroSizes () {
		switch(hero_type) {
		case WALLNUT:
		case SUNFLOWER:
			hero_size_x = 66;
		break;
		
		case PEASHOOTER:
			hero_size_x = 75;
		break;
		
		case BEETROOT:
			hero_size_x = 55;
		break;
		}
		hero_size_y = 75;
	}
}
