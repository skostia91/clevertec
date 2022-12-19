package exception;

import byn.Byn;

public class NonPositiveArgsException extends IllegalArgumentException {
    private Byn price;
    private int numbers;

    public NonPositiveArgsException() {
    }

    public NonPositiveArgsException(Byn value) {
        this.price = value;
    }

    public NonPositiveArgsException(int numbers) {
        this.numbers = numbers;
    }


    @Override
    public String toString() {
        return "NonPositiveArgsException{" +
                "price=" + price +
                ", numbers=" + numbers +
                '}';
    }
}
