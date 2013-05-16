package utils;

public class JumpCounter {

    private static int counter = 0;

    public static int get() {
        JumpCounter.increase(); // protože 0 je pracovní registr, začneme od 1
        return counter;
    }

    public static void increase() {
        counter++;
    }

    public static void decrease() {
        counter--;
    }
}
