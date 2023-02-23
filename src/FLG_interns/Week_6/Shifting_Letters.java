package FLG_interns.Week_6;

public class Shifting_Letters {
    public static void main(String[] args) {
        var app = new Shifting_Letters();
        app.shiftingLetters("ruu", new int[] {26,9,17});
    }

    public String shiftingLetters(String s, int[] shifts) {
        int shift = 0;
        var result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            shift = (shift + shifts[i]) % 26;
            result.append(getShifted(s.charAt(i), shift));
        }
        return result.reverse().toString();
    }

    private char getShifted(char ch, int shift) {
        int intValue = ((int) ch + (shift % 26));
        if (intValue  > 122)
            intValue -= 26;
        return (char) intValue;
    }
}
