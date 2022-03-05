//Author Gera Jahja
package src.opcodes;
/*  Last update: 04/03
    A0 =  LOG0 (LOG0(memory[ost:ost+len]))
    A1 =  LOG1 (LOG1(memory[ost:ost+len], topic0))
    ...etc
    
    A0	LOG0 (LOG0(memory[ost:ost+len]))
    A1	LOG1 (LOG1(memory[ost:ost+len], topic0))
    A2	LOG2 (LOG1(memory[ost:ost+len], topic0, topic1))
    A3	LOG3 (LOG1(memory[ost:ost+len], topic0, topic1, topic2))
    A4	LOG4 (LOG1(memory[ost:ost+len], topic0, topic1, topic2, topic3))
    A5-EF are invalid
*/
public class log {
    
}
