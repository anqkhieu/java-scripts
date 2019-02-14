/**
 * Write a description of class Target here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TargetTwo extends Target
{
    
    public int firstX; 
    
    /**
     * Constructor for objects of class Target
     */
    public TargetTwo(int x, int y, int v)
    {
        this.x = x;
        this.y = y; 
        this.v = v; 
        firstX = x; 
        targetSize = 25; 
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
        
        if (x >= 400) {  // move up 
            v = -v; 
        }
        
        if (x == firstX) {  // move 
            v = -v; 
        }
    }
}
