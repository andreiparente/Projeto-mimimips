package UFRRJ.arquitetura.laboratorio;

/**
 * Created by windows on 23/06/17.
 */
public class Main {

    public static void main(String[] args)
    {
        ConjuntoResgistradores.Registradores[8].setValor(2);
        ConjuntoResgistradores.Registradores[9].setValor(2);

        Interpretador.interpretar(17387552);



        System.out.println(ConjuntoResgistradores.Registradores[10].getValor());
        System.out.println(Operacoes.getRs(17387552));
        System.out.println(Operacoes.getRt(17387552));
        System.out.println(Operacoes.getRd(17387552));
        System.out.println(Operacoes.getOp(17387552));
        System.out.println(Operacoes.getFunc(17387552));
    }
}
