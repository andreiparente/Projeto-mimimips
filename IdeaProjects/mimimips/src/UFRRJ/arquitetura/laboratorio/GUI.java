package UFRRJ.arquitetura.laboratorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Created by windows on 03/07/17.
 */
public class GUI {
    private JTextArea campoDeCodigo;
    private JButton compilar;
    private JPanel Janela;
    private JTable Registradores;
    private JTabbedPane tabbedPane1;
    private JPanel Código;
    private JTable DataMem;
    private Montador montador;
    Interpretador interpretador;

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new GUI().Janela);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public GUI() {


        montador = new Montador();
        interpretador = new Interpretador();
        ConjuntoRegistradores.Registradores[8].setValor(2);
        ConjuntoRegistradores.Registradores[9].setValor(2);
        String[] colunas = {"Registrador","Número","Valor"};
        String[] colunasMem = {"Adress","(+4)","(+8)","(+12)","(+16)","(+20)","(+24)","(+28)","(+32)"};
        DefaultTableModel regis = new DefaultTableModel();
        DefaultTableModel dataMem = new DefaultTableModel();
        regis.setColumnIdentifiers(colunas);
        dataMem.setColumnIdentifiers(colunasMem);


        DataMem.setModel(dataMem);
        Registradores.setModel(regis);


        dataMem.addRow(new Object[]{0,0,0,0,0,0,0,0,0});
        dataMem.addRow(new Object[]{0,0,0,0,0,0,0,0,0});
        dataMem.addRow(new Object[]{0,0,0,0,0,0,0,0,0});
        dataMem.addRow(new Object[]{0,0,0,0,0,0,0,0,0});
        dataMem.addRow(new Object[]{0,0,0,0,0,0,0,0,0});
        dataMem.addRow(new Object[]{0,0,0,0,0,0,0,0,0});
        dataMem.addRow(new Object[]{0,0,0,0,0,0,0,0,0});
        dataMem.addRow(new Object[]{0,0,0,0,0,0,0,0,0});
        dataMem.addRow(new Object[]{0,0,0,0,0,0,0,0,0});
        dataMem.addRow(new Object[]{0,0,0,0,0,0,0,0,0});
        dataMem.addRow(new Object[]{0,0,0,0,0,0,0,0,0});
        dataMem.addRow(new Object[]{0,0,0,0,0,0,0,0,0});
        dataMem.addRow(new Object[]{0,0,0,0,0,0,0,0,0});
        dataMem.addRow(new Object[]{0,0,0,0,0,0,0,0,0});
        dataMem.addRow(new Object[]{0,0,0,0,0,0,0,0,0});
        dataMem.addRow(new Object[]{0,0,0,0,0,0,0,0,0});



        compilar.addActionListener(e -> {
            String teste;
            teste = campoDeCodigo.getText();//pega toodo o texto e manda para uma string a ser tokenizada e jogada no montador
            montador.montar(teste);//monta e joga na memoria
            interpretador.interpretar();//pega na memoria e interpreta
            System.out.println(ConjuntoRegistradores.Registradores[10].getValor());//printa no terminal, é provisório, apenas para acompanharmos como está indo

            while(regis.getRowCount()>0){
                regis.removeRow(0);}


            for (int index = 0; index < 35; index++)
            {
                regis.addRow(new Object[]{ConjuntoRegistradores.Registradores[index].getNome(),
                                        ConjuntoRegistradores.Registradores[index].getNumero(),
                                        ConjuntoRegistradores.Registradores[index].getValor()}
                                        );
            }

            for (int index = 0; index < 35; index++)
            {
                ConjuntoRegistradores.Registradores[index].setValor(ConjuntoRegistradores.Registradores[index].getValorBase());
            }


///////////////////////////////////////////////////////LOGICA DA MEMORIA DATA SEGMENT//////////////////////////////////



            int indiceMemoria = 0;
            for(int i = 0; i<16; i++)//total de linhas da tabela de memoria
            {
                for(int j = 1; j<9; j++)//percorrendo agora as colunas, deixando sempre a primeira para o endereço de memoria
                {
                    dataMem.setValueAt(Memoria.memValor[indiceMemoria++],i,j);//seta o conteudo da memoria
                }


                dataMem.setValueAt(268501216L + (32*i),i,0);
            }

            for (int index = 0; index < 128; index++)
            {
                Memoria.memValor[index] = 0;
            }
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ConjuntoRegistradores.Registradores[8].setValor(2);
            ConjuntoRegistradores.Registradores[9].setValor(2);

        });
    }
}
