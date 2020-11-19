package JavaAdvanced.DefiningClasses.Ex.CompanyRooster;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        HashMap<Employee, Department> departments = new HashMap<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String department = tokens[3];

            Employee emp = new Employee(
                    tokens[0],
                    Double.parseDouble(tokens[1]),
                    tokens[2]
            );
            if (tokens.length == 5) {
                if (Character.isDigit(tokens[4].charAt(0))) {
                    emp.setAge(Integer.parseInt(tokens[4]));
                } else {
                    emp.setEmail(tokens[4]);
                }
            } else if (tokens.length == 6) {
                emp.setEmail(tokens[4]);
                emp.setAge(Integer.parseInt(tokens[5]));
            }

            if (!departments.containsKey(department)) {
//                departments.put(department, new Department());
            }
        }
    }
}
