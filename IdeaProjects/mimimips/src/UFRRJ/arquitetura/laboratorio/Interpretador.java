package UFRRJ.arquitetura.laboratorio;

import com.sun.javafx.fxml.expression.BinaryExpression;

import static UFRRJ.arquitetura.laboratorio.Memoria.memWord;

/**
 * Created by windows on 22/06/17.
 */
public class Interpretador {

    /**
     * função que ira receber uma palavra (000101010101 etc) como um inteiro, e irá: separar op para decidir qual bloco de funções
     * seguir de acordo com o tipo da palavra, então, separar os registradores e chamar a função de acordo com a func no caso de palavra R
     * ou com base no op de acordo com o tipo de palavra
     */

    public void interpretar() {
        int palavra;

        while (Memoria.index < Memoria.memWord.size()) //enquanto tiver coisa na memoria
        {

            palavra = Memoria.memWord.get(Memoria.index);

            int op = Operacoes.getOp(palavra);//pega o opcode do inteiro

            if (op == 0) {//conjunto de todos os opcodes 0
                int func = Operacoes.getFunc(palavra);//retira a func do inteiro

                switch (func) {//agora passeia pela lista de funções de opcode 0
                    case 32:
                        Operacoes.add(Operacoes.getRs(palavra), Operacoes.getRt(palavra), Operacoes.getRd(palavra));
                }
            }


            Memoria.index++;//passa para o próximo item da memoria

        }
    }


}
