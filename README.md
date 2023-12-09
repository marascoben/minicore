# Minicore

> This project was developed for the CSCI6461 Computer Architecture course during my masters studies at the George Washington University.

The core library for the minicomputer projects, shared between the [minicomputer](https://github.com/marascoben/minicomputer), and the assembler for the minicomputer ISA [minicomputer-asm](https://github.com/marascoben/minicomputer-asm)

## Unit Testing

Unit tests were created using JUnit within vscode, for running and checking unit tests see the 'Testing' tab in vscode.

## Instructions

### Load & Store Instructions

| Instruction  | Opcode   | Description |
| ------------ | -------- | ----------- |
| LDR          | `000001` | Load register from memory
| STR          | `000010` | Store register to memory
| LDA          | `000011` | Load register with address
| LDX          | `100001` | Load index register from memory
| STX          | `100010` | Store index register to memory

### Transfer Instructions

| Instruction  | Opcode   | Description |
| ------------ | -------- | --- |
| JZ           | `001010` | Jump if zero
| JNE          | `001011` | Jump if not equal
| JCC          | `001100` | Jump if condition code
| JMA          | `001101` | Uncondiational jump to address
| JSR          | `001110` | Jump and save return address
| RFS          | `001111` | Return from subroutine
| SOB          | `010000` | Subtract one and branch
| JGE          | `010001` | Jump greater than or equal to


### Arithmetic & Logic Instructions

| Instruction  | Opcode   | Description |
| ------------ | -------- | --- |
| AMR          | `000100` | Add memory to register
| SMR          | `000101` | Subtract memory from register
| AIR          | `000110` | Add immediate to register
| SIR          | `000111` | Subtract immediate from register

| Instruction  | Opcode   | Description |
| ------------ | -------- | --- |
| MLT          | `010010` | Multiply register by register
| DVD          | `010011` | Divide register by register
| TRR          | `010100` | Test equality of register and register
| AND          | `010101` | Logical AND of register to register
| ORR          | `010110` | Logical OR of register to register
| NOT          | `010111` | Logical NOT of register to register

| Instruction  | Opcode   | Description |
| ------------ | -------- | --- |
| SRC          | `011000` | Shift register by count
| RRC          | `011001` | Rotate register by count

### IO Instructions

| Instruction  | Opcode   | Description |
| ------------ | -------- | --- |
| IN           | `111101` | Input character to register from device
| OUT          | `111110` | Output character to device from register
| CHK          | `111111` | Check device status to register 

### Misc Instructions
| Instruction  | Opcode   | Description |
| ------------ | -------- | --- |
| HLT          | `000000` | Stops the machine
| TRP          | `011000` | Traps to memory address 0
