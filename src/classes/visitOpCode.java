//Author Gera Jahja
package src.classes;
import src.interfaces.*;
import src.opcodes.*;

//Uses interfaces to visit the opcode java classes
//Last update: 24/04
class visitOpCode implements Dissasemble
{ 
    @Override
    public String  visit(push Push)
    {
        System.out.println(Integer.toHexString(Push.getOpcode()).toUpperCase() + "  "+ Push.getName());//output the instruction(Disassembly), used for decompilation
        return Push.getName();
    }@Override
    public String visit(log Log)
    {
        System.out.println(Integer.toHexString(Log.getOpcode()).toUpperCase() + "  "+ Log.getName());//output the instruction(Disassembly), used for decompilation
        return Log.getName();
    }@Override
    public String visit(dup Dup)
        {
        System.out.println(Integer.toHexString(Dup.getOpcode()).toUpperCase() + "  "+ Dup.getName());//output the instruction(Disassembly), used for decompilation
        return Dup.getName();
    }@Override
    public String visit(swap Swap)
    {
        System.out.println(Integer.toHexString(Swap.getOpcode()).toUpperCase() + "  "+ Swap.getName());//output the instruction(Disassembly), used for decompilation
        return Swap.getName();
    }
    @Override
    public String visit(sh3 Sh3) 
    {
        System.out.println(Integer.toHexString(Sh3.getOpcode()).toUpperCase() + "  "+ Sh3.getName());//output the instruction(Disassembly), used for decompilation
        return Sh3.getName();
    }
    @Override
    public String visit(add Add) 
    {
        System.out.println("0"+Integer.toHexString(Add.getOpcode()).toUpperCase() + "  "+ Add.getName());//output the instruction(Disassembly), used for decompilation
        return Add.getName();
    }
    @Override
    public String visit(stop Stop) 
    {
        System.out.println("0"+Integer.toHexString(Stop.getOpcode()).toUpperCase() + "  "+ Stop.getName());//output the instruction(Disassembly), used for decompilation
        return Stop.getName();
    }
    @Override
    public String visit(mul Mul) 
    {
        System.out.println("0"+Integer.toHexString(Mul.getOpcode()).toUpperCase() + "  "+ Mul.getName());//output the instruction(Disassembly), used for decompilation
        return Mul.getName();
    }

    @Override
    public String visit(sub Sub) 
    {
        System.out.println("0"+Integer.toHexString(Sub.getOpcode()).toUpperCase() + "  "+ Sub.getName());//output the instruction(Disassembly), used for decompilation
        return Sub.getName();
    }
    
    @Override
    public String visit(div Div){
        System.out.println("0"+Integer.toHexString(Div.getOpcode()).toUpperCase() + "  "+ Div.getName());//output the instruction(Disassembly), used for decompilation
        return Div.getName();
    }
    @Override
    public String visit(sdiv Sdiv){
        System.out.println("0"+Integer.toHexString(Sdiv.getOpcode()).toUpperCase() + "  "+ Sdiv.getName());//output the instruction(Disassembly), used for decompilation
        return Sdiv.getName();
    }
    @Override
    public String visit(mod Mod){
        System.out.println("0"+Integer.toHexString(Mod.getOpcode()).toUpperCase() + "  "+ Mod.getName());//output the instruction(Disassembly), used for decompilation
        return Mod.getName();
    }
    @Override
    public String visit(smod Smod){
        System.out.println("0"+Integer.toHexString(Smod.getOpcode()).toUpperCase() + "  "+ Smod.getName());//output the instruction(Disassembly), used for decompilation
        return Smod.getName();
    }
    @Override
    public String visit(addmod Addmod){
        System.out.println("0"+Integer.toHexString(Addmod.getOpcode()).toUpperCase() + "  "+ Addmod.getName());//output the instruction(Disassembly), used for decompilation
        return Addmod.getName();
    }
    @Override
    public String visit(mulmod Mulmod){
        System.out.println("0"+Integer.toHexString(Mulmod.getOpcode()).toUpperCase() + "  "+ Mulmod.getName());//output the instruction(Disassembly), used for decompilation
        return Mulmod.getName();
    }
    @Override
    public String visit(exp Exp){
        System.out.println("0"+Integer.toHexString(Exp.getOpcode()).toUpperCase() + "  "+ Exp.getName());//output the instruction(Disassembly), used for decompilation
        return Exp.getName();
    }
    @Override
    public String visit(signextend Signextend){
        System.out.println("0"+Integer.toHexString(Signextend.getOpcode()).toUpperCase() + "  "+ Signextend.getName());//output the instruction(Disassembly), used for decompilation
        return Signextend.getName();
    }
    @Override
    public String visit(lt Lt){
        System.out.println(Integer.toHexString(Lt.getOpcode()).toUpperCase() + "  "+ Lt.getName());//output the instruction(Disassembly), used for decompilation
        return Lt.getName();
    }
    @Override
    public String visit(gt GT){
        System.out.println(Integer.toHexString(GT.getOpcode()).toUpperCase() + "  "+ GT.getName());//output the instruction(Disassembly), used for decompilation
        return GT.getName();
    }
    @Override
    public String visit(slt Slt){
        System.out.println(Integer.toHexString(Slt.getOpcode()).toUpperCase() + "  "+ Slt.getName());//output the instruction(Disassembly), used for decompilation
        return Slt.getName();
    }
    @Override
    public String visit(sgt Sgt){
        System.out.println(Integer.toHexString(Sgt.getOpcode()).toUpperCase() + "  "+ Sgt.getName());//output the instruction(Disassembly), used for decompilation
        return Sgt.getName();
    }
    @Override
    public String visit(eq Eq){
        System.out.println(Integer.toHexString(Eq.getOpcode()).toUpperCase()+ "  "+ Eq.getName());//output the instruction(Disassembly), used for decompilation
        return Eq.getName();
    }
    @Override
    public String visit(iszero Iszero){
        System.out.println(Integer.toHexString(Iszero.getOpcode()).toUpperCase() + "  "+ Iszero.getName());//output the instruction(Disassembly), used for decompilation
        return Iszero.getName();
    }
    @Override
    public String visit(and And){
        System.out.println(Integer.toHexString(And.getOpcode()).toUpperCase() + "  "+ And.getName());//output the instruction(Disassembly), used for decompilation
        return And.getName();
    }
    @Override
    public String visit(or Or){
        System.out.println(Integer.toHexString(Or.getOpcode()).toUpperCase() + "  "+ Or.getName());//output the instruction(Disassembly), used for decompilation
        return Or.getName();
    }
    @Override
    public String visit(xor Xor){
        System.out.println(Integer.toHexString(Xor.getOpcode()).toUpperCase() + "  "+ Xor.getName());//output the instruction(Disassembly), used for decompilation
        return Xor.getName();
    }
    @Override
    public String visit(not Not){
        System.out.println(Integer.toHexString(Not.getOpcode()).toUpperCase() + "  "+ Not.getName());//output the instruction(Disassembly), used for decompilation
        return Not.getName();
    }
    @Override
    public String visit(bytee Bytee){
        System.out.println(Integer.toHexString(Bytee.getOpcode()).toUpperCase() + "  "+ Bytee.getName());//output the instruction(Disassembly), used for decompilation
        return Bytee.getName();
    }
    @Override
    public String visit(shl Shl){
        System.out.println(Integer.toHexString(Shl.getOpcode()).toUpperCase() + "  "+ Shl.getName());//output the instruction(Disassembly), used for decompilation
        return Shl.getName();
    }
    
    @Override
    public String visit(shr Shr){
        System.out.println(Integer.toHexString(Shr.getOpcode()).toUpperCase() + "  "+ Shr.getName());//output the instruction(Disassembly), used for decompilation
        return Shr.getName();
    }
    @Override
    public String visit(sar Sar){
        System.out.println(Integer.toHexString(Sar.getOpcode()).toUpperCase() + "  "+ Sar.getName());//output the instruction(Disassembly), used for decompilation
        return Sar.getName();
    }
    @Override
    public String visit(address Address){
        System.out.println(Integer.toHexString(Address.getOpcode()).toUpperCase() + "  "+ Address.getName());//output the instruction(Disassembly), used for decompilation
        return Address.getName();
    }
    @Override
    public String visit(balance Balance){
        System.out.println(Integer.toHexString(Balance.getOpcode()).toUpperCase() + "  "+ Balance.getName());//output the instruction(Disassembly), used for decompilation
        return Balance.getName();
    }
    @Override
    public String visit(origin Origin){
        System.out.println(Integer.toHexString(Origin.getOpcode()).toUpperCase() + "  "+ Origin.getName());//output the instruction(Disassembly), used for decompilation
        return Origin.getName();
    }
    @Override
    public String visit(caller Caller){
        System.out.println(Integer.toHexString(Caller.getOpcode()).toUpperCase() + "  "+ Caller.getName());//output the instruction(Disassembly), used for decompilation
        return Caller.getName();
    }
    @Override
    public String visit(callvalue Callvalue){
        System.out.println(Integer.toHexString(Callvalue.getOpcode()).toUpperCase() + "  "+ Callvalue.getName());//output the instruction(Disassembly), used for decompilation
        return Callvalue.getName();
    }
    @Override
    public String visit(calldataload Calldataload){
        System.out.println(Integer.toHexString(Calldataload.getOpcode()).toUpperCase() + "  "+ Calldataload.getName());//output the instruction(Disassembly), used for decompilation
        return Calldataload.getName();
    }
    @Override
    public String visit(calldatasize Calldatasize){
        System.out.println(Integer.toHexString(Calldatasize.getOpcode()).toUpperCase() + "  "+ Calldatasize.getName());//output the instruction(Disassembly), used for decompilation
        return Calldatasize.getName();
    }
    @Override
    public String visit(calldatacopy Calldatacopy){
        System.out.println(Integer.toHexString(Calldatacopy.getOpcode()).toUpperCase() + "  "+ Calldatacopy.getName());//output the instruction(Disassembly), used for decompilation
        return Calldatacopy.getName();
    }
    @Override
    public  String visit(codesize Codesize){
        System.out.println(Integer.toHexString(Codesize.getOpcode()).toUpperCase() + "  "+ Codesize.getName());//output the instruction(Disassembly), used for decompilation
        return Codesize.getName();
    }
    @Override
    public String visit(codecopy Codecopy){
        System.out.println(Integer.toHexString(Codecopy.getOpcode()).toUpperCase() + "  "+ Codecopy.getName());//output the instruction(Disassembly), used for decompilation
        return Codecopy.getName();
    }
    @Override
    public String visit(gasprice Gasprice){
        System.out.println(Integer.toHexString(Gasprice.getOpcode()).toUpperCase() + "  "+ Gasprice.getName());//output the instruction(Disassembly), used for decompilation
        return Gasprice.getName();
    }
    @Override
    public String visit(extcodesize Extcodesize){
        System.out.println(Integer.toHexString(Extcodesize.getOpcode()).toUpperCase() + "  "+ Extcodesize.getName());//output the instruction(Disassembly), used for decompilation
        return Extcodesize.getName();
    }
    @Override
    public String visit(extcodecopy Extcodecopy){
        System.out.println(Integer.toHexString(Extcodecopy.getOpcode()).toUpperCase() + "  "+ Extcodecopy.getName());//output the instruction(Disassembly), used for decompilation
        return Extcodecopy.getName();
    }
    @Override
    public String visit(returndatasize Returndatasize){
        System.out.println(Integer.toHexString(Returndatasize.getOpcode()).toUpperCase() + "  "+ Returndatasize.getName());//output the instruction(Disassembly), used for decompilation
        return Returndatasize.getName();
    }
    @Override
    public String visit(returndatacopy Returndatacopy){
        System.out.println(Integer.toHexString(Returndatacopy.getOpcode()).toUpperCase() + "  "+ Returndatacopy.getName());//output the instruction(Disassembly), used for decompilation
        return Returndatacopy.getName();
    }
    @Override
    public String visit(extcodehash Extcodehash){
        System.out.println(Integer.toHexString(Extcodehash.getOpcode()).toUpperCase() + "  "+ Extcodehash.getName());//output the instruction(Disassembly), used for decompilation
        return Extcodehash.getName();
    }
    @Override
    public String visit(blockhash Blockhash){
        System.out.println(Integer.toHexString(Blockhash.getOpcode()).toUpperCase() + "  "+ Blockhash.getName());//output the instruction(Disassembly), used for decompilation
        return Blockhash.getName();
    }
    @Override
    public String visit(coinbase Coinbase){
        System.out.println(Integer.toHexString(Coinbase.getOpcode()).toUpperCase() + "  "+ Coinbase.getName());//output the instruction(Disassembly), used for decompilation
        return Coinbase.getName();
    }
    @Override
    public String visit(timestamp Timestamp){
        System.out.println(Integer.toHexString(Timestamp.getOpcode()).toUpperCase() + "  "+ Timestamp.getName());//output the instruction(Disassembly), used for decompilation
        return Timestamp.getName();
    }
    @Override
    public String visit(number Number){
        System.out.println(Integer.toHexString(Number.getOpcode()).toUpperCase() + "  "+ Number.getName());//output the instruction(Disassembly), used for decompilation
        return Number.getName();
    }
    @Override
    public String visit(difficulty Difficulty){
        System.out.println(Integer.toHexString(Difficulty.getOpcode()).toUpperCase() + "  "+ Difficulty.getName());//output the instruction(Disassembly), used for decompilation
        return Difficulty.getName();
    }
    @Override
    public String visit(gaslimit Gaslimit){
        System.out.println(Integer.toHexString(Gaslimit.getOpcode()).toUpperCase() + "  "+ Gaslimit.getName());//output the instruction(Disassembly), used for decompilation
        return Gaslimit.getName();
    }
    @Override
    public String visit(chainid Chainid){
        System.out.println(Integer.toHexString(Chainid.getOpcode()).toUpperCase() + "  "+ Chainid.getName());//output the instruction(Disassembly), used for decompilation
        return Chainid.getName();
    }
    @Override
    public String visit(selfbalance Selfbalance){
        System.out.println(Integer.toHexString(Selfbalance.getOpcode()).toUpperCase() + "  "+ Selfbalance.getName());//output the instruction(Disassembly), used for decompilation
        return Selfbalance.getName();
    }
    @Override
    public String visit(basefee Basefee){
        System.out.println(Integer.toHexString(Basefee.getOpcode()).toUpperCase() + "  "+ Basefee.getName());//output the instruction(Disassembly), used for decompilation
        return Basefee.getName();
    }
    @Override
    public String visit(pop Pop){
        System.out.println(Integer.toHexString(Pop.getOpcode()).toUpperCase() + "  "+ Pop.getName());//output the instruction(Disassembly), used for decompilation
        return Pop.getName();
    }
    @Override
    public String visit(mload Mload){
        System.out.println(Integer.toHexString(Mload.getOpcode()).toUpperCase() + "  "+ Mload.getName());//output the instruction(Disassembly), used for decompilation
        return Mload.getName();
    }
    @Override
    public String visit(mstore Mstore){
        System.out.println(Integer.toHexString(Mstore.getOpcode()).toUpperCase() + "  "+ Mstore.getName());//output the instruction(Disassembly), used for decompilation
        return Mstore.getName();
    }
    @Override
    public String visit(mstore8 Mstore8){
        System.out.println(Integer.toHexString(Mstore8.getOpcode()).toUpperCase() + "  "+ Mstore8.getName());//output the instruction(Disassembly), used for decompilation
        return Mstore8.getName();
    }
    @Override
    public String visit(sload Sload){
        System.out.println(Integer.toHexString(Sload.getOpcode()).toUpperCase() + "  "+ Sload.getName());//output the instruction(Disassembly), used for decompilation
        return Sload.getName();
    }
    @Override
    public String visit(sstore Sstore){
        System.out.println(Integer.toHexString(Sstore.getOpcode()).toUpperCase() + "  "+ Sstore.getName());//output the instruction(Disassembly), used for decompilation
        return Sstore.getName();
    }
    @Override
    public String visit(jump Jump){
        System.out.println(Integer.toHexString(Jump.getOpcode()).toUpperCase() + "  "+ Jump.getName());//output the instruction(Disassembly), used for decompilation
        return Jump.getName();
    }
    @Override
    public String visit(jumpi Jumpi){
        System.out.println(Integer.toHexString(Jumpi.getOpcode()).toUpperCase() + "  "+ Jumpi.getName());//output the instruction(Disassembly), used for decompilation
        return Jumpi.getName();
    }
    @Override
    public String visit(pc Pc){
        System.out.println(Integer.toHexString(Pc.getOpcode()).toUpperCase() + "  "+ Pc.getName());//output the instruction(Disassembly), used for decompilation
        return Pc.getName();
    }
    @Override
    public String visit(msize Msize){
        System.out.println(Integer.toHexString(Msize.getOpcode()).toUpperCase() + "  "+ Msize.getName());//output the instruction(Disassembly), used for decompilation
        return Msize.getName();
    }
    @Override
    public String visit(gas Gas){
        System.out.println(Integer.toHexString(Gas.getOpcode()).toUpperCase() + "  "+ Gas.getName());//output the instruction(Disassembly), used for decompilation
        return Gas.getName();
    }
    @Override
    public String visit(jumpdest Jumpdest){
        System.out.println(Integer.toHexString(Jumpdest.getOpcode()).toUpperCase() + "  "+ Jumpdest.getName());//output the instruction(Disassembly), used for decompilation
        return Jumpdest.getName();
    }
    
    @Override
    public String visit(create Create){
        System.out.println(Integer.toHexString(Create.getOpcode()).toUpperCase() + "  "+ Create.getName());//output the instruction(Disassembly), used for decompilation
        return Create.getName();
    }
    @Override
    public String visit(call Call){
        System.out.println(Integer.toHexString(Call.getOpcode()).toUpperCase() + "  "+ Call.getName());//output the instruction(Disassembly), used for decompilation
        return Call.getName();
    }
    @Override
    public String visit(callcode Callcode){
        System.out.println(Integer.toHexString(Callcode.getOpcode()).toUpperCase() + "  "+ Callcode.getName());//output the instruction(Disassembly), used for decompilation
        return Callcode.getName();
    }
    @Override
    public String visit(return_ Return_){
        System.out.println(Integer.toHexString(Return_.getOpcode()).toUpperCase() + "  "+ Return_.getName());//output the instruction(Disassembly), used for decompilation
        return Return_.getName();
    }
    @Override
    public String visit(delegatecall Delegatecall){
        System.out.println(Integer.toHexString(Delegatecall.getOpcode()).toUpperCase() + "  "+ Delegatecall.getName());//output the instruction(Disassembly), used for decompilation
        return Delegatecall.getName();
    }
    @Override
    public String visit(create2 Create2){
        System.out.println(Integer.toHexString(Create2.getOpcode()).toUpperCase() + "  "+ Create2.getName());//output the instruction(Disassembly), used for decompilation
        return Create2.getName();
    }
    @Override
    public String visit(staticcall Staticcall){
        System.out.println(Integer.toHexString(Staticcall.getOpcode()).toUpperCase() + "  "+ Staticcall.getName());//output the instruction(Disassembly), used for decompilation
        return Staticcall.getName();
    }
    @Override
    public String visit(revert Revert){
        System.out.println(Integer.toHexString(Revert.getOpcode()).toUpperCase() + "  "+ Revert.getName());//output the instruction(Disassembly), used for decompilation
        return Revert.getName();
    }
    @Override
    public String visit(invalid Invalid){
        System.out.println(Integer.toHexString(Invalid.getOpcode()).toUpperCase() + "  "+ Invalid.getName());//output the instruction(Disassembly), used for decompilation
        return Invalid.getName();
    }
    @Override
    public String visit(selfdestruct Selfdestruct){
        System.out.println(Integer.toHexString(Selfdestruct.getOpcode()).toUpperCase() + "  "+ Selfdestruct.getName());//output the instruction(Disassembly), used for decompilation
        return Selfdestruct.getName();
    }
}

