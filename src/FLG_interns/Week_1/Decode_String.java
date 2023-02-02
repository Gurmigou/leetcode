package FLG_interns.Week_1;

public class Decode_String {
    public static void main(String[] args) {
        var app = new Decode_String();
        String s = app.decodeString("2[abc]3[cd]ef");
        System.out.println(s);
    }

    public String decodeString(String s) {
        return decodeStringHelper(s).first;
    }

    private Pair<String, Integer> decodeStringHelper(String s) {
        StringBuilder result = new StringBuilder();

        int index = 0;
        char cur = ' ';
        while (index < s.length() && cur != ']') {
            cur = s.charAt(index);
            if (Character.isDigit(cur)) {
                int number = 0;
                while (Character.isDigit(cur)) {
                    number = number * 10 + (cur - '0');
                    index++;
                    cur = s.charAt(index);
                }

                var recursive = decodeStringHelper(s.substring(index + 1));

                for (int i = 0; i < number; i++) {
                    result.append(recursive.first);
                }

                index += recursive.second;

            } else if (Character.isLetter(cur)) {
                result.append(cur);
            }
            index++;
        }

        return Pair.of(result.toString(), index);
    }

    static public class Pair<T, V> {
        public T first;
        public V second;

        private Pair(T first, V second) {
            this.first = first;
            this.second = second;
        }

        public static <T, V> Pair<T, V> of(T first, V second) {
            return new Pair<>(first, second);
        }
    }
}
