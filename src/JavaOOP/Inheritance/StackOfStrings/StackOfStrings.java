package JavaOOP.Inheritance.StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String string) {
        this.data.add(string);
    }

    public String pop() {
       return data.remove(data.size() - 1);
    }

    public String peek() {
        return data.get(data.size() - 1);
    }
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
