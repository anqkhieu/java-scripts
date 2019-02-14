import java.util.*;
class DipsyTank extends Tank
{
   
    public DipsyTank(int i, String name)
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
        shotDelay = 100; // can never shoot
        
        int randAng = (int) ((Math.random() * Math.PI * 2) + 1);
        int randVel = (int) ((Math.random() * 5) + 1);
        
        if(x > (600 - 6)) {               // borders
            hit++;                      // damage, stop
            a = Math.PI; 
            v = randVel;
            x = 600 -6;
        }
        if(x < (0 + 6)) {
            hit++;
            a = 0; 
            v = randVel;
            x = 0 + 6;
        }
        if(y > (600 - 6)) {
            hit++;
            a = 1.5*Math.PI; 
            v = randVel;
            y = 600 - 6;
        }
        if(y < (0 + 6)) {
            hit++;
            a = 0.5*Math.PI; 
            v = randVel;
            y = 0 + 6;
        }
        
        return (super.move(tanks, shells)); 
    }
}
