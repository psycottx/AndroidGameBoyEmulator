package com.github.pedrovgs.androidgameboyemulator.core.processor.isa;

import com.github.pedrovgs.androidgameboyemulator.core.mmu.MMU;
import com.github.pedrovgs.androidgameboyemulator.core.processor.GBZ80;

public class LoadPCMemoryIntoHLMemory extends Instruction {

  LoadPCMemoryIntoHLMemory(GBZ80 z80, MMU mmu) {
    super(z80, mmu);
  }

  @Override public void execute() {
    int address = (z80.getRegisterH() << 8) + z80.getRegisterL();
    int memoryValue = mmu.readByte(z80.getProgramCounter());
    mmu.writeByte(address, memoryValue);
    z80.incrementProgramCounter();
    z80.setLastInstructionExecutionTime(3);
  }
}