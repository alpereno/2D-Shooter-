package sh1;

import datastructure.Vector2;

public class Bullet {
    Vector2 pos, vel;
    
    public Bullet(Vector2 pos){
        this.pos = pos;
        vel = new Vector2(1000,0);
    }
}
