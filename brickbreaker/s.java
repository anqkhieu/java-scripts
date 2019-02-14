import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class s extends JApplet implements Runnable, KeyListener  { 
    Thread t;   
    int timeStep = 50;     // delay 100ms

    ArrayList <Ball> ballObjectsList = new ArrayList(); 
    ArrayList <Brick> bricks = new ArrayList();
    Paddle p = new Paddle((300 - 50), 350, 100, 20);
    
    public void init() { 
        
        setFocusable(true);
        addKeyListener(this);
        resize(600, 400);
        
        for (int i = 0; i < 10; i = i + 1) {
            Ball Ballio = new Ball();       // creates a new ball
            ballObjectsList.add(Ballio);    // said ball is added to the ArrayList
        }
        
        for (int j = 0; j < 80; j = j + 40) {
            for (int i = 0; i < 600; i = i + 150) {
                bricks.add(new Brick(i, j, 150, 40)); 
            }
        }
        
        t = new Thread(this);
        t.start();              // last line in init()
    }

    
    public void run() {
        try {
            while(true) {
                
                for (int i = 0; i < 10; i = i + 1) {
                    ballObjectsList.get(i).move();  
                } 
                
                repaint();  
                t.sleep(timeStep);   
                
                for (int j = 0; j < bricks.size(); j = j + 1) {
                    if (p.isIn((int)ballObjectsList.get(j).x, (int)ballObjectsList.get(j).y) == true) {
                        ballObjectsList.get(j).a = 180 - ballObjectsList.get(j).a;
                    }    
                }
            }
        } catch (InterruptedException e) {}
    }
    
    public void keyPressed(KeyEvent e) {}
 
    public void keyReleased(KeyEvent e) {}
 
    public void keyTyped(KeyEvent e) {
        char moveInput = e.getKeyChar();
        p.move(moveInput);  
    }
    
    public void paint (Graphics g) {
        g.clearRect(0, 0, 1000, 1000);
        
        g.fillRect(p.getX(), p.getY(), p.getW(), p.getH()); 
        
        for (int i = 0; i < 10; i = i + 1) {
            g.fillOval((int)ballObjectsList.get(i).x-10, (int)ballObjectsList.get(i).y-10, 20, 20);   
        }
        
        for (int j = 0; j < bricks.size(); j = j + 1) {
            g.drawRect(bricks.get(j).getX(), bricks.get(j).getY(), 150, 40); 
            if (bricks.get(j).isIn((int)ballObjectsList.get(j).x, (int)ballObjectsList.get(j).y) == true) {
                bricks.remove(j);
                ballObjectsList.get(j).a = 180 - ballObjectsList.get(j).a; 
            } 
        }
        
    }
}