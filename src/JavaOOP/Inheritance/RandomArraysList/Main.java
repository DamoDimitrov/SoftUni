package JavaOOP.Inheritance.RandomArraysList;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList rl = new RandomArrayList();

        rl.add(125);
        rl.add("Pesho");
        rl.add(new ArrayList<String>());

        System.out.println(rl.getRandomElement());
        System.out.println(rl.getRandomElement());
        System.out.println(rl.getRandomElement());
    }
}
