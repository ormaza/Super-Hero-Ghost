/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ormaza
 */
public class Recordes extends JFrame{
    
    private JPanel painel;
    private JTable jtable;
    private DefaultTableModel table;
    private String[] nomes = new String[50];
    private int[] pontos = new int[50];
    private int numCadastrados=1;
    private String[] cols = new String[2];
    
    public void initTable() {
    	table =  new DefaultTableModel(cols,0);
	jtable =  new JTable(table);
                
        setSize(200, 500);
	setLocation(50,80);
        setResizable(false);
                
        JScrollPane scroll = new JScrollPane(jtable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	getContentPane().add(scroll, BorderLayout.CENTER);
                
        painel = new JPanel();
        painel.add(jtable);
	add(painel);

        jtable.setSelectionBackground(Color.ORANGE);
    }
    
    private void insertionSort() {
        int j;
        int key;
        int i;
        String nome;
        
        for (j = 1; j < numCadastrados; j++) {
          key = pontos[j];
          nome = nomes[j];
          for (i = j - 1; (i >= 0) && (pontos[i] > key); i--) {
		  pontos[i + 1] = pontos[i];
		  nomes[i + 1] = nomes[i];
          }
          pontos[i + 1] = key;
          nomes [i + 1] = nome;
        }
    }
    
    public void listPlayers() {
    	String nome, ponto;
    	int numRow=0;
	String[] row = {cols[0],cols[1]};
	table.insertRow(numRow, row);
	insertionSort();
	for(numRow=1;numRow<=numCadastrados;numRow++) {
		nome = nomes[numCadastrados-numRow];
		ponto = ""+pontos[numCadastrados-numRow];
		String[] row2 = {nome,ponto};
    		table.insertRow(numRow, row2);
	}
    }
    
    public void addRecord(String nome, int ponto) {
    	nomes[numCadastrados] = nome;
    	pontos[numCadastrados] = ponto;
    	numCadastrados++;
    }
    
    public Recordes() {
        super("RECORDES");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	cols[0] = "Nome";
	cols[1] = "Pontos";
	initTable();
	listPlayers();
    }
     
}
