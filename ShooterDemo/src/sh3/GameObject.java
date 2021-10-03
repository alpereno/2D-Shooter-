package sh3;

import datastructure.Vector2;

public class GameObject {
    Vector2 pos, vel;
    
    public GameObject(Vector2 pos){
        this.pos = pos;
        vel = Vector2.zero;
    }
    
    public void updatePos(int dt){
        Vector2 displacement = vel.mul(dt/1000f);
        pos.addOn(displacement);
    }
}
