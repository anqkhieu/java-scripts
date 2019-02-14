import java.util.*;
class LaaLaaTank extends Tank
{
   
    public LaaLaaTank(int i, String name)
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
        v = 0;
        return (super.move(tanks, shells)); 
    }
    
    Shell shoot(ArrayList <Tank> tanks) {       
        double targetX = ((Math.random() * 900) + 1);
        double targetY = ((Math.random() * 710) + 1);
        Shell s = new Shell(x, y, targetX, targetY, ID);  // credit for the shot
        return s;
    }
}
