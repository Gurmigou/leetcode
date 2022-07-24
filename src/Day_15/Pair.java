package Day_15;

public class Pair {
    public String first;
    public int second;

    public Pair(String s, int i) {
        this.first = s;
        this.second = i;
    }

    public static Pair of(String s, int i) {
        return new Pair(s, i);
    }
}
