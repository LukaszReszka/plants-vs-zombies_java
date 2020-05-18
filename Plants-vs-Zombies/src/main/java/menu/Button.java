package menu;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Button {

	public static final int BUTTON_HEIGHT = 50;
	public static final int BUTTON_WIDTH = 200;
	
	private int button_x;
	private int button_y;
	private Image button;
	
	public Button (int pos_x, int pos_y, String path) throws SlickException {
		button_x = pos_x;
		button_y = pos_y;
		button = new Image(path);
	}
	
	public boolean isButtonPressed(int mouse_x, int mouse_y) {
		if (mouse_x < button_x || mouse_y < button_y || mouse_x > (button_x + BUTTON_WIDTH)
				|| mouse_y > (button_y + BUTTON_HEIGHT))
			return false;
		return true;
	}
	
	public void drawButton() {
		button.draw(button_x, button_y);
	}
}
