package domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final Random RANDOM = new Random();

    @Override
    public int generate() {
        return RANDOM.nextInt(9);
    }
}
