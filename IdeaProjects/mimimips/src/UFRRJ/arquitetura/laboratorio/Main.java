package UFRRJ.arquitetura.laboratorio;

/**
 * Created by windows on 23/06/17.
 */
public class Main {

    public static void main(String[] args) {
        ConjuntoRegistradores.Registradores[8].setValor(2);
        ConjuntoRegistradores.Registradores[9].setValor(2);

        Interpretador.interpretar(17387552);
        System.out.println(ConjuntoRegistradores.Registradores[32].getValor());
        Interpretador.interpretar(17387552);
        System.out.println(ConjuntoRegistradores.Registradores[32].getValor());
        Interpretador.interpretar(17387552);


        System.out.println(ConjuntoRegistradores.Registradores[10].getValor());
        System.out.println(ConjuntoRegistradores.Registradores[32].getValor());

    }
}
