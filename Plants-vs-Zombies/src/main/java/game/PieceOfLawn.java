package game;

class PieceOfLawn {
	private final int CHOSEN_PIECE_HALF_SIZE = 20;
	
	private int left_x, upper_y, right_x, down_y;
	private int hero_x, hero_y;
	private int choosing_x, choosing_y;
	
	public PieceOfLawn (int aleft_x, int aupper_y, int aright_x, int adown_y, int ahero_x, int ahero_y) {
		left_x = aleft_x;
		upper_y = aupper_y;
		right_x = aright_x;
		down_y = adown_y;
		hero_x = ahero_x;
		hero_y = ahero_y;
		choosing_x = ((left_x + right_x)/2)-CHOSEN_PIECE_HALF_SIZE;
		choosing_y = ((upper_y + down_y)/2)-CHOSEN_PIECE_HALF_SIZE;
	}
	
	public boolean isMouseOver (int mouse_x, int mouse_y)
	{
		if (mouse_x < left_x || mouse_y < upper_y || mouse_x > right_x || mouse_y > down_y)
			return false;
		return true;
	}
	
	public int getHeroX ()
	{
		return hero_x;
	}
	
	public int getHeroY ()
	{
		return hero_y;
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