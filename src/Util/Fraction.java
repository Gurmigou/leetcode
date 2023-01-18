package Util;

import java.util.Objects;

public class Fraction {
    int nominator;
    int denominator;

    private Fraction(int nominator, int denominator) {
        this.nominator = nominator;
        this.denominator = denominator;
    }

    public static Fraction of(int nominator, int denominator) {
        return new Fraction(nominator, denominator);
    }

    public Fraction add(Fraction other) {
        int newNominator = this.nominator * other.denominator + other.nominator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return of(newNominator, newDenominator).reduceFraction();
    }

    public Fraction subtract(Fraction other) {
        int newNominator = this.nominator * other.denominator - other.nominator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return of(newNominator, newDenominator).reduceFraction();
    }

    public Fraction multiply(Fraction other) {
        int newNominator = this.nominator * other.nominator;
        int newDenominator = this.denominator * other.denominator;
        return of(newNominator, newDenominator).reduceFraction();
    }

    public Fraction divide(Fraction other) {
        int newNominator = this.nominator * other.denominator;
        int newDenominator = this.denominator * other.nominator;
        return of(newNominator, newDenominator).reduceFraction();
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    private Fraction reduceFraction() {
        int gcd = gcd(this.nominator, this.denominator);
        this.nominator /= gcd;
        this.denominator /= gcd;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return nominator == fraction.nominator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nominator, denominator);
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "nominator=" + nominator +
                ", denominator=" + denominator +
                '}';
    }
}
