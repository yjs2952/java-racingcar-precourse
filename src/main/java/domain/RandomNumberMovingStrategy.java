package domain;

import java.util.Random;

public class RandomNumberMovingStrategy implements MovingStrategy {

    private static final Random RANDOM = new Random();
    public static final int BOUND = 10;
    public static final int MOVING_POSSIBLE_NUMBER = 4;

    @Override
    public boolean isMovable() {
        return RANDOM.nextInt(BOUND) >= MOVING_POSSIBLE_NUMBER;
    }
}
