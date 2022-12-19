package byn;

import exception.NonPositiveArgsException;

public class Byn {
    private int value;

    public Byn() {
    }

    public Byn(int rubs, int coins) {
        this(rubs*100 + coins);
    }

    public Byn(Byn byn) {
        this(byn.value);
    }

    public Byn(int value) {
        if (value < 0) {
            throw new NonPositiveArgsException();
        }
        this.value = value;
    }

    public int getRub() {
        return value / 100;
    }

    public int getCoin() {
        return value % 100;
    }

    public Byn add(Byn byn) {
        this.value += byn.value;
        return this;
    }

    public Byn sub(Byn byn) {
        this.value -= byn.value;
        return this;
    }

    public Byn mul(int number) {
        this.value *= number;
        return this;
    }

    public Byn mul(double k, Rounding rounding, int d){
        this.value = rounding.getNumberFromEnum(value*k, d);
        return this;
    }

    public Byn round(Rounding rounding, int d) {
        int tenPow = (int) Math.pow(10, d);
        this.value = (int) (rounding.getNumberFromEnum(value/tenPow, d) * tenPow);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Byn)) return false;
        Byn byn = (Byn) o;
        return value == byn.value;
    }

    @Override
    public String toString() {
        return "$" + String.format("%d,%02d", getRub(), getCoin());
    }
}