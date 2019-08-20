package JavaOOP.Inheritance.RandomArraysList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {
    private static final Random RANDOM_INDEX;

    static {
        RANDOM_INDEX = new Random();
    }

    public Object getRandomElement() {
        Object ob = super.get(RANDOM_INDEX.nextInt(super.size()));
        super.remove(ob);

        return ob;
    }
}
