import java.util.*;
class myTank extends Tank
{
    double dir = Math.PI; 
    public myTank(int i, String name)
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
        double d = Math.random() * 1.0 - 0.5;   
        dir = dir + d;                  // 0.5 radians, L or R
        x = (int) (x + v * Math.cos(dir));      // velocity is 5
        y = (int) (y + v * Math.sin(dir));
            
            if(x >= 575) {                   // borders
               dir = Math.PI/2-dir;
               x = 575;
            }
            if(x <= 10) {
                dir = Math.PI/2-dir;
                x = 10;
            }
            if(y >= 575) {
                dir = -dir;
                y = 575;
            }
            if(y <= 10) {
                dir = -dir;
                y = 10;
            }
            
        v = 3;
            
            for (int i = 0; i < shells.size(); i = i + 1) {
                if ((shells.get(i).x >= (x - 30)) && (shells.get(i).y >= y - 30)) {
                    v = 5;
                }
                if ((shells.get(i).x <= (x - 30)) && (shells.get(i).y >= y - 30)) {
                    v = 5;
                }
            }
            return (super.move(tanks, shells)); 
    }
    
    Shell shoot(ArrayList <Tank> tanks) {       
        int rand = (int) ((Math.random() * tanks.size()));
        Tank target = tanks.get(rand); 
        if(target == null) return null;
        Shell s = new Shell(x, y, target.x, target.y, ID);  // credit for the shot
        return s;
    }
}
