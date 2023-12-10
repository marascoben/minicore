package test.isa;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import isa.Instruction;
import register.GPR;
import register.IXR;

public class InstructionTest {

    // GPR 0
    char GPR0 = 0b0000000000000000;

    // GPR 1
    char GPR1 = 0b0000000100000000;

    // GPR 2
    char GPR2 = 0b0000001000000000;

    // GPR 3
    char GPR3 = 0b0000001100000000;

    // NO INDEX
    char NOIX = 0b0000000000000000;

    // IX 1
    char IXR1 = 0b0000000001000000;

    // IX 2
    char IXR2 = 0b0000000010000000;

    // IX 3
    char IXR3 = 0b0000000011000000;

    // Indirect Addressing
    char INDIRECT = 0b0000000000100000;

    // No Indirect Addressing
    char NO_INDIRECT = 0b0000000000000000;

    @Test
    public void getGPR_ShouldReturnGPR0() {
        Instruction instruction = new Instruction(GPR0);
        assertEquals(GPR.GPR0, instruction.getGPR());
    }

    @Test
    public void getGPR_ShouldReturnGPR1() {
        Instruction instruction = new Instruction(GPR1);
        assertEquals(GPR.GPR1, instruction.getGPR());
    }

    @Test
    public void getGPR_ShouldReturnGPR2() {
        Instruction instruction = new Instruction(GPR2);
        assertEquals(GPR.GPR2, instruction.getGPR());
    }

    @Test
    public void getGPR_ShouldReturnGPR3() {
        Instruction instruction = new Instruction(GPR3);
        assertEquals(GPR.GPR3, instruction.getGPR());
    }

    @Test
    public void getIXR_ShouldReturnNOX() {
        Instruction instruction = new Instruction(NOIX);
        assertEquals(IXR.NOX, instruction.getIXR());
    }

    @Test
    public void getIXR_ShouldReturnIXR1() {
        Instruction instruction = new Instruction(IXR1);
        assertEquals(IXR.IX1, instruction.getIXR());
    }

    @Test
    public void getIXR_ShouldReturnIXR2() {
        Instruction instruction = new Instruction(IXR2);
        assertEquals(IXR.IX2, instruction.getIXR());
    }

    @Test
    public void getIXR_ShouldReturnIXR3() {
        Instruction instruction = new Instruction(IXR3);
        assertEquals(IXR.IX3, instruction.getIXR());
    }

    @Test
    public void isIndirect_ShouldReturnTrue() {
        Instruction instruction = new Instruction(INDIRECT);
        assertEquals(true, instruction.isIndirectAddressing());
    }

    @Test
    public void isIndirect_ShouldReturnFalse() {
        Instruction instruction = new Instruction(NO_INDIRECT);
        assertEquals(false, instruction.isIndirectAddressing());
    }
}
