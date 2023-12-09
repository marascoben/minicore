package isa;

public enum Opcode {
    HLT ((byte) 0b000000), 
    LDR ((byte) 0b000001), 
    STR ((byte) 0b000010), 
    LDA ((byte) 0b000011),
    LDX ((byte) 0b100001),
    STX ((byte) 0b100010),
    JZ  ((byte) 0b001010), 
    JNE ((byte) 0b001011), 
    JCC ((byte) 0b001100), 
    JMA ((byte) 0b001101), 
    JSR ((byte) 0b001110), 
    RFS ((byte) 0b001111), 
    SOB ((byte) 0b010000), 
    JGE ((byte) 0b010001), 
    AMR ((byte) 0b000100), 
    SMR ((byte) 0b000101), 
    AIR ((byte) 0b000110), 
    SIR ((byte) 0b000111), 
    MLT ((byte) 0b010010), 
    DVD ((byte) 0b010011), 
    TRR ((byte) 0b010100), 
    AND ((byte) 0b010101), 
    ORR ((byte) 0b010110), 
    NOT ((byte) 0b010111), 
    SRC ((byte) 0b011000), 
    RRC ((byte) 0b011001), 
    IN  ((byte) 0b111101), 
    OUT ((byte) 0b111110), 
    CHK ((byte) 0b111111), 
    TRP ((byte) 0b011000); 

    public final byte opcode;

    private Opcode(byte opcode) {
        this.opcode = opcode;
    }

    /**
     * Returns the Opcode with the given id
     * 
     * @param opcode the id of the Opcode
     * @return the Opcode with the given id
     */
    public static Opcode fromId(byte opcode) {
        for (Opcode op : Opcode.values()) {
            if (op.opcode == opcode) {
                return op;
            }
        }

        return HLT;
    }

    /**
     * Returns the Opcode from the given word
     * 
     * @param word the word to parse
     * @return the Opcode from the given word
     */
    public static Opcode fromWord(char word) {
        return fromId((byte) (word >> 10));
    }
}
