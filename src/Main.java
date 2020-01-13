import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Main {
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static double height=screenSize.getHeight(),width=screenSize.getWidth();
	public static ArrayList<Player> plist = new ArrayList<Player>();
	public static ArrayList<Ball> blist = new ArrayList<Ball>();
	public static int scr1=0,scr2=0;
	public static int round;
	public static int fps = 70;
	public static void main(String[] args) {
		plist.add(new Player(45,height/2));
		plist.add(new Player(width-20,height/2));
		Main.plist.get(0).ai=true;
		Main.plist.get(1).ai=true;
//		for(int i=0; i<360; i++) {
//			blist.add(new  Ball(width/2, height/2, i/**Math.PI*2*/));
//		}
		EventQueue.invokeLater(() -> {
			JFrame ex = new Frame();
			ex.setVisible(true);
		});
	}
	public static double dist(double y1,double x1,double y2,double x2) {
		//return Math.sqrt((y1-y2)*(y1-y2)+(x1-x2)*(x1-x2));
		return Math.hypot(x1-x2, y1-y2);
	}
}
