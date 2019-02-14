
public class Paddle
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    private int w;
    private int h;
    private int v;
    
    /**
     * Constructor for objects of class Paddle
     */
    public Paddle(int x,int y, int w, int h) 
    {
        this.x = x; 
        this.y = y; 
        this.w = w;
        this.h = h; 
    }

    public int getX()
    {
        return x; 
    }
    
    public int getY()
    {
        return y; 
    }
    
    public int getW()
    {
        return w; 
    }
    
    public int getH()
    {
        return h; 
    }
    
    public void move(int inputLetter)
    {
        if (inputLetter == 'w') {
            y = y - 10 ;
        }
        
        if (inputLetter == 's') {
            y = y + 10 ;
        }
        
        if (inputLetter == 'd') {
            x = x + 10 ;
        }
        
        if (inputLetter == 'a') {
            x = x - 10 ;
        }
        
        // walls 

        if ((x <= 0)) {
            x = x + 10; 
        }
        
        if (x >= 590) {
            x = x - 10; 
        }
        
        if ((y <= 0)) {
            y = y + 10; 
        }
        
        if ((y >= 390)) {
            y = y - 10; 
        }
        
    }
    
    public boolean isIn(double xBall, double yBall) {
        if ((xBall >= x) && (xBall <= x + w) && (yBall >= y) && (yBall <= y + h)) { 
            return true; 
        }        
        return false; 
    }
}
