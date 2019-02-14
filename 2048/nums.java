import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class nums extends JApplet implements KeyListener {
    
    int [][]grid = new int[4][4]; 
    int x; int y; 
    int size = 100; 
    
    public void init() {
        setFocusable(true);     
        addKeyListener(this);
    }
    public void paint(Graphics g) {
        g.clearRect(0, 0, 500, 500); 
        g.setFont(new Font("Serif", Font.BOLD, 36));
        for (int r = 0; r < 4; r = r + 1) {
            for (int c = 0; c < 4; c = c + 1) {
                g.drawRect(c*100, r*100, size, size); 
                g.drawString("" + grid[r][c], (c*100) + 40, (r*size + 60));         
            }
        }    
    }
    public void addNum() {
            do {
                x = (int)(Math.random() * 4); 
                y = (int)(Math.random() * 4);   
            } while (!(grid[x][y] == 0));
            grid[x][y] = 2;
    }
    public void slideLeft() {
        for(int r = 0; r < 4; r = r + 1){
            for(int c = 0; c < 4; c = c + 1){
                if ((c + 1) < 4) {
                    // SLIDE IF ONE ZERO
                    if ((grid[r][c] == 0) && (grid[r][c+1] != 0)) {
                        
                        grid[r][c] = grid[r][c+1];
                        grid[r][c+1] = 0;
                        
                    }
                    
                    // SLIDE IF TWO ZEROS
                    if ((c + 2) < 4) {
                        if ((grid[r][c] == 0) && (grid[r][c+1] == 0) && (grid[r][c+2] != 0)) {
                        
                            grid[r][c] = grid[r][c+2];
                            grid[r][c+2] = 0;        
                        }           
                    }     
                    
                    // SLIDE IF THREE ZEROS
                    if ((c + 3) < 4) {
                        if ((grid[r][c] == 0) && (grid[r][c+3] == 0) && (grid[r][c+3] != 0)) {
                        
                            grid[r][c] = grid[r][c+3];
                            grid[r][c+3] = 0;        
                        }           
                    } 
                   
                    
                    // COMBINE
                    if (grid[r][c] == grid[r][c+1]) {
                        grid[r][c] = grid[r][c] * 2; 
                        grid[r][c+1] = 0; 
                    }
                }
                      
            }
        }
    }
    public void slideUp() {
        for(int r = 0; r < 4; r = r + 1){
            for(int c = 0; c < 4; c = c + 1){
                if ((r + 1) < 4) {
                    if ((grid[r][c] == 0) && (grid[r+1][c] != 0)) {
                        
                        grid[r][c] = grid[r+1][c];
                        grid[r+1][c] = 0;
                        
                    }
                               
                    if (grid[r][c] == grid[r+1][c]) {
                        grid[r][c] = grid[r][c] * 2; 
                        grid[r+1][c] = 0; 
                    }
                }
            }
        }
    }
    public void slideRight() {
        for(int r = 0; r < 4; r = r + 1){
            for(int c = 0; c < 4; c = c + 1){
                if ((c + 1) < 4) {
                    // SLIDE IF ONE ZERO
                    if ((grid[r][c] == 0) && (grid[r][c+1] != 0)) {
                        
                        grid[r][c] = grid[r][c+1];
                        grid[r][c+1] = 0;
                        
                    }
                    
                    // SLIDE IF TWO ZEROS
                    if ((c + 2) < 4) {
                        if ((grid[r][c] == 0) && (grid[r][c+1] == 0) && (grid[r][c+2] != 0)) {
                        
                            grid[r][c] = grid[r][c+2];
                            grid[r][c+2] = 0;        
                        }           
                    }     
                    
                    // SLIDE IF THREE ZEROS
                    if ((c + 3) < 4) {
                        if ((grid[r][c] == 0) && (grid[r][c+3] == 0) && (grid[r][c+3] != 0)) {
                        
                            grid[r][c] = grid[r][c+3];
                            grid[r][c+3] = 0;        
                        }           
                    } 
                   
                    
                    // COMBINE
                    if (grid[r][c] == grid[r][c+1]) {
                        grid[r][c] = grid[r][c] * 2; 
                        grid[r][c+1] = 0; 
                    }
                }
                      
            }
        }

    }
    public void slideDown() {
        for(int r = 0; r < 4; r = r + 1){
            for(int c = 0; c < 4; c = c + 1){
                if ((r + 1) < 4) {
                    if ((grid[r][c] == 0) && (grid[r+1][c] != 0)) {
                        
                        grid[r][c] = grid[r+1][c];
                        grid[r+1][c] = 0;
                        
                    }
                               
                    if (grid[r][c] == grid[r+1][c]) {
                        grid[r][c] = grid[r][c] * 2; 
                        grid[r+1][c] = 0; 
                    }
                }
            }
        }

    }
    public void keyTyped(KeyEvent k) {
        if(k.getKeyChar() == 'a')
            slideLeft();
        if(k.getKeyChar() == 'w')
            slideUp();
        if(k.getKeyChar() == 'd')
            slideRight();
        if(k.getKeyChar() == 'x')
            slideDown();
        addNum();
        repaint();
    }
    public void keyPressed(KeyEvent k) {}
    public void keyReleased(KeyEvent k) {}
}