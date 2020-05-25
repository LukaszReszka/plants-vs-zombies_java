package menu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState {

	public static final int BUTTONS_Y = 350;
	public static final int START_X = 100;
	public static final int INSTRUCTION_X = 400;
	public static final int QUIT_X = 700;
	public static final int BUTTON_HEIGHT = 50;
	public static final int BUTTON_WIDTH = 200;

	private Image background;
	private Music music;
	private Button start;
	private Button instruction;
	private Button quit;
	private Input mouse;
	private int mouse_x, mouse_y;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		container.setMouseCursor("cursor.png", 24, 24);
		mouse = container.getInput();
		background = new Image("menu.jpg");
		start = new Button(START_X, BUTTONS_Y, BUTTON_WIDTH, BUTTON_HEIGHT,"button_start.png");
		instruction = new Button(INSTRUCTION_X, BUTTONS_Y, BUTTON_WIDTH, BUTTON_HEIGHT, "button_instruction.png");
		quit = new Button(QUIT_X, BUTTONS_Y, BUTTON_WIDTH, BUTTON_HEIGHT,"button_quit.png");
		music = new Music("menu.wav");
		music.loop();
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		background.draw();
		start.drawButton();
		instruction.drawButton();
		quit.drawButton();
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		if (mouse.isMousePressed(Input.MOUSE_LEFT_BUTTON))
		{
			mouse_x = mouse.getMouseX();
			mouse_y = mouse.getMouseY();	
			
			if (start.isButtonPressed(mouse_x, mouse_y))
				game.enterState(1);
			else if (instruction.isButtonPressed(mouse_x, mouse_y))
				game.enterState(2);
			else if (quit.isButtonPressed(mouse_x, mouse_y))
				container.exit();
		}
	}
	
	@Override
	public void enter(GameContainer gc , StateBasedGame sbg) {
		if (!music.playing())
			music.loop();
	}

	@Override
	public int getID() {
		return 0;
	}

}
