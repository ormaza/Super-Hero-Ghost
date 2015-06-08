/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Ormaza
 */
public class Recordes extends JFrame{
    
    JPanel painel;
    JTable produtos;
    DefaultTableModel produtoModel;
    static String[] nomes = new String[10];
    static String[] pontos = new String[10];
    int[] point = new int[10];
    int[] ponto = new int[10];
    static int numcadastrados=1;
    
    
    public Recordes() throws IOException
    {
        super("RECORDES");
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        
        String[] cols = {"Nome","Pontos"};
		produtoModel =  new DefaultTableModel(cols,0);
		produtos =  new JTable(produtoModel);
                
                setSize(200, 500);
		setLocation(50,80);
                setResizable(false);
                
                JScrollPane auxDesc = new JScrollPane(produtos, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		getContentPane().add(auxDesc, BorderLayout.CENTER);
                
		//getContentPane().add(new JLabel("Tabela"), BorderLayout.NORTH);
                
                
                
                
                painel =  new JPanel();
                
                
                painel.add(produtos);
		add(painel);
               
		
		
                
                
                produtos.setSelectionBackground(Color.ORANGE);
                
                
                
                //listar os clientes
                
                String Nomet = "Nome",Pontost="Pontos";
				int numRow=0;
				String[] row = {Nomet,Pontost};
				produtoModel.insertRow(numRow, row);
                
                   FileWriter arq = new FileWriter("src/dados/recordes.txt");
                   PrintWriter gravarArq = new PrintWriter(arq);
 
                   gravarArq.printf("+--RECORDES--+%n");
                    
               for(numRow=1;numRow<=numcadastrados;numRow++)
               {
                  
                   
                   String Nome = nomes[numRow],Pontos = pontos[numRow];
                   
                   String[] row2 = {Nome,Pontos};
		   produtoModel.insertRow(numRow, row2);
                   
                   
                   
                   gravarArq.printf(Nome+" ------ "+Pontos+"%n");
    }
    gravarArq.printf("+-------------+%n");
 
    arq.close();
 
    System.out.printf("arquivo gravado com sucesso");



                   
                   //algoritmo de ordenaçao
                   /*
                   Integer.parseInt(pontos[numRow], point[numRow]);
                   
                   for(int i=numcadastrados;i>0;i--){
           for(int j=0;j<(numcadastrados-1);j++){
              
               if(point[j]>point[j+1]){
                   
                   String tmp=pontos[j+1];
                   pontos[j+1]=pontos[j];
                   pontos[j]=tmp;
                   
                   String tmpn=nomes[j+1];
                   nomes[j+1]=nomes[j];
                   nomes[j]=tmp;
                   
                   int tmpi=point[j+1];
                   point[j+1]=point[j];
                   point[j]=tmpi;
                   
                   
               }
               
           }
        }
               }*/
                   
                 
				
               
               //setVisible(true);
              //Gamex game = new Gamex();
              //game.run();
    }
    /*
    public static void main(String[] args) throws IOException {
		
		new Recordes().setVisible(true);

	}
        */
}
