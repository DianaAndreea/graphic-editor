import java.awt.*;

class Forme extends Rectangle {

    private Color color;
    private int forma;

    public Forme(int x, int y, int width, int height, Color color,int forma) {
        super(x, y, width, height);
        this.color = color;
        this.forma=forma;
    }

    public Color getColor() {
        return color;
    }
    public int getForma() {
        return forma;
    }

    public void paintPatrat(Graphics2D g2d) {
        g2d.drawRect(x, y,
                width - 1,height - 1);
        g2d.setColor(getColor());
       // g2d.fillRect(x + 1, y + 1,                width - 2, height - 2);

    }
    public void paintCerc(Graphics2D g2d) {
        g2d.drawOval(x, y,
                width - 1,height - 1);
        g2d.setColor(getColor());
        //g2d.fillOval(x + 1, y + 1,                width - 2, height - 2);

    }

    public void remove() {
        this.x=-500;
        this.y=-500;
    }
}