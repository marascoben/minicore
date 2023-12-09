package isa;

import register.GPR;
import register.IXR;

public class Instruction {

    private char word;

    /**
     * Creates a new empty instruction
     */
    public Instruction() {
        this((char) 0);
    }

    /**
     * Creates a new instruction from the given word.
     * 
     * @param word the word to parse
     */
    public Instruction(char word) {
        this.word = word;
    }

    /**
     * Returns the word stored in this instruction
     * 
     * @return the word stored in this instruction
     */
    public char getWord() {
        return word;
    }

    /**
     * Returns the opcode of this instruction
     * 
     * @return the opcode of this instruction
     */
    public Opcode getOpcode() {
        return Opcode.fromWord(word);
    }

    /**
     * Returns the raw opcode of this instruction
     * 
     * @return thre raw opcode
     */
    public byte getRawOpcode() {
        return (byte) (word >> 10);
    }

    /**
     * Returns the address stored in the instruction
     * 
     * @return the address
     */
    public char getAddress() {
        return (char) (word & 0b0000000000011111);
    }

    /**
     * Returns if this instruction is using indirect addressing mode
     * 
     * @return true if indirect, false otherwise
     */
    public boolean isIndirectAddressing() {
        return ((word << 10) >> 15) == 1;
    }

    /**
     * Returns the immediate value stored in the instruction, the address and immed
     * value share the bit positions
     * 
     * @return the immediate value
     */
    public char getImmmed() {
        return getAddress();
    }

    /**
     * Returns the device id stored in the instruction, the address and device id
     * share the bit positions
     * 
     * @return the device id
     */
    public char getDeviceId() {
        return getAddress();
    }

    /**
     * Returns the general purpose register this instruction is using
     * 
     * @return the general purpose register
     */
    public GPR getGPR() {
        return GPR.fromId((byte) ((word >> 8) & 0b11));
    }

    /**
     * Returns the index register this instruction is using
     * 
     * @return the index register
     */
    public IXR getIXR() {
        return IXR.getIXR((byte) ((word >> 6) & 0b11));
    }

    /**
     * Returns the general purpose register this instruction is using for the RX
     * register
     * 
     * @return the general purpose register
     */
    public GPR getRX() {
        return GPR.fromId((byte) ((word >> 8) & 0b11));
    }

    /**
     * Returns the general purpose register this instruction is using for the RY
     * register
     * 
     * @return the general purpose register
     */
    public GPR getRY() {
        return GPR.fromId((byte) ((word >> 6) & 0b11));
    }

    /**
     * Returns if the manipulation instruction is logical or arithmetic
     * 
     * @return true if logical, false if arithmetic
     */
    public boolean manipulateLogically() {
        return ((word >> 5) & 0b1) == 1;
    }

    /**
     * Returns if the manipulation instruction is left or right
     * 
     * @return true if left, false if right
     */
    public boolean manipulateLeft() {
        return ((word >> 4) & 0b1) == 1;
    }

    /**
     * Returns the count stored in the instruction for the SRC and RRC instructions
     * 
     * @return the count value
     */
    public char getCount() {
        return (char) (word & 0b0000000000001111);
    }

    /**
     * Sets the opcode of this instruction
     * 
     * @param opcode the opcode to set
     * @return the modified instruction
     */
    public Instruction setOpcode(Opcode opcode) {
        word = (char) ((word & 0b0000000000000000) | (opcode.opcode << 10));
        return this;
    };

    /**
     * Sets the address of this instruction
     * 
     * @param address the address to set
     * @return the modified instruction
     */
    public Instruction setAddress(char address) {
        word = (char) ((word & 0b1111111111100000) | (address & 0b0000000000011111));
        return this;
    }

    /**
     * Sets whether or not the instruction should be using indirect addressing mode,
     * true if indirect, false otherwise
     * 
     * @param indirect the indirect flag
     * @return the modified instruction
     */
    public Instruction setIndirect(boolean indirect) {
        word = (char) ((word & 0b1111111111011111) | ((indirect ? 1 : 0) << 6));
        return this;
    }

    /**
     * Sets the immediate value of this instruction, the address and immed value
     * share the bit positions
     * 
     * @param immed the immediate value to set
     * @return the modified instruction
     */
    public Instruction setImmed(char immed) {
        return setAddress(immed);
    }

    /**
     * Sets the device id of this instruction, the address and device id share the
     * bit positions
     * 
     * @param deviceId the device id to set
     * @return the modified instruction
     */
    public Instruction setDeviceId(char deviceId) {
        return setAddress(deviceId);
    }

    /**
     * Sets the general purpose register of this instruction
     * 
     * @param gpr the general purpose register to set
     * @return the modified instruction
     */
    public Instruction setGPR(GPR gpr) {
        word = (char) ((word & 0b1111110011111111) | (gpr.id << 8));
        return this;
    }

    /**
     * Sets the index register of this instruction
     * 
     * @param ixr the index register to set
     * @return the modified instruction
     */
    public Instruction setIXR(IXR ixr) {
        word = (char) ((word & 0b1111111100111111) | (ixr.id << 6));
        return this;
    }

    /**
     * Sets the general purpose register of this instruction for the RX register
     * 
     * @param rx the general purpose register to set
     * @return the modified instruction
     */
    public Instruction setRX(GPR rx) {
        word = (char) ((word & 0b1111110011111111) | (rx.id << 8));
        return this;
    }

    /**
     * Sets the general purpose register of this instruction for the RY register
     * 
     * @param ry the general purpose register to set
     * @return the modified instruction
     */
    public Instruction setRY(GPR ry) {
        word = (char) ((word & 0b1111111100111111) | (ry.id << 6));
        return this;
    }

    /**
     * Sets whether or not the manipulation instruction should be logical or
     * arithmetic, true if logical, false if arithmetic
     * 
     * @param logical the logical flag
     * @return the modified instruction
     */
    public Instruction setLogical(boolean logical) {
        word = (char) ((word & 0b1111111101111111) | ((logical ? 1 : 0) << 7));
        return this;
    }

    /**
     * Sets whether or not the manipulation instruction should be left or right,
     * true if left, false if right
     * 
     * @param left the left flag
     * @return the modified instruction
     */
    public Instruction setLeft(boolean left) {
        word = (char) ((word & 0b1111111110111111) | ((left ? 1 : 0) << 6));
        return this;
    }

    /**
     * Sets the count of this instruction for the SRC and RRC instructions
     * 
     * @param count the count to set
     * @return the modified instruction
     */
    public Instruction setCount(char count) {
        word = (char) ((word & 0b1111111111110000) | (count & 0b0000000000001111));
        return this;
    }

}
