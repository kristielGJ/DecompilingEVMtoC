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
	stack[top] =  0x0000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_2 :
 {
	stack[top] =  0x000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_3 :
 {
	stack[top] =  0x00000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_4 :
 {
	stack[top] =  0x0000000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_5 :
 {
	stack[top] =  0x000000000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_6 :
 {
	stack[top] =  0x00000000000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_7 :
 {
	stack[top] =  0x0000000000000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_8 :
 {
	stack[top] =  0x000000000000000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_9 :
 {
	stack[top] =  0x00000000000000000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_10 :
 {
	stack[top] =  0x0000000000000000000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_11 :
 {
	stack[top] =  0x000000000000000000000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_12 :
 {
	stack[top] =  0x00000000000000000000000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_13 :
 {
	stack[top] =  0x0000000000000000000000000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_14 :
 {
	stack[top] =  0x000000000000000000000000000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_15 :
 {
	stack[top] =  0x00000000000000000000000000000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_16 :
 {
	stack[top] =  0x0000000000000000000000000000000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_17 :
 {
	stack[top] =  0x000000000000000000000000000000000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_18 :
 {
	stack[top] =  0x00000000000000000000000000000000000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_19 :
 {
	stack[top] =  0x0000000000000000000000000000000000000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_20 :
 {
	stack[top] =  0x000000000000000000000000000000000000000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_21 :
 {
	stack[top] =  0x00000000000000000000000000000000000000000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_22 :
 {
	stack[top] =  0x0000000000000000000000000000000000000000000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_23 :
 {
	stack[top] =  0x000000000000000000000000000000000000000000000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_24 :
 {
	stack[top] =  0x00000000000000000000000000000000000000000000000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_25 :
 {
	stack[top] =  0x0000000000000000000000000000000000000000000000000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_26 :
 {
	stack[top] =  0x000000000000000000000000000000000000000000000000000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_27 :
 {
	stack[top] =  0x00000000000000000000000000000000000000000000000000000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_28 :
 {
	stack[top] =  0x0000000000000000000000000000000000000000000000000000000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_29 :
 {
	stack[top] =  0x000000000000000000000000000000000000000000000000000000000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_30 :
 {
	stack[top] =  0x00000000000000000000000000000000000000000000000000000000000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_31 :
 {
	stack[top] =  0x0000000000000000000000000000000000000000000000000000000000000000;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }exit(0);

 label_33 :
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
 label_34 :
 {
	uvar tmp4 = stack[top - 2];
	uvar tmp5 = stack[top - 1];
	uvar tmp6 = tmp4 * tmp5;
	top-=2;
	stack[top] = tmp6;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=5;
	assert(gasUsed < gasLimit);
 }
 label_35 :
 {
	uvar tmp7 = stack[top - 2];
	uvar tmp8 = stack[top - 1];
	uvar tmp9 = tmp7 - tmp8;
	top-=2;
	stack[top] = tmp9;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_36 :
 {
	uvar tmp10 = stack[top - 2];
	uvar tmp11 = stack[top - 1];
	uvar tmp12 = tmp10 / tmp11;
	top-=2;
	stack[top] = tmp12;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=5;
	assert(gasUsed < gasLimit);
 }
 label_37 :
 {
	var tmp13 = stack[top - 2];
	var tmp14 = stack[top - 1];
	var tmp15 = tmp13 / tmp14;
	top-=2;
	stack[top] = tmp15;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=5;
	assert(gasUsed < gasLimit);
 }
 label_38 :
 {
	uvar tmp16 = stack[top - 2];
	uvar tmp17 = stack[top - 1];
	uvar tmp18 = tmp16 % tmp17;
	top-=2;
	stack[top] = tmp18;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=5;
	assert(gasUsed < gasLimit);
 }
 label_39 :
 {
	var tmp19 = stack[top - 2];
	var tmp20 = stack[top - 1];
	var tmp21 = tmp19 % tmp20;
	top-=2;
	stack[top] = tmp21;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=5;
	assert(gasUsed < gasLimit);
 }
//ADDMOD

//MULMOD

 label_42 :
 {
	uvar tmp22 = stack[top - 2];
	uvar tmp23 = stack[top - 1];
	uvar tmp24 = pow(tmp22,tmp23);
	top-=2;
	stack[top] = tmp24;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=10;
	assert(gasUsed < gasLimit);
 }
 label_43 :
 {
	var tmp25 = stack[top - 2];
	var tmp26 = stack[top - 1];
	var tmp27 = tmp25 ~ tmp26;
	top-=2;
	stack[top] = tmp27;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=5;
	assert(gasUsed < gasLimit);
 }
 label_1 :
 {
	uvar tmp1 = stack[top - 2];
	uvar tmp2 = stack[top - 1];
	uvar tmp3 = tmp1 < tmp2;
	top-=2;
	stack[top] = tmp3;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_45 :
 {
	uvar tmp31 = stack[top - 2];
	uvar tmp32 = stack[top - 1];
	uvar tmp33 = tmp31 > tmp32;
	top-=2;
	stack[top] = tmp33;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_46 :
 {
	var tmp34 = stack[top - 2];
	var tmp35 = stack[top - 1];
	var tmp36 = tmp34 < tmp35;
	top-=2;
	stack[top] = tmp36;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_47 :
 {
	var tmp37 = stack[top - 2];
	var tmp38 = stack[top - 1];
	var tmp39 = tmp37 > tmp38;
	top-=2;
	stack[top] = tmp39;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_48 :
 {
	uvar tmp40 = stack[top - 2];
	uvar tmp41 = stack[top - 1];
	uvar tmp42 = tmp40 == tmp41;
	top-=2;
	stack[top] = tmp42;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_49 :
 {
	uvar tmp43 = stack[top - 1];
	uvar tmp44 = !(tmp43);
	--top;
	stack[top] = tmp44;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_50 :
 {
	var tmp44 = stack[top - 2];
	var tmp45 = stack[top - 1];
	var tmp46 = tmp44 & tmp45;
	top-=2;
	stack[top] = tmp46;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_51 :
 {
	var tmp47 = stack[top - 2];
	var tmp48 = stack[top - 1];
	var tmp49 = tmp47 | tmp48;
	top-=2;
	stack[top] = tmp49;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_52 :
 {
	var tmp50 = stack[top - 2];
	var tmp51 = stack[top - 1];
	var tmp52 = tmp50 ^ tmp51;
	top-=2;
	stack[top] = tmp52;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_53 :
 {
	uvar tmp53 = stack[top - 1];
	uvar tmp54 = ~(tmp53);
	--top;
	stack[top] = tmp54;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 label_55 :
 {
	var tmp54 = stack[top - 2];
	var tmp55 = stack[top - 1];
	var tmp56 = tmp54 << tmp55;
	top-=2;
	stack[top] = tmp56;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_56 :
 {
	var tmp57 = stack[top - 2];
	var tmp58 = stack[top - 1];
	var tmp59 = tmp57 >> tmp58;
	top-=2;
	stack[top] = tmp59;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_57 :
 {
	var tmp60 = stack[top - 2];
	var tmp61 = stack[top - 1];
	var tmp62 = tmp60 >> tmp61;
	top-=2;
	stack[top] = tmp62;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_58 :
 {
	gasUsed +=30;
	assert(gasUsed < gasLimit);
	stack[top]='lBvDCks+1cUWFSJWXlKdfmCydvmEl2IaH3s6wBfSKCw=';

 }
 label_59 :
 {
	stack[top] = accounts[accountNo-1].address;
	++top;

	gasUsed +=2;
	assert(gasUsed < gasLimit);
 }
 label_60 :
 {
	stack[top] = accounts[accountNo-1].balance;
	++top;

	gasUsed +=400;
	assert(gasUsed < gasLimit);
 }
	gasUsed +=2;
	assert(gasUsed < gasLimit);
	gasUsed +=2;
	assert(gasUsed < gasLimit);
	gasUsed +=2;
	assert(gasUsed < gasLimit);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
	gasUsed +=2;
	assert(gasUsed < gasLimit);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
	gasUsed +=2;
	assert(gasUsed < gasLimit);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 label_69 :
 {
	stack[top] = gasUsed;
	++top;

	gasUsed +=2;
	assert(gasUsed < gasLimit);
 }
	gasUsed +=700;
	assert(gasUsed < gasLimit);
	gasUsed +=700;
	assert(gasUsed < gasLimit);
	gasUsed +=2;
	assert(gasUsed < gasLimit);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
	gasUsed +=700;
	assert(gasUsed < gasLimit);
	gasUsed +=20;
	assert(gasUsed < gasLimit);
	gasUsed +=2;
	assert(gasUsed < gasLimit);
	gasUsed +=2;
	assert(gasUsed < gasLimit);
	gasUsed +=2;
	assert(gasUsed < gasLimit);
	gasUsed +=2;
	assert(gasUsed < gasLimit);
	gasUsed +=2;
	assert(gasUsed < gasLimit);
	gasUsed +=2;
	assert(gasUsed < gasLimit);
	gasUsed +=2;
	assert(gasUsed < gasLimit);
 label_84 :
 {
	--top;
	assert(top >=0);
	gasUsed +=2;
	assert(gasUsed < gasLimit);
 }
 label_85 :
 {
	int i;
	for (i = 0; i <= memPoint; i++)
	{
		if (memory[i].location == stack[top-1])
		{
			stack[top]= memory[i].value;
			top++;
		}
	}
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_86 :
 {
	memory[memPoint] = (struct pair){stack[top-1],stack[top-2] };
	top-=2;
	memPoint++;
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_87 :
 {
	memory[memPoint] = (struct pair){stack[top-1],stack[top-2] };
	top-=2;
	memPoint++;
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_88 :
 {
	int i;
	for (i = 0; i <= storePoint; i++)
	{
		if (storage[i].location == stack[top-1])
		{
			stack[top]= storage[i].value;
			top++;
		}
	}
	gasUsed +=800;
	assert(gasUsed < gasLimit);
 }
 label_89 :
 {
	storage[storePoint] = (struct pair){stack[top-1],stack[top-2] };
	top-=2;
	storePoint++;
	gasUsed +=20000;
	assert(gasUsed < gasLimit);
 }
 label_90 :
 {
	gasUsed +=8;
	assert(gasUsed < gasLimit);
	goto label_89;
	pcCounter++;
 }
 label_92 :
 {
	stack[top] = pcCounter;
	++top;

	pcCounter++;	gasUsed +=2;
	assert(gasUsed < gasLimit);
 }
 label_93 :
 {
	stack[top] = memPoint;
	++top;
	gasUsed +=2;
	assert(gasUsed < gasLimit);
 }
 label_94 :
 {
	gasUsed+=2;
	stack[top] = GASLIMIT- gasUsed;
	++top;

 }
 label_96 :
 {
	var tmp63 = stack[top - 1];
	stack[top] = tmp63;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_97 :
 {
	var tmp64 = stack[top - 2];
	stack[top] = tmp64;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_98 :
 {
	var tmp65 = stack[top - 3];
	stack[top] = tmp65;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_99 :
 {
	var tmp66 = stack[top - 4];
	stack[top] = tmp66;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_100 :
 {
	var tmp67 = stack[top - 5];
	stack[top] = tmp67;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_101 :
 {
	var tmp68 = stack[top - 6];
	stack[top] = tmp68;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_102 :
 {
	var tmp69 = stack[top - 7];
	stack[top] = tmp69;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_103 :
 {
	var tmp70 = stack[top - 8];
	stack[top] = tmp70;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_104 :
 {
	var tmp71 = stack[top - 9];
	stack[top] = tmp71;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_105 :
 {
	var tmp72 = stack[top - 10];
	stack[top] = tmp72;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_106 :
 {
	var tmp73 = stack[top - 11];
	stack[top] = tmp73;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_107 :
 {
	var tmp74 = stack[top - 12];
	stack[top] = tmp74;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_108 :
 {
	var tmp75 = stack[top - 13];
	stack[top] = tmp75;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_109 :
 {
	var tmp76 = stack[top - 14];
	stack[top] = tmp76;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_110 :
 {
	var tmp77 = stack[top - 15];
	stack[top] = tmp77;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_111 :
 {
	var tmp78 = stack[top - 16];
	stack[top] = tmp78;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_112 :
 {
	var tmp79 = stack[top - 1];
	var tmp80 = stack[top - 2];
	stack[top - 1] = tmp80;
	stack[top - 2] = tmp79;

	assert(2<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_113 :
 {
	var tmp81 = stack[top - 1];
	var tmp82 = stack[top - 3];
	stack[top - 1] = tmp82;
	stack[top - 3] = tmp81;

	assert(3<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_114 :
 {
	var tmp83 = stack[top - 1];
	var tmp84 = stack[top - 4];
	stack[top - 1] = tmp84;
	stack[top - 4] = tmp83;

	assert(4<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_115 :
 {
	var tmp85 = stack[top - 1];
	var tmp86 = stack[top - 5];
	stack[top - 1] = tmp86;
	stack[top - 5] = tmp85;

	assert(5<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_116 :
 {
	var tmp87 = stack[top - 1];
	var tmp88 = stack[top - 6];
	stack[top - 1] = tmp88;
	stack[top - 6] = tmp87;

	assert(6<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_117 :
 {
	var tmp89 = stack[top - 1];
	var tmp90 = stack[top - 7];
	stack[top - 1] = tmp90;
	stack[top - 7] = tmp89;

	assert(7<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_118 :
 {
	var tmp91 = stack[top - 1];
	var tmp92 = stack[top - 8];
	stack[top - 1] = tmp92;
	stack[top - 8] = tmp91;

	assert(8<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_119 :
 {
	var tmp93 = stack[top - 1];
	var tmp94 = stack[top - 9];
	stack[top - 1] = tmp94;
	stack[top - 9] = tmp93;

	assert(9<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_120 :
 {
	var tmp95 = stack[top - 1];
	var tmp96 = stack[top - 10];
	stack[top - 1] = tmp96;
	stack[top - 10] = tmp95;

	assert(10<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_121 :
 {
	var tmp97 = stack[top - 1];
	var tmp98 = stack[top - 11];
	stack[top - 1] = tmp98;
	stack[top - 11] = tmp97;

	assert(11<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_122 :
 {
	var tmp99 = stack[top - 1];
	var tmp100 = stack[top - 12];
	stack[top - 1] = tmp100;
	stack[top - 12] = tmp99;

	assert(12<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_123 :
 {
	var tmp101 = stack[top - 1];
	var tmp102 = stack[top - 13];
	stack[top - 1] = tmp102;
	stack[top - 13] = tmp101;

	assert(13<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_124 :
 {
	var tmp103 = stack[top - 1];
	var tmp104 = stack[top - 14];
	stack[top - 1] = tmp104;
	stack[top - 14] = tmp103;

	assert(14<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_125 :
 {
	var tmp105 = stack[top - 1];
	var tmp106 = stack[top - 15];
	stack[top - 1] = tmp106;
	stack[top - 15] = tmp105;

	assert(15<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_126 :
 {
	var tmp107 = stack[top - 1];
	var tmp108 = stack[top - 16];
	stack[top - 1] = tmp108;
	stack[top - 16] = tmp107;

	assert(16<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_127 :
 {
	var tmp109 = stack[top - 1];
	var tmp110 = stack[top - 17];
	stack[top - 1] = tmp110;
	stack[top - 17] = tmp109;

	assert(17<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_128 :
 {

	assert(0);
	gasUsed +=375;
	assert(gasUsed < gasLimit);
	
 }
 label_129 :
 {

	assert(0);
	gasUsed +=750;
	assert(gasUsed < gasLimit);
	
 }
 label_130 :
 {

	assert(0);
	gasUsed +=1125;
	assert(gasUsed < gasLimit);
	
 }
 label_131 :
 {

	assert(0);
	gasUsed +=1500;
	assert(gasUsed < gasLimit);
	
 }
 label_132 :
 {

	assert(0);
	gasUsed +=1875;
	assert(gasUsed < gasLimit);
	
 }
 label_133 :
 {
	accounts[accountNo] = (struct numpair){accountNo, 0.0};
	accountNo++;
	gasUsed +=32000;
	assert(gasUsed < gasLimit);
 }exit(0);

 label_138 :
 {
	accounts[accountNo] = (struct numpair){accountNo, 0.0};
	accountNo++;
	gasUsed +=32000;
	assert(gasUsed < gasLimit);
 }
	gasUsed +=40;
	assert(gasUsed < gasLimit);exit(0);
 /*** End of decompiled code ***/
return 0;

}
