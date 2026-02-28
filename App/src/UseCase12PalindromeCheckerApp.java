import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

interface PalindromeStrategy {
    boolean check(String input);
}

class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {
        String normalized = input.toLowerCase().replaceAll("\\s+", "");
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < normalized.length(); i++) {
            stack.push(normalized.charAt(i));
        }

        for (int i = 0; i < normalized.length(); i++) {
            if (normalized.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {

    public boolean check(String input) {
        String normalized = input.toLowerCase().replaceAll("\\s+", "");
        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < normalized.length(); i++) {
            deque.addLast(normalized.charAt(i));
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}

class PalindromeService {

    private PalindromeStrategy strategy;

    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean execute(String input) {
        return strategy.check(input);
    }
}

public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "Never Odd Or Even";

        PalindromeStrategy strategy = new StackStrategy();
        PalindromeService service = new PalindromeService(strategy);

        boolean result = service.execute(input);

        System.out.println("Input String : " + input);

        if (result) {
            System.out.println("Result : The string is a Palindrome");
        } else {
            System.out.println("Result : The string is NOT a Palindrome");
        }
    }
}