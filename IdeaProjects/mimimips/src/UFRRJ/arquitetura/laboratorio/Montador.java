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

    public Montador() {//construtor que inicializa
        this.mapStart();
    }

    private void mapStart()
    {
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
        map.put("add",32); // op 0, funct 32, value: (100+funct)
        map.put("addu",33);
        map.put("and",36);
        map.put("or",39);
        map.put("slt",42);
        map.put("sltu",43);
        map.put("sub",34);
        map.put("subu",35);
        map.put("xor",38);
        map.put("sll",0);
        map.put("sllv",4);
        map.put("sra",3);
        map.put("srav",7);
        map.put("srl",2);
        map.put("srlv",6);
        map.put("div",26);
        map.put("divu",27);
        map.put("mfhi",10);
        map.put("mflo",12);
        map.put("mthi",17);
        map.put("mtlo",19);
        map.put("mult",24);
        map.put("multu",25);
        map.put("jalr",9);
        map.put("jr",8);
        map.put("addi",8); // op 8, value: (200+op)
        map.put("addiu",9);
        map.put("andi",12);
        map.put("lui",15);
        map.put("ori",13);
        map.put("slti",10);
        map.put("sltiu",11);
        map.put("xori",14);
        map.put("beq",4);
        /*map.put("bgez",1); // op 1, rt 1, value: (300+rt)
        map.put("bgezal",17);
        map.put("bltz",0);
        map.put("bltzal",16);*/
        map.put("bgtz",7);
        map.put("blez",6);
        map.put("bne",5);



        //todo terminar todos os hashs de função

    }

    protected void montar(String teste)
    {
        StringTokenizer st = new StringTokenizer(teste," ,'\n'");//captura toodo o texto da string "teste" e ignora to espaço, virgula e "enters"
        while(st.hasMoreTokens()) {//enquanto houverem tokens na string


            int[] padraoBinario = new int[32];//vetor que irá receber o padrão binario para criar a palavra como inteiro

            int palavra = 0;

            String firstToken = new String(st.nextToken());

            if (    firstToken.equals("add") ||
                    firstToken.equals("addu") ||
                    firstToken.equals("and") ||
                    firstToken.equals("or") ||
                    firstToken.equals("slt") ||
                    firstToken.equals("sltu") ||
                    firstToken.equals("sub") ||
                    firstToken.equals("subu") ||
                    firstToken.equals("xor") ||
                    firstToken.equals("sllv") ||
                    firstToken.equals("srav") || //NEED FIX
                    firstToken.equals("srlv")) { //NEED FIX
                    Utilidade.binarizer(0, padraoBinario, 0, 5);//começa a preencher o vetor padrão binario
                    Utilidade.binarizer(16, padraoBinario, map.get(st.nextToken()), 20);
                    Utilidade.binarizer(6, padraoBinario, map.get(st.nextToken()), 10);//busca no mapa através da string do token, então pega o valor atribuido e "binariza" no vetor
                    Utilidade.binarizer(11, padraoBinario, map.get(st.nextToken()), 15);
                    Utilidade.binarizer(21, padraoBinario, 0, 25);
                    Utilidade.binarizer(26, padraoBinario, map.get(firstToken), 31);
            }

            palavra = Utilidade.desBinarizerWord(palavra, padraoBinario);//transforma o binario em um inteiro
            Memoria.memWord.add(palavra);//armazena na memoria, onde será recuperado pelo interpretador
        }

    }

}