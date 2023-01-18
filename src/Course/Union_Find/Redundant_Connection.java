package Course.Union_Find;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Redundant_Connection {
    public static void main(String[] args) {
//        [[1, 2], [1, 3], [2, 3]]
        List<List<Integer>> input = Stream.of(List.of(1, 2), List.of(1, 3), List.of(2, 3)).toList();

        List<Integer> result = redundantConnection(input);
        result.forEach(System.out::println);
    }


    public static List<Integer> redundantConnection(List<List<Integer>> edges) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        UnionFind unionFind = new UnionFind(edges.size());

        for (var pair : edges) {
            boolean canUnion = unionFind.union(pair.get(0), pair.get(1));
            if (!canUnion)
                result.addLast(pair);
        }

        if (result.isEmpty())
            return Collections.emptyList();

        return result.getLast();
    }


    static class UnionFind {
        private List<Integer> parent;
        private List<Integer> rank;

        public UnionFind(int n) {
            this.parent = IntStream.range(0, n + 1).boxed().collect(Collectors.toList());
            this.rank = new ArrayList<>(Collections.nCopies(n + 1, 0));
        }

        public int findParent(int x) {
            if (this.parent.get(x) != x) {
                this.parent.set(x, this.findParent(this.parent.get(x)));
            }
            return this.parent.get(x);
        }

        public boolean union(int v1, int v2) {
            // finds the root parents of both v1 and v2
            int p1 = this.findParent(v1);
            int p2 = this.findParent(v2);

            // if both parents are the same, a cycle exists and v1,v2 is the redundant edge
            if (p1 == p2)
                return false;

            // updates the parent and rank lists otherwise
            else if (this.rank.get(p1) > this.rank.get(p2)) {
                this.parent.set(p2, p1);
                this.rank.set(p1, this.rank.get(p1) + this.rank.get(p2));
            } else {
                this.parent.set(p1, p2);
                this.rank.set(p2, rank.get(p2) + rank.get(p1));
            }
            return true;
        }
    }
}
