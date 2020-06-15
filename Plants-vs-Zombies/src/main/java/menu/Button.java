package menu;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Button {
	
	protected int button_x;
	protected int button_y;
	private int size_x;
	private int size_y;
	private Image button;
	
	public Button (int pos_x, int pos_y, int asize_x, int asize_y, String path) throws SlickException {
		button_x = pos_x;
		button_y = pos_y;
		size_x = asize_x;
		size_y = asize_y;
		button = new Image(path);
	}
	
	public boolean isButtonPressed(int mouse_x, int mouse_y) {
		if (mouse_x < button_x || mouse_y < button_y || mouse_x > (button_x + size_x)
				|| mouse_y > (button_y + size_y))
			return false;
		return true;
	}
	
	public void drawButton() {
		button.draw(button_x, button_y);
	}
}
