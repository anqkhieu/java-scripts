import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.applet.*;

public class TankBattle extends JApplet implements Runnable {
    Thread t; 
    int timeStep = 50; 
    Graphics bg;                // double- buffered
    Image offscreen; 
    ArrayList <Tank> tanks = new ArrayList();
    ArrayList <Shell> shells = new ArrayList();
    int[] scores;
    String[] bots;

    public void init() {
        tanks.add(new PoTank(0, "Po"));
        tanks.add(new LaaLaaTank(1, "LaaLaa"));
        tanks.add(new DipsyTank(2, "Dipsy"));
        tanks.add(new TinkyWinkyTank(3, "TinkyWinky"));
        tanks.add(new SunBabyTank(4, "SunBaby"));
        tanks.add(new myTank(5, "myTank"));
        scores = new int[tanks.size()];
        bots = new String[tanks.size()];
        for(int i = 0; i < bots.length; i++) {
            bots[i] = tanks.get(i).name;
        }
        resize(900, 710);
        offscreen = createImage(900, 750);
        bg = offscreen.getGraphics();
        setFocusable(true);  
        t = new Thread(this);
        t.start(); 
    }

    public void run() {
        try{
            while(true){
                if(tanks.size() == 1) {
                    scores[tanks.get(0).ID] += 2 * (bots.length - tanks.size()); 
                    tanks.remove(0);
                }
                for(int i = 0; i < tanks.size(); i++) {
                    Tank ta = tanks.get(i);
                    if(ta.move(tanks, shells)) {             // true indicates may shoot
                        Shell s = ta.shoot(tanks);
                        if(s != null) shells.add(s);
                    }
                }
                for(int j = 0; j < shells.size(); j++) {
                    Shell s = shells.get(j);
                    if(s.move()) {              // true indicates off screen
                        shells.remove(j);
                        continue;
                    }
                    for(int i = 0; i < tanks.size(); i++) {
                        Tank ta = tanks.get(i);
                        if(s.shooter != ta.ID && s.in(ta.x, ta.y)) {  // shell hits tank
                            ta.hit++;
                            if(ta.hit > 3) {   // 4th hit destroys
                                scores[ta.ID] += 2 * (bots.length - tanks.size());  // bonus for survival
                                tanks.remove(i);
                                scores[shells.get(j).shooter] += 2;
                            }
                            scores[shells.get(j).shooter]++;    // points
                            shells.remove(j);
                            break;
                        }
                    }
                }
                repaint();  
                t.sleep(timeStep);   
            }
        } 
        catch (InterruptedException e) {}
    }

    public void paint(Graphics g) {
        //showStatus("" + tanks.size() + " " + shells.size());
        if(tanks.size() >= 2) showStatus(tanks.get(1).hit + " ");
        bg.clearRect(0,0,900,750);
        bg.drawRect(1, 1, 600, 600);
        for(Tank ta : tanks) {              // tanks measure r = 10
            bg.fillOval((int)ta.x - 10, (int)ta.y - 10, 20, 20);
            bg.drawString(bots[ta.ID], (int)ta.x - 10, (int)ta.y + 20);
        }
        for(Shell s : shells) 
            bg.fillOval((int)s.x - 2, (int)s.y - 2, 4, 4);
        for(int i = 0; i < scores.length; i++) 
            bg.drawString(bots[i] + ": " + scores[i], 700, 20 + i * 20);
        g.drawImage(offscreen, 0, 0, this);
    }

    public void update(Graphics g) { 
        paint(g);
    }
}


