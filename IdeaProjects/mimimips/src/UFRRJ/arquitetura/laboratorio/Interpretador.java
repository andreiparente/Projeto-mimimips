package UFRRJ.arquitetura.laboratorio;

import com.sun.javafx.fxml.expression.BinaryExpression;

/**
 * Created by windows on 22/06/17.
 */
public class Interpretador{

    /**
     * chegar em casa, lembrar de transformar a palavra nos devidos setores verificando o tipo da instrução, ento, usa os shifts para colocar cada coisa no lugar
     */
    public int palavra;

    public void interpretar(int palavra)
    {
        int a = palavra;
        if(a >> 26 == 0)//verifica se a palavra é tipo R
        {
            int function = palavra & 31;

            switch(function){
                case 1:
                    Operacoes.add();
            }
        }

    }


}
