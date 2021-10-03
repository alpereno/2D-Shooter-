package datastructure;

public class Vector2 {
    
    public static final Vector2 zero = new Vector2(0, 0);
    public double x,y;
    
    public Vector2(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public Vector2(Vector2 vector2){
        this.x = vector2.x;
        this.y = vector2.y;
    }
    
    public Vector2 add(Vector2 vector2){
        return new Vector2(this.x + vector2.x, this.y + vector2.y);
    }
    
    public void addOn(Vector2 vector2){
        this.x += vector2.x;
        this.y += vector2.y;
    }
    
    public Vector2 mul(double k){
        return new Vector2(this.x * k, this.y * k);
    }
    
    public void mulOn(double k){
        this.x *= k;
        this.y *= k;
    }
    
    public void normalize(){
        double len = getLength();
        x /= len;
        y /= len;
    }
    
    public Vector2 unitVector(){
        double normalizedX = x/getLength();
        double normalizedY = y/getLength();
        return new Vector2(normalizedX, normalizedY);
    }

    public double getLength() {
        return Math.sqrt(x*x + y*y);
    }
}
