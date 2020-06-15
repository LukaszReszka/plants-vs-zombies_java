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
import menu.Menu;

public class Game extends BasicGameState  {
	public static final int BACK_X= 795;
	public static final int BACK_Y = 375;
	
	private Image background;
	private Music music;
	private Button back;
	private Input mouse;
	private int mouse_x, mouse_y;
	private Lawn board;
	private BuyHeroButton sunflower_choice, wallnut_choice, peashooter_choice, beetroot_choice;
	private SunCounter sun_counter;
	private RandomSunsGenerator suns_generator;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		background = new Image("game.jpg");
		music = new Music("game_music.wav");
		mouse = container.getInput();
		back = new Button(BACK_X, BACK_Y,  Menu.BUTTON_WIDTH, Menu.BUTTON_HEIGHT, "button_return.png");
		board = new Lawn();
		wallnut_choice = new BuyHeroButton(0, 23, BuyHeroButton.WALLNUT, "active_wallnut.png", "inactive_wallnut.png",
											"placing_wallnut.png", "wallnut.png", 25);
		sunflower_choice = new BuyHeroButton(0, 119, BuyHeroButton.SUNFLOWER, "active_sunflower.png", 
											"inactive_sunflower.png", "placing_sunflower.png", "sunflower.png", 50);
		
		peashooter_choice = new BuyHeroButton(0, 215, BuyHeroButton.PEASHOOTER, "active_peashooter.png", 
											  "inactive_peashooter.png", "placing_peashooter.png", "peashooter.png", 100);
		
		beetroot_choice = new BuyHeroButton(0, 311, BuyHeroButton.BEETROOT, "active_beetroot.png", "inactive_beetroot.png",
											"placing_beetroot.png", "beetroot.png", 125);
		sun_counter = new SunCounter();
		suns_generator = new RandomSunsGenerator();
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		background.draw();
		board.drawPlacedHeroes();
		wallnut_choice.drawFollowingHero(mouse_x, mouse_y, board);
		sunflower_choice.drawFollowingHero(mouse_x, mouse_y, board);
		peashooter_choice.drawFollowingHero(mouse_x, mouse_y, board);
		beetroot_choice.drawFollowingHero(mouse_x, mouse_y, board);
		wallnut_choice.drawButton();
		sunflower_choice.drawButton();
		peashooter_choice.drawButton();
		beetroot_choice.drawButton();
		back.drawButton();
		suns_generator.drawGeneratedSuns();
		sun_counter.draw(g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		mouse_x = mouse.getMouseX();
		mouse_y = mouse.getMouseY();		
		
		boolean isLeftButtonPressed = mouse.isMousePressed(Input.MOUSE_LEFT_BUTTON);
		boolean isLeftButtonDown = mouse.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON);
		
		board.update(mouse_x, mouse_y, delta);
		
		if (isLeftButtonPressed && back.isButtonPressed(mouse_x, mouse_y))
			game.enterState(0);
		
		wallnut_choice.update(mouse_x, mouse_y, isLeftButtonPressed, isLeftButtonDown, board, sun_counter);
		sunflower_choice.update(mouse_x, mouse_y, isLeftButtonPressed, isLeftButtonDown, board, sun_counter);
		peashooter_choice.update(mouse_x, mouse_y, isLeftButtonPressed, isLeftButtonDown, board, sun_counter);
		beetroot_choice.update(mouse_x, mouse_y, isLeftButtonPressed, isLeftButtonDown, board, sun_counter);
		suns_generator.updateGeneratedSuns(delta, mouse_x, mouse_y, isLeftButtonPressed, sun_counter);
		sun_counter.update();
	}

	@Override
	public void enter(GameContainer gc , StateBasedGame sbg) {
			music.loop();
	}
	
	@Override
	public void leave (GameContainer container, StateBasedGame game) {
		board.cleanBoard();
		suns_generator.resetGenerator();
		sun_counter.reset();
	}

	@Override
	public int getID() {
		return 1;
	}

}