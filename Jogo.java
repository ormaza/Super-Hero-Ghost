/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;


import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Ormaza
 */
public class Jogo extends JFrame implements KeyListener{
    
    JButton minhoca,comida1,comida2,comida3,comida4,comida5,bomba1,bomba2,bomba3;
    JLabel lbpontos,fundo;
    int pontos;
    ImageIcon apple = new ImageIcon("src/imagens/apple.jpg");
    ImageIcon cenario = new ImageIcon("src/imagens/cenario.jpg");
    ImageIcon ghost = new ImageIcon("src/imagens/jogador.jpg");
    ImageIcon bomb = new ImageIcon("src/imagens/bomb.jpg");
    String nome;
    boolean salvo=true;
    int cond=0;
    
    int planox=0;
    int planoy=0;
    int FPS = 30;
    int janelaW = 1000;
    int janelaH = 500;
 
    // posição inicial do jogador
    int posx = 200;
    int posy = 200;
    int tamx =80;
    
    //posições iniciais dos outros atores
    int px1=posicaox();
    int py1=posicaoy();
    
    int px2=posicaox();
    int py2=posicaoy();
    
    int px3=posicaox();
    int py3=posicaoy();
    
    int px4=posicaox();
    int py4=posicaoy();
    
    int px5=posicaox();
    int py5=posicaoy();
    
    int ex1=posicaox();
    int ey1=posicaoy();
    
    int ex2=posicaox();
    int ey2=posicaoy();
    
    int ex3=posicaox();
    int ey3=posicaoy();
    
    
    int dist=25; //intervalo de segurança para colisão
    
    
    public void desenharGraficos() throws IOException {
  
       
  
  
  minhoca.setBounds(posx, posy, tamx, 60);
  
  
  comida1.setBounds(px1,py1,50,50);
  comida2.setBounds(px2,py2,50,50);
  comida3.setBounds(px3,py3,50,50);
  comida4.setBounds(px4,py4,50,50);
  comida5.setBounds(px5,py5,50,50);
  bomba1.setBounds(ex1,ey1,50,50);
  bomba2.setBounds(ex2,ey2,50,50);
  bomba3.setBounds(ex3,ey3,50,50);
  
  //detecta colisão
  
  if(posy>=py1-dist && posy<=py1+dist)
    if(posx>=px1-dist && posx<=px1+dist)
     
  {
    pontos++;  
    px1=posicaox();
    py1=posicaoy();
    
  }
    
  
  if(posy>=py2-dist && posy<=py2+dist)
    if(posx>=px2-dist && posx<=px2+dist)
      
  {
    pontos++;  
    px2=posicaox();
    py2=posicaoy();
  }
  
  if(posy>=py3-dist && posy<=py3+dist)
    if(posx>=px3-dist && posx<=px3+dist)
      
  {
    pontos++;  
    px3=posicaox();
    py3=posicaoy();
  }
  
  if(posy>=py4-dist && posy<=py4+dist)
     if(posx>=px4-dist && posx<=px4+dist)
      
  {
    pontos++;  
    px4=posicaox();
    py4=posicaoy();
  }
  
  if(posy>=py5-dist && posy<=py5+dist)
     if(posx>=px5-dist && posx<=px5+dist)
      
  {
    pontos++;  
    px5=posicaox();
    py5=posicaoy();
  }
  
  if(posy>=ey1-dist && posy<=ey1+dist)
     if(posx>=ex1-dist && posx<=ex1+dist)
      
  {
    if(cond==0)
    recorde();
    
  }
  
  if(posy>=ey2-dist && posy<=ey2+dist)
     if(posx>=ex2-dist && posx<=ex2+dist)
      
  {
    if(cond==0)
    recorde();
  }
  
  if(posy>=ey3-dist && posy<=ey3+dist)
     if(posx>=ex3-dist && posx<=ex3+dist)
      
  {
    if(cond==0)
    recorde();
  }
  
  
  //se o projetil sair do cenário
  
  if(px1<0) {px1=posicaox(); py1=posicaoy();}
  if(px2<0) {px2=posicaox(); py2=posicaoy();}
  if(px3<0) {px3=posicaox(); py3=posicaoy();}
  if(px4<0) {px4=posicaox(); py4=posicaoy();}
  if(px5<0) {px5=posicaox(); py5=posicaoy();}
  if(ex1<0) {ex1=posicaox(); ey1=posicaoy();}
  if(ex2<0) {ex2=posicaox(); ey2=posicaoy();}
  if(ex3<0) {ex3=posicaox(); ey3=posicaoy();}
  
  //se o jogador tentar sair do cenário
  
  if(posx>900 && salvo){ posx=890;}
  if(posx<0 && salvo) {posx=10;}
  if(posy<0 && salvo) {posy=10;}
  if(posy>400 && salvo) {posy=390;}
          
  lbpontos.setText("Pontos: "+pontos);        
                  
 
 }
    
    
    public int posicaox()
    {
        Random gerador = new Random();  
        int numero = gerador.nextInt(100);
        numero=numero+1000;
        return numero;
    }
    
    public int posicaoy()
    {
        Random gerador = new Random();  
        int numero = gerador.nextInt(500);
        return numero;
    }
    
    public void velocidade(int v1,int v2,int v3,int v4,int v5,int v6,int v7,int v8)
    {
       px1=px1-v1;
       px2=px2-v2;
       px3=px3-v3;
       px4=px4-v4;
       px5=px5-v5;
       ex1=ex1-v6;
       ex2=ex2-v7;
       ex3=ex3-v8;
       
              
    }
    
    public void recorde() throws IOException
    {
        
        
        cond=1;
        nome = JOptionPane.showInputDialog("digite seu nome");
        
        
        Recordes.nomes[Recordes.numcadastrados]=nome;
        Recordes.pontos[Recordes.numcadastrados]=""+pontos;
        
        new Recordes().setVisible(true);
        //new Recordes().run();
        
        Recordes.numcadastrados++;
        
        pontos=0;
        cond=0;
        
        
    posx = 200;
    posy = 200;
    tamx =80;
    
    //posições iniciais dos outros atores
    px1=posicaox();
    py1=posicaoy();
    
    px2=posicaox();
    py2=posicaoy();
    
    px3=posicaox();
    py3=posicaoy();
    
    px4=posicaox();
    py4=posicaoy();
    
    px5=posicaox();
    py5=posicaoy();
    
    ex1=posicaox();
    ey1=posicaoy();
    
    ex2=posicaox();
    ey2=posicaoy();
    
    ex3=posicaox();
    ey3=posicaoy();
    }
    
    
    public void inicializar() {
  setTitle("SUPER HERO GHOST");
  setSize(janelaW, janelaH);
  setResizable(false);
  setLayout(null);
  setVisible(true);
  setLocation(270,80);
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  
  
  
  
  minhoca = new JButton(ghost);
  minhoca.setBorder(BorderFactory.createLineBorder(Color.white));
  add(minhoca);
  
  comida1 = new JButton(apple);
  comida1.setBorder(BorderFactory.createLineBorder(Color.white));
  add(comida1);
  
  comida2 = new JButton(apple);
  comida2.setBorder(BorderFactory.createLineBorder(Color.white));
  add(comida2);
  
  comida3 = new JButton(apple);
  comida3.setBorder(BorderFactory.createLineBorder(Color.white));
  add(comida3);
  
  comida4 = new JButton(apple);
  comida4.setBorder(BorderFactory.createLineBorder(Color.white));
  add(comida4);
  
  comida5 = new JButton(apple);
  comida5.setBorder(BorderFactory.createLineBorder(Color.white));
  add(comida5);
  
  bomba1 = new JButton(bomb);
  bomba1.setBorder(BorderFactory.createLineBorder(Color.white));
  add(bomba1);
  
  bomba2 = new JButton(bomb);
  bomba2.setBorder(BorderFactory.createLineBorder(Color.white));
  add(bomba2);
  
  bomba3 = new JButton(bomb);
  bomba3.setBorder(BorderFactory.createLineBorder(Color.white));
  add(bomba3);
  
  
  
  lbpontos = new JLabel("");
  lbpontos.setText("Pontos: "+pontos);
  lbpontos.setBounds(10,10,100,10);
  add(lbpontos);
  
  fundo = new JLabel(cenario);  
  fundo.setBounds(planox, planoy, 1000, 500);
  fundo.setBackground(getContentPane().getBackground());
  add(fundo);
  
  //AQUI ESTAMOS ADICIONANDO UM ESCUTADOR DE TECLAS
  addKeyListener(this);
 }
    
    public void run() throws IOException {
   
  //this.nome=nome;      
  inicializar();
  requestFocus();
  new Recordes().setVisible(true);
  while (true) {
       requestFocus();
   desenharGraficos();
   velocidade(1,2,3,4,5,5,7,10);
    try {
     Thread.sleep(1000/FPS);
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
   
  if(e.getKeyCode() == e.VK_LEFT){
   posx -= 10;
  }
  
  if(e.getKeyCode() == e.VK_RIGHT){
   posx += 10;
  }
  
  if(e.getKeyCode() == e.VK_UP){
   posy -= 10;
  }
  
  if(e.getKeyCode() == e.VK_DOWN){
   posy += 10;
  }
   
 }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
   
    
}
