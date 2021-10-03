package sh1;

import datastructure.Vector2;
import java.awt.Color;
import java.awt.event.MouseEvent;
import window.GameWindow;

public class Shooter1 extends GameWindow{
    Player player;
    Bullet bullet; 
   
    public void init(){
        player = new Player(new Vector2(100, 100));
    }
    
    public void update(){
        if (bullet != null) {
            Vector2 displacement = bullet.vel.mul(dt/1000f);
            bullet.pos.addOn(displacement);
        }
    }
    
    public void paint(){
        g.fillOval((int)player.pos.x-25, (int)player.pos.y-25, 50, 50);
        if (bullet != null) {
            g.setColor(Color.RED);
            g.fillOval((int)bullet.pos.x, (int)bullet.pos.y, 10, 10);
            g.setColor(Color.BLACK);
        }
    }
    
    public void mousePressed(MouseEvent me){
        bullet = new Bullet(new Vector2(player.pos.x, player.pos.y));
    }
    
    public static void main(String[] args) {
        new Shooter1().run();
    }    
}
