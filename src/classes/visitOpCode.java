//Author Gera Jahja
package src.classes;
import src.interfaces.*;
import src.opcodes.*;

//Uses interfaces to visit the opcode java classes
//Last update: 05/03
class visitOpCode implements Dissasemble
{ 
    @Override
    public String visit(add Add) 
    {
        System.out.println(Add.getOpcode() + "  "+ Add.getName());//output the instruction(Disassembly), used for decompilation
        return Add.getName();
    }
    @Override
    public String visit(stop Stop) 
    {
        System.out.println(Stop.getOpcode() + "  "+ Stop.getName());//output the instruction(Disassembly), used for decompilation
        return Stop.getName();
    }
    @Override
    public String visit(mul Mul) 
    {
        System.out.println(Mul.getOpcode() + "  "+ Mul.getName());//output the instruction(Disassembly), used for decompilation
        return Mul.getName();
    }

    @Override
    public String visit(sub Sub) 
    {
        System.out.println(Sub.getOpcode() + "  "+ Sub.getName());//output the instruction(Disassembly), used for decompilation
        return Sub.getName();
    }
    
    @Override
    public String visit(div Div){
        System.out.println(Div.getOpcode() + "  "+ Div.getName());//output the instruction(Disassembly), used for decompilation
        return Div.getName();
    }
    @Override
    public String visit(sdiv Sdiv){
        System.out.println(Sdiv.getOpcode() + "  "+ Sdiv.getName());//output the instruction(Disassembly), used for decompilation
        return Sdiv.getName();
    }
    @Override
    public String visit(mod Mod){
        System.out.println(Mod.getOpcode() + "  "+ Mod.getName());//output the instruction(Disassembly), used for decompilation
        return Mod.getName();
    }
    @Override
    public String visit(smod Smod){
        System.out.println(Smod.getOpcode() + "  "+ Smod.getName());//output the instruction(Disassembly), used for decompilation
        return Smod.getName();
    }
    @Override
    public String visit(addmod Addmod){
        System.out.println(Addmod.getOpcode() + "  "+ Addmod.getName());//output the instruction(Disassembly), used for decompilation
        return Addmod.getName();
    }
    @Override
    public String visit(mulmod Mulmod){
        System.out.println(Mulmod.getOpcode() + "  "+ Mulmod.getName());//output the instruction(Disassembly), used for decompilation
        return Mulmod.getName();
    }
    @Override
    public String visit(exp Exp){
        System.out.println(Exp.getOpcode() + "  "+ Exp.getName());//output the instruction(Disassembly), used for decompilation
        return Exp.getName();
    }
    @Override
    public String visit(signextend Signextend){
        System.out.println(Signextend.getOpcode() + "  "+ Signextend.getName());//output the instruction(Disassembly), used for decompilation
        return Signextend.getName();
    }
    @Override
    public String visit(lt Lt){
        System.out.println(Lt.getOpcode() + "  "+ Lt.getName());//output the instruction(Disassembly), used for decompilation
        return Lt.getName();
    }
    @Override
    public String visit(gt GT){
        System.out.println(GT.getOpcode() + "  "+ GT.getName());//output the instruction(Disassembly), used for decompilation
        return GT.getName();
    }
    @Override
    public String visit(slt Slt){
        System.out.println(Slt.getOpcode() + "  "+ Slt.getName());//output the instruction(Disassembly), used for decompilation
        return Slt.getName();
    }
    @Override
    public String visit(sgt Sgt){
        System.out.println(Sgt.getOpcode() + "  "+ Sgt.getName());//output the instruction(Disassembly), used for decompilation
        return Sgt.getName();
    }
    @Override
    public String visit(eq Eq){
        System.out.println(Eq.getOpcode() + "  "+ Eq.getName());//output the instruction(Disassembly), used for decompilation
        return Eq.getName();
    }
    @Override
    public String visit(iszero Iszero){
        System.out.println(Iszero.getOpcode() + "  "+ Iszero.getName());//output the instruction(Disassembly), used for decompilation
        return Iszero.getName();
    }
    @Override
    public String visit(and And){
        System.out.println(And.getOpcode() + "  "+ And.getName());//output the instruction(Disassembly), used for decompilation
        return And.getName();
    }
    @Override
    public String visit(or Or){
        System.out.println(Or.getOpcode() + "  "+ Or.getName());//output the instruction(Disassembly), used for decompilation
        return Or.getName();
    }
    @Override
    public String visit(xor Xor){
        System.out.println(Xor.getOpcode() + "  "+ Xor.getName());//output the instruction(Disassembly), used for decompilation
        return Xor.getName();
    }
    @Override
    public String visit(not Not){
        System.out.println(Not.getOpcode() + "  "+ Not.getName());//output the instruction(Disassembly), used for decompilation
        return Not.getName();
    }
    @Override
    public String visit(bytee Byte_){
        System.out.println(Byte_.getOpcode() + "  "+ Byte_.getName());//output the instruction(Disassembly), used for decompilation
        return Byte_.getName();
    }
    @Override
    public String visit(shl Shl){
        System.out.println(Shl.getOpcode() + "  "+ Shl.getName());//output the instruction(Disassembly), used for decompilation
        return Shl.getName();
    }
    
    @Override
    public String visit(shr Shr){
        System.out.println(Shr.getOpcode() + "  "+ Shr.getName());//output the instruction(Disassembly), used for decompilation
        return Shr.getName();
    }
    @Override
    public String visit(sar Sar){
        System.out.println(Sar.getOpcode() + "  "+ Sar.getName());//output the instruction(Disassembly), used for decompilation
        return Sar.getName();
    }
    @Override
    public String visit(address Address){
        System.out.println(Address.getOpcode() + "  "+ Address.getName());//output the instruction(Disassembly), used for decompilation
        return Address.getName();
    }
    @Override
    public String visit(balance Balance){
        System.out.println(Balance.getOpcode() + "  "+ Balance.getName());//output the instruction(Disassembly), used for decompilation
        return Balance.getName();
    }
    @Override
    public String visit(origin Origin){
        System.out.println(Origin.getOpcode() + "  "+ Origin.getName());//output the instruction(Disassembly), used for decompilation
        return Origin.getName();
    }
    @Override
    public String visit(caller Caller){
        System.out.println(Caller.getOpcode() + "  "+ Caller.getName());//output the instruction(Disassembly), used for decompilation
        return Caller.getName();
    }
    @Override
    public String visit(callvalue Callvalue){
        System.out.println(Callvalue.getOpcode() + "  "+ Callvalue.getName());//output the instruction(Disassembly), used for decompilation
        return Callvalue.getName();
    }
    @Override
    public String visit(calldataload Calldataload){
        System.out.println(Calldataload.getOpcode() + "  "+ Calldataload.getName());//output the instruction(Disassembly), used for decompilation
        return Calldataload.getName();
    }
    @Override
    public String visit(calldatasize Calldatasize){
        System.out.println(Calldatasize.getOpcode() + "  "+ Calldatasize.getName());//output the instruction(Disassembly), used for decompilation
        return Calldatasize.getName();
    }
    @Override
    public String visit(calldatacopy Calldatacopy){
        System.out.println(Calldatacopy.getOpcode() + "  "+ Calldatacopy.getName());//output the instruction(Disassembly), used for decompilation
        return Calldatacopy.getName();
    }
    @Override
    public  String visit(codesize Codesize){
        System.out.println(Codesize.getOpcode() + "  "+ Codesize.getName());//output the instruction(Disassembly), used for decompilation
        return Codesize.getName();
    }
    @Override
    public String visit(codecopy Codecopy){
        System.out.println(Codecopy.getOpcode() + "  "+ Codecopy.getName());//output the instruction(Disassembly), used for decompilation
        return Codecopy.getName();
    }
    @Override
    public String visit(gasprice Gasprice){
        System.out.println(Gasprice.getOpcode() + "  "+ Gasprice.getName());//output the instruction(Disassembly), used for decompilation
        return Gasprice.getName();
    }
    @Override
    public String visit(extcodesize Extcodesize){
        System.out.println(Extcodesize.getOpcode() + "  "+ Extcodesize.getName());//output the instruction(Disassembly), used for decompilation
        return Extcodesize.getName();
    }
    @Override
    public String visit(extcodecopy Extcodecopy){
        System.out.println(Extcodecopy.getOpcode() + "  "+ Extcodecopy.getName());//output the instruction(Disassembly), used for decompilation
        return Extcodecopy.getName();
    }
    @Override
    public String visit(returndatasize Returndatasize){
        System.out.println(Returndatasize.getOpcode() + "  "+ Returndatasize.getName());//output the instruction(Disassembly), used for decompilation
        return Returndatasize.getName();
    }
    @Override
    public String visit(returndatacopy Returndatacopy){
        System.out.println(Returndatacopy.getOpcode() + "  "+ Returndatacopy.getName());//output the instruction(Disassembly), used for decompilation
        return Returndatacopy.getName();
    }
    @Override
    public String visit(extcodehash Extcodehash){
        System.out.println(Extcodehash.getOpcode() + "  "+ Extcodehash.getName());//output the instruction(Disassembly), used for decompilation
        return Extcodehash.getName();
    }
    @Override
    public String visit(blockhash Blockhash){
        System.out.println(Blockhash.getOpcode() + "  "+ Blockhash.getName());//output the instruction(Disassembly), used for decompilation
        return Blockhash.getName();
    }
    @Override
    public String visit(coinbase Coinbase){
        System.out.println(Coinbase.getOpcode() + "  "+ Coinbase.getName());//output the instruction(Disassembly), used for decompilation
        return Coinbase.getName();
    }
    @Override
    public String visit(timestamp Timestamp){
        System.out.println(Timestamp.getOpcode() + "  "+ Timestamp.getName());//output the instruction(Disassembly), used for decompilation
        return Timestamp.getName();
    }
    @Override
    public String visit(number Number){
        System.out.println(Number.getOpcode() + "  "+ Number.getName());//output the instruction(Disassembly), used for decompilation
        return Number.getName();
    }
    @Override
    public String visit(dificulty Dificulty){
        System.out.println(Dificulty.getOpcode() + "  "+ Dificulty.getName());//output the instruction(Disassembly), used for decompilation
        return Dificulty.getName();
    }
    @Override
    public String visit(gaslimit Gaslimit){
        System.out.println(Gaslimit.getOpcode() + "  "+ Gaslimit.getName());//output the instruction(Disassembly), used for decompilation
        return Gaslimit.getName();
    }
    @Override
    public String visit(chainid Chainid){
        System.out.println(Chainid.getOpcode() + "  "+ Chainid.getName());//output the instruction(Disassembly), used for decompilation
        return Chainid.getName();
    }
    @Override
    public String visit(selfbalance Selfbalance){
        System.out.println(Selfbalance.getOpcode() + "  "+ Selfbalance.getName());//output the instruction(Disassembly), used for decompilation
        return Selfbalance.getName();
    }
    @Override
    public String visit(basefee Basefee){
        System.out.println(Basefee.getOpcode() + "  "+ Basefee.getName());//output the instruction(Disassembly), used for decompilation
        return Basefee.getName();
    }
    @Override
    public String visit(pop Pop){
        System.out.println(Pop.getOpcode() + "  "+ Pop.getName());//output the instruction(Disassembly), used for decompilation
        return Pop.getName();
    }
    @Override
    public String visit(mload Mload){
        System.out.println(Mload.getOpcode() + "  "+ Mload.getName());//output the instruction(Disassembly), used for decompilation
        return Mload.getName();
    }
    @Override
    public String visit(mstore Mstore){
        System.out.println(Mstore.getOpcode() + "  "+ Mstore.getName());//output the instruction(Disassembly), used for decompilation
        return Mstore.getName();
    }
    @Override
    public String visit(mstore8 Mstore8){
        System.out.println(Mstore8.getOpcode() + "  "+ Mstore8.getName());//output the instruction(Disassembly), used for decompilation
        return Mstore8.getName();
    }
    @Override
    public String visit(sload Sload){
        System.out.println(Sload.getOpcode() + "  "+ Sload.getName());//output the instruction(Disassembly), used for decompilation
        return Sload.getName();
    }
    @Override
    public String visit(sstore Sstore){
        System.out.println(Sstore.getOpcode() + "  "+ Sstore.getName());//output the instruction(Disassembly), used for decompilation
        return Sstore.getName();
    }
    @Override
    public String visit(jump Jump){
        System.out.println(Jump.getOpcode() + "  "+ Jump.getName());//output the instruction(Disassembly), used for decompilation
        return Jump.getName();
    }
    @Override
    public String visit(jumpi Jumpi){
        System.out.println(Jumpi.getOpcode() + "  "+ Jumpi.getName());//output the instruction(Disassembly), used for decompilation
        return Jumpi.getName();
    }
    @Override
    public String visit(pc Pc){
        System.out.println(Pc.getOpcode() + "  "+ Pc.getName());//output the instruction(Disassembly), used for decompilation
        return Pc.getName();
    }
    @Override
    public String visit(msize Msize){
        System.out.println(Msize.getOpcode() + "  "+ Msize.getName());//output the instruction(Disassembly), used for decompilation
        return Msize.getName();
    }
    @Override
    public String visit(gas Gas){
        System.out.println(Gas.getOpcode() + "  "+ Gas.getName());//output the instruction(Disassembly), used for decompilation
        return Gas.getName();
    }
    @Override
    public String visit(jumpdest Jumpdest){
        System.out.println(Jumpdest.getOpcode() + "  "+ Jumpdest.getName());//output the instruction(Disassembly), used for decompilation
        return Jumpdest.getName();
    }
    /*@Override
    public String visit(push Push){
        System.out.println(Callvalue.getOpcode() + "  "+ Callvalue.getName());//output the instruction(Disassembly), used for decompilation
        return Callvalue.getName();
    }
    @Override
    public String visit(dup Dup){
        System.out.println(Callvalue.getOpcode() + "  "+ Callvalue.getName());//output the instruction(Disassembly), used for decompilation
        return Callvalue.getName();
    }
    @Override
    public String visit(swap Swap){
        System.out.println(Callvalue.getOpcode() + "  "+ Callvalue.getName());//output the instruction(Disassembly), used for decompilation
        return Callvalue.getName();
    }
    @Override
    public String visit(log Log){
        System.out.println(Log.getOpcode() + "  "+ Log.getName());//output the instruction(Disassembly), used for decompilation
        return Log.getName();
    }*/
    @Override
    public String visit(create Create){
        System.out.println(Create.getOpcode() + "  "+ Create.getName());//output the instruction(Disassembly), used for decompilation
        return Create.getName();
    }
    @Override
    public String visit(call Call){
        System.out.println(Call.getOpcode() + "  "+ Call.getName());//output the instruction(Disassembly), used for decompilation
        return Call.getName();
    }
    @Override
    public String visit(callcode Callcode){
        System.out.println(Callcode.getOpcode() + "  "+ Callcode.getName());//output the instruction(Disassembly), used for decompilation
        return Callcode.getName();
    }
    @Override
    public String visit(return_ Return_){
        System.out.println(Return_.getOpcode() + "  "+ Return_.getName());//output the instruction(Disassembly), used for decompilation
        return Return_.getName();
    }
    @Override
    public String visit(delegatecall Delegatecall){
        System.out.println(Delegatecall.getOpcode() + "  "+ Delegatecall.getName());//output the instruction(Disassembly), used for decompilation
        return Delegatecall.getName();
    }
    @Override
    public String visit(create2 Create2){
        System.out.println(Create2.getOpcode() + "  "+ Create2.getName());//output the instruction(Disassembly), used for decompilation
        return Create2.getName();
    }
    @Override
    public String visit(staticcall Staticcall){
        System.out.println(Staticcall.getOpcode() + "  "+ Staticcall.getName());//output the instruction(Disassembly), used for decompilation
        return Staticcall.getName();
    }
    @Override
    public String visit(revert Revert){
        System.out.println(Revert.getOpcode() + "  "+ Revert.getName());//output the instruction(Disassembly), used for decompilation
        return Revert.getName();
    }
    @Override
    public String visit(invalid Invalid){
        System.out.println(Invalid.getOpcode() + "  "+ Invalid.getName());//output the instruction(Disassembly), used for decompilation
        return Invalid.getName();
    }
    @Override
    public String visit(selfdestruct Selfdestruct){
        System.out.println(Selfdestruct.getOpcode() + "  "+ Selfdestruct.getName());//output the instruction(Disassembly), used for decompilation
        return Selfdestruct.getName();
    }
    @Override
    public String visit(push Push) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public String visit(dup Dup) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public String visit(swap Swap) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public String visit(log Log) {
        // TODO Auto-generated method stub
        return null;
    }
}

