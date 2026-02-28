public class UseCase10PalindromeCheckerApp {

    public static void main(String[] args) {
        String input = "Never Odd Or Even";

        String normalized = input.toLowerCase().replaceAll("\\s+", "");

        boolean isPalindrome = true;
        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        System.out.println("Original String : " + input);
        System.out.println("Processed String : " + normalized);

        if (isPalindrome) {
            System.out.println("Result : The string is a Palindrome");
        } else {
            System.out.println("Result : The string is NOT a Palindrome");
        }
    }
}