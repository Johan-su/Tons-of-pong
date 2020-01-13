import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Player {
	public double px,py,speedx,speedy,angle;
	public boolean up,down,ai;
	public final int width=50,height=100;
	private int minpos;
	private double min=99999;
	public Rectangle2D p;
	public Player(double x,double y) {
		this.px = x;
		this.py = y;
	}
	public void doDraw(Graphics2D g2) {
		p = new Rectangle2D.Double(px-width/2, py-height/2, 25, 100);
		g2.setColor(Color.GRAY);
		g2.fill(p);
	}
	public void tick() {
		if(!(up && down)) {
			if(up) {
				py -= 15;
			} else if(down) {
				py += 15;
			}
		}
		if(py <= height/2) {
			py=height/2;
		} else if(py >= Main.height-height/2) {
			py=Main.height-height/2;
		}
		if(ai && Main.blist.size()>0) {
			min=99999;
			for(int i=0; i<Main.blist.size(); i++) {
				Ball p1 = Main.blist.get(i);
				if(Math.abs(p1.bx + 2*(Math.sin(p1.angle)*p1.speed) -px) < min) {
					min=Math.abs(p1.bx-px);
					minpos=i;
				}
			}
			py=Main.blist.get(minpos).by;
		}
	}

}
