package Dailty_Problems.month_1.Day_14_01;

public class Lexicographically_Smallest_Equivalent_String {
    public static void main(String[] args) {
        var app = new Lexicographically_Smallest_Equivalent_String();
        String result = app.smallestEquivalentString("leetcode", "programs", "sourcecode");
        System.out.println(result);
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        CharacterUnion unionFind = new CharacterUnion();
        for (int i = 0; i < s1.length(); i++) {
            unionFind.union(s1.charAt(i), s2.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            sb.append(unionFind.findParent(baseStr.charAt(i)));
        }
        return sb.toString();
    }

    static class CharacterUnion {
        private final int[] union;

        public CharacterUnion() {
            this.union = new int[26];
            for (int i = 0; i < union.length; i++) {
                union[i] = i + 'a';
            }
        }

        public char findParent(char ch) {
            int intVal = ch - 'a';
            if (ch != union[intVal]) {
                union[intVal] = findParent((char) union[intVal]);
            }
            return (char) union[intVal];
        }

        public void union(char c1, char c2) {
            char parent1 = findParent(c1);
            char parent2 = findParent(c2);

            if (parent1 == parent2)
                return;

            int min = Math.min(parent1 - 'a', parent2 - 'a');
            int max = Math.max(parent1 - 'a', parent2 - 'a');
            union[max] = min + 'a';
        }
    }
}
































