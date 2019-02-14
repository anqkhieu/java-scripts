/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball
{
    // instance variables - replace the example below with your own  
    double x = 0;
    double y = 0;  
    double v = 0;  
    double a = 0;  
                
    /**
     * Constructor for objects of class Ball
     */
    
    Ball()
    {
            x = (int) (500*(Math.random()) + 1);
            y = (int) (500*(Math.random()) + 1); 
            v = (int) (10*(Math.random()) + 1);
            a = (int) (6.283*(Math.random()) + 1);  // two pi                        
    }

    
    public int xcoord() 
    {
        return (int)x; 
    }
    
    public int ycoord() 
    {
        return (int)y; 
    }
    
    
    /**
     Move Method
     */
    
    public void move() 
    {
        x = x + (v*Math.cos(a)); 
        y = y + (v*Math.sin(a)); 
        
        if ((x <= 10) || (x >= 590)) {
            a = 180-a;
            x = x + (v*Math.cos(a)); 
        }
        
        if ((y <= 10) || (y >= 390)) {
            a = -a;
            y = y + (v*Math.sin(a)); 
        }
    }    
}