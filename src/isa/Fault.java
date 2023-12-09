package isa;

public enum Fault {
    ILLEGAL_MEMORY_RESERVED(
            (byte) 0b0000,
            (byte) 0b0001,
            "Illegal memory address to reserved locations"),
    ILLEGAL_TRAP(
            (byte) 0b0001,
            (byte) 0b0010,
            "Illegal TRAP code"),
    ILLEGAL_OPCODE(
            (byte) 0b0010,
            (byte) 0b100,
            "Illegal Operation code"),
    ILLEGAL_MEMORY_ADDRESS(
            (byte) 0b0011,
            (byte) 0b1000,
            "Illegal memory address beyond 2048");

    public final byte id;

    public final byte bit;

    public final String message;

    private Fault(byte id, byte bit, String message) {
        this.id = id;
        this.bit = bit;
        this.message = message;
    }

}
