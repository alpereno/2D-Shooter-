package sh2;

import datastructure.Vector2;

public class Bullet {
    Vector2 pos, vel;
    
    public Bullet(Vector2 pos){
        this.pos = pos;
        vel = new Vector2(1000,0);
    }
    
    public void updatePos(int dt){
        Vector2 displacement = vel.mul(dt/1000f);
        pos.addOn(displacement);
    }
}
