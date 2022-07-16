package Day_2;

import java.util.ArrayList;
import java.util.List;


public class Snapshot_Array {
    public static void main(String[] args) {
        var app = new Snapshot_Array(1);
        app.set(0, 15);
        app.snap();
        app.snap();
        app.snap();
        System.out.println(app.get(0, 2));

        app.snap();
        app.snap();

        System.out.println(app.get(0, 0));
    }
    private final List<Pair>[] matrix;
    private int snapId;

    static class Pair {
        public int first;
        public int second;

        public Pair(int s, int i) {
            this.first = s;
            this.second = i;
        }

        public static Pair of(int s, int i) {
            return new Pair(s, i);
        }
    }

    public Snapshot_Array(int length) {
        this.matrix = new List[length];
        this.snapId = 0;

    }

    public void set(int index, int val) {
       if (matrix[index] == null)
           matrix[index] = new ArrayList<>();

       if (matrix[index].isEmpty()) {
           matrix[index].add(Pair.of(snapId, val));
       }
       // update value
       else if (matrix[index].get(matrix[index].size() - 1).first == snapId) {
           matrix[index].get(matrix[index].size() - 1).second = val;
       }
       else {
           matrix[index].add(Pair.of(snapId, val));
       }
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        List<Pair> versions = matrix[index];
        if (versions == null)
            return 0;

        return binarySearch(versions, snap_id);
    }

    private int binarySearch(List<Pair> versions, int target) {
        int low = 0;
        int high = versions.size() - 1;

        int result = 0;

        while (low <= high) {
            int middle = (low + high) / 2;
            if (versions.get(middle).first <= target) {
                result = versions.get(middle).second;
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return result;
    }
}
