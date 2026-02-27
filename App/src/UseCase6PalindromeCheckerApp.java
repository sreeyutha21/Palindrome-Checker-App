import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class UseCase6PalindromeCheckerApp {
    public static void main(String[] args) {
        String input = "MADAM";

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        boolean isPalindrome = true;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            stack.push(ch);
            queue.add(ch);
        }

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.remove())) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Input String : " + input);

        if (isPalindrome) {
            System.out.println("Result : The string is a Palindrome");
        } else {
            System.out.println("Result : The string is NOT a Palindrome");
        }
    }
}
