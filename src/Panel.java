import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Panel extends JPanel implements ActionListener {
	public Timer t = new Timer(1000/Main.fps,this);
	public Graphics2D g2;
	int i;
	public Panel() {
		this.setPreferredSize(Main.screenSize);
		this.setBackground(Color.BLACK);
		setFocusable(true);
		t.start();
	}
	public void paintComponent(Graphics g) {
		//i++;
		//int p=(int)((1+Math.sin(Math.toRadians(i)))*125);
		//this.setBackground(new Color(0, p/4, p/2));
		g2=(Graphics2D)g;
		super.paintComponent(g2);
		Toolkit.getDefaultToolkit().sync();
		balldraw(g2);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
		playerdraw(g2);
		g2.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g2.drawString(Main.scr1+":"+Main.scr2, (int) (Main.width/2), 50);
		g2.drawString("Round: "+Main.round, (int) (Main.width/2), 100);
	}
	public void playerdraw(Graphics2D g2) {
		for(int i=0; i<Main.plist.size(); i++) {
			Main.plist.get(i).doDraw(g2);
		}
	}
	public void balldraw(Graphics2D g2) {
		for(int i=0; i<Main.blist.size(); i++) {
			Main.blist.get(i).doDraw(g2);
			}
	}
	public void playertick() {
		for(int i=0; i<Main.plist.size(); i++) {
			Main.plist.get(i).tick();
			}
	}
	public void balltick() {
		for(int i=0; i<Main.blist.size(); i++) {
			Main.blist.get(i).tick();
			if(Main.blist.get(i).dead) {
				Main.blist.remove(i);
				i--;
			}
		}
	}
	public void activateRound() {
		double r;
		if(Main.blist.size()==0) { //restart round
			for(int i=0; i<10*(1+Main.round); i++) {
				if(Math.random()<0.5) {
					r=(Math.PI+Math.random()/4);
				} else {
					r=Math.random()/4;
				}
				Main.blist.add(new Ball(Main.width/2, 15+Math.random()*(Main.height-25), r/*Math.random()*1*Math.PI*/));
			}
			Main.round++;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		playertick();
		balltick();
		repaint();
		
	}
}