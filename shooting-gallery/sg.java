import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*; 
import java.awt.Image;


public class sg extends JApplet implements Runnable, MouseListener{ 
    
    Thread t;   
    int timeStep = 100;     // delay 100ms
    ArrayList <Target> targets = new ArrayList(); 
    int score = 0; 
    Image targetOneImg;
    Image targetTwoImg; 
    Image targetThreeImg;
    Graphics bg;		// buffered graphics
    Image offscreen; 
    AudioClip hit; 

    
    public void init() { 
        
        offscreen = createImage(1000, 800);
        bg = offscreen.getGraphics();
        hit = getAudioClip(getDocumentBase(),"o.wav");
        
        // ADDING TARGETS TO ARRAYLIST ////////////////////////////////////////
        for (int i = 0; i < 400; i = i + 100) {    // 4 horizontally moving
            TargetOne tempOne = new TargetOne(i+50, 100, 10); 
            targets.add(tempOne); 
        }
        
        for (int j = 0; j < 400; j = j + 100) {
            TargetTwo tempTwo = new TargetTwo(100, j+50, 10); 
            targets.add(tempTwo); 
        }
        
        for (int z = 0; z < 400; z = z + 100) {
            TargetThree tempThree = new TargetThree((int)(z*0.2), z+50, 10); 
            targets.add(tempThree); 
        }
        ///////////////////////////////////////////////////////////////////////
       
        targetOneImg = getImage(getDocumentBase(), "targetOne.png");
        targetTwoImg = getImage(getDocumentBase(), "targetTwo.png");
        targetThreeImg = getImage(getDocumentBase(), "targetThree.png");
        
        t = new Thread(this);
        setFocusable(true);
        addMouseListener(this);
        t.start(); 
    }

    public void run() {
        try {
            while(true) {

                repaint();  
                for (Target t:targets) {
                    t.move(); 
                }
                t.sleep(timeStep);   
            }
            
        } catch (InterruptedException e) {}
    }

    public void paint (Graphics g) {
        bg.setColor(Color.white); 
        bg.fillRect(0, 0, 500, 500);     
        
        bg.setColor(Color.black);
        bg.drawString("Score: " + score, 400, 480); 
        
        for (Target t: targets) {
            if (t instanceof TargetOne) {
                bg.setColor(Color.red); 
                bg.drawImage(targetOneImg, t.x, t.y, t.targetSize, t.targetSize, this);
            }
            if (t instanceof TargetTwo) {
                bg.setColor(Color.orange); 
                //g.fillRect(t.x, t.y, t.targetSize, t.targetSize);
                bg.drawImage(targetTwoImg, t.x, t.y, t.targetSize, t.targetSize, this);
            }
            if (t instanceof TargetThree) {
                bg.setColor(Color.blue); 
                //g.fillRect(t.x, t.y, t.targetSize, t.targetSize);
                bg.drawImage(targetThreeImg, t.x, t.y, t.targetSize, t.targetSize, this);
            }
        }
        
        
        // paint()
        // g.drawImage(target, t.x, t.y, t.targetSize, t.targetSize, this);
        g.drawImage(offscreen, 0, 0, this);
    }

    public void update(Graphics g) { 
        paint(g);
    }

    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();   
        int mouseY = e.getY();   
        hit.play();
        
        for (int i = 0; i < targets.size(); i = i + 1) {
            if ((mouseX >= targets.get(i).x) && (mouseX <= targets.get(i).x + targets.get(i).targetSize)) {
                if ((mouseY >= targets.get(i).y) && (mouseY <= targets.get(i).y + targets.get(i).targetSize)) {
                    targets.remove(targets.get(i)); 
                    
                    score = score + 100; 
                }
            }
        }    
        
    }
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}

