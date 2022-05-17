#include <assert.h>
#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include <stdint.h>

typedef int64_t var;

typedef uint64_t uvar;

#define GASLIMIT 10000
#define STACKHEIGHT 1024
#define MEMORYSIZE 10000


struct pair {
	var location;
	var value;
};
struct numpair {
	int address;
	double balance;
};

struct pair memory[MEMORYSIZE] = {};
struct pair storage[MEMORYSIZE] = {};
struct numpair accounts[MEMORYSIZE] = {};

var stack[STACKHEIGHT];
var top;

var memPoint;
var storePoint;
var accountNo;
var pcCounter;
var gasUsed;
var gasLimit = GASLIMIT;

int main (int argc, char **argv) {

 /*** Start of decompiled code ***/ 

 label_0 :
 {
    stack[top] =  0x00;
    ++top;
    assert(top != STACKHEIGHT);
    gasUsed +=3;
    assert(gasUsed < gasLimit);
 }
 label_1 :
 {
    stack[top] =  0x01;
    ++top;
    assert(top != STACKHEIGHT);
    gasUsed +=3;
    assert(gasUsed < gasLimit);
 }
 label_2 :
 {
    uvar tmp1 = stack[top - 2];
    uvar tmp2 = stack[top - 1];
    uvar tmp3 = tmp1 + tmp2;
    top-=2;
    stack[top] = tmp3;
    ++top;

    assert(top != STACKHEIGHT);
    gasUsed +=3;
    assert(gasUsed < gasLimit);
 }
 label_3 :
 {
    stack[top] =  0x02;
    ++top;
    assert(top != STACKHEIGHT);
    gasUsed +=3;
    assert(gasUsed < gasLimit);
 }
 
  int i;
  for (i = 0; i < STACKHEIGHT; i++) {
  printf("%d ", stack[i]);
}
return 0;

}
