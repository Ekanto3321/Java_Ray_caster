import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Core extends JFrame {

    double framerate = 120.0;
    double timePerFrame = 1000000000.0/framerate;
    double lastFrame;

    int height=840,width=800;

    Core(){

        Ray r = new Ray();
        add(r);
        r.setLayout(null);
        setSize(width,height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setBackground(Color.BLACK);
        setTitle("Better Raycaster");

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                r.setX(e.getX());
                r.setY(e.getY()-40);
            }
        });




    }
    public void loop(){
        while (true){
            
            if(System.nanoTime()-lastFrame>=timePerFrame){
                lastFrame=System.nanoTime();
                repaint();
            }


        }

    }

    public static void main(String[] args) {

        new Core().loop();
    }

}
