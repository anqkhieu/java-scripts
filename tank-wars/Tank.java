import java.util.*;
abstract class Tank
{
    double x, y, a, v;
    int shotDelay, hit, score, ID;
    String name;
//     public Tank(int i, String name)
//     {
//         x = Math.random() * 550 + 25;
//         y = Math.random() * 550 + 25;
//         a = Math.random() * 2 * Math.PI;
//         v = 3;
//         shotDelay = 10;
//         hit = 0;
//         ID = i;
//         this.name = name;
//     }

    boolean move(ArrayList <Tank> tanks, ArrayList <Shell> shells) {     // override this
        if(v > 5) v = 5;                // speed limit
        if(v < 0) v = 0;
        if(x > 600) {                   // borders
            hit++;                      // damage, stop
            a = Math.PI;
            v = 0;
            x = 599;
        }
        if(x < 0) {
            hit++;
            a = 0;
            v = 0;
            x = 1;
        }
        if(y > 600) {
            hit++;
            a = 1.5*Math.PI;
            v = 0;
            y = 599;
        }
        if(y < 0) {
            hit++;
            a = 0.5*Math.PI;
            v = 0;
            y = 1;
        }
        x = x + v * Math.cos(a);            // normal movement
        y = y + v * Math.sin(a);
        shotDelay--;                        // allows shooting
        if(shotDelay < 0) {
            shotDelay = 10;
            return true;
        }
        return false;
    }

    Shell shoot(ArrayList <Tank> tanks) {           // possibly override this  
        Tank target = findTarget(tanks);
        if(target == null) return null;
        Shell s = new Shell(x, y, target.x, target.y, ID);  // credit for the shot
        return s;
    }

    Tank findTarget(ArrayList <Tank> tanks) {      // override this
        if(tanks.size() == 0) 
            return null;
        Tank tmp = tanks.get(0);
        return tmp;
    }
}