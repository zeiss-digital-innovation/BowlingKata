package de.saxsys.dojo.bowling;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {

	private BowlingGame game;

	@Before
	public void setUp() {
		game = new BowlingGame();
	}

	@Test
	public void noRollShouldGiveScoreZero() throws Exception {
		assertThat(game.score(), is(0));
	}

	@Test
	public void rollZeroShouldGiveScoreZero() throws Exception {
		game.roll(0);
		assertThat(game.score(), is(0));
	}

	@Test
	public void rollOneShouldGiveScoreOne() throws Exception {
		game.roll(1);
		assertThat(game.score(), is(1));
	}

	@Test
	public void rollTwoAndThreeShouldGiveFive() throws Exception {
		game.roll(2);
		game.roll(3);
		assertThat(game.score(), is(5));
	}

	@Test
	public void strikeShouldDoubleNextFrame() throws Exception {
		game.roll(10);
		game.roll(2);
		game.roll(5);
		assertThat(game.score(), is(24));
	}

	@Test
	public void threeStrikesShouldGive60() throws Exception {
		game.roll(10);
		game.roll(10);
		game.roll(10);
		assertThat(game.score(), is(60));
	}

	@Test
	public void fourRollsShouldGive75() throws Exception {
		game.roll(10);
		game.roll(10);
		game.roll(10);
		game.roll(5);
		assertThat(game.score(), is(75));
	}

	// @Test
	// public void oneSpareAndFiveShouldGive20() throws Exception {
	// game.roll(6);
	// game.roll(4);
	// game.roll(5);
	// assertThat(game.score(), is(20));
	// }

}
