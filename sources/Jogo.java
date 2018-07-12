/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Ormaza
 */
public class Jogo extends JFrame implements KeyListener {
    
    private JButton player, comida1, comida2, comida3, comida4, comida5, bomba1, bomba2, bomba3;
    private JLabel lbpontos, fundo;
    private int pontos;
    private int px1, py1, px2, py2, px3, py3, px4, py4, px5, py5, ex1, ey1, ex2, ey2, ex3, ey3;
    private ImageIcon apple = new ImageIcon("src/images/apple.png");
    private ImageIcon cenario = new ImageIcon("src/images/cenario.jpg");
    private ImageIcon ghost = new ImageIcon("src/images/player.png");
    private ImageIcon bomb = new ImageIcon("src/images/bomb.png");
    private String nome;
    private boolean stateSave = false;
    private Recordes recordes = new Recordes();
    
    private int planoX = 0;
    private int planoY = 0;
    private int FPS = 30;
    private int janelaW = 1000;
    private int janelaH = 500;
 
    // caracteristicas do jogador
    private int posX, posY, tamX, tamY;
    
    //calcular posicoes iniciais dos outros atores
    private int randX = 100;
    private int randY = 500;
    private int offset = 1000;
    private int size = 50;
    
    private int dist=25; //intervalo de segurança para colisão
    
    private void inicializarPosicao() {
	posX = 200;
	posY = 200;
	tamX = 80;
	tamY = 60;
	px1 = getPosition(randX, offset);
	py1 = getPosition(randY, 0);
	px2 = getPosition(randX, offset);
	py2 = getPosition(randY, 0);
	px3 = getPosition(randX, offset);
	py3 = getPosition(randY, 0);
	px4 = getPosition(randX, offset);
	py4 = getPosition(randY, 0);
	px5 = getPosition(randX, offset);
	py5 = getPosition(randY, 0);
	ex1 = getPosition(randX, offset);
	ey1 = getPosition(randY, 0);
	ex2 = getPosition(randX, offset);
	ey2 = getPosition(randY, 0);
	ex3 = getPosition(randX, offset);
	ey3 = getPosition(randY, 0);
    }
    
    private void detectaColisao() {
	if(posY>=py1-dist && posY<=py1+dist)
		  if(posX>=px1-dist && posX<=px1+dist) {
			  pontos++;  
			  px1 = getPosition(randX, offset);
			  py1 = getPosition(randY, 0);}
		  
  	if(posY>=py2-dist && posY<=py2+dist)
		  if(posX>=px2-dist && posX<=px2+dist) {
			  pontos++;  
			  px2 = getPosition(randX, offset);
			  py2 = getPosition(randY, 0);}

  	if(posY>=py3-dist && posY<=py3+dist)
		  if(posX>=px3-dist && posX<=px3+dist) {
			  pontos++;  
			  px3 = getPosition(randX, offset);
			  py3 = getPosition(randY, 0);}

  	if(posY>=py4-dist && posY<=py4+dist)
		  if(posX>=px4-dist && posX<=px4+dist) {
			  pontos++;  
			  px4 = getPosition(randX, offset);
			  py4 = getPosition(randY, 0);}

  	if(posY>=py5-dist && posY<=py5+dist)
		  if(posX>=px5-dist && posX<=px5+dist) {
			  pontos++;  
			  px5 = getPosition(randX, offset);
			  py5 = getPosition(randY, 0);}

  	if(posY>=ey1-dist && posY<=ey1+dist)
	     	if(posX>=ex1-dist && posX<=ex1+dist) {
		 	if(!stateSave) recorde();}

  	if(posY>=ey2-dist && posY<=ey2+dist)
	     	if(posX>=ex2-dist && posX<=ex2+dist) {
			 if(!stateSave) recorde();}

  	if(posY>=ey3-dist && posY<=ey3+dist)
	     	if(posX>=ex3-dist && posX<=ex3+dist) {
			 if(!stateSave) recorde();}
    }
    
    private void foraDosLimites() {
	  if(px1<0) {px1 = getPosition(randX, offset); py1 = getPosition(randX, 0);}
	  if(px2<0) {px2 = getPosition(randX, offset); py2 = getPosition(randX, 0);}
	  if(px3<0) {px3 = getPosition(randX, offset); py3 = getPosition(randX, 0);}
	  if(px4<0) {px4 = getPosition(randX, offset); py4 = getPosition(randX, 0);}
	  if(px5<0) {px5 = getPosition(randX, offset); py5 = getPosition(randX, 0);}
	  if(ex1<0) {ex1 = getPosition(randX, offset); ey1 = getPosition(randX, 0);}
	  if(ex2<0) {ex2 = getPosition(randX, offset); ey2 = getPosition(randX, 0);}
	  if(ex3<0) {ex3 = getPosition(randX, offset); ey3 = getPosition(randX, 0);}

	  if(posX>900) posX=890;
	  if(posX<0) posX=10;
	  if(posY<0) posY=10;
	  if(posY>400) posY=390;
    }
    
    private void desenharGraficos() {
    	  player.setBounds(posX, posY, tamX, tamY);
	  comida1.setBounds(px1,py1,size,size);
	  comida2.setBounds(px2,py2,size,size);
	  comida3.setBounds(px3,py3,size,size);
          comida4.setBounds(px4,py4,size,size);
          comida5.setBounds(px5,py5,size,size);
	  bomba1.setBounds(ex1,ey1,size,size);
	  bomba2.setBounds(ex2,ey2,size,size);
          bomba3.setBounds(ex3,ey3,size,size);

	  detectaColisao();
	  foraDosLimites();

	  lbpontos.setText("Pontos: "+pontos);        
    }
    
    private int getPosition(int rand, int offset) {
	Random gerador = new Random();  
	int numero = gerador.nextInt(rand);
	numero = numero + offset;
	return numero;
    }
    
    private void velocidade(int v1,int v2,int v3,int v4,int v5,int v6,int v7,int v8) {
	px1=px1-v1;
	px2=px2-v2;
	px3=px3-v3;
	px4=px4-v4;
	px5=px5-v5;
	ex1=ex1-v6;
	ex2=ex2-v7;
	ex3=ex3-v8;         
    }
    
    private void recorde() {
    	stateSave = true;
        nome = JOptionPane.showInputDialog("Digite seu nome");
        
        recordes.addRecord(nome, pontos);
        recordes.initTable();
        recordes.listPlayers();

        pontos = 0;
        stateSave = false;
        
        inicializarPosicao(); //reinicializar
    }
    
    private void inicializarAtor(JButton ator) {
    	ator.setBorder(BorderFactory.createLineBorder(Color.white));
    	ator.setOpaque(false);
    	ator.setBorderPainted(false);
    	ator.setContentAreaFilled(false);
    }
    
    private void inicializarGraficos() {
	  player = new JButton(ghost);
  	  inicializarAtor(player);
  	  add(player);
    
  	  comida1 = new JButton(apple);
  	  inicializarAtor(comida1);
  	  add(comida1);
    
  	  comida2 = new JButton(apple);
  	  inicializarAtor(comida2);
  	  add(comida2);
    
  	  comida3 = new JButton(apple);
  	  inicializarAtor(comida3);
  	  add(comida3);
  	  
  	  comida4 = new JButton(apple);
  	  inicializarAtor(comida4);
  	  add(comida4);
  	  
  	  comida5 = new JButton(apple);
  	  inicializarAtor(comida5);
  	  add(comida5);
  	  
  	  bomba1 = new JButton(bomb);
  	  inicializarAtor(bomba1);
  	  add(bomba1);
  	  
  	  bomba2 = new JButton(bomb);
  	  inicializarAtor(bomba2);
  	  add(bomba2);
  	  
  	  bomba3 = new JButton(bomb);
  	  inicializarAtor(bomba3);
  	  add(bomba3);
    
  	  lbpontos = new JLabel("");
  	  lbpontos.setText("Pontos: "+pontos);
  	  lbpontos.setBounds(10,10,100,10);
  	  add(lbpontos);
  	  
  	  fundo = new JLabel(cenario);  
  	  fundo.setBounds(planoX, planoY, 1000, 500);
  	  fundo.setBackground(getContentPane().getBackground());
  	  add(fundo);
    }
     
    private void inicializar() {
	  setTitle("SUPER HERO GHOST");
	  setSize(janelaW, janelaH);
	  setResizable(false);
	  setLayout(null);
	  setVisible(true);
	  setLocation(270,80);
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  
	  inicializarPosicao();
	  inicializarGraficos();
	  
	  addKeyListener(this);
    }
    
    public void run() {     
    	inicializar();
    	requestFocus();
    	recordes.setVisible(true);
    	while (true) {
    		requestFocus();
    		desenharGraficos();
    		velocidade(1,2,3,4,5,5,7,10);
    		try { Thread.sleep(1000/FPS);
    		} catch (Exception e) {
    			System.out.println("Thread interrompida!");
    		}
    	}
    }
    
    
    public static void main(String[] args) throws IOException {
	  Jogo game = new Jogo();
	  game.run();
    }
    
    
    public void keyPressed(KeyEvent e) {
	  if(e.getKeyCode() == e.VK_LEFT) posX -= 10;
	  if(e.getKeyCode() == e.VK_RIGHT) posX += 10;
	  if(e.getKeyCode() == e.VK_UP) posY -= 10;
	  if(e.getKeyCode() == e.VK_DOWN) posY += 10;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
   
    
}
