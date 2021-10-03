package sh2;

import datastructure.Vector2;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import window.GameWindow;

public class Shooter2 extends GameWindow{
    
    Player player;
    ArrayList<Enemy> enemies = new ArrayList<>();
    ArrayList<Bullet> bullets = new ArrayList<>();
    
    @Override
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
    
    public void mousePressed(MouseEvent me){
        bullets.add(new Bullet(new Vector2((int)player.pos.x, (int)player.pos.y)));
        //System.out.println(bullets.size());
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
        new Shooter2().run();
    }
}
