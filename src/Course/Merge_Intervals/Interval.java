package Course.Merge_Intervals;

public class Interval {
    int start;
    int end;
    boolean closed;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
        this.closed = true;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}
