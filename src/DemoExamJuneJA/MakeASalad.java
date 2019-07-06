package DemoExamJuneJA;

import java.util.*;
import java.util.stream.Collectors;

public class MakeASalad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> products = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));
        Deque<Integer> salads = new ArrayDeque<>();
        List<String> madeSalads = new ArrayList<>();

        int[] inputSld = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < inputSld.length; i++) {
            salads.push(inputSld[i]);
        }
        while (!products.isEmpty() && !salads.isEmpty()) {
            int salad = salads.pop();
            int saladInMaking = salad;

            while (saladInMaking > 0 && !products.isEmpty()) {
                String product = products.poll();

                int productCalories = 0;

                switch (product) {
                    case "tomato":
                        productCalories = 80;
                        break;
                    case "potato":
                        productCalories = 215;
                        break;
                    case "carrot":
                        productCalories = 136;
                        break;
                    case "lettuce":
                        productCalories = 109;
                        break;
                    default:
                        break;
                }
                if (productCalories > saladInMaking) {
                    madeSalads.add(String.valueOf(salad));
                    saladInMaking = 0;
                } else {
                    saladInMaking -= productCalories;
                }
                if (products.isEmpty() && saladInMaking > 0) {
                    madeSalads.add(String.valueOf(salad));
                }
            }
        }
        System.out.println(String.join(" ", madeSalads));
        if (!products.isEmpty() && salads.isEmpty()) {
            System.out.println(String.join(" ", products));
        } else if (!salads.isEmpty() && products.isEmpty()) {
            int saladsSize = salads.size();
            for (int i = 0; i < saladsSize; i++) {
                System.out.print(salads.pop() + " ");
            }
        }
    }
}
