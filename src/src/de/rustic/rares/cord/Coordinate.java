package de.rustic.rares.cord;

public class Coordinate {

     int x;
     int y;
     int z;

    public Coordinate(int x,int y,int z){

        this.x = x;
        this.y = y;
        this.z = z;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public double getDistance(Coordinate c){

        double xy = Math.sqrt(((pos(c.x - x))^2 + (pos(c.x - x))^2));
        double dif = Math.sqrt(xy*xy + (pos(c.z - z)* pos(c.z - z)));
        return pos(dif);
    }
    public static int pos(int a){
        if(a < 0){
            return -a;
        }
        return a;
    }
    public double pos(double a){
        if(a < 0){
            return -a;
        }
        return a;
    }
    public float pos(float a){
        if(a < 0){
            return -a;
        }
        return a;
    }
}

