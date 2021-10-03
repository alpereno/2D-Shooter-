package sh3;

import datastructure.Vector2;

public class Bullet extends GameObject {
    
    public Bullet(Vector2 pos){
        super(pos);
        vel = new Vector2(1000,1000);
    }
}
