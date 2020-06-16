package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.newdawn.slick.SlickException;

class SunCounterTest {

	SunCounter sc;
	
	@BeforeEach
	void init () throws SlickException {
		sc = new SunCounter();
	}
	
	@Test
	void testAddSuns() {
		assertTrue(sc.areEnoughSuns(SunCounter.NUM_SUNS_AT_BEGINNING),"Incorrect number of suns at the beginning");
		sc.addSuns(50);
		assertTrue(sc.areEnoughSuns(SunCounter.NUM_SUNS_AT_BEGINNING+50),"Method addSuns does not work");
	}
	
	@Test
	void testRemoveSuns() {
		assertTrue(sc.areEnoughSuns(SunCounter.NUM_SUNS_AT_BEGINNING),"Incorrect number of suns at the beginning");
		sc.removeSuns(50);
		assertTrue(sc.areEnoughSuns(SunCounter.NUM_SUNS_AT_BEGINNING-50),"Method removeSuns does not work");
	}
	
	@Test
	void testReset() {
		assertTrue(sc.areEnoughSuns(SunCounter.NUM_SUNS_AT_BEGINNING),"Incorrect number of suns at the beginning");
		sc.addSuns(50);
		sc.reset();
		assertTrue(sc.areEnoughSuns(SunCounter.NUM_SUNS_AT_BEGINNING),"Method reset does not work");
	}

}
