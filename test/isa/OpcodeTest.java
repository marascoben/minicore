package test.isa;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import isa.Opcode;

public class OpcodeTest {

    @Test
    public void fromId_ShouldReturnHLT() {
        assertEquals(Opcode.HLT, Opcode.fromId((byte) 0b000000));
    }

    @Test
    public void fromId_ShouldReturnLDR() {
        assertEquals(Opcode.LDR, Opcode.fromId((byte) 0b000001));
    }

    @Test
    public void fromId_InvalidShouldReturnHLT() {
        assertEquals(Opcode.HLT, Opcode.fromId((byte) 0b100000));
    }

    @Test
    public void fromWord_ShouldReturnHLT() {
        assertEquals(Opcode.HLT, Opcode.fromWord((char) 0b0000000000000000));
    }

    @Test
    public void fromWord_ShouldReturnLDR() {
        assertEquals(Opcode.LDR, Opcode.fromWord((char) 0b0000010000000000));
    }
}
