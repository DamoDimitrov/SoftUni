package healthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private String name;
    private List<Vegetable> products;

    public Salad(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getTotalCalories() {
        int sum = 0;
        for (Vegetable product : products) {
            sum += product.getCalories();
        }
        return sum;
    }

    public int getProductCount() {
        return products.size();
    }

    public void add(Vegetable product) {
        this.products.add(product);
    }
}

//    @Override
//    public String toString() {
//
//        return String.format("* Salad %s is %d " +
//                "calories and have %d products: " +
//                "%s", getName(), getTotalCalories(), getProductCount(), String.join("%n", products));
//        }
//    }
