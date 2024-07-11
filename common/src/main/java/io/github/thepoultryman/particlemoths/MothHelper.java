package io.github.thepoultryman.particlemoths;

import java.util.Random;

public class MothHelper {
    private static final Random random = new Random();

    public static float floatRange(float min, float max) {
        return random.nextFloat(min, max);
    }
}