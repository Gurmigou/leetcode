package Day_33;

public class Valid_Palindrome_II {
    public static void main(String[] args) {
    }

    public boolean validPalindrome(String s) {
        return validPalindromeHelper(s, 0, s.length() - 1, false);
    }

    public boolean validPalindromeHelper(String s, int l, int r, boolean onceDeleted) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                if (onceDeleted)
                    return false;

                return validPalindromeHelper(s, l + 1, r, true) || validPalindromeHelper(s, l, r - 1, true);
            }
            l++;
            r--;
        }
        return true;
    }
}
