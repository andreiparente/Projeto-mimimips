package UFRRJ.arquitetura.laboratorio;


import static UFRRJ.arquitetura.laboratorio.Memoria.memWord;

/**
 * Created by windows on 22/06/17.
 */
public class Interpretador {

    /**
     * função que ira receber uma palavra (000101010101 etc) como um inteiro, e irá: separar op para decidir qual bloco de funções
     * seguir de acordo com o tipo da palavra, então, separar os registradores e chamar a função de acordo com a func no caso de palavra R
     * ou com base no op de acordo com o tipo de palavra
     */

    public void interpretar() {
        Long palavra;

        while (Memoria.index < Memoria.memWord.size()) //enquanto tiver coisa na memoria
        {

            palavra = Memoria.memWord.get(Memoria.index);

            long op = Operacoes.getOp(palavra);//pega o opcode do inteiro

            if (op == 0) {//conjunto de todos os opcodes 0
                long func = Operacoes.getFunc(palavra);//retira a func do inteiro

                switch ((int) func) {//agora passeia pela lista de funções de opcode 0
                    case 32:
                        Operacoes.add(Operacoes.getRs(palavra), Operacoes.getRt(palavra), Operacoes.getRd(palavra));
                        break;

                    case 33:
                        Operacoes.addu(Operacoes.getRs(palavra), Operacoes.getRt(palavra), Operacoes.getRd(palavra));
                        break;

                    case 36:
                        Operacoes.and(Operacoes.getRs(palavra), Operacoes.getRt(palavra), Operacoes.getRd(palavra));
                        break;

                    case 39:
                        Operacoes.or(Operacoes.getRs(palavra), Operacoes.getRt(palavra), Operacoes.getRd(palavra));
                        break;

                    case 42:
                        Operacoes.slt(Operacoes.getRs(palavra), Operacoes.getRt(palavra), Operacoes.getRd(palavra));
                        break;

                    case 43:
                        Operacoes.sltu(Operacoes.getRs(palavra), Operacoes.getRt(palavra), Operacoes.getRd(palavra));
                        break;

                    case 34:
                        Operacoes.sub(Operacoes.getRs(palavra), Operacoes.getRt(palavra), Operacoes.getRd(palavra));
                        break;

                    case 35:
                        Operacoes.subu(Operacoes.getRs(palavra), Operacoes.getRt(palavra), Operacoes.getRd(palavra));
                        break;

                    case 38:
                        Operacoes.xor(Operacoes.getRs(palavra), Operacoes.getRt(palavra), Operacoes.getRd(palavra));
                        break;

                    case 0:
                        Operacoes.sll(Operacoes.getRt(palavra), Operacoes.getRd(palavra), Operacoes.getShamt(palavra));
                        break;

                    case 4:
                        Operacoes.sllv(Operacoes.getRs(palavra), Operacoes.getRt(palavra), Operacoes.getRd(palavra));
                        break;

                    case 3:
                        Operacoes.sra(Operacoes.getRt(palavra), Operacoes.getRd(palavra), Operacoes.getShamt(palavra));
                        break;

                    case 7:
                        Operacoes.srav(Operacoes.getRs(palavra), Operacoes.getRt(palavra), Operacoes.getRd(palavra));
                        break;

                    case 2:
                        Operacoes.srl(Operacoes.getRt(palavra), Operacoes.getRd(palavra), Operacoes.getShamt(palavra));
                        break;

                    case 6:
                        Operacoes.srlv(Operacoes.getRs(palavra), Operacoes.getRt(palavra), Operacoes.getRd(palavra));
                        break;

                    case 26:
                        Operacoes.div(Operacoes.getRs(palavra), Operacoes.getRt(palavra));
                        break;

                    case 27:
                        Operacoes.divu(Operacoes.getRs(palavra), Operacoes.getRt(palavra));
                        break;

                    case 10:
                        Operacoes.mfhi(Operacoes.getRd(palavra));
                        break;

                    case 12:
                        Operacoes.mflo(Operacoes.getRd(palavra));
                        break;

                    case 17:
                        Operacoes.mthi(Operacoes.getRs(palavra));
                        break;

                    case 19:
                        Operacoes.mtlo(Operacoes.getRs(palavra));
                        break;

                    case 24:
                        Operacoes.mult(Operacoes.getRs(palavra), Operacoes.getRt(palavra));
                        break;

                    case 25:
                        Operacoes.multu(Operacoes.getRs(palavra), Operacoes.getRt(palavra));
                        break;

                    case 9:
                        Operacoes.jalr(Operacoes.getRs(palavra));
                        break;

                    case 8:
                        Operacoes.jr(Operacoes.getRs(palavra));
                        break;

                    case 20:
                        Operacoes.move(Operacoes.getRs(palavra), Operacoes.getRt(palavra));
                        break;
                }
            }
            else {
                switch ((int) op) {
                    case 8:
                        Operacoes.addi(Operacoes.getRs(palavra), Operacoes.getRt(palavra), Operacoes.getI(palavra));
                        break;

                    case 9:
                        Operacoes.addiu(Operacoes.getRs(palavra), Operacoes.getRt(palavra), Operacoes.getI(palavra));
                        break;

                    case 12:
                        Operacoes.andi(Operacoes.getRs(palavra), Operacoes.getRt(palavra), Operacoes.getI(palavra));
                        break;

                    case 15:
                        Operacoes.lui(Operacoes.getRt(palavra), Operacoes.getI(palavra));
                        break;

                    case 13:
                        Operacoes.ori(Operacoes.getRs(palavra), Operacoes.getRt(palavra), Operacoes.getI(palavra));
                        break;

                    case 10:
                        Operacoes.slti(Operacoes.getRs(palavra), Operacoes.getRt(palavra), Operacoes.getI(palavra));
                        break;

                    case 11:
                        Operacoes.sltiu(Operacoes.getRs(palavra), Operacoes.getRt(palavra), Operacoes.getI(palavra));
                        break;

                    case 14:
                        Operacoes.xori(Operacoes.getRs(palavra), Operacoes.getRt(palavra), Operacoes.getI(palavra));
                        break;

                    case 4:
                        Operacoes.beq(Operacoes.getRs(palavra), Operacoes.getRt(palavra), Operacoes.getI(palavra));
                        break;

                    case 1:
                        if(Operacoes.getRt(palavra) == 1)
                            Operacoes.bgez(Operacoes.getRs(palavra), Operacoes.getI(palavra));

                        else if(Operacoes.getRt(palavra) == 17)
                            Operacoes.bgezal(Operacoes.getRs(palavra), Operacoes.getI(palavra));

                        else if(Operacoes.getRt(palavra) == 0)
                            Operacoes.bltz(Operacoes.getRs(palavra), Operacoes.getI(palavra));

                        else if(Operacoes.getRt(palavra) == 16)
                            Operacoes.bltzal(Operacoes.getRs(palavra), Operacoes.getI(palavra));

                        break;

                    case 7:
                        Operacoes.bgtz(Operacoes.getRs(palavra), Operacoes.getI(palavra));
                        break;

                    case 6:
                        Operacoes.blez(Operacoes.getRs(palavra), Operacoes.getI(palavra));
                        break;

                    case 5:
                        Operacoes.bne(Operacoes.getRs(palavra), Operacoes.getRt(palavra), Operacoes.getI(palavra));
                        break;

                    case 2:
                        Operacoes.j(Operacoes.getTarget(palavra));
                        break;

                    case 3:
                        Operacoes.jal(Operacoes.getTarget(palavra));
                        break;

                    case 35:
                        Operacoes.lw(Operacoes.getRs(palavra), Operacoes.getRt(palavra), Operacoes.getI(palavra));
                        break;

                    case 43:
                        Operacoes.sw(Operacoes.getRs(palavra), Operacoes.getRt(palavra), Operacoes.getI(palavra));
                        break;

                    case 21:
                        Operacoes.li(Operacoes.getRt(palavra), Operacoes.getI(palavra));
                        break;

                    case 22:
                        Operacoes.blt(Operacoes.getRs(palavra), Operacoes.getRt(palavra), Operacoes.getI(palavra));
                        break;

                    case 23:
                        Operacoes.ble(Operacoes.getRs(palavra), Operacoes.getRt(palavra), Operacoes.getI(palavra));
                        break;

                    case 24:
                        Operacoes.bgt(Operacoes.getRs(palavra), Operacoes.getRt(palavra), Operacoes.getI(palavra));
                        break;

                    case 25:
                        Operacoes.bge(Operacoes.getRs(palavra), Operacoes.getRt(palavra), Operacoes.getI(palavra));
                        break;
                }
            }
            Memoria.index++;//passa para o próximo item da memoria
        }
    }
}
