package FLG_interns.Week_4;

public class PRESENTING_Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length {
    public static void main(String[] args) {
        var app = new PRESENTING_Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length();
        app.maxVowels("abciiidef", 3);
    }

    public int maxVowels(String s, int k) {
        int l = 0;
        int r = k;

        int curVowels = 0;
        for (int i = l; i < r; i++) {
            if (isVowel(s.charAt(i))) {
                curVowels += 1;
            }
        }

        int maxVowels = curVowels;
        while (r < s.length()) {
            if (isVowel(s.charAt(l)))
                curVowels -= 1;
            l += 1;
            if (isVowel(s.charAt(r)))
                curVowels += 1;
            r += 1;
            maxVowels = Math.max(maxVowels, curVowels);
        }
        return maxVowels;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
