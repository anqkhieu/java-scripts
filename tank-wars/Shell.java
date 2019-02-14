public class Shell
{
    double x, y, m, n, a, v;
    int shooter;
    Shell(double x, double y, double m, double n, int i) {
        this.x = x;
        this.y = y;
        this.m = m;
        this.n = n;
        a = Math.atan2(n - y, m - x);
        v = 10;
        shooter = i;
    }

    boolean move() { 
        x = x + v * Math.cos(a);
        y = y + v * Math.sin(a);
        if(x <= 0 || x >= 600 || y <= 0 || y >= 600) {
            return true;
        }
        return false;
    }

    boolean in(double m, double n) {
        if(Math.sqrt(Math.pow(x - m, 2) + Math.pow(y - n, 2)) < 10)
            return true;
        return false;
    }
}
