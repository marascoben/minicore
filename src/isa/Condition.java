package isa;

public enum Condition {
    OVERFLOW(
            (byte) 0b0000,
            (byte) 0b1000,
            "Overflow"),
    UNDERFLOW(
            (byte) 0b0001,
            (byte) 0b0100,
            "Underflow"),
    DIVZERO(
            (byte) 0b0010,
            (byte) 0b0010,
            "Divide by zero"),
    EQUALORNOT(
            (byte) 0b0011,
            (byte) 0b0001,
            "Equal or not equal");

    public final byte id;

    public final byte bit;

    public final String message;

    private Condition(byte id, byte bit, String message) {
        this.id = id;
        this.bit = bit;
        this.message = message;
    }
}
