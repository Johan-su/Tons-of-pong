import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Key implements KeyListener{
	public Key() {
	}
	public static boolean[] keyarr=new boolean[16];
	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_W) {
			Main.plist.get(0).up=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_A) {
		}
		if(e.getKeyCode()==KeyEvent.VK_S) {
			Main.plist.get(0).down=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_D) {
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			Main.plist.get(1).up=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			Main.plist.get(1).down=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			
		}
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_W) {
			Main.plist.get(0).up=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_A) {
		}
		if(e.getKeyCode()==KeyEvent.VK_S) {
			Main.plist.get(0).down=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_D) {
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			Main.plist.get(1).up=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			Main.plist.get(1).down=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			Frame.p.activateRound();
		}
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	}

}
