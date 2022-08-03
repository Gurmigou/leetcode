package Day_23;

public class Redistribute_Characters_to_Make_All_Strings_Equal {
    public boolean makeEqual(String[] words) {
        int[] counter = new int[26];
        for (var s : words) {
            for (char ch : s.toCharArray())
                ++counter[ch - 'a'];
        }
        for (int count : counter) {
            if (count % words.length != 0)
                return false;
        }

        return true;
    }
}
