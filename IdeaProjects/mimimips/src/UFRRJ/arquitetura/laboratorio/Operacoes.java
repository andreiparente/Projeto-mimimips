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
     * @param palavra
     */



    public static long getRs(long palavra)
    {
        long rs = palavra >> 21;
        rs = rs & 31;
        return rs;
    }

    public static long getRt(long palavra)
    {
        long rt = palavra >> 16;
        rt = rt & 31;
        return rt;
    }

    public static long getRd(long palavra)
    {
        long rd = palavra >> 11;
        rd = rd & 31;
        return rd;
    }

    public static long getOp(long palavra)
    {
        long op = palavra >> 26;
        op = op & 63;
        return op;
    }

    public static long getShamt(long palavra)
    {
        long shamt = palavra >> 6;
        shamt &= 31;
        return shamt;
    }

    public static long getFunc(long palavra)
    {
        return palavra & 63;
    }

    public static long getI(long palavra)
    {
        return (palavra << 48) >> 48;
    }

    public static long getTarget(long palavra)
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
    public static void add(long rs, long rt, long rd)//op 0, funct 32
    {

         ConjuntoRegistradores.Registradores[(int) rd].setValor(ConjuntoRegistradores.Registradores[(int) rs].getValor() +
                                                           ConjuntoRegistradores.Registradores[(int) rt].getValor());
            //TODO: lançar um erro em caso de overflow, o addu que ignora overflow

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void addi(long rs, long rt, long imediato)//op 8
    {
        ConjuntoRegistradores.Registradores[(int) rt].setValor(ConjuntoRegistradores.Registradores[(int) rs].getValor() +
                imediato);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void addiu(long rs, long rt, long imediato)//op 9
    {
        ConjuntoRegistradores.Registradores[(int) rt].setValor(ConjuntoRegistradores.Registradores[(int) rs].getValor() +
                imediato);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void addu(long rs, long rt, long rd)//op 0, funct 33
    {
        ConjuntoRegistradores.Registradores[(int) rd].setValor(ConjuntoRegistradores.Registradores[(int) rs].getValor() +
                ConjuntoRegistradores.Registradores[(int) rt].getValor());

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void and(long rs, long rt, long rd)//op 0, funct 36
    {
        ConjuntoRegistradores.Registradores[(int) rd].setValor(ConjuntoRegistradores.Registradores[(int) rs].getValor() &
                ConjuntoRegistradores.Registradores[(int) rt].getValor());

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void andi(long rs, long rt, long imediato)//op 12
    {
        ConjuntoRegistradores.Registradores[(int) rt].setValor(ConjuntoRegistradores.Registradores[(int) rs].getValor() &
                imediato);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void lui(long rt, long imediato)//op 15
    {
        ConjuntoRegistradores.Registradores[(int) rt].setValor(imediato << 16);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void nor(long rs, long rt, long rd)//op 0, funct 39 Analisar se está correto por causa do complementod de 2
    {
        ConjuntoRegistradores.Registradores[(int) rd].setValor(~(ConjuntoRegistradores.Registradores[(int) rs].getValor() |
                ConjuntoRegistradores.Registradores[(int) rt].getValor()));

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void or(long rs, long rt, long rd)//op 0, funct 37
    {
        ConjuntoRegistradores.Registradores[(int) rd].setValor(ConjuntoRegistradores.Registradores[(int) rs].getValor() |
                ConjuntoRegistradores.Registradores[(int) rt].getValor());

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void ori(long rs, long rt, long imediato)//op 13
    {
        ConjuntoRegistradores.Registradores[(int) rt].setValor(ConjuntoRegistradores.Registradores[(int) rs].getValor() |
                imediato);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void slt(long rs, long rt, long rd)//op 0, funct 42
    {
        if(ConjuntoRegistradores.Registradores[(int) rs].getValor() < ConjuntoRegistradores.Registradores[(int) rt].getValor())
            ConjuntoRegistradores.Registradores[(int) rd].setValor(1);
        else
            ConjuntoRegistradores.Registradores[(int) rd].setValor(0);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void slti(long rs, long rt, long imediato)//op 10
    {
        if(ConjuntoRegistradores.Registradores[(int) rs].getValor() < imediato)
            ConjuntoRegistradores.Registradores[(int) rt].setValor(1);
        else
            ConjuntoRegistradores.Registradores[(int) rt].setValor(0);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void sltiu(long rs, long rt, long imediato)//op 11
    {
        if(ConjuntoRegistradores.Registradores[(int) rs].getValor() < imediato)
            ConjuntoRegistradores.Registradores[(int) rt].setValor(1);
        else
            ConjuntoRegistradores.Registradores[(int) rt].setValor(0);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void sltu(long rs, long rt, long rd)//op 0, funct 43
    {
        if(ConjuntoRegistradores.Registradores[(int) rs].getValor() < ConjuntoRegistradores.Registradores[(int) rt].getValor())
            ConjuntoRegistradores.Registradores[(int) rd].setValor(1);
        else
            ConjuntoRegistradores.Registradores[(int) rd].setValor(0);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void sub(long rs, long rt, long rd)//op 0, funct 34
    {
        ConjuntoRegistradores.Registradores[(int) rd].setValor(ConjuntoRegistradores.Registradores[(int) rs].getValor() -
                ConjuntoRegistradores.Registradores[(int) rt].getValor());

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
        //TODO: lançar um erro em caso de overflow, o subu que ignora overflow
    }



    public static void subu(long rs, long rt, long rd)//op 0, funct 35
    {
        ConjuntoRegistradores.Registradores[(int) rd].setValor(ConjuntoRegistradores.Registradores[(int) rs].getValor() -
                ConjuntoRegistradores.Registradores[(int) rt].getValor());

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void xor(long rs, long rt, long rd)//op 0, funct 38
    {
        ConjuntoRegistradores.Registradores[(int) rd].setValor(ConjuntoRegistradores.Registradores[(int) rs].getValor() ^
                ConjuntoRegistradores.Registradores[(int) rt].getValor());

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void xori(long rs, long rt, long imediato)//op 14
    {
        ConjuntoRegistradores.Registradores[(int) rt].setValor(ConjuntoRegistradores.Registradores[(int) rs].getValor() ^
                imediato);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }
    ///////
    /////// SHIFTERS ///////
    ///////
    public static void sll(long rt, long rd, long shamt)//op 0, funct 0
    {
        ConjuntoRegistradores.Registradores[(int) rd].setValor(ConjuntoRegistradores.Registradores[(int) rt].getValor() <<
                shamt);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void sllv(long rs, long rt, long rd)//op 0, funct 4
    {
        ConjuntoRegistradores.Registradores[(int) rd].setValor(ConjuntoRegistradores.Registradores[(int) rt].getValor() <<
                (ConjuntoRegistradores.Registradores[(int) rs].getValor() & 31)); //pois é somente os 5 bits menores

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }



    public static void sra(long rt, long rd, long shamt)//op 0, funct 3
    {
        ConjuntoRegistradores.Registradores[(int) rd].setValor(ConjuntoRegistradores.Registradores[(int) rt].getValor() >>
                shamt);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void srav(long rs, long rt, long rd)//op 0, funct 7
    {
        ConjuntoRegistradores.Registradores[(int) rd].setValor(ConjuntoRegistradores.Registradores[(int) rt].getValor() >>
                (ConjuntoRegistradores.Registradores[(int) rs].getValor())); //pois é somente os 5 bits menores

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void srl(long rt, long rd, long shamt)//op 0, funct 2
    {
        ConjuntoRegistradores.Registradores[(int) rd].setValor(ConjuntoRegistradores.Registradores[(int) rt].getValor() >>>
                shamt);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void srlv(long rs, long rt, long rd)//op 0, funct 6
    {
        ConjuntoRegistradores.Registradores[(int) rd].setValor(ConjuntoRegistradores.Registradores[(int) rt].getValor() >>>
                (ConjuntoRegistradores.Registradores[(int) rs].getValor() & 31)); //pois é somente os 5 bits menores

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }
    ///////
    /////// MULTIPLICAÇÃO ///////
    ///////
    public static void div(long rs, long rt)//op 0, funct 26
    {
        ConjuntoRegistradores.Registradores[33].setValor(ConjuntoRegistradores.Registradores[(int) rs].getValor() %
                ConjuntoRegistradores.Registradores[(int) rt].getValor());
        ConjuntoRegistradores.Registradores[34].setValor(ConjuntoRegistradores.Registradores[(int) rs].getValor() /
                ConjuntoRegistradores.Registradores[(int) rt].getValor());

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void divu(long rs, long rt)//op 0, funct 27
    {
        ConjuntoRegistradores.Registradores[33].setValor(ConjuntoRegistradores.Registradores[(int) rs].getValor() %
                ConjuntoRegistradores.Registradores[(int) rt].getValor());
        ConjuntoRegistradores.Registradores[34].setValor(ConjuntoRegistradores.Registradores[(int) rs].getValor() /
                ConjuntoRegistradores.Registradores[(int) rt].getValor());

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void mfhi(long rd)//op 0, funct 10
    {
        ConjuntoRegistradores.Registradores[(int) rd].setValor(ConjuntoRegistradores.Registradores[33].getValor());

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void mflo(long rd)//op 0, funct 12
    {
        ConjuntoRegistradores.Registradores[(int) rd].setValor(ConjuntoRegistradores.Registradores[34].getValor());

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void mthi(long rs)//op 0, funct 17
    {
        ConjuntoRegistradores.Registradores[33].setValor(ConjuntoRegistradores.Registradores[(int) rs].getValor());

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void mtlo(long rs)//op 0, funct 19
    {
        ConjuntoRegistradores.Registradores[34].setValor(ConjuntoRegistradores.Registradores[(int) rs].getValor());

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void mult(long rs, long rt)//op 0, funct 24
    {
        long x = (1 << 16) - 1;
        long y = ConjuntoRegistradores.Registradores[(int) rs].getValor()* ConjuntoRegistradores.Registradores[(int) rt].getValor();

        ConjuntoRegistradores.Registradores[34].setValor((x & y) + (x << 16) & y);
        ConjuntoRegistradores.Registradores[33].setValor((y - ConjuntoRegistradores.Registradores[34].getValor())
                >> 32);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void multu(long rs, long rt)//op 0, funct 25
    {
        long x = (1 << 16) - 1;
        long y = ConjuntoRegistradores.Registradores[(int) rs].getValor()* ConjuntoRegistradores.Registradores[(int) rt].getValor();

        ConjuntoRegistradores.Registradores[34].setValor((x & y) + (x << 16) & y);
        ConjuntoRegistradores.Registradores[33].setValor((y - ConjuntoRegistradores.Registradores[34].getValor())
                >> 32);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }
    ///////
    /////// BRANCH ///////
    ///////
    public static void beq(long rs, long rt, long offset)//op 4
    {
        if(ConjuntoRegistradores.Registradores[(int) rt].getValor() == ConjuntoRegistradores.Registradores[(int) rs].getValor())
            ConjuntoRegistradores.Registradores[32].setValor(offset);

        else
            ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void bge(long rs, long rt, long offset)//op ?  TALVEZ ERRADO
    {
        if(ConjuntoRegistradores.Registradores[(int) rt].getValor() >= ConjuntoRegistradores.Registradores[(int) rs].getValor())
            ConjuntoRegistradores.Registradores[32].setValor(offset);

        else
            ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void bgez(long rs, long offset)//op 1, rt 1
    {
        if(ConjuntoRegistradores.Registradores[(int) rs].getValor() >= 0)
            ConjuntoRegistradores.Registradores[32].setValor(offset);

        else
            ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void bgezal(long rs, long offset)//op 1, rt 17
    {

        if(ConjuntoRegistradores.Registradores[(int) rs].getValor() >= 0) {
            ConjuntoRegistradores.Registradores[31].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
            ConjuntoRegistradores.Registradores[32].setValor(offset);
        }

        else
            ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void bgt(long rs, long rt, long offset)//op ?
    {
        if(ConjuntoRegistradores.Registradores[(int) rt].getValor() > ConjuntoRegistradores.Registradores[(int) rs].getValor())
            ConjuntoRegistradores.Registradores[32].setValor(offset);

        else
            ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void bgtz(long rs, long offset)//op 7
    {
        if(ConjuntoRegistradores.Registradores[(int) rs].getValor() > 0)
            ConjuntoRegistradores.Registradores[32].setValor(offset);

        else
            ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void ble(long rs, long rt, long offset)//op ?
    {
        if(ConjuntoRegistradores.Registradores[(int) rt].getValor() <= ConjuntoRegistradores.Registradores[(int) rs].getValor())
            ConjuntoRegistradores.Registradores[32].setValor(offset);

        else
            ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void blez(long rs, long offset)//op 6
    {
        if(ConjuntoRegistradores.Registradores[(int) rs].getValor() <= 0)
            ConjuntoRegistradores.Registradores[32].setValor(offset);

        else
            ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void blt(long rs, long rt, long offset)//op ?
    {
        if(ConjuntoRegistradores.Registradores[(int) rt].getValor() < ConjuntoRegistradores.Registradores[(int) rs].getValor())
            ConjuntoRegistradores.Registradores[32].setValor(offset);

        else
            ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void bltz(long rs, long offset)//op 1, rt 0
    {
        if(ConjuntoRegistradores.Registradores[(int) rs].getValor() < 0)
            ConjuntoRegistradores.Registradores[32].setValor(offset);

        else
            ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void bltzal(long rs, long offset)//op 1, rt 16
    {
        if(ConjuntoRegistradores.Registradores[(int) rs].getValor() < 0) {
            ConjuntoRegistradores.Registradores[31].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
            ConjuntoRegistradores.Registradores[32].setValor(offset);
        }

        else
            ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    public static void bne(long rs, long rt, long offset)//op 5
    {
        if(ConjuntoRegistradores.Registradores[(int) rt].getValor() != ConjuntoRegistradores.Registradores[(int) rs].getValor())
            ConjuntoRegistradores.Registradores[32].setValor(offset);

        else
            ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    // public static void break(){}

    public static void j(long target)//op 2
    {
        ConjuntoRegistradores.Registradores[32].setValor(target);
    }

    public static void jal(long target)//op 3
    {
        ConjuntoRegistradores.Registradores[31].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);

        ConjuntoRegistradores.Registradores[32].setValor(target);
    }

    public static void jalr(long rs)//op 0, funct 9
    {
        ConjuntoRegistradores.Registradores[31].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[(int) rs].getValor());
    }

    public static void jr(long rs)//op 0, funct 8
    {
        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[(int) rs].getValor());
    }

    // public static void syscall(){}

    ///////
    /////// ACESSO A MEMÓRIA ///////
    ///////

    // public static void lb(long rs, long rt, long offset){}

    // public static void lbu(long rs, long rt, long offset){}

    // public static void lh(long rs, long rt, long offset)

    // public static void lhu(long rs, long rt, long offset)

    public static void lw(long rs, long rt, long offset)//op 35
    {
        ConjuntoRegistradores.Registradores[(int) rt].setValor(Memoria.memValor[(int) (ConjuntoRegistradores.Registradores[(int) rs].getValor()
                        +(offset/4))]);

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    // public static void sb(long rs, long rt, long offset){}

    // public static void sh(long rs, long rt, long offset){}

    public static void sw(long rs, long rt, long offset)//op 43
    {
        Memoria.memValor[(int) (ConjuntoRegistradores.Registradores[(int) rs].getValor()+offset/4)] =
                (int) ConjuntoRegistradores.Registradores[(int) rt].getValor();

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }

    /*public static void mul(long rs, long rt)//24
    {
        if(ConjuntoRegistradores.Registradores[(int) rs].getValor()* ConjuntoRegistradores.Registradores[(int) rt].getValor() > 2147483647)
        {
            ConjuntoRegistradores.Registradores[34].setValor(2147483647);
            ConjuntoRegistradores.Registradores[33].setValor(ConjuntoRegistradores.Registradores[(int) rs].getValor() *
                                                              ConjuntoRegistradores.Registradores[(int) rt].getValor()-2147483647);
        }

        else
        {
            ConjuntoRegistradores.Registradores[34].setValor(ConjuntoRegistradores.Registradores[(int) rs].getValor() *
                                                              ConjuntoRegistradores.Registradores[(int) rt].getValor());
        }

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }


    public static void mulu(long rs, long rt)//25
    {
        ConjuntoRegistradores.Registradores[33].setValor(ConjuntoRegistradores.Registradores[(int) rs].getValor() *
                                                          ConjuntoRegistradores.Registradores[(int) rt].getValor());


        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }*/

}
