package Day_30;

public class Mirror_Reflection {
    public static void main(String[] args) {
        var app = new Mirror_Reflection();
        int result = app.mirrorReflection(6, 5);
        System.out.println(result);
    }

    public int mirrorReflection(int p, int q) {
        int nP = 0;
        int nQ = 0;
        do {
            if (nP == 0)
                nP += p;
            else
                nP = 0;
            nQ += q;

        } while (nQ % p != 0 || (nP == 0 && (nQ / p) % 2 != 1));
        int d = nQ / p;
        if (nP == 0) return 2;
        if (d % 2 == 1) return 1;
        if (d % 2 == 0) return 0;

        return -1;
    }
}
