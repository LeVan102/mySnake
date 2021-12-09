package snake;
//LeVan
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer; 
public class GameJpanel extends JPanel implements ActionListener {
    final int W =500;
    final int H = 500;
    final int U = 20;
    int body = 50;  
    int level = 1;
    int Ax;
    int Ay;
    int x[] = new int[(W*H)/(U*U)];
    int y[] = new int[(W*H)/(U*U)];
    char Key = 'R';
    Timer time ;
    Random randoms = new Random();
    boolean running = true; 
    boolean Stop = false; 
    GameKey e = new GameKey();
    public GameJpanel() {
        setFocusable(true);
        this.setBackground(Color.BLACK);
        this.setSize(W,H);
        this.addKeyListener(e);
        this.GameStart();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        draw(g);
    } 
    
    public void draw(Graphics g){
        if (running) {
            g.setColor(Color.gray);
            g.setColor(new Color(204,204,204));
            for (int i = 1; i < W/U; i++) {
                g.drawLine(i*U,0,i*U,W);
                g.drawLine(0,i*U,H,i*U);
            }
            for (int i = 1;i < body; i++) {
                int a = randoms.nextInt(255);
                int b = randoms.nextInt(255);
                int c = randoms.nextInt(255);
                g.setColor(new Color(a, b, c));
                g.fillOval(Ax*U,Ay*U,U,U);
                g.fillRect(x[i]*U,y[i]*U,U,U);
             }    
            g.setColor(Color.red);
            g.setFont(new Font("Georgia",Font.ITALIC,35));      
            g.drawString("Score : " +(body*level-5*level) ,W/3,H/20);
            g.fillOval(x[0]*U+2,y[0]*U-2,U,U);//đầu rắn
            g.setColor(Color.GREEN);
            if ((Key == 'R')||(Key == 'L')) {
                g.fillOval(x[0]*U+U/2,y[0]*U,    U/4,U/4);
                g.fillOval(x[0]*U+U/2,y[0]*U+U/2,U/4,U/4);
            } else { 
                g.fillOval(x[0]*U+U/4,y[0]*U+U/4,U/4,U/4);
                g.fillOval(x[0]*U+7*U/10,y[0]*U+U/4,U/4,U/4);
            }
            g.setFont(new Font("Georgia",Font.ITALIC,20));
            g.drawString("Level : " +level ,W-H/5,3*H/100);
        }else{
            Gameover(g);
        }
    } 
    
    public void GameStart(){
       newApple();
       time = new Timer(500-level*100,this);
       time.start();
       x[0] = 1;y[0] = 0;
       time.restart();
    }
    
    public  void Gameover(Graphics g){
        g.setColor(Color.red);
        g.setFont(new Font("Georgia",Font.ITALIC,75));      
        g.drawString("GameOver",W/6,H/2);
        g.setFont(new Font("Georgia",Font.ITALIC,50));
        g.drawString("my Score is : "+(body*level-5*level),W/5,H-H/3);
    
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        Running();
        if (running){
           CheckA();
           run();
        }
        repaint();
    } 
    
    public void newApple(){
         Ax = randoms.nextInt(W/U); 
         Ay = randoms.nextInt(W/U);   
    }
    
    public void run(){
        if (Stop) {
            for(int i=body; i > 0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
            }   
            switch (Key){
                case 'R':
                    x[0] += 1;
                    break;
                case 'L':
                    x[0] -= 1;break;
                case 'U':
                    y[0] -= 1;break;
                case 'D':
                    y[0] += 1;break;
            }
            
        }
   }    
    
    public void Running(){ 
        if (   (x[0]<0)||(x[0] ==(W/U))||  
               (y[0]<0)||(y[0] ==(H/U))   ) {
            running = false;
        }
        for (int i = 1; i < body; i++) {
            if ((x[0]== x[i])&&(y[0]== y[i])) {
                running = false;
            }   
        }
        
    } 
 
    public void CheckA(){
         for (int i = 0; i < body; i++) {
            if ((x[i]==Ax)&&(y[i]==Ay)) {
                newApple();
                body += 1;
            }   
        }
        
    }
    
    public class GameKey extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent E) {
            switch (E.getKeyCode()){
            case KeyEvent.VK_LEFT :
              System.out.println(Key);
              if((Key == 'D')||(Key == 'U')) Key = 'L';
              break;
            case KeyEvent.VK_RIGHT :
                
             if((Key == 'D')||(Key == 'U')) Key = 'R';
              System.out.println(Key);
              break;
            case KeyEvent.VK_DOWN:
                
              if((Key == 'R')||(Key == 'L')) Key = 'D';
              System.out.println(Key);
              break;       
            case KeyEvent.VK_UP :
              if((Key == 'R')||(Key == 'L')) Key = 'U'; 
              System.out.println(Key);
              break;
        }
      }      
    }
    
    
    
    
    
    
    
    
    
    
    
    public boolean getStop() {
        return Stop;
    }

    public void setStop(boolean Stop) {
        this.Stop = Stop;
    }

    public void setKey(char Key) {
        this.Key = Key;  
    }
}