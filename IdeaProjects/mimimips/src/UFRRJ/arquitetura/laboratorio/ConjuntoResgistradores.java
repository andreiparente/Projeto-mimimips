package UFRRJ.arquitetura.laboratorio;

import java.util.HashMap;

/**
 * Created by Guilherme Cruz Freitas on 22/06/17.
 */
public class ConjuntoResgistradores {

    /**conjunto de todos os 32 registradores, feito com vetor ao invés de arraylist pois o número do registrador
     * será seu indice
     */



    public static Registrador[] Registradores={
            new Registrador("$zero", 0, 0),
            new Registrador("$at", 1, 0),
            new Registrador("$v0", 2, 0),
            new Registrador("$v1", 3, 0),
            new Registrador("$a0", 4, 0),
            new Registrador("$a1", 5, 0),
            new Registrador("$a2", 6, 0),
            new Registrador("$a3", 7, 0),
            new Registrador("$t0", 8, 0),
            new Registrador("$t1", 9, 0),
            new Registrador("$t2", 10, 0),
            new Registrador("$t3", 11, 0),
            new Registrador("$t4", 12, 0),
            new Registrador("$t5", 13, 0),
            new Registrador("$t6", 14, 0),
            new Registrador("$t7", 15, 0),
            new Registrador("$s0", 16, 0),
            new Registrador("$s1", 17, 0),
            new Registrador("$s2", 18, 0),
            new Registrador("$s3", 19, 0),
            new Registrador("$s4", 20, 0),
            new Registrador("$s5", 21, 0),
            new Registrador("$s6", 22, 0),
            new Registrador("$s7", 23, 0),
            new Registrador("$t8", 24, 0),
            new Registrador("$t9", 25, 0),
            new Registrador("$k0", 26, 0),
            new Registrador("$k1", 27, 0),
            new Registrador("$gp", 28, 268468224),
            new Registrador("$sp", 29, 2147479548),
            new Registrador("$fp", 30, 0),
            new Registrador("$ra", 31, 0),
            new Registrador("pc", 32, 4194304),
            new Registrador("hi", 33, 0),//se a muliplicação passar de 2147483647, guardar aqui, em divisão, é o resto
            new Registrador("lo", 34, 0),//guarda a mult até 2147483647, em divisão, o quociente

    };

    /**
     * implementação futura dos registradores pc hi lo
     */


    /**
     * conjunto de funções para setar, regatar etc informções dos registradores
     */


    /*protected HashMap<String, Registrador> registradorMap;
    public ConjuntoResgistradores() {
        registradorMap = new HashMap<>();

        registradorMap.put("$zero", new Registrador("$zero", 0, 0));
        registradorMap.put("$at", new Registrador("$at", 1, 0));
        registradorMap.put("$v0", new Registrador("$v0", 2, 0));
        registradorMap.put("$v1", new Registrador("$v1", 3, 0));
        registradorMap.put("$a0", new Registrador("$a0", 4, 0));
        registradorMap.put("$a1", new Registrador("$a1", 5, 0));
        registradorMap.put("$a2", new Registrador("$a2", 6, 0));
        registradorMap.put("$a3", new Registrador("$a3", 7, 0));
        registradorMap.put("$t0", new Registrador("$t0", 8, 0));
        registradorMap.put("$t1", new Registrador("$t1", 9, 0));
        registradorMap.put("$t2", new Registrador("$t2", 10, 0));
        registradorMap.put("$t3", new Registrador("$t3", 11, 0));
        registradorMap.put("$t4", new Registrador("$t4", 12, 0));
        registradorMap.put("$t5", new Registrador("$t5", 13, 0));
        registradorMap.put("$t6", new Registrador("$t6", 14, 0));
        registradorMap.put("$t7", new Registrador("$t7", 15, 0));
        registradorMap.put("$s0", new Registrador("$s0", 16, 0));
        registradorMap.put("$s1", new Registrador("$s1", 17, 0));
        registradorMap.put("$s2", new Registrador("$s2", 18, 0));
        registradorMap.put("$s3", new Registrador("$s3", 19, 0));
        registradorMap.put("$s4", new Registrador("$s4", 20, 0));
        registradorMap.put("$s5", new Registrador("$s5", 21, 0));
        registradorMap.put("$s6", new Registrador("$s6", 22, 0));
        registradorMap.put("$s7", new Registrador("$s7", 23, 0));
        registradorMap.put("$t8", new Registrador("$t8", 24, 0));
        registradorMap.put("$t9", new Registrador("$t9", 25, 0));
        registradorMap.put("$k0", new Registrador("$k0", 26, 0));
        registradorMap.put("$k1", new Registrador("$k1", 27, 0));
        registradorMap.put("$gp", new Registrador("$gp", 28, 268468224));
        registradorMap.put("$sp", new Registrador("$sp", 29, 2147479548));
        registradorMap.put("$fp", new Registrador("$fp", 30, 0));
        registradorMap.put("$ra", new Registrador("$ra", 31, 0));
    }*/

    public static void setValorRegistrador(String nome, int valor)
    {
        if(Registradores[0].getNome().equals(nome)  || Registradores[1].getNome().equals(nome)) {

        }

        for(int i = 2; i<32; i++)
        {

            if(Registradores[i].getNome().equals(nome))
            {
                Registradores[i].setValor(valor);
                break;
            }
        }
    }







}
