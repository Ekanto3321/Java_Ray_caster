import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Ray extends JPanel {


    int x, y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

//    ArrayList<Double> t = new ArrayList<>();
//    ArrayList<Double> u = new ArrayList<>();
//    ArrayList<Double> den = new ArrayList<>();
//
//    ArrayList<Double> dist = new ArrayList<>();
//
//    ArrayList<Wall> w = new ArrayList<Wall>();


//Intersection Formula from https://en.wikipedia.org/wiki/Line%E2%80%93line_intersection


protected void paintComponent(Graphics g) {
    //    int x3,y3,x4,y4;


//----------------------------BACKUPS-------------------------------------
    g.setColor(Color.BLUE);
    Wall w = new Wall(400,400,200,350);
    g.drawLine(400,200,400,350);

    int x3=w.x3;
    int y3= w.y3;
    int x4 =w.x4;
    int y4= w.y4;

        for (int i = 0; i < 360; i++) {

            //Intersection Formula from https://en.wikipedia.org/wiki/Line%E2%80%93line_intersection

            int x1 = x;
            int y1 = y;
            int x2 = x+(int) (1700*Math.sin(Math.toRadians(i)));
            int y2= y+(int)(1700*Math.cos(Math.toRadians(i)));


            double den = (x1-x2)*(y3-y4)-(y1-y2)*(x3-x4);

            double t = ((x1-x3)*(y3-y4)-(y1-y3)*(x3-x4))/den;
            double u = -(((x1-x2)*(y1-y3)-(y1-y2)*(x1-x3))/den);

            g.setColor(Color.gray);
            if(t>0&&t<1&&u>0&&u<1){
                int P1 = (int) (x1+t*(x2-x1));
                int P2 = (int) (y1+t*(y2-y1));
                g.drawLine(x,y, P1, P2);

            }
            else {
                g.drawLine(x,y, x2, y2);
            }


        }



    }


}
