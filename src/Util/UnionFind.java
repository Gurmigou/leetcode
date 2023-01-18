package Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UnionFind {
    private final List<Integer> parent;
    private final List<Integer> rank;

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
