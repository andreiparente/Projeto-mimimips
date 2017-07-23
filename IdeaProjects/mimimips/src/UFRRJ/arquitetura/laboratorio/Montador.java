package UFRRJ.arquitetura.laboratorio;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by windows on 25/06/17.
 */
public class Montador {
    HashMap<String, Integer> map = new HashMap<>();//inicializa o hashmap

    public Montador() {//construtor que inicializa
        this.mapStart();
    }

    private void mapStart() {
        map.put("$zero", 0);
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
        map.put("add", 32);
        map.put("addu", 33);
        map.put("and", 36);
        map.put("or", 39);
        map.put("slt", 42);
        map.put("sltu", 43);
        map.put("sub", 34);
        map.put("subu", 35);
        map.put("xor", 38);
        map.put("sll", 0);
        map.put("sllv", 4);
        map.put("sra", 3);
        map.put("srav", 7);
        map.put("srl", 2);
        map.put("srlv", 6);
        map.put("div", 26);
        map.put("divu", 27);
        map.put("mfhi", 10);
        map.put("mflo", 12);
        map.put("mthi", 17);
        map.put("mtlo", 19);
        map.put("mult", 24);
        map.put("multu", 25);
        map.put("jalr", 9);
        map.put("jr", 8);
        map.put("addi", 8);
        map.put("addiu", 9);
        map.put("andi", 12);
        map.put("lui", 15);
        map.put("ori", 13);
        map.put("slti", 10);
        map.put("sltiu", 11);
        map.put("xori", 14);
        map.put("beq", 4);
        map.put("bgez",1);
        map.put("bgezal",1);
        map.put("bltz",1);
        map.put("bltzal",1);
        map.put("bgtz", 7);
        map.put("blez", 6);
        map.put("bne", 5);
        map.put("j", 2);
        map.put("jal", 3);
        map.put("lw", 35);
        map.put("sw", 43);


        //todo terminar todos os hashs de função

    }

    protected void montar(String teste) {
        StringTokenizer st = new StringTokenizer(teste, " ,'\n'()");//captura toodo o texto da string "teste" e ignora to espaço, virgula e "enters"
       try {
           while (st.hasMoreTokens()) {//enquanto houverem tokens na string


               int[] padraoBinario = new int[32];//vetor que irá receber o padrão binario para criar a palavra como inteiro

               long palavra = 0;

               String firstToken = new String(st.nextToken());

               if (firstToken.equals("add") ||
                       firstToken.equals("addu") ||
                       firstToken.equals("and") ||
                       firstToken.equals("or") ||
                       firstToken.equals("slt") ||
                       firstToken.equals("sltu") ||
                       firstToken.equals("sub") ||
                       firstToken.equals("subu") ||
                       firstToken.equals("xor")) {
                   Utilidade.binarizer(0, padraoBinario, 0, 5);//começa a preencher o vetor padrão binario
                   Utilidade.binarizer(16, padraoBinario, map.get(st.nextToken()), 20);
                   Utilidade.binarizer(6, padraoBinario, map.get(st.nextToken()), 10);//busca no mapa através da string do token, então pega o valor atribuido e "binariza" no vetor
                   Utilidade.binarizer(11, padraoBinario, map.get(st.nextToken()), 15);
                   Utilidade.binarizer(21, padraoBinario, 0, 25);
                   Utilidade.binarizer(26, padraoBinario, map.get(firstToken), 31);
               } else if (firstToken.equals("sllv") ||
                       firstToken.equals("srav") ||
                       firstToken.equals("srlv")) {
                   Utilidade.binarizer(0, padraoBinario, 0, 5);
                   Utilidade.binarizer(16, padraoBinario, map.get(st.nextToken()), 20);
                   Utilidade.binarizer(11, padraoBinario, map.get(st.nextToken()), 15);
                   Utilidade.binarizer(6, padraoBinario, map.get(st.nextToken()), 10);
                   Utilidade.binarizer(21, padraoBinario, 0, 25);
                   Utilidade.binarizer(26, padraoBinario, map.get(firstToken), 31);
               } else if (firstToken.equals("sll") ||
                       firstToken.equals("sra") ||
                       firstToken.equals("srl")) {
                   Utilidade.binarizer(0, padraoBinario, 0, 5);
                   Utilidade.binarizer(16, padraoBinario, map.get(st.nextToken()), 20);
                   Utilidade.binarizer(6, padraoBinario, 0, 10);
                   Utilidade.binarizer(11, padraoBinario, map.get(st.nextToken()), 15);
                   Utilidade.binarizer(21, padraoBinario, Integer.parseInt(st.nextToken()), 25);
                   Utilidade.binarizer(26, padraoBinario, map.get(firstToken), 31);
               } else if (firstToken.equals("div") ||
                       firstToken.equals("divu") ||
                       firstToken.equals("mult") ||
                       firstToken.equals("multu")) {
                   Utilidade.binarizer(0, padraoBinario, 0, 5);
                   Utilidade.binarizer(16, padraoBinario, 0, 20);
                   Utilidade.binarizer(6, padraoBinario, map.get(st.nextToken()), 10);
                   Utilidade.binarizer(11, padraoBinario, map.get(st.nextToken()), 15);
                   Utilidade.binarizer(21, padraoBinario, 0, 25);
                   Utilidade.binarizer(26, padraoBinario, map.get(firstToken), 31);
               } else if (firstToken.equals("mfhi") ||
                       firstToken.equals("mflo")) {
                   Utilidade.binarizer(0, padraoBinario, 0, 5);
                   Utilidade.binarizer(16, padraoBinario, map.get(st.nextToken()), 20);
                   Utilidade.binarizer(6, padraoBinario, 0, 10);
                   Utilidade.binarizer(11, padraoBinario, 0, 15);
                   Utilidade.binarizer(21, padraoBinario, 0, 25);
                   Utilidade.binarizer(26, padraoBinario, map.get(firstToken), 31);
               } else if (firstToken.equals("mthi") ||
                       firstToken.equals("mtlo") ||
                       firstToken.equals("jr")) {
                   Utilidade.binarizer(0, padraoBinario, 0, 5);
                   Utilidade.binarizer(16, padraoBinario, 0, 20);
                   Utilidade.binarizer(6, padraoBinario, map.get(st.nextToken()), 10);
                   Utilidade.binarizer(11, padraoBinario, 0, 15);
                   Utilidade.binarizer(21, padraoBinario, 0, 25);
                   Utilidade.binarizer(26, padraoBinario, map.get(firstToken), 31);
               } else if (firstToken.equals("jalr")) {
                   Utilidade.binarizer(0, padraoBinario, 0, 5);
                   Utilidade.binarizer(6, padraoBinario, map.get(st.nextToken()), 10);
                   Utilidade.binarizer(11, padraoBinario, 0, 15);
                   Utilidade.binarizer(21, padraoBinario, 0, 25);
                   Utilidade.binarizer(26, padraoBinario, map.get(firstToken), 31);
               } else if (firstToken.equals("addi") ||
                       firstToken.equals("addiu") ||
                       firstToken.equals("andi") ||
                       firstToken.equals("ori") ||
                       firstToken.equals("slti") ||
                       firstToken.equals("sltiu") ||
                       firstToken.equals("xori") ||
                       firstToken.equals("beq") ||
                       firstToken.equals("bne")) {
                   Utilidade.binarizer(0, padraoBinario, map.get(firstToken), 5);
                   Utilidade.binarizer(11, padraoBinario, map.get(st.nextToken()), 15);
                   Utilidade.binarizer(6, padraoBinario, map.get(st.nextToken()), 10);
                   Utilidade.binarizer(16, padraoBinario, Integer.parseInt(st.nextToken()), 31);
               } else if (firstToken.equals("lw") ||
                       firstToken.equals("sw")) {
                   Utilidade.binarizer(0, padraoBinario, map.get(firstToken), 5);
                   Utilidade.binarizer(11, padraoBinario, map.get(st.nextToken()), 15);
                   Utilidade.binarizer(16, padraoBinario, Integer.parseInt(st.nextToken()), 31);
                   Utilidade.binarizer(6, padraoBinario, map.get(st.nextToken()), 10);
               } else if (firstToken.equals("lui")) {
                   Utilidade.binarizer(0, padraoBinario, map.get(firstToken), 5);
                   Utilidade.binarizer(6, padraoBinario, 0, 10);
                   Utilidade.binarizer(11, padraoBinario, map.get(st.nextToken()), 15);
                   Utilidade.binarizer(16, padraoBinario, Integer.parseInt(st.nextToken()), 31);
               } else if (firstToken.equals("bgez") ||
                       firstToken.equals("bgezal") ||
                       firstToken.equals("bltz") ||
                       firstToken.equals("bltzal") ||
                       firstToken.equals("bgtz") ||
                       firstToken.equals("blez")) {
                   if (firstToken.equals("bgez"))
                       Utilidade.binarizer(11, padraoBinario, 1, 15);
                   else if (firstToken.equals("bgezal"))
                       Utilidade.binarizer(11, padraoBinario, 17, 15);
                   else if (firstToken.equals("bltz"))
                       Utilidade.binarizer(11, padraoBinario, 0, 15);
                   else if (firstToken.equals("bltzal"))
                       Utilidade.binarizer(11, padraoBinario, 16, 15);

                   Utilidade.binarizer(0, padraoBinario, map.get(firstToken), 5);
                   Utilidade.binarizer(6, padraoBinario, map.get(st.nextToken()), 10);
                   Utilidade.binarizer(16, padraoBinario, Integer.parseInt(st.nextToken()), 31);
               } else if (firstToken.equals("j") ||
                       firstToken.equals("jal")) {
                   Utilidade.binarizer(0, padraoBinario, map.get(firstToken), 5);
                   Utilidade.binarizer(6, padraoBinario, Integer.parseInt(st.nextToken()), 31);
               }

               palavra = Utilidade.desBinarizerWord(palavra, padraoBinario);//transforma o binario em um inteiro
               Memoria.memWord.add(palavra);//armazena na memoria, onde será recuperado pelo interpretador
           }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Não foi possível prosseguir com a montagem da palavra, por favor, verifique alguma entrada inválida");
       }
    }
}