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
	gasUsed +=30;
	assert(gasUsed < gasLimit);
	stack[top]='+aR3AJ4WcekqzR2iX9p7Gt4nrgZdD5MWKyiRMLPbt0s=';

 } /*** End of decompiled code ***/
return 0;

}
