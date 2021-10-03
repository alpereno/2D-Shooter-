package window;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class BasicWindow extends JFrame implements MouseListener, MouseMotionListener, KeyListener{

    protected int wid , heg;
    protected Graphics g;
    protected Image img;
    
    
    public BasicWindow(){
        cons(800, 800);
    }    
    public BasicWindow(int wid, int heg){  
        cons(wid, heg);
    }
    void cons(int wid, int heg){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.wid = wid;
        this.heg = heg;        
        setVisible(true);
        img = createImage(wid, heg);
        g = img.getGraphics();        
        setLocation(300, 100);
        setSize(wid, heg);    
        addMouseListener(this);
        addMouseMotionListener(this);        
        addKeyListener(this);     
        
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {  
               if(ke.getKeyCode() == KeyEvent.VK_ESCAPE) 
                   System.exit(0);
            }});
    }
    
    @Override
    public void paint(Graphics g2){
        if(g==null)
            return;
        
        g.clearRect(0, 0, wid, heg);
        
        paint();
        
        g2.drawImage(img, 0, 0, null);
    }
    
    public void paint(){        
        //... drawing goes here    
    }
    


    public static void main(String[] args) {
        new BasicWindow();
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    
    public void mouseDragged(MouseEvent me) {
    }

    
    public void mouseMoved(MouseEvent me) {
    }

    
    public void keyTyped(KeyEvent ke) {
    }

    
    public void keyPressed(KeyEvent ke) {
    }

    
    public void keyReleased(KeyEvent ke) {
    }

}
