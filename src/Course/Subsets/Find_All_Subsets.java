package Course.Subsets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Find_All_Subsets {
    public static void main(String[] args) {
        var result = findAllSubsets(List.of(1, 2, 3));
        result.forEach(System.out::println);
    }

    public static List<HashSet<Integer>> findAllSubsets(List<Integer> v) {
        List<HashSet<Integer>> result = new ArrayList<>();
        result.add(new HashSet<>());

        for (int num : v) {
            List<HashSet<Integer>> toAdd = new ArrayList<>();
            for (var existingSet : result) {
                var newSet = new HashSet<>(existingSet);
                newSet.add(num);
                toAdd.add(newSet);
            }
            result.addAll(toAdd);
        }
        return result;
    }
}
