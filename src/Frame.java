import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Frame extends JFrame {
	public static Panel p = new Panel();
	public Frame() {
		this.setSize((int)Main.width, (int)Main.height);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setUndecorated(true);
		add(p);
		pack();
		p.addKeyListener(new Key());
		this.setVisible(true);
	}
}
