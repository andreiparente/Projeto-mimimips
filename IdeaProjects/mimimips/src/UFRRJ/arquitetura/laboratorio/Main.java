package UFRRJ.arquitetura.laboratorio;

/**
 * Created by windows on 23/06/17.
 */
public class Main {

    public static void main(String[] args) {

        String teste = "add $t2, $t1, $t0";

        Montador montador = new Montador(teste);
        Interpretador interpretador = new Interpretador();

        ConjuntoRegistradores.Registradores[8].setValor(2);
        ConjuntoRegistradores.Registradores[9].setValor(2);


        interpretador.interpretar(montador.montar(teste));
        System.out.println(ConjuntoRegistradores.Registradores[10].getValor());

        System.out.println(montador.montar(teste));






    }
}
