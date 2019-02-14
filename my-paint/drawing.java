
import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.Image;

public class drawing extends JApplet implements KeyListener, MouseListener, MouseMotionListener
{
    int x, y, c, brushRadius;
    int style = Font.BOLD | Font.ITALIC;
    boolean drawInstructions, splashSwitch, topClear;
    
    public void init()
    {
        setFocusable(true);
        resize(800, 600);
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        
        // initialize variables 
        brushRadius = 10;           // default brush radius
        c = 1;                      // default brush color black
        drawInstructions = true;    // draw instructions once
        splashSwitch = true;        // draw splash screen once
        topClear = false;           // clearing splash screen
    }
    
    public void paint (Graphics g) 
    {
        int w = getWidth();
        int h = getHeight();
        
        // create usable font type(s)
        Font tr = new Font("TimesRoman", Font.PLAIN, 14); 
        Font bigtr = new Font("TimesRoman", Font.PLAIN, 25); 
        
        // color Selection, dependent on KeyTyped change of "c"
        if (c==1) {
            g.setColor(Color.black); }
        if (c==2) {
            g.setColor(Color.red); }
        if (c==3) {
            g.setColor(Color.blue); } 
        if (c==4){
            g.setColor(Color.green); }
        if (c==5) {
            g.setColor(Color.orange); }
        if (c==6) {
            g.setColor(Color.magenta); } 
        if (c==7) {
            g.setColor(Color.cyan); }  
        if (c==8) {
            g.setColor(Color.yellow); }
        if (c==9) {
            g.setColor(Color.white); } 
        if (c==0) {
            clearScreen(g); }
        
        if (c!=0) {               // draw circle if user has selected a brush   
            if (y < 470) {        // bottom border of canvas
                g.fillOval(x - 20, y - 20, brushRadius*2, brushRadius*2); }
        }
        // write out instructions for user
        if (drawInstructions = true) {
        g.setFont(tr);
        g.setColor(Color.black); 
        g.drawRect(15, 520, 415, 70);                     // border box, for colors' key
        g.drawString("Color [1]: Black", 20, 540); 
        g.drawString("Color [2]: Red", 20, 560); 
        g.drawString("Color [3]: Blue", 20, 580); 
        g.drawString("Color [4]: Green", 170, 540); 
        g.drawString("Color [5]: Orange", 170, 560);
        g.drawString("Color [6]: Magenta", 170, 580); 
        g.drawString("Color [7]: Cyan", 320, 540); 
        g.drawString("Color [8]: Yellow", 320, 560); 
        g.drawString("Color [9]: White", 320, 580); 
        g.drawRect(455, 520, 335, 70);                    // border box, for directions
        g.drawString("Drag your mouse to draw, selecting a color by hitting", 470, 540); 
        g.drawString("the corresponding key. Clear your screen with Key [0].", 470, 560); 
        g.drawString("Right click to change the brush radius.", 470, 580);
        drawInstructions = false ;                       // do not repaint instructions
        }
        
        // write out splash screen once
    if (topClear == false) {
        if (splashSwitch == true) {
            g.setFont(bigtr);
            g.setColor(Color.black); 
            g.drawString("Paint Program", 300, 210);
            g.setColor(Color.gray); 
            g.drawString("By Alisa Khieu", 300, 230);  
            g.setFont(tr);
            g.setColor(Color.black); 
            g.drawString("August 30, 2016.", 350, 250); 
          
        }
        
       if (splashSwitch == false) {
           clearScreen(g);
           topClear = true; 
        }
    }
    }
    
    public void clearScreen(Graphics g) {
        g.clearRect(0, 0, 800, 515);
    }
    
    public void keyPressed(KeyEvent e) {}

    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {
        // take input to change variable selecting color
        if(e.getKeyChar() == '1')
            c = 1;
        if(e.getKeyChar() == '2')
            c = 2;
        if(e.getKeyChar() == '3')
            c = 3;
        if(e.getKeyChar() == '4')
            c = 4;
        if(e.getKeyChar() == '5')
            c = 5;
        if(e.getKeyChar() == '6')
            c = 6;
        if(e.getKeyChar() == '7')
            c = 7;
        if(e.getKeyChar() == '8')
            c = 8;
        if(e.getKeyChar() == '9')
            c = 9;
        if(e.getKeyChar() == '0')
            c = 0;
    }

    public void mouseClicked(MouseEvent e) {
        // increase brushRadius upon click
            brushRadius = brushRadius + 5; 
        // reset brushRadius to default size after surpassing said radius
        if (brushRadius > 30) { 
            brushRadius = 10 ; } 
        
        // random color upon pressing mouse
        Random rand = new Random();
        c = rand.nextInt(8) + 1;
        }

    public void mousePressed(MouseEvent e) {
    }
        
    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseDragged(MouseEvent e) {   
        
        // turn off splash screen    
        splashSwitch = false;  
        
        x = e.getX();
        y = e.getY();
        repaint();
    }

    public void mouseMoved(MouseEvent e) {}
    
}