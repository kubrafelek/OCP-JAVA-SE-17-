package methodReferences;

public class Duckling {
    public static void makeSound(String sound) {
//        LearnToSpeak learner = s -> System.out.println(s); redundant
        LearnToSpeak learner = System.out::println;
        DuckHelper.teacher(sound, learner);
    }
}