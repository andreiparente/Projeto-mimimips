package UFRRJ.arquitetura.laboratorio;

/**
 * Created by windows on 22/06/17.
 */
public class Operacoes {



    /**
     * conjunto de funções utilizadas ara retirar os devidos campos das palavras
     * *********************faltando adress******************
     *
     *
     */



    public static int getRs(int palavra)
    {
        int rs = palavra >> 21;
        rs = rs & 31;
        return rs;
    }

    public static int getRt(int palavra)
    {
        int rt = palavra >> 16;
        rt = rt & 31;
        return rt;
    }

    public static int getRd(int palavra)
    {
        int rd = palavra >> 11;
        rd = rd & 31;
        return rd;
    }

    public static int getOp(int palavra)
    {
        int op = palavra >> 26;
        op = op & 63;
        return op;
    }

    public static int getShamt(int palavra)
    {
        int shamt = palavra >> 6;
        shamt &= 31;
        return shamt;
    }

    public static int getFunc(int palavra)
    {
        return palavra & 63;
    }

    public static int getI(int palavra)
    {
        return palavra & 65535;
    }

    public static int getTarget(int palavra)
    {
        return palavra & 67108863;
    }

    /**
     * A seguir, conjunto de função separadas por tipo da palavra
     *
     */
    public static void nop()//op 0, funct
    {
        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }


    ///////
    /////// UNIDADE DE ARITMÉTICA LÓGICA ///////
    ///////
    public static void add(int rs, int rt, int rd)//op 0, funct 32
    {

         ConjuntoRegistradores.Registradores[rd].setValor(ConjuntoRegistradores.Registradores[rs].getValor() +
                                                           ConjuntoRegistradores.Registradores[rt].getValor());
            //TODO: lançar um erro em caso de overflow, o addu que ignora overflow

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void addi(int rs, int rt, int imediato)//op 8
    {
        ConjuntoRegistradores.Registradores[rt].setValor(ConjuntoRegistradores.Registradores[rs].getValor() +
                imediato);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void addiu(int rs, int rt, int imediato)//op 9
    {
        ConjuntoRegistradores.Registradores[rt].setValor(ConjuntoRegistradores.Registradores[rs].getValor() +
                imediato);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void addu(int rs, int rt, int rd)//op 0, funct 33
    {
        ConjuntoRegistradores.Registradores[rd].setValor(ConjuntoRegistradores.Registradores[rs].getValor() +
                ConjuntoRegistradores.Registradores[rt].getValor());

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void and(int rs, int rt, int rd)//op 0, funct 36
    {
        ConjuntoRegistradores.Registradores[rd].setValor(ConjuntoRegistradores.Registradores[rs].getValor() &
                ConjuntoRegistradores.Registradores[rt].getValor());

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void andi(int rs, int rt, int imediato)//op 12
    {
        ConjuntoRegistradores.Registradores[rt].setValor(ConjuntoRegistradores.Registradores[rs].getValor() &
                imediato);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void lui(int rt, int imediato)//op 15
    {
        ConjuntoRegistradores.Registradores[rt].setValor(imediato << 16);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void nor(int rs, int rt, int rd)//op 0, funct 39 Analisar se está correto por causa do complementod de 2
    {
        ConjuntoRegistradores.Registradores[rd].setValor(~(ConjuntoRegistradores.Registradores[rs].getValor() |
                ConjuntoRegistradores.Registradores[rt].getValor()));

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void or(int rs, int rt, int rd)//op 0, funct 37
    {
        ConjuntoRegistradores.Registradores[rd].setValor(ConjuntoRegistradores.Registradores[rs].getValor() |
                ConjuntoRegistradores.Registradores[rt].getValor());

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void ori(int rs, int rt, int imediato)//op 13
    {
        ConjuntoRegistradores.Registradores[rt].setValor(ConjuntoRegistradores.Registradores[rs].getValor() |
                imediato);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void slt(int rs, int rt, int rd)//op 0, funct 42
    {
        if(ConjuntoRegistradores.Registradores[rs].getValor() < ConjuntoRegistradores.Registradores[rt].getValor())
            ConjuntoRegistradores.Registradores[rd].setValor(1);
        else
            ConjuntoRegistradores.Registradores[rd].setValor(0);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void slti(int rs, int rt, int imediato)//op 10
    {
        if(ConjuntoRegistradores.Registradores[rs].getValor() < imediato)
            ConjuntoRegistradores.Registradores[rt].setValor(1);
        else
            ConjuntoRegistradores.Registradores[rt].setValor(0);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void sltiu(int rs, int rt, int imediato)//op 11
    {
        if(ConjuntoRegistradores.Registradores[rs].getValor() < imediato)
            ConjuntoRegistradores.Registradores[rt].setValor(1);
        else
            ConjuntoRegistradores.Registradores[rt].setValor(0);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void sltu(int rs, int rt, int rd)//op 0, funct 43
    {
        if(ConjuntoRegistradores.Registradores[rs].getValor() < ConjuntoRegistradores.Registradores[rt].getValor())
            ConjuntoRegistradores.Registradores[rd].setValor(1);
        else
            ConjuntoRegistradores.Registradores[rd].setValor(0);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void sub(int rs, int rt, int rd)//op 0, funct 34
    {
        ConjuntoRegistradores.Registradores[rd].setValor(ConjuntoRegistradores.Registradores[rs].getValor() -
                ConjuntoRegistradores.Registradores[rt].getValor());

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
        //TODO: lançar um erro em caso de overflow, o subu que ignora overflow
    }



    public static void subu(int rs, int rt, int rd)//op 0, funct 35
    {
        ConjuntoRegistradores.Registradores[rd].setValor(ConjuntoRegistradores.Registradores[rs].getValor() -
                ConjuntoRegistradores.Registradores[rt].getValor());

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void xor(int rs, int rt, int rd)//op 0, funct 38
    {
        ConjuntoRegistradores.Registradores[rd].setValor(ConjuntoRegistradores.Registradores[rs].getValor() ^
                ConjuntoRegistradores.Registradores[rt].getValor());

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void xori(int rs, int rt, int imediato)//op 14
    {
        ConjuntoRegistradores.Registradores[rt].setValor(ConjuntoRegistradores.Registradores[rs].getValor() ^
                imediato);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }
    ///////
    /////// SHIFTERS ///////
    ///////
    public static void sll(int rt, int rd, int shamt)//op 0, funct 0
    {
        ConjuntoRegistradores.Registradores[rd].setValor(ConjuntoRegistradores.Registradores[rt].getValor() <<
                shamt);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void sllv(int rs, int rt, int rd)//op 0, funct 4
    {
        ConjuntoRegistradores.Registradores[rd].setValor(ConjuntoRegistradores.Registradores[rt].getValor() <<
                (ConjuntoRegistradores.Registradores[rs].getValor() & 31)); //pois é somente os 5 bits menores

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void sra(int rt, int rd, int shamt)//op 0, funct 3
    {
        ConjuntoRegistradores.Registradores[rd].setValor(ConjuntoRegistradores.Registradores[rt].getValor() >>
                shamt);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void srav(int rs, int rt, int rd)//op 0, funct 7
    {
        ConjuntoRegistradores.Registradores[rd].setValor(ConjuntoRegistradores.Registradores[rt].getValor() >>
                (ConjuntoRegistradores.Registradores[rs].getValor() & 31)); //pois é somente os 5 bits menores

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void srl(int rt, int rd, int shamt)//op 0, funct 2
    {
        ConjuntoRegistradores.Registradores[rd].setValor(ConjuntoRegistradores.Registradores[rt].getValor() >>>
                shamt);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void srlv(int rs, int rt, int rd)//op 0, funct 6
    {
        ConjuntoRegistradores.Registradores[rd].setValor(ConjuntoRegistradores.Registradores[rt].getValor() >>>
                (ConjuntoRegistradores.Registradores[rs].getValor() & 31)); //pois é somente os 5 bits menores

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }
    ///////
    /////// MULTIPLICAÇÃO ///////
    ///////
    public static void div(int rs, int rt)//op 0, funct 26
    {
        ConjuntoRegistradores.Registradores[33].setValor(ConjuntoRegistradores.Registradores[rs].getValor() %
                ConjuntoRegistradores.Registradores[rt].getValor());
        ConjuntoRegistradores.Registradores[34].setValor(ConjuntoRegistradores.Registradores[rs].getValor() /
                ConjuntoRegistradores.Registradores[rt].getValor());

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void divu(int rs, int rt)//op 0, funct 27
    {
        ConjuntoRegistradores.Registradores[33].setValor(ConjuntoRegistradores.Registradores[rs].getValor() %
                ConjuntoRegistradores.Registradores[rt].getValor());
        ConjuntoRegistradores.Registradores[34].setValor(ConjuntoRegistradores.Registradores[rs].getValor() /
                ConjuntoRegistradores.Registradores[rt].getValor());

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void mfhi(int rd)//op 0, funct 10
    {
        ConjuntoRegistradores.Registradores[rd].setValor(ConjuntoRegistradores.Registradores[33].getValor());

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void mflo(int rd)//op 0, funct 12
    {
        ConjuntoRegistradores.Registradores[rd].setValor(ConjuntoRegistradores.Registradores[34].getValor());

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void mthi(int rs)//op 0, funct 17
    {
        ConjuntoRegistradores.Registradores[33].setValor(ConjuntoRegistradores.Registradores[rs].getValor());

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void mtlo(int rs)//op 0, funct 19
    {
        ConjuntoRegistradores.Registradores[34].setValor(ConjuntoRegistradores.Registradores[rs].getValor());

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void mult(int rs, int rt)//op 0, funct 24
    {
        int x = (1 << 32) - 1;
        int y = ConjuntoRegistradores.Registradores[rs].getValor()* ConjuntoRegistradores.Registradores[rt].getValor();

        ConjuntoRegistradores.Registradores[34].setValor(x & y);
        ConjuntoRegistradores.Registradores[33].setValor((x << 32) & y);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void multu(int rs, int rt)//op 0, funct 25
    {
        int x = (1 << 32) - 1;
        int y = ConjuntoRegistradores.Registradores[rs].getValor()* ConjuntoRegistradores.Registradores[rt].getValor();

        ConjuntoRegistradores.Registradores[34].setValor(x & y);
        ConjuntoRegistradores.Registradores[33].setValor(x & (y << 32));

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }
    ///////
    /////// BRANCH ///////
    ///////
    public static void beq(int rs, int rt, int offset)//op 4
    {
        if(ConjuntoRegistradores.Registradores[rt].getValor() == ConjuntoRegistradores.Registradores[rs].getValor())
            ConjuntoRegistradores.Registradores[32].setValor(offset);

        else
            ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void bge(int rs, int rt, int offset)//op ?  TALVEZ ERRADO
    {
        if(ConjuntoRegistradores.Registradores[rt].getValor() >= ConjuntoRegistradores.Registradores[rs].getValor())
            ConjuntoRegistradores.Registradores[32].setValor(offset);

        else
            ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void bgez(int rs, int offset)//op 1, rt 1
    {
        if(ConjuntoRegistradores.Registradores[rs].getValor() >= 0)
            ConjuntoRegistradores.Registradores[32].setValor(offset);

        else
            ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void bgezal(int rs, int offset)//op 1, rt 17
    {

        if(ConjuntoRegistradores.Registradores[rs].getValor() >= 0) {
            ConjuntoRegistradores.Registradores[31].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
            ConjuntoRegistradores.Registradores[32].setValor(offset);
        }

        else
            ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void bgt(int rs, int rt, int offset)//op ?
    {
        if(ConjuntoRegistradores.Registradores[rt].getValor() > ConjuntoRegistradores.Registradores[rs].getValor())
            ConjuntoRegistradores.Registradores[32].setValor(offset);

        else
            ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void bgtz(int rs, int offset)//op 7
    {
        if(ConjuntoRegistradores.Registradores[rs].getValor() > 0)
            ConjuntoRegistradores.Registradores[32].setValor(offset);

        else
            ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void ble(int rs, int rt, int offset)//op ?
    {
        if(ConjuntoRegistradores.Registradores[rt].getValor() <= ConjuntoRegistradores.Registradores[rs].getValor())
            ConjuntoRegistradores.Registradores[32].setValor(offset);

        else
            ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void blez(int rs, int offset)//op 6
    {
        if(ConjuntoRegistradores.Registradores[rs].getValor() <= 0)
            ConjuntoRegistradores.Registradores[32].setValor(offset);

        else
            ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void blt(int rs, int rt, int offset)//op ?
    {
        if(ConjuntoRegistradores.Registradores[rt].getValor() < ConjuntoRegistradores.Registradores[rs].getValor())
            ConjuntoRegistradores.Registradores[32].setValor(offset);

        else
            ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void bltz(int rs, int offset)//op 1, rt 0
    {
        if(ConjuntoRegistradores.Registradores[rs].getValor() < 0)
            ConjuntoRegistradores.Registradores[32].setValor(offset);

        else
            ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void bltzal(int rs, int offset)//op 1, rt 16
    {
        if(ConjuntoRegistradores.Registradores[rs].getValor() < 0) {
            ConjuntoRegistradores.Registradores[31].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
            ConjuntoRegistradores.Registradores[32].setValor(offset);
        }

        else
            ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void bne(int rs, int rt, int offset)//op 5
    {
        if(ConjuntoRegistradores.Registradores[rt].getValor() != ConjuntoRegistradores.Registradores[rs].getValor())
            ConjuntoRegistradores.Registradores[32].setValor(offset);

        else
            ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    // public static void break(){}

    public static void j(int target)//op 2
    {
        ConjuntoRegistradores.Registradores[32].setValor(target);
    }

    public static void jal(int target)//op 3
    {
        ConjuntoRegistradores.Registradores[31].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);

        ConjuntoRegistradores.Registradores[32].setValor(target);
    }

    public static void jalr(int rs, int rd)//op 0, funct 9
    {
        ConjuntoRegistradores.Registradores[rd].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[rs].getValor());
    }

    public static void jr(int rs)//op 0, funct 8
    {
        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[rs].getValor());
    }

    // public static void syscall(){}

    ///////
    /////// ACESSO A MEMÓRIA ///////
    ///////

    // public static void lb(int rs, int rt, int offset){}

    // public static void lbu(int rs, int rt, int offset){}

    // public static void lh(int rs, int rt, int offset)

    // public static void lhu(int rs, int rt, int offset)

    public static void lw(int rs, int rt, int offset)//op ?
    {
        ConjuntoRegistradores.Registradores[rt].setValor(ConjuntoRegistradores.Registradores[rs+offset].getValor());

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    // public static void sb(int rs, int rt, int offset){}

    // public static void sh(int rs, int rt, int offset){}

    public static void sw(int rs, int rt, int offset)//op ?
    {
        ConjuntoRegistradores.Registradores[rs+offset].setValor(ConjuntoRegistradores.Registradores[rt].getValor());

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    /*public static void mul(int rs, int rt)//24
    {
        if(ConjuntoRegistradores.Registradores[rs].getValor()* ConjuntoRegistradores.Registradores[rt].getValor() > 2147483647)
        {
            ConjuntoRegistradores.Registradores[34].setValor(2147483647);
            ConjuntoRegistradores.Registradores[33].setValor(ConjuntoRegistradores.Registradores[rs].getValor() *
                                                              ConjuntoRegistradores.Registradores[rt].getValor()-2147483647);
        }

        else
        {
            ConjuntoRegistradores.Registradores[34].setValor(ConjuntoRegistradores.Registradores[rs].getValor() *
                                                              ConjuntoRegistradores.Registradores[rt].getValor());
        }

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }


    public static void mulu(int rs, int rt)//25
    {
        ConjuntoRegistradores.Registradores[33].setValor(ConjuntoRegistradores.Registradores[rs].getValor() *
                                                          ConjuntoRegistradores.Registradores[rt].getValor());


        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }*/

}
