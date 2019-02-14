import java.util.*;
class SunBabyTank extends Tank
{
   
    public SunBabyTank(int i, String name)
    {
        x = Math.random() * 550 + 25;
        y = Math.random() * 550 + 25;
        a = Math.random() * 2 * Math.PI;
        v = 3;
        shotDelay = 10;
        hit = 0;
        ID = i;
        this.name = name; 
    }
   
    boolean move(ArrayList <Tank> tanks, ArrayList <Shell> shells) {  
        if (x < 300) {
            x = x + v; 
        }
        if (x > 300) {
            x = x - v; 
        }
        if (y < 300) {
            y = y + v; 
        }
        if (y > 300) {
            y = y - v; 
        }    
        return (super.move(tanks, shells)); 
    }
    
        Shell shoot(ArrayList <Tank> tanks) {       
        double randDir = ((Math.random() * 4) + 1);
        int targetX = 0;
        int targetY = 0; 
        if (randDir == 1) { // North
            targetX = 900/2; 
            targetY = 0; 
        }
        if (randDir == 2) { // South
            targetX = 900/2;
            targetY = 710; 
        }
        if (randDir == 3) { // South
            targetX = 0;
            targetY = 710/2; 
        }
        if (randDir == 4) { // South
            targetX = 900;
            targetY = 710/2; 
        }
        Shell s = new Shell(x, y, targetX, targetY, ID);  // credit for the shot
        return s;
    }
}
