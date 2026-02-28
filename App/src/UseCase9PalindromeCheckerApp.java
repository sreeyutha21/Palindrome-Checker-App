public class UseCase9PalindromeCheckerApp {

    public static void main(String[] args) {
        String input = "MADAM";

        boolean result = isPalindrome(input, 0, input.length() - 1);

        System.out.println("Input String : " + input);

        if (result) {
            System.out.println("Result : The string is a Palindrome");
        } else {
            System.out.println("Result : The string is NOT a Palindrome");
        }
    }

    public static boolean isPalindrome(String str, int start, int end) {
        if (start >= end) {
            return true;
        }

        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        return isPalindrome(str, start + 1, end - 1);
    }
}
