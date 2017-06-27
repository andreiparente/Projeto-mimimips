package UFRRJ.arquitetura.laboratorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by windows on 25/06/17.
 */
public class Montador
{
    HashMap<String,Integer> map = new HashMap<>();//inicializa o hashmap

    public Montador(String teste) {//construtor que inicializa
        this.mapStart();
    }

    private void mapStart()
    {
        map.put("add",32);//hash map provisório que ira servir de base para a busca dos valores dos tokens
        map.put("$zero",0);
        map.put("$at", 1);
        map.put("$v0", 2);
        map.put("$v1", 3);
        map.put("$a0", 4);
        map.put("$a1", 5);
        map.put("$a2", 6);
        map.put("$a3", 7);
        map.put("$t0", 8);
        map.put("$t1", 9);
        map.put("$t2", 10);
        map.put("$t3", 11);
        map.put("$t4", 12);
        map.put("$t5", 13);
        map.put("$t6", 14);
        map.put("$t7", 15);
        map.put("$s0", 16);
        map.put("$s1", 17);
        map.put("$s2", 18);
        map.put("$s3", 19);
        map.put("$s4", 20);
        map.put("$s5", 21);
        map.put("$s6", 22);
        map.put("$s7", 23);
        map.put("$t8", 24);
        map.put("$t9", 25);
        map.put("$k0", 26);
        map.put("$k1", 27);
        map.put("$gp", 28);
        map.put("$sp", 29);
        map.put("$fp", 30);
        map.put("$ra", 31);
        map.put("pc", 32);
        //todo terminar todos os hashs de função

    }

    protected int montar(String teste)
    {
        StringTokenizer st = new StringTokenizer(teste," ,");
        int[] padraoBinario = new int[32];

        int palavra = 0;

        switch(st.nextToken())
        {
            case "add":
            {
                Utilidade.binarizer(0,padraoBinario,0,5);
                int aux = map.get(st.nextToken());
                Utilidade.binarizer(6,padraoBinario,map.get(st.nextToken()),10);
                Utilidade.binarizer(11,padraoBinario,map.get(st.nextToken()),15);
                Utilidade.binarizer(16,padraoBinario,aux,20);
                Utilidade.binarizer(21,padraoBinario,0,25);
                Utilidade.binarizer(26,padraoBinario,32,31);

            }
        }

        int expoente = 31;
        for(int i = 0; i<32; i++)
        {

            if(padraoBinario[i] > 0)
            {
                palavra += Math.pow(2,expoente);
            }
            expoente--;
        }
        return (palavra);
    }

}