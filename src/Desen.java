//import javax.scene.shape.Circle;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class Desen extends JPanel {
    public int x1, x2, y1, y2;
    public int type = 0;//default draw type

    static ArrayList<Forme> forme = new ArrayList<Forme>();

    public Desen() {
        init();
    }

    public void init() {
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {


            public void mousePressed(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
                repaint();

                if(type==3){
                    int x = e.getX();
                    int y = e.getY();
                    for (int i= forme.size()-1 ; i >=0 ; i--){
                        if(forme.get(i).contains(e.getX(), e.getY())){
                            forme.get(i).remove();
                            repaint();
                            break;
                        }
                    }
                }
            }

            public void mouseReleased(MouseEvent m) {
                Random rand = new Random();
                float rc = rand.nextFloat();
                float gc = rand.nextFloat();
                float bc = rand.nextFloat();

                x2 = m.getX();
                y2 = m.getY();
                repaint();
                if (type == 1) {
                    forme.add(new Forme(x1, y1, x2, y2,new Color(rc,gc,bc),0));
                } else if (type == 2) {
                    forme.add(new Forme(x1, y1, x2, y2,new Color(rc,gc,bc),1));
                }
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent m) {
                x2 = m.getX();
                y2 = m.getY();
                repaint();
            }
        });
    }

    public void setType(int arg) {
        if (arg == 1) {
            type = 1;
        } else if (arg == 2) {
            type = 2;
        }else if (arg == 3) {
            type = 3;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (Forme form : forme) {
            if (form.getForma()==0) {
                form.paintPatrat(g2d);
            }
            if (form.getForma()==1) {
                form.paintCerc(g2d);
            }
        }

        if (type == 1) {
            g.drawRect(x1, y1, x2, y2);
        } else if (type == 2) {
            g.drawOval(x1, y1, x2, y2);
        }


    }
}