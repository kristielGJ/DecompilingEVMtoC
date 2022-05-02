// Run in command-line
// gcc -DGASLIMIT=500 gera.c -o gera
// ./gera
//
// OR...
//
// cbmc -DGASLIMIT=500 gera.c

#include <assert.h>

// Pick what type you want to use
typedef int var;

// For now...
#define STACKHEIGHT 1024
#define GASLIMIT 1000

// Model ethereum stack;
var stack[STACKHEIGHT];
int top; // The first unused position

// Model gas;
int gasUsed;
int gasLimit = GASLIMIT;


// (Obviously if you are doing function reconstruction you will need more functions... )
int main (int argc, char **argv) {

  /*** Start of decompiled code ***/

  // Instruction 0, 0x60 PUSH1, with byte 0x80
 label_000 :
  stack[top] = 0x80;
  ++top;
  assert(top != STACKHEIGHT);
  gasUsed++;
  assert(gasUsed < gasLimit);

  // Instruction 1, 0x60 PUSH1, with byte 0x40
 label_001 :
  stack[top] = 0x40;
  ++top;
  assert(top != STACKHEIGHT);
  gasUsed++;
  assert(gasUsed < gasLimit);

  // Instruction 2, 0x01 ADD
 label_002 :
  {
    var tmp1 = stack[top - 2];
    var tmp2 = stack[top - 1];
    var tmp3 = tmp1 + tmp2;
    // Could put an overflow check here?
    stack[top] = tmp3;
    ++top;
    assert(top != STACKHEIGHT);
    gasUsed++;
    assert(gasUsed < gasLimit);
  }

  // Instruction 3, 0x50 POP
 label_003 :
 {
   --top;
   assert(top >= 0);
    gasUsed++;
    assert(gasUsed < gasLimit);
  }

  // Instruction 4, 0x56 JUMP to instruction 3
 label_004 :
  goto label_003;
  
  /*** End of decompiled code ***/

  // Maybe dump the stack or the registers or something for diagnostics?
  return 0;
}
