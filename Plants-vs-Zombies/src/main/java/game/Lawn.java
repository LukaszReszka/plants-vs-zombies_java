package game;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

class Lawn {
	public static final int LAWN_ROWS = 5;
	public static final int LAWN_COLUMNS = 9;
	private static final int HERO_ID = 0;
	private static final int UPPER_OR_LEFT_ID = 1;
	private static final int DOWN_OR_RIGHT_ID = 2;
	
	private PieceOfLawn[][] pieces_tab;
	private Image choosing_pic;
	private PieceOfLawn chosen_piece;
	private boolean isChosenSelected;
	
	public Lawn () throws SlickException {
		pieces_tab = new PieceOfLawn[LAWN_ROWS][LAWN_COLUMNS];
		setPiecesProperties();
		choosing_pic = new Image("chosen_piece.png");
		isChosenSelected = false;
	}
	
	public void update(int mouse_x, int mouse_y, int delta) {
		findChosenPiece(mouse_x, mouse_y);
		if (chosen_piece == null || chosen_piece.getIsOccupied())
			isChosenSelected = false;
		else
			isChosenSelected = true;
		
		for (PieceOfLawn[] row: pieces_tab)
			for (PieceOfLawn piece: row)
				piece.update(delta);
	}
	
	public void drawPlacedHeroes () {
		for (PieceOfLawn[] row: pieces_tab)
			for (PieceOfLawn piece: row)
				piece.draw();
	}
	
	public void cleanBoard () {
		for (PieceOfLawn[] row: pieces_tab)
			for (PieceOfLawn piece: row)
				piece.removeHero();
	}
	
	public void putHeroOnBoard (int size_x, int size_y, String path, SunCounter sun_counter, int price) throws SlickException {
		if(isChosenSelected)
			chosen_piece.placeHero(size_x, size_y, path, sun_counter, price);
	}
	
	private void findChosenPiece (int mouse_x, int mouse_y)
	{
		chosen_piece = null;
		if ((mouse_x < 180 || mouse_y < 60 || mouse_x > 700 || mouse_y > 405))
			return;
		for (PieceOfLawn[] row: pieces_tab)
			for (PieceOfLawn piece: row) {
				if(piece.isMouseOver(mouse_x, mouse_y))
					chosen_piece = piece;
			}
	}
	
	public void markChosenPiece () {
		if(isChosenSelected)
			choosing_pic.draw(chosen_piece.getChoosingX(), chosen_piece.getChoosingY());
	}
	
	private void setPiecesProperties () {
		int[] coordinateX;
		int[] coordinateY;
		for (int r = 0; r < LAWN_ROWS; ++r)
		{
			coordinateY = setPieceY(r);
			for (int c = 0; c < LAWN_COLUMNS; ++c) {
				coordinateX = setPieceX(c);
				pieces_tab[r][c] = new PieceOfLawn(coordinateX[UPPER_OR_LEFT_ID], coordinateY[UPPER_OR_LEFT_ID],
				coordinateX[DOWN_OR_RIGHT_ID], coordinateY[DOWN_OR_RIGHT_ID], coordinateX[HERO_ID], 
				coordinateY[HERO_ID]);
			}
		}
	}
	
	private int[] setPieceY (int row) {
		int[] result = new int[3];
		if (row == 0)
		{
			result[HERO_ID] = 50;
			result[UPPER_OR_LEFT_ID]= 60;
			result[DOWN_OR_RIGHT_ID] = 125;
		}
		else if (row == 1)
		{
			result[HERO_ID] = 120;
			result[UPPER_OR_LEFT_ID] = 125;
			result[DOWN_OR_RIGHT_ID] = 195;	
		}
		else if (row == 2)
		{
			result[HERO_ID] = 195;
			result[UPPER_OR_LEFT_ID] = 195;
			result[DOWN_OR_RIGHT_ID] = 270;	
		}
		else if (row == 3)
		{
			result[HERO_ID] = 260;
			result[UPPER_OR_LEFT_ID] = 270;
			result[DOWN_OR_RIGHT_ID] = 335;	
		}
		else
		{
			result[HERO_ID] = 330;
			result[UPPER_OR_LEFT_ID] = 335;
			result[DOWN_OR_RIGHT_ID] = 405;	
		}
		return result;
	}
	
	private int[] setPieceX (int column) {
		int[] result = new int[3];
		if (column == 0)
		{
			result[HERO_ID] = 180;
			result[UPPER_OR_LEFT_ID]= 180;
			result[DOWN_OR_RIGHT_ID] = 240;
		}
		else if (column == 1)
		{
			result[HERO_ID] = 240;
			result[UPPER_OR_LEFT_ID] = 240;
			result[DOWN_OR_RIGHT_ID] = 290;	
		}
		else if (column == 2)
		{
			result[HERO_ID] = 295;
			result[UPPER_OR_LEFT_ID] = 290;
			result[DOWN_OR_RIGHT_ID] = 355;	
		}
		else if (column == 3)
		{
			result[HERO_ID] = 355;
			result[UPPER_OR_LEFT_ID] = 355;
			result[DOWN_OR_RIGHT_ID] = 410;	
		}
		else if (column == 4)
		{
			result[HERO_ID] = 410;
			result[UPPER_OR_LEFT_ID] = 410;
			result[DOWN_OR_RIGHT_ID] = 470;	
		}
		else if (column == 5)
		{
			result[HERO_ID] = 470;
			result[UPPER_OR_LEFT_ID] = 470;
			result[DOWN_OR_RIGHT_ID] = 530;	
		}
		else if (column == 6)
		{
			result[HERO_ID] = 525;
			result[UPPER_OR_LEFT_ID] = 530;
			result[DOWN_OR_RIGHT_ID] = 580;	
		}
		else if (column == 7)
		{
			result[HERO_ID] = 580;
			result[UPPER_OR_LEFT_ID] = 580;
			result[DOWN_OR_RIGHT_ID] = 640;	
		}
		else
		{
			result[HERO_ID] = 640;
			result[UPPER_OR_LEFT_ID] = 640;
			result[DOWN_OR_RIGHT_ID] = 700;	
		}		
		return result;
	}
}