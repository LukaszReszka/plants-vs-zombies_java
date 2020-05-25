package menu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Instruction extends BasicGameState {
	
	public static final int BACK_X= 770;
	public static final int BACK_Y = 370;
	
	private Image background;
	private Button back;
	private Input mouse;
	private int mouse_x, mouse_y;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		background = new Image("instruction.png");
		mouse = container.getInput();
		back = new Button(BACK_X, BACK_Y, Menu.BUTTON_WIDTH, Menu.BUTTON_HEIGHT,"button_return.png");
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		background.draw();
		back.drawButton();
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		if (mouse.isMousePressed(Input.MOUSE_LEFT_BUTTON))
		{
			mouse_x = mouse.getMouseX();
			mouse_y = mouse.getMouseY();	
			
			if (back.isButtonPressed(mouse_x, mouse_y))
				game.enterState(0);
		}
	}

	@Override
	public int getID() {
		return 2;
	}

}
