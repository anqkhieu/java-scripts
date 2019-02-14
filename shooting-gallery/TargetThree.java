
/**
 * Write a description of class Target here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TargetThree extends Target
{
    public int firstX; 
    public int firstY; 
    
    /**
     * Constructor for objects of class Target
     */
    public TargetThree(int x, int y, int v)
    {
        this.x = x;
        this.y = y; 
        this.v = v; 
        firstY = y; 
        firstX = x; 
        targetSize = 45;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void move()
    {
        x = x + v; 
        y = y + v; 
        
        if (y >= 420) {  // move up 
            v = -v; 
        }
        
        if (y <= firstY) {  // move 
            v = -v; 
        }
    }
}
