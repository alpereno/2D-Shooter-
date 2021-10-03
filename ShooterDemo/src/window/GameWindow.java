package window;

public class GameWindow extends BasicWindow {
    
    protected int dt = 10;
    
    public GameWindow(){
    }
    
    public GameWindow(int wid, int heg){
        super(wid, heg);
    }
    
    public void run(){
        init();        
        while(true){
            try {Thread.sleep(dt);} catch(Exception e) {}
            
            update();
            
            repaint();
        }
    }
    
    protected void init(){}
    
    protected void update(){}
    
    public void paint(){
        g.drawString("Override update() and paint(), then call run", 100, 100);
    }
    
    public static void main(String[] args) {
        new GameWindow();
    }
}
