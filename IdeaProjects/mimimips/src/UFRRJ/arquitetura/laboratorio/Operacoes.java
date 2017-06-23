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
        op = op & 31;
        return op;

    }

    public static int getFunc(int palavra)
    {
        return palavra & 63;

    }

    /**
     * A seguir, conjunto de função separadas por tipo da palavra
     *
     */
    public static void add(int rs, int rt, int rd)
    {

         ConjuntoRegistradores.Registradores[rd].setValor(ConjuntoRegistradores.Registradores[rs].getValor() +
                                                           ConjuntoRegistradores.Registradores[rt].getValor());
            //TODO: lançar um erro em caso de overflow, o addu que ignora overflow

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }


    public static void addu(int rs, int rt, int rd)//33
    {
        ConjuntoRegistradores.Registradores[rd].setValor(ConjuntoRegistradores.Registradores[rs].getValor() +
                ConjuntoRegistradores.Registradores[rt].getValor());

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }


    public static void sub(int rs, int rt, int rd)//34
    {
        ConjuntoRegistradores.Registradores[rd].setValor(ConjuntoRegistradores.Registradores[rs].getValor() -
                ConjuntoRegistradores.Registradores[rt].getValor());

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
        //TODO: lançar um erro em caso de overflow, o subu que ignora overflow
    }



    public static void subu(int rs, int rt, int rd)//35
    {
        ConjuntoRegistradores.Registradores[rd].setValor(ConjuntoRegistradores.Registradores[rs].getValor() -
                ConjuntoRegistradores.Registradores[rt].getValor());

        ConjuntoRegistradores.Registradores[32].setValor(ConjuntoRegistradores.Registradores[32].getValor()+4);
    }


    public static void mul(int rs, int rt)//24
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
    }


   /* public static void add(int rs, int rt, int rd){}


    public static void add(int rs, int rt, int rd){}


    public static void add(int rs, int rt, int rd){}


    public static void add(int rs, int rt, int rd){}


    public static void add(int rs, int rt, int rd){}*/







}
