package UFRRJ.arquitetura.laboratorio;
import java.io.FileOutputStream;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

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
    private JButton geraBinario;
    private JButton abrirArquivo;
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
        String[] colunas = {"Registrador","Número","Valor"};
        String[] colunasMem = {"Adress","(+0)","(+4)","(+8)","(+12)","(+16)","(+20)","(+24)","(+28)"};
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
            //Memoria.memWord.clear();

        });


        geraBinario.addActionListener(e->{
            String teste;
            teste = campoDeCodigo.getText();//pega toodo o texto e manda para uma string a ser tokenizada e jogada no montador
            montador.montar(teste);//monta e joga na memoria
            interpretador.interpretar();//pega na memoria e interpreta


            long padraoBinario[] = new long[32];

            try
            {
                FileOutputStream arquivoBin = new FileOutputStream("binario.txt");
                PrintWriter pr = new PrintWriter(arquivoBin);

                for(Long mem : Memoria.memWord)
                {
                    Utilidade.binarizer(0,padraoBinario,mem,31);
                    for(int i = 0; i<32; i++)
                        pr.print(padraoBinario[i]);
                    pr.print('\n');

                }

                pr.close();
                arquivoBin.close();

            }catch(Exception a)
            {
                System.out.println("Não foi possível geraro arquivo");
            }

            Memoria.memWord.clear();

            //addi $t0,$t0,3

        });
    }
}
