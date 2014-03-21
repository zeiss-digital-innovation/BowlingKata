package de.saxsys.dojo.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

	public class Frame {
		private Integer firstRoll;
		private Integer secondRoll;

	}

	private List<Integer> rolls = new ArrayList<>();
	private List<Frame> frames = new ArrayList<>();

	public int score() {
		int score = 0;
		for (int i = 0; i < rolls.size(); i++) {
			score += rolls.get(i);
			if (wasStrikeOneRollAgo(i)) {
				score += (rolls.get(i));
			}
			if (wasStrikeTwoRollsAgo(i)) {
				score += (rolls.get(i));
			}
		}
		return score;
	}

	public void roll(int pins) {
		rolls.add(pins);
		if (frames.isEmpty()) {
			frames.add(new Frame());
		}
		frames.get(frames.size() - 1).firstRoll = pins;
	}

	private boolean wasStrikeTwoRollsAgo(int i) {
		return i > 1 && rolls.get(i - 2) == 10;
	}

	private boolean wasStrikeOneRollAgo(int i) {
		return i > 0 && rolls.get(i - 1) == 10;
	}

}
