package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import menu.Button;

public class Game extends BasicGameState  {
	public static final int BACK_X= 795;
	public static final int BACK_Y = 375;
	
	private Image background;
	private Music music;
	private Button back;
	private Input mouse;
	private int mouse_x, mouse_y;
	private Lawn board;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		background = new Image("game.jpg");
		music = new Music("game_music.wav");
		mouse = container.getInput();
		back = new Button(BACK_X, BACK_Y,"button_return.png");
		board = new Lawn();
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		background.draw();
		board.markChosenPiece();
		back.drawButton();
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		mouse_x = mouse.getMouseX();
		mouse_y = mouse.getMouseY();		
		
		board.findChosenPiece(mouse_x, mouse_y);
		
		if (mouse.isMousePressed(Input.MOUSE_LEFT_BUTTON) && back.isButtonPressed(mouse_x, mouse_y))
			game.enterState(0);
	}

	@Override
	public void enter(GameContainer gc , StateBasedGame sbg) {
			music.loop();
	}

	@Override
	public int getID() {
		return 1;
	}

}