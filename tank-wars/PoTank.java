import java.util.*;
class PoTank extends Tank
{
   
    public PoTank(int i, String name)
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
        shotDelay = 100; // can never shoot
        return (super.move(tanks, shells)); 
    }
}
