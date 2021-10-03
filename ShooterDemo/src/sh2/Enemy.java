package sh2;

import datastructure.Vector2;

public class Enemy {
    Vector2 pos, vel;
    
    public Enemy(Vector2 pos){
        this.pos = pos;
        vel = Vector2.zero;
    }
}
