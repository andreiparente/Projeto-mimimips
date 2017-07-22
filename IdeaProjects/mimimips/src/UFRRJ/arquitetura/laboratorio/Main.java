package UFRRJ.arquitetura.laboratorio;

/**
 * Created by windows on 23/06/17.
 */
public class Main {

    public static void main(String[] args) {

        String teste = "mult $t1, $t0";

        Montador montador = new Montador();
        montador.montar(teste);
        teste = "mflo $t2";
        montador.montar(teste);
        Interpretador interpretador = new Interpretador();

        ConjuntoRegistradores.Registradores[8].setValor(3);
        ConjuntoRegistradores.Registradores[9].setValor(7);


        interpretador.interpretar();
        System.out.println(ConjuntoRegistradores.Registradores[34].getValor());

        System.out.println();
    }
}
