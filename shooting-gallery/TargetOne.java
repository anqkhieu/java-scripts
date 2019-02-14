
/**
 * Write a description of class Target here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TargetOne extends Target
{
    
    public int firstY; 
    
    /**
     * Constructor for objects of class Target
     */
    public TargetOne(int x, int y, int v)
    {
        this.x = x;
        this.y = y; 
        this.v = v; 
        firstY = y; 
        targetSize = 80;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void move()
    {
        y = y + v; 
        
        if (y >= 400) {  // move up 
            v = -v; 
        }
        
        if (y <= firstY) {  // move 
            v = -v; 
        }
    }
}
