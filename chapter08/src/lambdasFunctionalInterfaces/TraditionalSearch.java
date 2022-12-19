package lambdasFunctionalInterfaces;

import java.util.ArrayList;

public class TraditionalSearch {

    public static void main(String[] args) {

        var animals = new ArrayList<Animal>();
        animals.add(new Animal("fish",false, true));
        animals.add(new Animal("kangaroo", true, false));
        animals.add(new Animal("rabbit", true, false));
        animals.add(new Animal("turtle", false, true));

        print(animals, new CheckIfHopper());

        print(animals, a -> a.canHop());  // lambda style
        print(animals, Animal::canHop);   // method reference
    }
    private static void print(ArrayList<Animal> animals, CheckTrait checker) {
        for (Animal animal: animals) {

            if (checker.test(animal))
                System.out.print(animal + " ");
        }
        System.out.println();
    }
}
