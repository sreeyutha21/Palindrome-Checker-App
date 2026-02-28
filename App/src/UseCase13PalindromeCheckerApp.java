import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

public class UseCase13PalindromeCheckerApp {

    public static boolean twoPointerCheck(String input) {
        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean stackCheck(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static boolean dequeCheck(String input) {
        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String input = "NeverOddOrEven".toLowerCase();

        long start, end;

        start = System.nanoTime();
        boolean result1 = twoPointerCheck(input);
        end = System.nanoTime();
        long time1 = end - start;

        start = System.nanoTime();
        boolean result2 = stackCheck(input);
        end = System.nanoTime();
        long time2 = end - start;

        start = System.nanoTime();
        boolean result3 = dequeCheck(input);
        end = System.nanoTime();
        long time3 = end - start;

        System.out.println("Input String : " + input);
        System.out.println();
        System.out.println("Two Pointer Result : " + result1 + " | Time (ns): " + time1);
        System.out.println("Stack Result       : " + result2 + " | Time (ns): " + time2);
        System.out.println("Deque Result       : " + result3 + " | Time (ns): " + time3);
    }
}