package game;

import java.util.Random;
import java.util.Vector;

import org.newdawn.slick.SlickException;

class RandomSunsGenerator {
	public static final int MAX_GEN_SUNS_NUMB = 5;
	public static final int MIN_TIME_TO_GENERATE = 5000;
	public static final int RAND_ADD_TO_MIN_TIME = 5000;
	public static final int MIN_SUNS_X = 200;
	public static final int MRAND_ADD_TO_SUNS_X = 450;
	
	private Vector<Sun> generated_suns;
	int timer, time_before_generating;
	Random rand_generator;
	
	RandomSunsGenerator() {
		timer = 0;
		rand_generator = new Random();
		time_before_generating = MIN_TIME_TO_GENERATE + rand_generator.nextInt(RAND_ADD_TO_MIN_TIME);
		generated_suns = new Vector<Sun>(MAX_GEN_SUNS_NUMB);
	}
	
	void updateGeneratedSuns(int delta, int mouse_x, int mouse_y, boolean isLeftButtonPressed, SunCounter sun_counter) 
							 throws SlickException {
		int suns_numb = generated_suns.size();
		int collected_suns = 0;
		
		if (suns_numb < MAX_GEN_SUNS_NUMB) {
			if(timer >= time_before_generating) {
				timer = 0;
				time_before_generating = MIN_TIME_TO_GENERATE + rand_generator.nextInt(RAND_ADD_TO_MIN_TIME);
				generated_suns.addElement(new Sun(MIN_SUNS_X + rand_generator.nextInt(MRAND_ADD_TO_SUNS_X), 0, true));
			} 
			else 
				timer += delta;
		}
		
		for (int i = 0; i < suns_numb-collected_suns; ++i)
			if((generated_suns.get(i)).getIsCollected()) {
				generated_suns.remove(i);
				++collected_suns;
				--i;
			}
		
		generated_suns.forEach(s -> s.update(delta, mouse_x, mouse_y, isLeftButtonPressed, sun_counter));
	}
	
	public void drawGeneratedSuns() {
		generated_suns.forEach(s -> s.draw());
	}
	
	public void resetGenerator() {
		generated_suns.removeAllElements();
		timer = 0;
		time_before_generating = MIN_TIME_TO_GENERATE + rand_generator.nextInt(RAND_ADD_TO_MIN_TIME);
	}
}
