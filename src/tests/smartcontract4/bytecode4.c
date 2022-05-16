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
	stack[top] =  0x80;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_1 :
 {
	stack[top] =  0x40;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_2 :
 {
	memory[memPoint] = (struct pair){stack[top-1],stack[top-2] };
	top-=2;
	memPoint++;
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
	gasUsed +=2;
	assert(gasUsed < gasLimit);
 label_4 :
 {
	var tmp1 = stack[top - 1];
	stack[top] = tmp1;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_5 :
 {
	uvar tmp2 = stack[top - 1];
	uvar tmp3 = !(tmp2);
	--top;
	stack[top] = tmp3;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_6 :
 {
	stack[top] =  0x0010;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_8 :
 {
	stack[top] =  0x00;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_9 :
 {
	var tmp3 = stack[top - 1];
	stack[top] = tmp3;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_12 :
 {
	--top;
	assert(top >=0);
	gasUsed +=2;
	assert(gasUsed < gasLimit);
 }
 label_13 :
 {
	stack[top] =  0x04;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
	gasUsed +=2;
	assert(gasUsed < gasLimit);
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
 label_16 :
 {
	stack[top] =  0x002b;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_18 :
 {
	stack[top] =  0x00;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 label_20 :
 {
	stack[top] =  0xe0;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_22 :
 {
	var tmp7 = stack[top - 1];
	stack[top] = tmp7;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_23 :
 {
	stack[top] =  0x8ee93cf3;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_24 :
 {
	uvar tmp8 = stack[top - 2];
	uvar tmp9 = stack[top - 1];
	uvar tmp10 = tmp8 == tmp9;
	top-=2;
	stack[top] = tmp10;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_25 :
 {
	stack[top] =  0x0030;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_28 :
 {
	stack[top] =  0x00;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_29 :
 {
	var tmp11 = stack[top - 1];
	stack[top] = tmp11;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_32 :
 {
	stack[top] =  0x0043;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_33 :
 {
	stack[top] =  0x003e;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
	gasUsed +=2;
	assert(gasUsed < gasLimit);
 label_35 :
 {
	stack[top] =  0x04;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_36 :
 {
	stack[top] =  0x0099;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_37 :
 {
	gasUsed +=8;
	assert(gasUsed < gasLimit);
	goto label_36;
	pcCounter++;
 }
 label_39 :
 {
	stack[top] =  0x0045;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_40 :
 {
	gasUsed +=8;
	assert(gasUsed < gasLimit);
	goto label_39;
	pcCounter++;
 }exit(0);

	gasUsed +=2;
	assert(gasUsed < gasLimit);
 label_45 :
 {
	stack[top] =  0xffffffffffffffffffffffffffffffffffffffff;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_46 :
 {
	var tmp12 = stack[top - 2];
	var tmp13 = stack[top - 1];
	var tmp14 = tmp12 & tmp13;
	top-=2;
	stack[top] = tmp14;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_47 :
 {
	stack[top] =  0x6babe127d1599cad37c523a2dd29c5d02acd7132a883e378a2d9b42ec75a1fa9;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_48 :
 {
	var tmp15 = stack[top - 4];
	stack[top] = tmp15;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_49 :
 {
	var tmp16 = stack[top - 4];
	stack[top] = tmp16;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_50 :
 {
	stack[top] =  0x40;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_51 :
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
 label_52 :
 {
	stack[top] =  0x008d;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_53 :
 {
	var tmp17 = stack[top - 1];
	var tmp18 = stack[top - 4];
	stack[top - 1] = tmp18;
	stack[top - 4] = tmp17;

	assert(4<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_54 :
 {
	var tmp19 = stack[top - 1];
	var tmp20 = stack[top - 3];
	stack[top - 1] = tmp20;
	stack[top - 3] = tmp19;

	assert(3<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_55 :
 {
	var tmp21 = stack[top - 1];
	var tmp22 = stack[top - 2];
	stack[top - 1] = tmp22;
	stack[top - 2] = tmp21;

	assert(2<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_56 :
 {
	stack[top] =  0x0106;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_57 :
 {
	gasUsed +=8;
	assert(gasUsed < gasLimit);
	goto label_56;
	pcCounter++;
 }
 label_59 :
 {
	stack[top] =  0x40;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_60 :
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
 label_61 :
 {
	var tmp23 = stack[top - 1];
	stack[top] = tmp23;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_62 :
 {
	var tmp24 = stack[top - 1];
	var tmp25 = stack[top - 3];
	stack[top - 1] = tmp25;
	stack[top - 3] = tmp24;

	assert(3<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_63 :
 {
	uvar tmp26 = stack[top - 2];
	uvar tmp27 = stack[top - 1];
	uvar tmp28 = tmp26 - tmp27;
	top-=2;
	stack[top] = tmp28;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_64 :
 {
	var tmp29 = stack[top - 1];
	var tmp30 = stack[top - 2];
	stack[top - 1] = tmp30;
	stack[top - 2] = tmp29;

	assert(2<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_66 :
 {
	--top;
	assert(top >=0);
	gasUsed +=2;
	assert(gasUsed < gasLimit);
 }
 label_67 :
 {
	--top;
	assert(top >=0);
	gasUsed +=2;
	assert(gasUsed < gasLimit);
 }
 label_68 :
 {
	gasUsed +=8;
	assert(gasUsed < gasLimit);
	goto label_67;
	pcCounter++;
 }
 label_70 :
 {
	stack[top] =  0x00;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_71 :
 {
	var tmp31 = stack[top - 1];
	stack[top] = tmp31;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_72 :
 {
	stack[top] =  0x20;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_73 :
 {
	var tmp32 = stack[top - 4];
	stack[top] = tmp32;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_74 :
 {
	var tmp33 = stack[top - 6];
	stack[top] = tmp33;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_75 :
 {
	uvar tmp34 = stack[top - 2];
	uvar tmp35 = stack[top - 1];
	uvar tmp36 = tmp34 - tmp35;
	top-=2;
	stack[top] = tmp36;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_76 :
 {
	var tmp37 = stack[top - 2];
	var tmp38 = stack[top - 1];
	var tmp39 = tmp37 < tmp38;
	top-=2;
	stack[top] = tmp39;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_77 :
 {
	uvar tmp40 = stack[top - 1];
	uvar tmp41 = !(tmp40);
	--top;
	stack[top] = tmp41;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_78 :
 {
	stack[top] =  0x00ab;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_80 :
 {
	var tmp41 = stack[top - 2];
	stack[top] = tmp41;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_81 :
 {
	var tmp42 = stack[top - 3];
	stack[top] = tmp42;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_84 :
 {
	var tmp43 = stack[top - 3];
	stack[top] = tmp43;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 label_86 :
 {
	stack[top] =  0xffffffffffffffff;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_87 :
 {
	var tmp44 = stack[top - 1];
	stack[top] = tmp44;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_88 :
 {
	var tmp45 = stack[top - 3];
	stack[top] = tmp45;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_89 :
 {
	uvar tmp46 = stack[top - 2];
	uvar tmp47 = stack[top - 1];
	uvar tmp48 = tmp46 > tmp47;
	top-=2;
	stack[top] = tmp48;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_90 :
 {
	uvar tmp49 = stack[top - 1];
	uvar tmp50 = !(tmp49);
	--top;
	stack[top] = tmp50;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_91 :
 {
	stack[top] =  0x00c2;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_93 :
 {
	var tmp50 = stack[top - 4];
	stack[top] = tmp50;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_94 :
 {
	var tmp51 = stack[top - 5];
	stack[top] = tmp51;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_97 :
 {
	var tmp52 = stack[top - 2];
	stack[top] = tmp52;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_98 :
 {
	var tmp53 = stack[top - 6];
	stack[top] = tmp53;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_99 :
 {
	uvar tmp54 = stack[top - 2];
	uvar tmp55 = stack[top - 1];
	uvar tmp56 = tmp54 + tmp55;
	top-=2;
	stack[top] = tmp56;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_100 :
 {
	var tmp57 = stack[top - 1];
	var tmp58 = stack[top - 3];
	stack[top - 1] = tmp58;
	stack[top - 3] = tmp57;

	assert(3<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_101 :
 {
	--top;
	assert(top >=0);
	gasUsed +=2;
	assert(gasUsed < gasLimit);
 }
 label_102 :
 {
	var tmp59 = stack[top - 6];
	stack[top] = tmp59;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_103 :
 {
	stack[top] =  0x1f;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_104 :
 {
	var tmp60 = stack[top - 4];
	stack[top] = tmp60;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_105 :
 {
	uvar tmp61 = stack[top - 2];
	uvar tmp62 = stack[top - 1];
	uvar tmp63 = tmp61 + tmp62;
	top-=2;
	stack[top] = tmp63;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_106 :
 {
	var tmp64 = stack[top - 2];
	var tmp65 = stack[top - 1];
	var tmp66 = tmp64 < tmp65;
	top-=2;
	stack[top] = tmp66;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_107 :
 {
	stack[top] =  0x00d5;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_109 :
 {
	var tmp67 = stack[top - 4];
	stack[top] = tmp67;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_110 :
 {
	var tmp68 = stack[top - 5];
	stack[top] = tmp68;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_113 :
 {
	var tmp69 = stack[top - 2];
	stack[top] = tmp69;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 label_115 :
 {
	var tmp70 = stack[top - 2];
	stack[top] = tmp70;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_116 :
 {
	var tmp71 = stack[top - 2];
	stack[top] = tmp71;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_117 :
 {
	uvar tmp72 = stack[top - 2];
	uvar tmp73 = stack[top - 1];
	uvar tmp74 = tmp72 > tmp73;
	top-=2;
	stack[top] = tmp74;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_118 :
 {
	uvar tmp75 = stack[top - 1];
	uvar tmp76 = !(tmp75);
	--top;
	stack[top] = tmp76;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_119 :
 {
	stack[top] =  0x00e3;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_121 :
 {
	var tmp76 = stack[top - 5];
	stack[top] = tmp76;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_122 :
 {
	var tmp77 = stack[top - 6];
	stack[top] = tmp77;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_125 :
 {
	var tmp78 = stack[top - 7];
	stack[top] = tmp78;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_126 :
 {
	stack[top] =  0x20;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_127 :
 {
	var tmp79 = stack[top - 3];
	stack[top] = tmp79;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_128 :
 {
	var tmp80 = stack[top - 6];
	stack[top] = tmp80;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_129 :
 {
	uvar tmp81 = stack[top - 2];
	uvar tmp82 = stack[top - 1];
	uvar tmp83 = tmp81 + tmp82;
	top-=2;
	stack[top] = tmp83;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_130 :
 {
	uvar tmp84 = stack[top - 2];
	uvar tmp85 = stack[top - 1];
	uvar tmp86 = tmp84 + tmp85;
	top-=2;
	stack[top] = tmp86;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_131 :
 {
	uvar tmp87 = stack[top - 2];
	uvar tmp88 = stack[top - 1];
	uvar tmp89 = tmp87 > tmp88;
	top-=2;
	stack[top] = tmp89;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_132 :
 {
	uvar tmp90 = stack[top - 1];
	uvar tmp91 = !(tmp90);
	--top;
	stack[top] = tmp91;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_133 :
 {
	stack[top] =  0x00f4;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_135 :
 {
	var tmp91 = stack[top - 5];
	stack[top] = tmp91;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_136 :
 {
	var tmp92 = stack[top - 6];
	stack[top] = tmp92;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_139 :
 {
	stack[top] =  0x20;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_140 :
 {
	var tmp93 = stack[top - 1];
	var tmp94 = stack[top - 4];
	stack[top - 1] = tmp94;
	stack[top - 4] = tmp93;

	assert(4<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_141 :
 {
	var tmp95 = stack[top - 1];
	var tmp96 = stack[top - 2];
	stack[top - 1] = tmp96;
	stack[top - 2] = tmp95;

	assert(2<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_142 :
 {
	var tmp97 = stack[top - 1];
	var tmp98 = stack[top - 4];
	stack[top - 1] = tmp98;
	stack[top - 4] = tmp97;

	assert(4<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_143 :
 {
	uvar tmp99 = stack[top - 2];
	uvar tmp100 = stack[top - 1];
	uvar tmp101 = tmp99 + tmp100;
	top-=2;
	stack[top] = tmp101;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_144 :
 {
	var tmp102 = stack[top - 1];
	var tmp103 = stack[top - 8];
	stack[top - 1] = tmp103;
	stack[top - 8] = tmp102;

	assert(8<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_145 :
 {
	var tmp104 = stack[top - 1];
	var tmp105 = stack[top - 3];
	stack[top - 1] = tmp105;
	stack[top - 3] = tmp104;

	assert(3<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_146 :
 {
	var tmp106 = stack[top - 1];
	var tmp107 = stack[top - 7];
	stack[top - 1] = tmp107;
	stack[top - 7] = tmp106;

	assert(7<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_147 :
 {
	--top;
	assert(top >=0);
	gasUsed +=2;
	assert(gasUsed < gasLimit);
 }
 label_148 :
 {
	var tmp108 = stack[top - 1];
	var tmp109 = stack[top - 2];
	stack[top - 1] = tmp109;
	stack[top - 2] = tmp108;

	assert(2<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_149 :
 {
	var tmp110 = stack[top - 1];
	var tmp111 = stack[top - 5];
	stack[top - 1] = tmp111;
	stack[top - 5] = tmp110;

	assert(5<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_150 :
 {
	--top;
	assert(top >=0);
	gasUsed +=2;
	assert(gasUsed < gasLimit);
 }
 label_151 :
 {
	--top;
	assert(top >=0);
	gasUsed +=2;
	assert(gasUsed < gasLimit);
 }
 label_152 :
 {
	--top;
	assert(top >=0);
	gasUsed +=2;
	assert(gasUsed < gasLimit);
 }
 label_153 :
 {
	--top;
	assert(top >=0);
	gasUsed +=2;
	assert(gasUsed < gasLimit);
 }
 label_154 :
 {
	gasUsed +=8;
	assert(gasUsed < gasLimit);
	goto label_153;
	pcCounter++;
 }
 label_156 :
 {
	stack[top] =  0x00;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_157 :
 {
	stack[top] =  0x20;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_158 :
 {
	var tmp112 = stack[top - 3];
	stack[top] = tmp112;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_159 :
 {
	memory[memPoint] = (struct pair){stack[top-1],stack[top-2] };
	top-=2;
	memPoint++;
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_160 :
 {
	var tmp113 = stack[top - 3];
	stack[top] = tmp113;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_161 :
 {
	stack[top] =  0x20;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_162 :
 {
	var tmp114 = stack[top - 4];
	stack[top] = tmp114;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_163 :
 {
	uvar tmp115 = stack[top - 2];
	uvar tmp116 = stack[top - 1];
	uvar tmp117 = tmp115 + tmp116;
	top-=2;
	stack[top] = tmp117;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_164 :
 {
	memory[memPoint] = (struct pair){stack[top-1],stack[top-2] };
	top-=2;
	memPoint++;
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_165 :
 {
	var tmp118 = stack[top - 3];
	stack[top] = tmp118;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_166 :
 {
	var tmp119 = stack[top - 5];
	stack[top] = tmp119;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_167 :
 {
	stack[top] =  0x40;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_168 :
 {
	var tmp120 = stack[top - 5];
	stack[top] = tmp120;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_169 :
 {
	uvar tmp121 = stack[top - 2];
	uvar tmp122 = stack[top - 1];
	uvar tmp123 = tmp121 + tmp122;
	top-=2;
	stack[top] = tmp123;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 label_171 :
 {
	var tmp124 = stack[top - 2];
	stack[top] = tmp124;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_172 :
 {
	var tmp125 = stack[top - 4];
	stack[top] = tmp125;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_173 :
 {
	uvar tmp126 = stack[top - 2];
	uvar tmp127 = stack[top - 1];
	uvar tmp128 = tmp126 + tmp127;
	top-=2;
	stack[top] = tmp128;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_174 :
 {
	stack[top] =  0x40;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_175 :
 {
	var tmp129 = stack[top - 1];
	var tmp130 = stack[top - 2];
	stack[top - 1] = tmp130;
	stack[top - 2] = tmp129;

	assert(2<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_176 :
 {
	var tmp131 = stack[top - 2];
	stack[top] = tmp131;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_177 :
 {
	uvar tmp132 = stack[top - 2];
	uvar tmp133 = stack[top - 1];
	uvar tmp134 = tmp132 + tmp133;
	top-=2;
	stack[top] = tmp134;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_178 :
 {
	var tmp135 = stack[top - 1];
	var tmp136 = stack[top - 3];
	stack[top - 1] = tmp136;
	stack[top - 3] = tmp135;

	assert(3<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_179 :
 {
	var tmp137 = stack[top - 1];
	var tmp138 = stack[top - 2];
	stack[top - 1] = tmp138;
	stack[top - 2] = tmp137;

	assert(2<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_180 :
 {
	var tmp139 = stack[top - 1];
	var tmp140 = stack[top - 3];
	stack[top - 1] = tmp140;
	stack[top - 3] = tmp139;

	assert(3<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_181 :
 {
	memory[memPoint] = (struct pair){stack[top-1],stack[top-2] };
	top-=2;
	memPoint++;
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_182 :
 {
	stack[top] =  0x1f;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_183 :
 {
	var tmp141 = stack[top - 1];
	var tmp142 = stack[top - 2];
	stack[top - 1] = tmp142;
	stack[top - 2] = tmp141;

	assert(2<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_184 :
 {
	var tmp143 = stack[top - 1];
	var tmp144 = stack[top - 4];
	stack[top - 1] = tmp144;
	stack[top - 4] = tmp143;

	assert(4<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_185 :
 {
	uvar tmp145 = stack[top - 2];
	uvar tmp146 = stack[top - 1];
	uvar tmp147 = tmp145 + tmp146;
	top-=2;
	stack[top] = tmp147;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_186 :
 {
	stack[top] =  0xffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffe0;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_187 :
 {
	var tmp148 = stack[top - 2];
	var tmp149 = stack[top - 1];
	var tmp150 = tmp148 & tmp149;
	top-=2;
	stack[top] = tmp150;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_188 :
 {
	uvar tmp151 = stack[top - 2];
	uvar tmp152 = stack[top - 1];
	uvar tmp153 = tmp151 + tmp152;
	top-=2;
	stack[top] = tmp153;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_189 :
 {
	uvar tmp154 = stack[top - 2];
	uvar tmp155 = stack[top - 1];
	uvar tmp156 = tmp154 + tmp155;
	top-=2;
	stack[top] = tmp156;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_190 :
 {
	var tmp157 = stack[top - 1];
	var tmp158 = stack[top - 3];
	stack[top - 1] = tmp158;
	stack[top - 3] = tmp157;

	assert(3<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_191 :
 {
	var tmp159 = stack[top - 1];
	var tmp160 = stack[top - 2];
	stack[top - 1] = tmp160;
	stack[top - 2] = tmp159;

	assert(2<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_192 :
 {
	--top;
	assert(top >=0);
	gasUsed +=2;
	assert(gasUsed < gasLimit);
 }
 label_193 :
 {
	gasUsed +=8;
	assert(gasUsed < gasLimit);
	goto label_192;
	pcCounter++;
 }
 label_196 :
 {
	stack[top] =  0x6970667358;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_198 :
 {
	var tmp161 = stack[top - 2];
	var tmp162 = stack[top - 1];
	var tmp163 = tmp161 < tmp162;
	top-=2;
	stack[top] = tmp163;
	++top;

	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_199 :
 {
	gasUsed +=30;
	assert(gasUsed < gasLimit);
	stack[top]='H9UrYV+4NbvulIKfgvoKBK9P2ymUJ4HS4Xc/3MKFhaY=';

 }
 label_200 :
 {
	var tmp164 = stack[top - 1];
	var tmp165 = stack[top - 3];
	stack[top - 1] = tmp165;
	stack[top - 3] = tmp164;

	assert(3<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
	gasUsed +=2;
	assert(gasUsed < gasLimit);
 label_202 :
 {
	var tmp166 = stack[top - 1];
	var tmp167 = stack[top - 17];
	stack[top - 1] = tmp167;
	stack[top - 17] = tmp166;

	assert(17<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_205 :
 {
	var tmp168 = stack[top - 1];
	var tmp169 = stack[top - 9];
	stack[top - 1] = tmp169;
	stack[top - 9] = tmp168;

	assert(9<= top);
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_207 :
 {
	stack[top] = accounts[accountNo-1].address;
	++top;

	gasUsed +=2;
	assert(gasUsed < gasLimit);
 }
 label_209 :
 {
	stack[top] =  0x1fb470a163a0384d9152cd15b5887f5f0b68e5a3c8;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }
 label_211 :
 {
	stack[top] =  0x736f6c6343;
	++top;
	assert(top != STACKHEIGHT);
	gasUsed +=3;
	assert(gasUsed < gasLimit);
 }exit(0);

//ADDMOD
exit(0);
exit(0);

	gasUsed +=2;
	assert(gasUsed < gasLimit); /*** End of decompiled code ***/
return 0;

}
