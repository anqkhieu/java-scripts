public class Brick
{
    // instance variables - replace the example below with your own
    private int x;
    private int y; 
    private int w; 
    private int h; 

    /**
     * Constructor for objects of class Brick
     */
    public Brick(int x, int y, int w, int h)
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
    
    public boolean isIn(double xBall, double yBall) {
        if ((xBall >= x) && (xBall <= x + w) && (yBall >= y) && (yBall <= y + h)) { 
            return true; 
        }        
        return false; 
    }
}