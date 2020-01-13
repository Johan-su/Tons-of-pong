import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

public class Ball {
	public double bx,by,angle,speed,dx,dy,radius=10;
	public boolean dead;
		public Ball(double x,double y,double angle) {
		this.bx=x;
		this.by=y;
		this.angle=angle;
		this.speed=60*Main.width*12/(1366*Main.fps);
	}
		public void doDraw(Graphics2D g2) {
			//g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(Color.GREEN);
			g2.fill(new Ellipse2D.Double(bx-radius,by-radius,2*radius,2*radius));
		}
		public void tick() {
			collision();
			by += Math.sin(angle)*speed;
			bx += Math.cos(angle)*speed;
			dy = by-Math.sin(angle)*speed;
			dx = bx-Math.cos(angle)*speed;
		}
		public void collision() {
			if(bx >=Main.width) {
				Main.scr1++;
				//angle =Math.PI-angle;
				//MySound.playSound();
				dead=true;
			}
			if(bx <=0) {
				Main.scr2++;
				//angle =Math.PI-angle;
				//MySound.playSound();
				dead=true;
			}
			if(by <=radius || by >=Main.height-radius) {
				angle =-angle;
				//MySound.playSound();
			}
			for(int i = 0; i < Main.plist.size(); i++) {
				Player p = Main.plist.get(i);
				
				if(bx + radius <= p.px+p.width/2 && bx+radius >=p.px-p.width/2 && by-radius <=p.py+p.height/2 && by+radius >=p.py-p.height/2) { // if touching player
					angle=-angle+Math.random()*Math.PI/24;
					speed *=1.03;
				//	MySound.playSound();
					if(!(dx+radius <=p.px+p.width/2 && dx+radius >=p.px-p.width/2)) { // if bounce on side of player
						angle +=Math.PI;	
					}
					if(dx+radius <=p.px+p.width/2 && dx+radius >=p.px-p.width/2 && dy-radius <=p.py+p.height/2 && dy+radius >=p.py-p.height/2) { // if inside player
						if(bx >= Main.width/2) {
							angle=Math.PI;
						} else {
							angle=0;
						}
						by += Math.sin(angle)*speed;
						bx += Math.cos(angle)*speed;
					}
				}
			}
		}
}
