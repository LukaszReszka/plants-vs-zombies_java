package core;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import game.Game;
import menu.Instruction;
import menu.Menu;


public class Core extends StateBasedGame {
	
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 429;
	public static final int FPS = 60;
	
	private static AppGameContainer game;
	
	
	public Core(String gameName) {
		super(gameName);
	}

	public static void main(String[] args) throws SlickException {
        game = new AppGameContainer(new Core("Plants vs Zombies"));
        game.setDisplayMode(WIDTH, HEIGHT, false);
        game.setTargetFrameRate(FPS);
        game.setShowFPS(false);
        game.setIcon("icon.png");
        game.start();
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.addState(new Menu());
		this.addState(new Game());
		this.addState(new Instruction());
		this.enterState(0);
	}

}