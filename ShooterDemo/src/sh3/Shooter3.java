package sh3;

import datastructure.Vector2;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import window.GameWindow;

public class Shooter3 extends GameWindow{
    Player player;
    ArrayList<Enemy> enemies = new ArrayList<>();
    ArrayList<Bullet> bullets = new ArrayList<>();
    
    public void init(){
        player = new Player(new Vector2(100,100));
        enemies.add(new Enemy(new Vector2(600, 100)));
        enemies.add(new Enemy(new Vector2(600, 200)));
        enemies.add(new Enemy(new Vector2(600, 300)));
    }
    
    public void update(){
        for (Bullet b:bullets) {
            b.updatePos(dt);
        }
        player.updatePos(dt);
    }
    
    public void paint(){
        g.fillOval((int)player.pos.x-25, (int)player.pos.y-25, 50, 50);
        
        for (Bullet b:bullets) {
            g.setColor(Color.BLUE);
            g.fillOval((int)b.pos.x-5, (int)b.pos.y-5, 10, 10);
            g.setColor(Color.BLACK);
        }
        
        for (Enemy e:enemies) {
            g.setColor(Color.RED);
            g.fillOval((int)e.pos.x-15, (int)e.pos.y-15, 30, 30);
            g.setColor(Color.BLACK);
        }
    }
    int bulletSpeed = 900;
    public void mousePressed(MouseEvent me){
        Vector2 targetPos = new Vector2(me.getX(), me.getY());
        Vector2 distance = new Vector2(targetPos.x - player.pos.x, targetPos.y - player.pos.y);
        distance.normalize();
        distance.mulOn(bulletSpeed);
        Bullet tempBullet = new Bullet(new Vector2((int)player.pos.x, (int)player.pos.y));
        tempBullet.vel = distance;
        bullets.add(tempBullet);
        //bullets.add(new Bullet(new Vector2((int)player.pos.x, (int)player.pos.y)));
        
    }
    
    int playerSpeed = 400;
    public void keyPressed(KeyEvent ke){
        switch(ke.getKeyCode()){
            case KeyEvent.VK_W:
                player.vel = new Vector2(0, -playerSpeed);
                break;
            case KeyEvent.VK_S:
                player.vel = new Vector2(0, playerSpeed);
                break;
            case KeyEvent.VK_A:
                player.vel = new Vector2(-playerSpeed, 0);
                break;
            case KeyEvent.VK_D:
                player.vel = new Vector2(playerSpeed, 0);
                break;
        }
    }
    
    public void keyReleased(KeyEvent ke){
        player.vel = Vector2.zero;
    } 
   
    public static void main(String[] args) {
        new Shooter3().run();
    }
}
